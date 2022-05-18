package io.github.vincorqc.lockout.handlers;

import io.github.vincorqc.lockout.common.LockoutMod;
import io.github.vincorqc.lockout.tasks.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.scores.Team;

public class VerificationHandler extends LockoutGameHandler {
    public static void validateObtain(Player p) {
        for(int i = 0; i < obtainTasks.size(); i++) {
            ObtainTask task = obtainTasks.get(i);
            if(p.getInventory().contains(new ItemStack(task.getItem()))) {
                task.complete(p);
                obtainTasks.remove(task);
                i--;
            }
        }
    }

    public static void validateAdvancement(Player p, String advancement) {
        for(int i = 0; i < advancementTasks.size(); i++) {
            AdvancementTask task = advancementTasks.get(i);
            if(task.getAdvancement().equals(advancement)) {
                task.complete(p);
                advancementTasks.remove(task);
                i--;
            }
        }
    }

    public static void validateKill(Player p, String mob) {
        for(int i = 0; i < killTasks.size(); i++) {
            KillTask task = killTasks.get(i);

            if(task.getMob().equals(mob)) {
                task.complete(p);
                killTasks.remove(task);
                i--;
            }
        }
    }

    public static void validateEffect(Player p) {

        for(int i = 0; i < effectTasks.size(); i++) {
            EffectTask task = effectTasks.get(i);

            if(p.hasEffect(task.getEffect())) {
                task.complete(p);
                effectTasks.remove(task);
                i--;
            }
        }
    }

    public static void validateMine(Player p, Block block) {
        for(int i  = 0; i < mineTasks.size(); i++) {
            MineTask task = mineTasks.get(i);

            if(task.getBlock().equals(block)) {
                task.complete(p);
                mineTasks.remove(task);
                i--;
            }
        }

    }

    public static void validateDeath(Player p, DamageSource damage) {
        for(int i = 0; i < deathTasks.size(); i++) {
            DeathTask task = deathTasks.get(i);

            if(task.getDamageSource().equals(damage)) {
                task.complete(p);
                deathTasks.remove(task);
                i--;
            }
        }
    }

    public static void validateCollect(Player p) {
        for(int i = 0; i < collectTasks.size(); i++) {
            CollectTask task = collectTasks.get(i);
            boolean complete = true;

            for(Item item : task.getCollection()) {
                if(!p.getInventory().contains(new ItemStack(item))) complete = false;
            }

            if(complete) {
                task.complete(p);
                collectTasks.remove(task);
                i--;
            }
        }
    }

    public static void validateExperience(Player p, int level) {
        for(int i = 0; i < experienceTasks.size(); i++) {
            ExperienceTask task = experienceTasks.get(i);

            if(level >= task.getLevel()) {
                task.complete(p);
                experienceTasks.remove(task);
                i--;
            }
        }
    }

    public static void validateOpponent(Player p) {
        for(int i = 0; i < opponentTasks.size(); i++) {
            OpponentTask task = opponentTasks.get(i);
            if(p.getInventory().contains(new ItemStack(task.getItem()))) {
                try {
                    int t = TeamHandler.getTeam(p) == 1 ? 2 : 1;
                    task.complete(t);
                    opponentTasks.remove(task);
                    i--;
                } catch (Exception e) {
                    LockoutMod.LOGGER.info(String.valueOf(e));
                }
            }
        }
    }
}
