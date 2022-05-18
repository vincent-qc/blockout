package io.github.vincorqc.lockout.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

public class DamageList {
    public static DamageSource[] EASY_DAMAGE = {
            DamageSource.IN_FIRE,
            DamageSource.DROWN,
            DamageSource.HOT_FLOOR,
            DamageSource.LAVA,
            DamageSource.SWEET_BERRY_BUSH,
            DamageSource.IN_WALL
    };

    public static DamageSource[] MEDIUM_DAMAGE = {
            DamageSource.ANVIL,
            DamageSource.FALLING_STALACTITE,
            DamageSource.MAGIC,
            DamageSource.WITHER,
            DamageSource.STARVE
    };

    public static DamageSource[] HARD_DAMAGE = {
            DamageSource.CRAMMING,
            DamageSource.OUT_OF_WORLD,
            DamageSource.DRAGON_BREATH,
    };

    public static Item[] EASY_ICONS =  {
            Items.FLINT_AND_STEEL,
            Items.WATER_BUCKET,
            Items.MAGMA_BLOCK,
            Items.LAVA_BUCKET,
            Items.SWEET_BERRIES,
            Items.SAND
    };

    public static Item[] MEDIUM_ICONS =  {
            Items.ANVIL,
            Items.POINTED_DRIPSTONE,
            Items.SPLASH_POTION,
            Items.WITHER_SKELETON_SKULL,
            Items.BREAD
    };

    public static Item[] HARD_ICONS = {
            Items.SKELETON_SKULL,
            Items.END_PORTAL_FRAME,
            Items.DRAGON_BREATH
    };

    public static String[] EASY_TITLES = {
            "Burn to death",
            "Drown to death",
            "Die by magma block",
            "Swim in lava",
            "Get pricked to death by sweetberries",
            "Suffocate to death",
    };

    public static String[] MEDIUM_TITLES = {
            "Die from falling anvil",
            "Die from falling Stalactite",
            "Die from magic",
            "Die from wither effect",
            "Starve to death",
    };

    public static String[] HARD_TITLES = {
            "Die from entity cramming",
            "Jump into the void",
            "Die from dragon's breath"
    };
}
