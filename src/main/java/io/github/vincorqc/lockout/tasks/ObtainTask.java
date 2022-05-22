package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.BlockList;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import io.github.vincorqc.lockout.data.ItemList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class ObtainTask extends Task {
    private final Item item;

    public ObtainTask(TaskDifficulty difficulty) {
        super(difficulty);
        // Assign Random Item
        Random r = new Random();
        ArrayList<Item> data = ItemList.list.get(difficulty);
        this.index = r.nextInt(data.size());

        this.item = data.get(index);
        this.title = "Obtain " + new ItemStack(item).getHoverName().getString();
    }

    public ObtainTask(TaskDifficulty difficulty, int index) {
        super(difficulty);

        ArrayList<Item> data = ItemList.list.get(difficulty);
        this.index = index;

        this.item = data.get(index);
        this.title = "Obtain " + new ItemStack(item).getHoverName().getString();
    }

    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(item);
    }

    public Item getItem() {
        return item;
    }
}
