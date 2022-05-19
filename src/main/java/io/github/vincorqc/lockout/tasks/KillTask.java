package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.MobList;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

public class KillTask extends Task {
    private final String mob;

    public KillTask(TaskDifficulty difficulty) {
        super(difficulty);
        // Assign Random Advancement
        Random r = new Random();
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

    public KillTask(String difficulty, int index) {
        super(difficulty);
        this.index = index;

        switch (difficulty) {
            case "easy" -> {
                this.difficulty = TaskDifficulty.EASY;
                this.mob = MobList.EASY_MOBS[index];
                this.icon = MobList.EASY_ICONS[index];
            }
            case "medium" -> {
                this.difficulty = TaskDifficulty.MEDIUM;
                this.mob = MobList.MEDIUM_MOBS[index];
                this.icon = MobList.MEDIUM_ICONS[index];
            }
            case "hard" -> {
                this.difficulty = TaskDifficulty.HARD;
                this.mob = MobList.HARD_MOBS[index];
                this.icon = MobList.HARD_ICONS[index];
            }
            default -> {
                this.difficulty = TaskDifficulty.EXPERT;
                this.mob = MobList.EXPERT_MOBS[index];
                this.icon = MobList.EXPERT_ICONS[index];
            }
        }

        title = "Kill a " + mob;
    }

    public String getMob() {
        return mob;
    }

    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(icon);
    }
}
