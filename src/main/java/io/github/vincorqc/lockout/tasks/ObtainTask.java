package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.util.TaskDifficulty;
import io.github.vincorqc.lockout.util.ItemList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

public class ObtainTask extends Task {
    private final Item item;

    public ObtainTask(TaskDifficulty difficulty) {
        super(difficulty);
        // Assign Random Item
        Random r = new Random();
        if(difficulty == TaskDifficulty.EASY) {
            index = r.nextInt(ItemList.EASY_ITEMS.length);
            this.item = ItemList.EASY_ITEMS[index];
        } else if(difficulty == TaskDifficulty.MEDIUM) {
            index = r.nextInt(ItemList.MEDIUM_ITEMS.length);
            this.item = ItemList.MEDIUM_ITEMS[index];
        } else if(difficulty == TaskDifficulty.HARD) {
            index = r.nextInt(ItemList.HARD_ITEMS.length);
            this.item = ItemList.HARD_ITEMS[index];
        } else {
            index = r.nextInt(ItemList.EXPERT_ITEMS.length);
            this.item = ItemList.EXPERT_ITEMS[index];
        }

        title = "Obtain " + new ItemStack(item).getHoverName().getString();
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
