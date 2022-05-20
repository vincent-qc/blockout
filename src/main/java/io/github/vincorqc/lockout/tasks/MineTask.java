package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.BlockList;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.Random;

public class MineTask extends Task {
    private final Block block;
    private static final Map<TaskDifficulty, Block[]> list = Map.ofEntries(
            Map.entry(TaskDifficulty.EASY, BlockList.EASY_BLOCKS),
            Map.entry(TaskDifficulty.MEDIUM, BlockList.MEDIUM_BLOCKS),
            Map.entry(TaskDifficulty.HARD, BlockList.HARD_BLOCKS)
    );

    public MineTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Advancement
        Random r = new Random();
        Block[] data = list.get(difficulty);

        this.index = r.nextInt(data.length);
        this.block = data[index];
        this.title = "Mine " + block.getName().getString();
    }

    public MineTask(TaskDifficulty difficulty, int index) {
        super(difficulty);

        Block[] data = list.get(difficulty);

        this.index = index;
        this.block = data[index];
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
