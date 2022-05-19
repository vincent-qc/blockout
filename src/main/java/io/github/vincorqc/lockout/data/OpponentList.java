package io.github.vincorqc.lockout.data;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class OpponentList {
    public static final Item[] MEDIUM_ITEMS = {
            Items.DIRT,
            Items.COBBLESTONE,
            Items.CRAFTING_TABLE,
            Items.FURNACE,
            Items.NETHERRACK
    };

    public static final Item[] HARD_ITEMS = {
            Items.DIAMOND,
            Items.OBSIDIAN,
            Items.IRON_INGOT,
            Items.BUCKET,
    };
}
