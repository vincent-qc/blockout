package io.github.vincorqc.lockout.common;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementList;
import net.minecraft.data.advancements.AdventureAdvancements;
import net.minecraft.data.advancements.TheEndAdvancements;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {
    @SubscribeEvent
    public void pickup(EntityItemPickupEvent event) {
        System.out.println("PICK UP: " + event.getItem().getName().getString());
    }

    @SubscribeEvent
    public void advancement(AdvancementEvent event) {
        System.out.println("ADANVCEMENT: " + event.getAdvancement().getId());
    }

    @SubscribeEvent
    public void fish(ItemFishedEvent event) {
        System.out.println("FISH: " + event.getDrops());
    }

    @SubscribeEvent
    public void interact(PlayerInteractEvent.RightClickBlock event) {
        System.out.println("INTERACT BLOCK: " + event.getHitVec().toString());
    }

    @SubscribeEvent
    public void use(LivingEntityUseItemEvent.Finish event) {
        System.out.println("USE: " + event.getEntityLiving().getName());

        if(event.getEntity() instanceof Player) {
            Player p = (Player) event.getEntity();

            System.out.println("USED ITEM: " + event.getItem().getHoverName() + " BY: " + p.getName());
        }
    }

    @SubscribeEvent
    public void kill(LivingHurtEvent event) {
        if(event.getSource().getEntity() instanceof Player) {
            Player p = (Player) event.getSource().getEntity();
            p.hurt(DamageSource.ANVIL, 1000);
            System.out.println(p.getId());
        }
    }

    @SubscribeEvent
    public void tick(TickEvent.PlayerTickEvent event) {

    }

    @SubscribeEvent
    public void playerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        System.out.println("\n\n\n" + "JOINED ID: " + event.getPlayer().getId());

        TeamHandler.addPlayer(event.getPlayer());
    }
}
