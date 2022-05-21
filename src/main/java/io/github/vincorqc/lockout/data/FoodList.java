package io.github.vincorqc.lockout.data;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class FoodList {
    public static final Item[] EASY_FOOD = {
            Items.APPLE,
            Items.CARROT,
            Items.MELON_SLICE,
            Items.POTATO,
            Items.DRIED_KELP,
            Items.COOKED_RABBIT,
            Items.COOKED_SALMON,
            Items.COOKED_COD,
            Items.SPIDER_EYE
    };

    public static final Item[] MEDIUM_FOOD = {
            Items.GLOW_BERRIES,
            Items.PUMPKIN_PIE,
            Items.PUFFERFISH,
            Items.TROPICAL_FISH,
            Items.BEETROOT_SOUP,
            Items.RABBIT_STEW,
            Items.SUSPICIOUS_STEW,
            Items.HONEY_BOTTLE
    };

    public static final Item[] HARD_FOOD = {
            Items.GOLDEN_APPLE,
            Items.POPPED_CHORUS_FRUIT,
            Items.GOLDEN_CARROT,
            Items.COOKIE,
            Items.POISONOUS_POTATO,
    };
}
