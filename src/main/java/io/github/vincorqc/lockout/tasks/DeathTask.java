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
    private Item icon;

    public DeathTask(TaskDifficulty difficulty) {
        super(difficulty, "death_titles");

        // Assign Random Item
        Random r = new Random();
        int index;
        if(difficulty == TaskDifficulty.EASY) {
            index = r.nextInt(DamageList.EASY_DAMAGE.length);
            this.damageSource = DamageList.EASY_DAMAGE[index];
            icon = DamageList.EASY_ICONS[index];
        } else if(difficulty == TaskDifficulty.MEDIUM) {
            index = r.nextInt(DamageList.MEDIUM_DAMAGE.length);
            this.damageSource = DamageList.MEDIUM_DAMAGE[index];
            icon = DamageList.MEDIUM_ICONS[index];
        } else {
            index = r.nextInt(DamageList.HARD_DAMAGE.length);
            this.damageSource = DamageList.HARD_DAMAGE[index];
            icon = DamageList.HARD_ICONS[index];
        }


        title = titles.get(this.damageSource.getMsgId());
        System.out.println(damageSource.getMsgId());
    }

    public DamageSource getDamageSource() {
        return damageSource;
    }

    @Override
    public ResourceLocation getIdentifier() {
        return new ResourceLocation(LockoutMod.MODID, "textures/tasks/identifiers/death.png");
    }

    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(icon);
    }
}
