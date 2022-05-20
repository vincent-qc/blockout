package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.OpponentList;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Map;
import java.util.Random;

public class OpponentTask extends Task {
    private final Item item;
    private final static Map<TaskDifficulty, Item[]> list = Map.ofEntries(
            Map.entry(TaskDifficulty.MEDIUM, OpponentList.MEDIUM_ITEMS),
            Map.entry(TaskDifficulty.HARD, OpponentList.HARD_ITEMS)
    );

    public OpponentTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Item
        Random r = new Random();
        Item[] data = list.get(difficulty);

        this.index = r.nextInt(data.length);
        this.item = data[index];
        this.title = "Opponent obtains " + new ItemStack(item).getHoverName().getString();
    }

    public OpponentTask(String difficulty, int index) {
        super(difficulty);
        this.index = index;

        if(difficulty.equals("medium")) {
            this.item = OpponentList.MEDIUM_ITEMS[index];
            this.difficulty = TaskDifficulty.MEDIUM;
        } else {
            this.item = OpponentList.HARD_ITEMS[index];
            this.difficulty = TaskDifficulty.HARD;
        }

        title = "Opponent obtains " + new ItemStack(item).getHoverName().getString();
    }

    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(item);
    }

    public Item getItem() {
        return item;
    }

}
