package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.common.LockoutMod;
import io.github.vincorqc.lockout.util.AdvancementList;
import io.github.vincorqc.lockout.util.MobList;
import io.github.vincorqc.lockout.util.TaskDifficulty;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

public class KillTask extends Task {
    private final String mob;
    private Item icon;

    public KillTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Advancement
        Random r = new Random();
        int index;
        if(difficulty == TaskDifficulty.EASY) {
            index = r.nextInt(MobList.EASY_MOBS.length);
            this.mob = MobList.EASY_MOBS[index];
            icon = MobList.EASY_ICONS[index];
        } else if(difficulty == TaskDifficulty.MEDIUM) {
            index = r.nextInt(MobList.MEDIUM_MOBS.length);
            this.mob = MobList.MEDIUM_MOBS[index];
            icon = MobList.MEDIUM_ICONS[index];
        } else if(difficulty == TaskDifficulty.HARD) {
            index = r.nextInt(MobList.HARD_MOBS.length);
            this.mob = MobList.HARD_MOBS[index];
            icon = MobList.HARD_ICONS[index];
        } else {
            index = r.nextInt(MobList.EXPERT_MOBS.length);
            this.mob = MobList.EXPERT_MOBS[index];
            icon = MobList.EXPERT_ICONS[index];
        }

        title = "Kill a " + mob;
    }

    public String getMob() {
        return mob;
    }

    @Override
    public ResourceLocation getIdentifier() {
        return new ResourceLocation(LockoutMod.MODID, "textures/tasks/identifiers/kill.png");
    }

    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(icon);
    }
}
