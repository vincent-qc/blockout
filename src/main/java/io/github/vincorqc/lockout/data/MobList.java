package io.github.vincorqc.lockout.data;

import net.minecraft.util.Tuple;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import oshi.util.tuples.Triplet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MobList {
    public static final Map<TaskDifficulty, ArrayList<Tuple<String, Item>>> list = Map.ofEntries(
            Map.entry(TaskDifficulty.EASY, new ArrayList<>(Arrays.asList(
                    new Tuple<>("Pig", Items.PIG_SPAWN_EGG),
                    new Tuple<>("Cow", Items.COW_SPAWN_EGG),
                    new Tuple<>("Sheep", Items.SHEEP_SPAWN_EGG),
                    new Tuple<>("Creeper", Items.CREEPER_SPAWN_EGG),
                    new Tuple<>("Zombie", Items.ZOMBIE_SPAWN_EGG),
                    new Tuple<>("Skeleton", Items.SKELETON_SPAWN_EGG),
                    new Tuple<>("Spider", Items.SPIDER_SPAWN_EGG),
                    new Tuple<>("Turtle", Items.TURTLE_SPAWN_EGG),
                    new Tuple<>("Piglin", Items.PIGLIN_SPAWN_EGG)
            ))),

            Map.entry(TaskDifficulty.MEDIUM, new ArrayList<>(Arrays.asList(
                    new Tuple<>("Blaze", Items.BLAZE_SPAWN_EGG),
                    new Tuple<>("Wither Skeleton", Items.WITHER_SKELETON_SPAWN_EGG),
                    new Tuple<>("Ghast", Items.GHAST_SPAWN_EGG),
                    new Tuple<>("Stider", Items.STRIDER_SPAWN_EGG),
                    new Tuple<>("Zombified Piglin", Items.ZOMBIFIED_PIGLIN_SPAWN_EGG),
                    new Tuple<>("Bat", Items.BAT_SPAWN_EGG),
                    new Tuple<>("Fox", Items.FOX_SPAWN_EGG),
                    new Tuple<>("Horse", Items.HORSE_SPAWN_EGG),
                    new Tuple<>("Donkey", Items.DONKEY_SPAWN_EGG),
                    new Tuple<>("Glow Squid", Items.GLOW_SQUID_SPAWN_EGG),
                    new Tuple<>("Parrot", Items.PARROT_SPAWN_EGG),
                    new Tuple<>("Snow Golem", Items.SNOW_BLOCK),
                    new Tuple<>("Zombie Villager", Items.ZOMBIE_VILLAGER_SPAWN_EGG),
                    new Tuple<>("Dolphin", Items.DOLPHIN_SPAWN_EGG),
                    new Tuple<>("Witch", Items.WITCH_SPAWN_EGG),
                    new Tuple<>("Llama", Items.LLAMA_SPAWN_EGG),
                    new Tuple<>("Iron Golem", Items.CARVED_PUMPKIN)
            ))),

            Map.entry(TaskDifficulty.HARD, new ArrayList<>(Arrays.asList(
                    new Tuple<>("Ocelot", Items.OCELOT_SPAWN_EGG),
                    new Tuple<>("Slime", Items.SLIME_SPAWN_EGG),
                    new Tuple<>("Polar Bear", Items.POLAR_BEAR_SPAWN_EGG),
                    new Tuple<>("Player", Items.PLAYER_HEAD),
                    new Tuple<>("Guardian", Items.GUARDIAN_SPAWN_EGG),
                    new Tuple<>("Frog", Items.FROG_SPAWN_EGG)
            ))),

            Map.entry(TaskDifficulty.EXPERT, new ArrayList<>(Arrays.asList(
                    new Tuple<>("Piglin Brute", Items.PIGLIN_BRUTE_SPAWN_EGG),
                    new Tuple<>("Silverfish", Items.SILVERFISH_SPAWN_EGG),
                    new Tuple<>("Zoglin", Items.ZOGLIN_SPAWN_EGG),
                    new Tuple<>("Pillager", Items.PILLAGER_SPAWN_EGG),
                    new Tuple<>("Panda", Items.PANDA_SPAWN_EGG),
                    new Tuple<>("Mule", Items.MULE_SPAWN_EGG),
                    new Tuple<>("Shulker", Items.SHULKER_SPAWN_EGG),
                    new Tuple<>("Endermite", Items.ENDERMITE_SPAWN_EGG),
                    new Tuple<>("Warden", Items.WARDEN_SPAWN_EGG),
                    new Tuple<>("Allay", Items.ALLAY_SPAWN_EGG)
            )))
    );
}
