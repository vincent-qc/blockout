package io.github.vincorqc.lockout.handlers;

import io.github.vincorqc.lockout.common.LockoutMod;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {
    @SubscribeEvent
    public void pickup(EntityItemPickupEvent event) {
        System.out.println("PICK UP: " + event.getItem().getName().getString());
    }

    @SubscribeEvent
    public void advancement(AdvancementEvent event) {
        VerificationHandler.validateAdvancement(event.getPlayer(), event.getAdvancement().getId().toString().split("/")[1]);
    }

    @SubscribeEvent
    public void use(LivingEntityUseItemEvent.Finish event) {
        if(event.getEntity() instanceof Player) {
            Player p = (Player) event.getEntity();

            System.out.println("USED ITEM: " + event.getItem().getHoverName() + " BY: " + p.getName().getString());
        }
    }

    @SubscribeEvent
    public void kill(LivingDeathEvent event) {
        if(event.getSource().getEntity() instanceof Player) {
            Player p = (Player) event.getSource().getEntity();

            System.out.println(LockoutGameHandler.asString());
        }
    }

    @SubscribeEvent
    public void tick(TickEvent.PlayerTickEvent event) {
        VerificationHandler.validateObtain(event.player);
    }

    @SubscribeEvent
    public void playerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        System.out.println("\n\n\n" + "JOINED ID: " + event.getPlayer().getName().getString());

        TeamHandler.addPlayer(event.getPlayer());
        TeamHandler.setTeam(event.getPlayer(), 1);
    }
}
