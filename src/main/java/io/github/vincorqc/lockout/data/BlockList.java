package io.github.vincorqc.lockout.data;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class BlockList {
    public static final Block[] EASY_BLOCKS = {
            Blocks.BOOKSHELF,
            Blocks.COBWEB,
            Blocks.ACACIA_LEAVES,
            Blocks.BIRCH_LEAVES,
            Blocks.DARK_OAK_LEAVES,
            Blocks.SPRUCE_LEAVES,
            Blocks.JUNGLE_LEAVES,
            Blocks.AZALEA_LEAVES,
            Blocks.OBSIDIAN,
            Blocks.BASALT,
            Blocks.CRYING_OBSIDIAN,
            Blocks.MUSHROOM_STEM,
            Blocks.BROWN_MUSHROOM_BLOCK,
            Blocks.RED_MUSHROOM_BLOCK
    };

    public static final Block[] MEDIUM_BLOCKS = {
            Blocks.DEAD_BUSH,
            Blocks.DIRT_PATH,
            Blocks.FERN,
            Blocks.SEA_PICKLE,
            Blocks.GILDED_BLACKSTONE,
            Blocks.MELON,
            Blocks.RED_SAND,
    };

    public static final Block[] HARD_BLOCKS = {
            Blocks.SPAWNER,
            Blocks.TURTLE_EGG,
            Blocks.SPONGE
    };
}
