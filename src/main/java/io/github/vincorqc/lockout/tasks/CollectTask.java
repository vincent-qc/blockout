package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.CollectList;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

public class CollectTask extends Task {
    private final Item[] collection;

    public CollectTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Item
        Random r = new Random();
        if (difficulty == TaskDifficulty.HARD) {
            index = r.nextInt(CollectList.HARD_COLLECT.length);
            this.collection = CollectList.HARD_COLLECT[index];
            title = CollectList.HARD_TITLES[index];
        } else {
            index = r.nextInt(CollectList.EXPERT_COLLECT.length);
            this.collection = CollectList.EXPERT_COLLECT[index];
            title = CollectList.EXPERT_TITLES[index];
        }
    }

    public CollectTask(String difficulty, int index) {
        super(difficulty);
        this.index = index;

        if(difficulty.equals("hard")) {
            this.collection = CollectList.HARD_COLLECT[index];
            this.difficulty = TaskDifficulty.HARD;
            title = CollectList.HARD_TITLES[index];
        } else {
            this.collection = CollectList.EXPERT_COLLECT[index];
            this.difficulty = TaskDifficulty.EXPERT;
            title = CollectList.EXPERT_TITLES[index];
        }
    }



    public ItemStack getItemIcon() {
        return new ItemStack(collection[0]);
    }

    public Item[] getCollection() {
        return collection;
    }

}
