package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.AdvancementList;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

public class AdvancementTask extends Task {
    private final String advancement;

    public AdvancementTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Advancement
        Random r = new Random();

        if(difficulty == TaskDifficulty.EASY) {
            index = r.nextInt(AdvancementList.EASY_ADVANCEMENTS.length);
            this.advancement = AdvancementList.EASY_ADVANCEMENTS[index];
            icon = AdvancementList.EASY_ICONS[index];
            title = AdvancementList.EASY_TITLES[index];
        } else if(difficulty == TaskDifficulty.MEDIUM){
            index  = r.nextInt(AdvancementList.MEDIUM_ADVANCEMENTS.length);
            this.advancement = AdvancementList.MEDIUM_ADVANCEMENTS[index];
            icon = AdvancementList.MEDIUM_ICONS[index];
            title = AdvancementList.MEDIUM_TITLES[index];
        } else if(difficulty == TaskDifficulty.HARD) {
            index  = r.nextInt(AdvancementList.HARD_ADVANCEMENTS.length);
            this.advancement = AdvancementList.HARD_ADVANCEMENTS[index];
            icon = AdvancementList.HARD_ICONS[index];
            title = AdvancementList.HARD_TITLES[index];
        } else {
            index  = r.nextInt(AdvancementList.EXPERT_ADVANCEMENTS.length);
            this.advancement = AdvancementList.EXPERT_ADVANCEMENTS[index];
            icon = AdvancementList.EXPERT_ICONS[index];
            title = AdvancementList.EXPERT_TITLES[index];
        }
    }

    public AdvancementTask(String difficulty, int index) {
        super(difficulty);

        switch (difficulty) {
            case "easy" -> {
                this.advancement = AdvancementList.EASY_ADVANCEMENTS[index];
                this.difficulty = TaskDifficulty.EASY;
                this.icon = AdvancementList.EASY_ICONS[index];
                title = AdvancementList.EASY_TITLES[index];
            }
            case "medium" -> {
                this.advancement = AdvancementList.MEDIUM_ADVANCEMENTS[index];
                this.difficulty = TaskDifficulty.MEDIUM;
                this.icon = AdvancementList.MEDIUM_ICONS[index];
                title = AdvancementList.MEDIUM_TITLES[index];
            }
            case "hard" -> {
                this.advancement = AdvancementList.HARD_ADVANCEMENTS[index];
                this.difficulty = TaskDifficulty.HARD;
                this.icon = AdvancementList.HARD_ICONS[index];
                title = AdvancementList.HARD_TITLES[index];
            }
            default -> {
                this.advancement = AdvancementList.EXPERT_ADVANCEMENTS[index];
                this.difficulty = TaskDifficulty.EXPERT;
                this.icon = AdvancementList.EXPERT_ICONS[index];
                title = AdvancementList.EXPERT_TITLES[index];
            }
        }
    }

    public String getAdvancement() {
        return advancement;
    }


    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(icon);
    }
}
