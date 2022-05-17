package io.github.vincorqc.lockout.handlers;

import io.github.vincorqc.lockout.common.LockoutMod;
import io.github.vincorqc.lockout.gui.LockoutScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.controls.KeyBindsList;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDestroyBlockEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.concurrent.locks.Lock;

public class EventHandler {

    /**
     * Validates AdvancementTasks
     *
     * @param event Activates when a player achieves an advancement
     */
    @SubscribeEvent
    public void advancement(AdvancementEvent event) {
        VerificationHandler.validateAdvancement(event.getPlayer(), event.getAdvancement().getId().toString().split("/")[1]);
    }

    /**
     *
     * @param event Activates after a player has finished using an item
     */
    @SubscribeEvent
    public void use(LivingEntityUseItemEvent.Finish event) {
        if(event.getEntity() instanceof Player) {
            Player p = (Player) event.getEntity();

            System.out.println("USED ITEM: " + event.getItem().getDisplayName().getString() + " BY: " + p.getName().getString());
        }
    }

    /**
     * Checks if the death of an entity is caused by a player kill
     * Validates KillTasks
     *
     * @param event Activates when a LivingEntity dies
     */
    @SubscribeEvent
    public void kill(LivingDeathEvent event) {

        if(event.getEntity() instanceof Player p) {
            System.out.println("PLAYER " + p.getName().getString() + " DIED BY " + event.getSource().getMsgId());
            VerificationHandler.validateDeath(p, event.getSource());
        }

        if(event.getSource().getEntity() instanceof Player p) {
            VerificationHandler.validateKill(p, event.getEntity().getName().getString());
        }
    }

    /**
     * Validates ObtainTasks
     * Validates EffectTasks
     * Validates CollectTasks
     *
     * @param event Activates every tick
     */
    @SubscribeEvent
    public void tick(TickEvent.PlayerTickEvent event) {

        if(!event.player.getInventory().isEmpty()) {
            VerificationHandler.validateObtain(event.player);
            VerificationHandler.validateCollect(event.player);
            VerificationHandler.validateOpponent(event.player);
        }

        if(!event.player.getActiveEffects().isEmpty()) VerificationHandler.validateEffect(event.player);
    }

    @SubscribeEvent
    public void mine(BlockEvent.BreakEvent event) {
        System.out.println("PLAYER " + event.getPlayer().getName().getString() + " MINED " + event.getState().getBlock().getName().getString());
        VerificationHandler.validateMine(event.getPlayer(), event.getState().getBlock());
    }

    @SubscribeEvent
    public void experience(PlayerXpEvent.XpChange event) {
        if(event.getPlayer().experienceLevel > 19) {
            VerificationHandler.validateExperience(event.getPlayer(), event.getPlayer().experienceLevel);
        }
    }


    /**
     * Adds new player to pool of players
     *
     * @param event Activates when a player joins the world
     */
    @SubscribeEvent
    public void playerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        System.out.println("\n\n\n" + "JOINED ID: " + event.getPlayer().getName().getString());

        TeamHandler.addPlayer(event.getPlayer());
        TeamHandler.setTeam(event.getPlayer(), 1);
    }

    @SubscribeEvent
    public void openLockoutGUI(TickEvent.ClientTickEvent event) {
        if(LockoutMod.key.isDown()) {
            Minecraft.getInstance().setScreen(new LockoutScreen(new TextComponent("Blockout")));
        }
    }
}
