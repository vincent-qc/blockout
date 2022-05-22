package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.ItemList;
import io.github.vincorqc.lockout.data.OpponentList;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class OpponentTask extends Task {
    private final Item item;

    public OpponentTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Item
        Random r = new Random();
        ArrayList<Item> data = OpponentList.list.get(difficulty);
        this.index = r.nextInt(data.size());

        this.item = data.get(index);
        this.title = "Opponent obtains " + new ItemStack(item).getHoverName().getString();
    }

    public OpponentTask(TaskDifficulty difficulty, int index) {
        super(difficulty);

        // Assign Random Item
        ArrayList<Item> data = OpponentList.list.get(difficulty);
        this.index = index;

        this.item = data.get(index);
        this.title = "Opponent obtains " + new ItemStack(item).getHoverName().getString();
    }

    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(item);
    }

    public Item getItem() {
        return item;
    }

}
