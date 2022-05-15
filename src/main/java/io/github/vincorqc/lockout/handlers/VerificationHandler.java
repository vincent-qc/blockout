package io.github.vincorqc.lockout.handlers;

import io.github.vincorqc.lockout.tasks.AdvancementTask;
import io.github.vincorqc.lockout.tasks.ObtainTask;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class VerificationHandler extends LockoutGameHandler {
    public static void validateObtain(Player p) {
        for(ObtainTask task : obtainTasks) {
            if(p.getInventory().contains(new ItemStack(task.getItem()))) task.complete(p);
        }
    }

    public static void validateAdvancement(Player p, String advancement) {
        for(AdvancementTask task : advancementTasks) {
            if(task.getAdvancement().equals(advancement)) task.complete(p);
        }
    }
}
