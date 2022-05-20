package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.TaskDifficulty;
import io.github.vincorqc.lockout.data.ItemList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Map;
import java.util.Random;

public class ObtainTask extends Task {
    private final Item item;
    private static final Map<TaskDifficulty, Item[]> list = Map.ofEntries(
            Map.entry(TaskDifficulty.EASY, ItemList.EASY_ITEMS),
            Map.entry(TaskDifficulty.MEDIUM, ItemList.MEDIUM_ITEMS),
            Map.entry(TaskDifficulty.HARD, ItemList.HARD_ITEMS),
            Map.entry(TaskDifficulty.EXPERT, ItemList.EXPERT_ITEMS)
    );

    public ObtainTask(TaskDifficulty difficulty) {
        super(difficulty);
        // Assign Random Item
        Random r = new Random();
        Item[] data = list.get(difficulty);

        this.index = r.nextInt(data.length);
        this.item = data[index];
        this.title = "Obtain " + new ItemStack(item).getHoverName().getString();
    }

    public ObtainTask(String difficulty, int index) {
        super(difficulty);
        this.index = index;

        switch (difficulty) {
            case "easy" -> {
                this.item = ItemList.EASY_ITEMS[index];
                this.difficulty = TaskDifficulty.EASY;
            }
            case "medium" -> {
                this.item = ItemList.MEDIUM_ITEMS[index];
                this.difficulty = TaskDifficulty.MEDIUM;
            }
            case "hard" -> {
                this.item = ItemList.HARD_ITEMS[index];
                this.difficulty = TaskDifficulty.HARD;
            }
            default -> {
                this.item = ItemList.EXPERT_ITEMS[index];
                this.difficulty = TaskDifficulty.EXPERT;
            }
        }

        title = "Obtain " + new ItemStack(item).getHoverName().getString();
    }

    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(item);
    }

    public Item getItem() {
        return item;
    }
}
