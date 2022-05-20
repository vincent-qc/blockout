package io.github.vincorqc.lockout.handlers;

import io.github.vincorqc.lockout.commands.StartCommand;
import io.github.vincorqc.lockout.gui.LockoutScreen;
import io.github.vincorqc.lockout.data.Keybinds;
import io.github.vincorqc.lockout.networking.LockoutPacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

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
            VerificationHandler.validateEat((Player) event.getEntity(), event.getItem().getItem());
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
            VerificationHandler.validateDeath(p, event.getSource());
        }

        if(event.getSource().getEntity() instanceof Player p) {
            // Check if entity killed is another player
            String name = event.getEntity() instanceof Player ? "Player" : event.getEntity().getName().getString();
            VerificationHandler.validateKill(p, name);
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
    @OnlyIn(Dist.DEDICATED_SERVER)
    public void playerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        TeamHandler.addPlayer(event.getPlayer());
        TeamHandler.setTeam(event.getPlayer(), 1);

        LockoutPacketHandler.sync();
    }

    private static int tick = 0;
    @SubscribeEvent
    @OnlyIn(Dist.DEDICATED_SERVER)
    public void serverTick(TickEvent.ServerTickEvent event) {
        tick++;

        if(tick >= 3000) {
            tick = 0;
            LockoutPacketHandler.sync();
        }
    }


    /* CLIENT EVENTS */


}
