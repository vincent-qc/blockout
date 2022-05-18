package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.common.LockoutMod;
import io.github.vincorqc.lockout.util.DamageList;
import io.github.vincorqc.lockout.util.EffectList;
import io.github.vincorqc.lockout.util.TaskDifficulty;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

public class DeathTask extends Task {
    private final DamageSource damageSource;

    public DeathTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Item
        Random r = new Random();
        if(difficulty == TaskDifficulty.EASY) {
            index = r.nextInt(DamageList.EASY_DAMAGE.length);
            this.damageSource = DamageList.EASY_DAMAGE[index];
            icon = DamageList.EASY_ICONS[index];
            title = DamageList.EASY_TITLES[index];
        } else if(difficulty == TaskDifficulty.MEDIUM) {
            index = r.nextInt(DamageList.MEDIUM_DAMAGE.length);
            this.damageSource = DamageList.MEDIUM_DAMAGE[index];
            icon = DamageList.MEDIUM_ICONS[index];
            title = DamageList.MEDIUM_TITLES[index];
        } else {
            index = r.nextInt(DamageList.HARD_DAMAGE.length);
            this.damageSource = DamageList.HARD_DAMAGE[index];
            icon = DamageList.HARD_ICONS[index];
            title = DamageList.HARD_TITLES[index];
        }
    }

    public DeathTask(String difficulty, int index) {
        super(difficulty);
        this.index = index;

        if(difficulty.equals("easy")) {
            this.difficulty = TaskDifficulty.EASY;
            this.damageSource = DamageList.EASY_DAMAGE[index];
            this.icon = DamageList.EASY_ICONS[index];
            title = DamageList.EASY_TITLES[index];
        } else if(difficulty.equals("medium")) {
            this.difficulty = TaskDifficulty.MEDIUM;
            this.damageSource = DamageList.MEDIUM_DAMAGE[index];
            this.icon = DamageList.MEDIUM_ICONS[index];
            title = DamageList.MEDIUM_TITLES[index];
        } else {
            this.difficulty = TaskDifficulty.HARD;
            this.damageSource = DamageList.HARD_DAMAGE[index];
            this.icon = DamageList.HARD_ICONS[index];
            title = DamageList.HARD_TITLES[index];
        }
    }

    public DamageSource getDamageSource() {
        return damageSource;
    }


    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(icon);
    }
}
