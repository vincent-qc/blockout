package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.BlockList;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.Random;

public class MineTask extends Task {
    private final Block block;

    public MineTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Advancement
        Random r = new Random();
        if(difficulty == TaskDifficulty.EASY) {
            index = r.nextInt(BlockList.EASY_BLOCKS.length);
            this.block = BlockList.EASY_BLOCKS[index];
        } else if(difficulty == TaskDifficulty.MEDIUM) {
            this.index = r.nextInt(BlockList.MEDIUM_BLOCKS.length);
            this.block = BlockList.MEDIUM_BLOCKS[index];
        } else {
            index = r.nextInt(BlockList.HARD_BLOCKS.length);
            this.block = BlockList.HARD_BLOCKS[index];
        }

        title = "Mine " + block.getName().getString();
    }

    public MineTask(String difficulty, int index) {
        super(difficulty);
        this.index = index;

        if(difficulty.equals("easy")) {
            this.block = BlockList.EASY_BLOCKS[index];
            this.difficulty = TaskDifficulty.EASY;
        } else if(difficulty.equals("medium")) {
            this.block = BlockList.MEDIUM_BLOCKS[index];
            this.difficulty = TaskDifficulty.MEDIUM;
        } else {
            this.block = BlockList.HARD_BLOCKS[index];
            this.difficulty = TaskDifficulty.HARD;
        }

        title = "Mine " + block.getName().getString();
    }

    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(block.asItem());
    }

    public Block getBlock() {
        return block;
    }

}
