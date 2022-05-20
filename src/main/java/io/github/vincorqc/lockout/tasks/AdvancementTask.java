package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.AdvancementList;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import oshi.util.tuples.Triplet;

import java.util.Map;
import java.util.Random;

public class AdvancementTask extends Task {
    private final String advancement;
    private static final Map<TaskDifficulty, Triplet<String[], Item[], String[]>> list = Map.ofEntries(
            Map.entry(TaskDifficulty.EASY, new Triplet<>(AdvancementList.EASY_ADVANCEMENTS, AdvancementList.EASY_ICONS, AdvancementList.EASY_TITLES)),
            Map.entry(TaskDifficulty.MEDIUM, new Triplet<>(AdvancementList.MEDIUM_ADVANCEMENTS, AdvancementList.MEDIUM_ICONS, AdvancementList.MEDIUM_TITLES)),
            Map.entry(TaskDifficulty.HARD, new Triplet<>(AdvancementList.HARD_ADVANCEMENTS, AdvancementList.HARD_ICONS, AdvancementList.HARD_TITLES)),
            Map.entry(TaskDifficulty.EXPERT, new Triplet<>(AdvancementList.EXPERT_ADVANCEMENTS, AdvancementList.EXPERT_ICONS, AdvancementList.EXPERT_TITLES))
    );

    public AdvancementTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Advancement
        Random r = new Random();
        Triplet<String[], Item[], String[]> data = list.get(difficulty);

        this.index = r.nextInt(data.getA().length);
        this.advancement = data.getA()[index];
        this.icon = data.getB()[index];
        this.title = data.getC()[index];
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
