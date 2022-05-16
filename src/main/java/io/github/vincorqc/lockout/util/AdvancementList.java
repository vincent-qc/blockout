package io.github.vincorqc.lockout.util;

import net.minecraft.advancements.Advancement;
import net.minecraft.client.gui.screens.advancements.AdvancementTab;
import net.minecraft.data.advancements.AdventureAdvancements;

public class AdvancementList {
    public static final String[] EASY_ADVANCEMENTS = {
            "plant_seed",
            "summon_iron_golem",
            "breed_an_animal",
            "honey_block_slide",
            "tame_an_animal",
            "make_a_sign_glow",
            "tactical_fishing",
            "wax_off"
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
            "respawn_dragon",
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
            "fast_travel"
    };
}
