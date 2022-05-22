package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.BlockList;
import io.github.vincorqc.lockout.data.FoodList;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class MineTask extends Task {
    private final Block block;

    public MineTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Advancement
        Random r = new Random();
        ArrayList<Block> data = BlockList.list.get(difficulty);
        this.index = r.nextInt(data.size());

        this.block = data.get(index);
        this.title = "Mine " + block.getName().getString();
    }

    public MineTask(TaskDifficulty difficulty, int index) {
        super(difficulty);

        ArrayList<Block> data = BlockList.list.get(difficulty);
        this.index = index;

        this.block = data.get(index);
        this.title = "Mine " + block.getName().getString();
    }

    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(block.asItem());
    }

    public Block getBlock() {
        return block;
    }

}
