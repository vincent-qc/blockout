package io.github.vincorqc.lockout.data;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class CollectList {
    public static Item[][] HARD_COLLECT = {
            {
                    Items.ACACIA_SAPLING,
                    Items.BIRCH_SAPLING,
                    Items.DARK_OAK_SAPLING,
                    Items.JUNGLE_SAPLING,
                    Items.SPRUCE_SAPLING,
                    Items.OAK_SAPLING
            },
            {
                    Items.IRON_INGOT,
                    Items.GOLD_INGOT,
                    Items.COPPER_INGOT,
                    Items.COAL,
                    Items.LAPIS_LAZULI,
                    Items.DIAMOND,
                    Items.EMERALD,
                    Items.REDSTONE
            },
            {
                    Items.DIAMOND_AXE,
                    Items.DIAMOND_HOE,
                    Items.DIAMOND_PICKAXE,
                    Items.DIAMOND_SHOVEL,
                    Items.DIAMOND_SWORD
            },
            {
                    Items.DIAMOND_HELMET,
                    Items.DIAMOND_CHESTPLATE,
                    Items.DIAMOND_LEGGINGS,
                    Items.DIAMOND_BOOTS
            }
    };

    public static final Item[][] EXPERT_COLLECT = {
            {
                    Items.CHAINMAIL_BOOTS,
                    Items.CHAINMAIL_CHESTPLATE,
                    Items.CHAINMAIL_HELMET,
                    Items.CHAINMAIL_LEGGINGS
            },
            {
                    Items.BLACK_DYE,
                    Items.BLUE_DYE,
                    Items.BROWN_DYE,
                    Items.CYAN_DYE,
                    Items.GRAY_DYE,
                    Items.GREEN_DYE,
                    Items.LIGHT_BLUE_DYE,
                    Items.LIGHT_GRAY_DYE,
                    Items.LIME_DYE,
                    Items.MAGENTA_DYE,
                    Items.ORANGE_DYE,
                    Items.PINK_DYE,
                    Items.PURPLE_DYE,
                    Items.RED_DYE,
                    Items.WHITE_DYE,
                    Items.YELLOW_DYE
            },
            {
                    Items.BLAST_FURNACE,
                    Items.SMOKER,
                    Items.CARTOGRAPHY_TABLE,
                    Items.BREWING_STAND,
                    Items.COMPOSTER,
                    Items.BARREL,
                    Items.FLETCHING_TABLE,
                    Items.CAULDRON,
                    Items.LECTERN,
                    Items.STONECUTTER,
                    Items.LOOM,
                    Items.SMITHING_TABLE,
                    Items.GRINDSTONE
            }
    };

    public static final String[] HARD_TITLES = {
            "Collect all saplings",
            "Collect all overworld ores",
            "Collect a full set of Diamond Tools",
            "Collect a full set of Diamond Armor"
    };

    public static final String[] EXPERT_TITLES = {
            "Collect a full set of Chainmail Armor",
            "Collect all dyes",
            "Collect every villager workstation block"
    };
}
