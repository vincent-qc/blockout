package io.github.vincorqc.lockout.data;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class FoodList {
    public static final Map<TaskDifficulty, ArrayList<Item>> list = Map.ofEntries(
            Map.entry(TaskDifficulty.EASY, new ArrayList<>(Arrays.asList(
                    Items.APPLE,
                    Items.CARROT,
                    Items.MELON_SLICE,
                    Items.POTATO,
                    Items.DRIED_KELP,
                    Items.COOKED_RABBIT,
                    Items.COOKED_SALMON,
                    Items.COOKED_COD,
                    Items.SPIDER_EYE
            ))),

            Map.entry(TaskDifficulty.MEDIUM, new ArrayList<>(Arrays.asList(
                    Items.GLOW_BERRIES,
                    Items.PUMPKIN_PIE,
                    Items.PUFFERFISH,
                    Items.TROPICAL_FISH,
                    Items.BEETROOT_SOUP,
                    Items.RABBIT_STEW,
                    Items.SUSPICIOUS_STEW,
                    Items.HONEY_BOTTLE
            ))),

            Map.entry(TaskDifficulty.HARD, new ArrayList<>(Arrays.asList(
                    Items.GOLDEN_APPLE,
                    Items.POPPED_CHORUS_FRUIT,
                    Items.GOLDEN_CARROT,
                    Items.COOKIE,
                    Items.POISONOUS_POTATO
            )))
    );
}
