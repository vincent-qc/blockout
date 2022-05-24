package io.github.vincorqc.lockout.data;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class BlockList {
    public static final Map<TaskDifficulty, ArrayList<Block>> list = Map.ofEntries(
            Map.entry(TaskDifficulty.EASY, new ArrayList<>(Arrays.asList(
                    Blocks.BOOKSHELF,
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
            ))),

            Map.entry(TaskDifficulty.MEDIUM, new ArrayList<>(Arrays.asList(
                    Blocks.DEAD_BUSH,
                    Blocks.DIRT_PATH,
                    Blocks.FERN,
                    Blocks.SEA_PICKLE,
                    Blocks.GILDED_BLACKSTONE,
                    Blocks.MELON,
                    Blocks.GLOW_LICHEN
            ))),

            Map.entry(TaskDifficulty.HARD, new ArrayList<>(Arrays.asList(
                    Blocks.SPAWNER,
                    Blocks.TURTLE_EGG,
                    Blocks.RED_SAND,
                    Blocks.COBWEB
            ))),

            Map.entry(TaskDifficulty.EXPERT, new ArrayList<>(Arrays.asList(
                    Blocks.WET_SPONGE,
                    Blocks.MYCELIUM,
                    Blocks.CHORUS_FLOWER
            )))
    );
}
