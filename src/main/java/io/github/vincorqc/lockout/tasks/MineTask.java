package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.util.BlockList;
import io.github.vincorqc.lockout.util.MobList;
import io.github.vincorqc.lockout.util.TaskDifficulty;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.Random;

public class MineTask extends Task {
    private final Block block;

    public MineTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Advancement
        Random r = new Random();
        if(difficulty == TaskDifficulty.EASY)
            this.block = BlockList.EASY_BLOCKS[r.nextInt(BlockList.EASY_BLOCKS.length)];

        else if(difficulty == TaskDifficulty.MEDIUM)
            this.block = BlockList.MEDIUM_BLOCKS[r.nextInt(BlockList.MEDIUM_BLOCKS.length)];

        else
            this.block = BlockList.HARD_BLOCKS[r.nextInt(BlockList.HARD_BLOCKS.length)];


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
