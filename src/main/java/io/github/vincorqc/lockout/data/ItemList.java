package io.github.vincorqc.lockout.data;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class ItemList {
    public static final Map<TaskDifficulty, ArrayList<Item>> list = Map.ofEntries(
            Map.entry(TaskDifficulty.EASY, new ArrayList<>(Arrays.asList(
                    Items.BELL,
                    Items.CAMPFIRE,
                    Items.CARROT_ON_A_STICK,
                    Items.CLOCK,
                    Items.CANDLE,
                    Items.DETECTOR_RAIL,
                    Items.DROPPER,
                    Items.FIREWORK_ROCKET,
                    Items.FLOWER_POT,
                    Items.GHAST_TEAR,
                    Items.GRINDSTONE,
                    Items.IRON_BARS,
                    Items.JACK_O_LANTERN,
                    Items.DRIED_KELP_BLOCK,
                    Items.LANTERN,
                    Items.LOOM,
                    Items.MAGMA_CREAM,
                    Items.NETHER_WART,
                    Items.NOTE_BLOCK,
                    Items.PAINTING,
                    Items.SOUL_CAMPFIRE,
                    Items.SOUL_LANTERN,
                    Items.PAPER,
                    Items.RABBIT_FOOT,
                    Items.RAIL,
                    Items.REDSTONE_LAMP,
                    Items.REPEATER,
                    Items.VINE,
                    Items.WARPED_FUNGUS_ON_A_STICK,
                    Items.CYAN_GLAZED_TERRACOTTA,
                    Items.YELLOW_GLAZED_TERRACOTTA,
                    Items.MAGENTA_GLAZED_TERRACOTTA,
                    Items.BLACK_GLAZED_TERRACOTTA
            ))),

            Map.entry(TaskDifficulty.MEDIUM, new ArrayList<>(Arrays.asList(
                    Items.COCOA_BEANS,
                    Items.JUKEBOX,
                    Items.LEAD,
                    Items.SLIME_BLOCK,
                    Items.SCAFFOLDING,
                    Items.SMOKER,
                    Items.OBSERVER,
                    Items.HONEYCOMB_BLOCK,
                    Items.CAKE
            ))),

            Map.entry(TaskDifficulty.HARD, new ArrayList<>(Arrays.asList(
                    Items.AXOLOTL_BUCKET,
                    Items.NETHERITE_INGOT,
                    Items.DRAGON_BREATH,
                    Items.END_CRYSTAL,
                    Items.ICE,
                    Items.PACKED_ICE,
                    Items.ECHO_SHARD,
                    Items.TADPOLE_BUCKET
            ))),

            Map.entry(TaskDifficulty.EXPERT, new ArrayList<>(Arrays.asList(
                    Items.ELYTRA,
                    Items.MYCELIUM,
                    Items.TURTLE_HELMET,
                    Items.SADDLE,
                    Items.NAME_TAG,
                    Items.WITHER_SKELETON_SKULL,
                    Items.BEE_NEST,
                    Items.END_ROD,
                    Items.RECOVERY_COMPASS
            )))
    );
}
