package io.github.vincorqc.lockout.data;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import oshi.util.tuples.Triplet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AdvancementList {
    public static final Map<TaskDifficulty, ArrayList<Triplet<String, Item, String>>> list = Map.ofEntries(
            Map.entry(TaskDifficulty.EASY, new ArrayList<>(Arrays.asList(
                    new Triplet<>("plant_seed", Items.WHEAT_SEEDS, "Plant a seed"),
                    new Triplet<>("summon_iron_golem", Items.CARVED_PUMPKIN, "Summon an iron golem"),
                    new Triplet<>("breed_an_animal", Items.WHEAT, "Breed an animal"),
                    new Triplet<>("tame_an_animal", Items.BONE, "Tame an animal"),
                    new Triplet<>("make_a_sign_glow", Items.GLOW_INK_SAC, "Make a sign glow"),
                    new Triplet<>("tactical_fishing", Items.SALMON_BUCKET, "Fish with a bucket"),
                    new Triplet<>("wax_off", Items.WAXED_COPPER_BLOCK, "Unwax a waxed copper block"),
                    new Triplet<>("deflect_arrow", Items.SHIELD, "Use a Shield"),
                    new Triplet<>("sleep_in_bed", Items.RED_BED, "Sleep in a bed")
            ))),

            Map.entry(TaskDifficulty.MEDIUM, new ArrayList<>(Arrays.asList(
                    new Triplet<>("ride_a_boat_with_a_goat", Items.OAK_BOAT, "Ride a boat with a goat"),
                    new Triplet<>("return_to_sender", Items.FIRE_CHARGE, "Complete \"Return to sender\""),
                    new Triplet<>("spyglass_at_ghast", Items.SPYGLASS, "Look at a ghast with a spyglass"),
                    new Triplet<>("walk_on_powder_snow_with_leather_boots", Items.LEATHER_BOOTS, "Walk on powder snow with leather boots"),
                    new Triplet<>("play_jukebox_in_meadows", Items.JUKEBOX, "Play a jukebox in a meadow")
            ))),

            Map.entry(TaskDifficulty.HARD, new ArrayList<>(Arrays.asList(
                    new Triplet<>("honey_block_slide", Items.HONEY_BLOCK, "Slide on a honey block"),
                    new Triplet<>("charge_respawn_anchor", Items.RESPAWN_ANCHOR, "Fully charge a respawn anchor"),
                    new Triplet<>("ride_strider", Items.SADDLE, "Ride a strider"),
                    new Triplet<>("spyglass_at_parrot", Items.SPYGLASS, "Look at a parrot with a spyglass"),
                    new Triplet<>("fall_from_world_height", Items.WATER_BUCKET, "Fall from the max to min height")
            ))),

            Map.entry(TaskDifficulty.EXPERT, new ArrayList<>(Arrays.asList(
                    new Triplet<>("obtain_netherite_hoe", Items.NETHERITE_HOE, "Obtain netherite hoe"),
                    new Triplet<>("use_lodestone", Items.LODESTONE, "Use a lodestone"),
                    new Triplet<>("ride_strider_in_overworld_lava", Items.WARPED_FUNGUS_ON_A_STICK, "Ride a strider for 50m in the overworld"),
                    new Triplet<>("fast_travel", Items.FILLED_MAP, "Complete \"Subspace\" Bubble"),
                    new Triplet<>("kill_dragon", Items.DRAGON_HEAD, "Kill the ender dragon"),
                    new Triplet<>("levitate", Items.SHULKER_SHELL, "Levitate 50 blocks"),
                    new Triplet<>("silk_touch_nest", Items.BEE_NEST, "Pick up a full bee nest")
            )))
    );
}