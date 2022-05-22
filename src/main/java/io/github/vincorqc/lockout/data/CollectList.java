package io.github.vincorqc.lockout.data;

import net.minecraft.util.Tuple;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CollectList {
    public static final Map<TaskDifficulty, ArrayList<Tuple<ArrayList<Item>, String>>> list = Map.ofEntries(
            Map.entry(TaskDifficulty.HARD, new ArrayList<>(Arrays.asList(
                    new Tuple<>(new ArrayList<>(Arrays.asList(
                            Items.ACACIA_SAPLING,
                            Items.BIRCH_SAPLING,
                            Items.DARK_OAK_SAPLING,
                            Items.JUNGLE_SAPLING,
                            Items.SPRUCE_SAPLING,
                            Items.OAK_SAPLING
                    )), "Collect all saplings"),

                    new Tuple<>(new ArrayList<>(Arrays.asList(
                            Items.IRON_INGOT,
                            Items.GOLD_INGOT,
                            Items.COPPER_INGOT,
                            Items.COAL,
                            Items.LAPIS_LAZULI,
                            Items.DIAMOND,
                            Items.EMERALD,
                            Items.REDSTONE
                    )), "Collect all overworld ores"),

                    new Tuple<>(new ArrayList<>(Arrays.asList(
                            Items.DIAMOND_AXE,
                            Items.DIAMOND_HOE,
                            Items.DIAMOND_PICKAXE,
                            Items.DIAMOND_SHOVEL,
                            Items.DIAMOND_SWORD
                    )), "Collect a full set of Diamond Tools")
            ))),

            Map.entry(TaskDifficulty.EXPERT, new ArrayList<>(Arrays.asList(
                    new Tuple<>(new ArrayList<>(Arrays.asList(
                            Items.DIAMOND_HELMET,
                            Items.DIAMOND_CHESTPLATE,
                            Items.DIAMOND_LEGGINGS,
                            Items.DIAMOND_BOOTS
                    )), "Collect a full set of Diamond Armor"),

                    new Tuple<>(new ArrayList<>(Arrays.asList(
                            Items.CHAINMAIL_BOOTS,
                            Items.CHAINMAIL_CHESTPLATE,
                            Items.CHAINMAIL_HELMET,
                            Items.CHAINMAIL_LEGGINGS
                    )), "Collect a full set of Chainmail Armor"),

                    new Tuple<>(new ArrayList<>(Arrays.asList(
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
                    )), "Collect all dyes"),

                    new Tuple<>(new ArrayList<>(Arrays.asList(
                            Items.SMITHING_TABLE,
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
                            Items.GRINDSTONE
                    )), "Collect all villager workstation blocks")
            )))
    );

}
