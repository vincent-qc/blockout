package io.github.vincorqc.lockout.data;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class OpponentList {
    public static final Item[] MEDIUM_ITEMS = {
            Items.COBBLESTONE,
            Items.CRAFTING_TABLE,
            Items.FURNACE,
            Items.DIRT
    };

    public static final Item[] HARD_ITEMS = {
            Items.DIAMOND,
            Items.IRON_INGOT,
            Items.NETHERRACK,
            Items.SAND,
            Items.STICK,
    };
}
