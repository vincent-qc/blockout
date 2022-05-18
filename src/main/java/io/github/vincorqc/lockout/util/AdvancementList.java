package io.github.vincorqc.lockout.util;

import net.minecraft.advancements.Advancement;
import net.minecraft.client.gui.screens.advancements.AdvancementTab;
import net.minecraft.data.advancements.AdventureAdvancements;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class AdvancementList {
    public static final String[] EASY_ADVANCEMENTS = {
            "plant_seed",
            "summon_iron_golem",
            "breed_an_animal",
            "honey_block_slide",
            "tame_an_animal",
            "make_a_sign_glow",
            "tactical_fishing",
            "wax_off",
            "deflect_arrow"
    };

    public static final String[] MEDIUM_ADVANCEMENTS = {
            "ride_a_boat_with_a_goat",
            "explore_nether",
            "charge_respawn_anchor",
            "ride_strider",
            "return_to_sender",
            "spyglass_at_ghast",
            "walk_on_powder_snow_with_leather_boots"
    };

    public static final String[] HARD_ADVANCEMENTS = {
            "kill_dragon",
            "levitate",
            "obtain_netherite_hoe",
            "silk_touch_nest",
            "use_lodestone",
            "spyglass_at_parrot",
    };

    public static final String[] EXPERT_ADVANCEMENTS = {
            "play_jukebox_in_meadows",
            "fall_from_world_height",
            "ride_strider_in_overworld_lava",
            "fast_travel",
            "respawn_dragon"
    };

    public static final Item[] EASY_ICONS = {
            Items.WHEAT_SEEDS,
            Items.CARVED_PUMPKIN,
            Items.WHEAT,
            Items.HONEY_BLOCK,
            Items.BONE,
            Items.GLOW_INK_SAC,
            Items.TROPICAL_FISH_BUCKET,
            Items.WAXED_COPPER_BLOCK,
            Items.SHIELD
    };

    public static final Item[] MEDIUM_ICONS = {
            Items.OAK_BOAT,
            Items.NETHERITE_BOOTS,
            Items.RESPAWN_ANCHOR,
            Items.WARPED_FUNGUS_ON_A_STICK,
            Items.FIRE_CHARGE,
            Items.SPYGLASS,
            Items.LEATHER_BOOTS
    };

    public static final Item[] HARD_ICONS = {
            Items.DRAGON_HEAD,
            Items.SHULKER_SHELL,
            Items.NETHERITE_HOE,
            Items.BEE_NEST,
            Items.LODESTONE,
            Items.SPYGLASS
    };

    public static final Item[] EXPERT_ICONS = {
            Items.JUKEBOX,
            Items.WATER_BUCKET,
            Items.WARPED_FUNGUS_ON_A_STICK,
            Items.FILLED_MAP,
            Items.DRAGON_EGG
    };

    public static final String[] EASY_TITLES = {
            "Plant a seed",
            "Summon an iron golem",
            "Breed an animal",
            "Slide on a honey block",
            "Tame an animal",
            "Make a sign glow",
            "Fish with a bucket",
            "Unwax a waxed copper block",
            "Use a shield"
    };

    public static final String[] MEDIUM_TITLES = {
            "Ride a boat with a goat",
            "Visit all nether biomes",
            "Fill a respawn anchor to the max",
            "Ride a strider",
            "Return to sender",
            "Look at a ghast with a spyglass",
            "Walk on powder snow with leather boots"
    };

    public static final String[] HARD_TITLES = {
            "Kill the ender dragon",
            "Levitate fifty blocks",
            "Obtain a netherite hoe",
            "Pick up a full bee nest",
            "Use a lodestone",
            "Look at a parrot with a spyglass",
    };

    public static final String[] EXPERT_TITLES = {
            "Play a jukebox in a meadow biome",
            "Survive a fall from the max to min height",
            "Ride 50m in the overworld on a strider",
            "Complete Subspace Bubble",
            "Complete \"Subspace Bubble\""
    };
}
