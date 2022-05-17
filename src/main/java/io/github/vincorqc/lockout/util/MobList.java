package io.github.vincorqc.lockout.util;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class MobList {
    public static final String[] EASY_MOBS = {
            "Pig",
            "Cow",
            "Sheep",
            "Creeper",
            "Zombie",
            "Skeleton",
            "Spider",
            "Blaze",
            "Wither Skeleton",
            "Ghast",
            "Strider",
            "Piglin",
            "Turtle"
    };

    public static final String[] MEDIUM_MOBS = {
            "Silverfish",
            "Bat",
            "Fox",
            "Horse",
            "Donkey",
            "Glow Squid",
            "Parrot",
            "Ocelot",
            "Snow Golem",
            "Zombie Villager",
            "Dolphin",
            "Piglin Brute",
            "Witch"
    };

    public static final String[] HARD_MOBS = {
            "Shulker",
            "Endermite",
            "Mule",
            "Panda"
    };

    public static final String[] EXPERT_MOBS = {
            "Zoglin",
            "Pillager",
            "Guardian"
    };

    public static final Item[] EASY_ICONS = {
            Items.PIG_SPAWN_EGG,
            Items.COW_SPAWN_EGG,
            Items.SHEEP_SPAWN_EGG,
            Items.CREEPER_SPAWN_EGG,
            Items.ZOMBIE_SPAWN_EGG,
            Items.SKELETON_SPAWN_EGG,
            Items.SPIDER_SPAWN_EGG,
            Items.BLAZE_SPAWN_EGG,
            Items.WITHER_SKELETON_SPAWN_EGG,
            Items.GHAST_SPAWN_EGG,
            Items.STRIDER_SPAWN_EGG,
            Items.PIGLIN_SPAWN_EGG,
            Items.TURTLE_SPAWN_EGG
    };

    public static final Item[] MEDIUM_ICONS = {
            Items.SILVERFISH_SPAWN_EGG,
            Items.BAT_SPAWN_EGG,
            Items.FOX_SPAWN_EGG,
            Items.HORSE_SPAWN_EGG,
            Items.DONKEY_SPAWN_EGG,
            Items.GLOW_SQUID_SPAWN_EGG,
            Items.PARROT_SPAWN_EGG,
            Items.OCELOT_SPAWN_EGG,
            Items.CARVED_PUMPKIN,
            Items.ZOMBIE_VILLAGER_SPAWN_EGG,
            Items.DOLPHIN_SPAWN_EGG,
            Items.PIGLIN_BRUTE_SPAWN_EGG,
            Items.WITCH_SPAWN_EGG
    };

    public static final Item[] HARD_ICONS = {
            Items.SHULKER_SPAWN_EGG,
            Items.ENDERMITE_SPAWN_EGG,
            Items.MULE_SPAWN_EGG,
            Items.PANDA_SPAWN_EGG,
    };

    public static final Item[] EXPERT_ICONS = {
            Items.ZOGLIN_SPAWN_EGG,
            Items.PILLAGER_SPAWN_EGG,
            Items.GUARDIAN_SPAWN_EGG
    };
}
