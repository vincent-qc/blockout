package io.github.vincorqc.lockout.data;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class EffectList {
    public static final MobEffect[] EASY_EFFECTS = {
            MobEffects.JUMP,
            MobEffects.MOVEMENT_SPEED,
            MobEffects.NIGHT_VISION,
            MobEffects.POISON,
            MobEffects.WITHER,
            MobEffects.DAMAGE_BOOST,
            MobEffects.WEAKNESS,
            MobEffects.DOLPHINS_GRACE,
            MobEffects.FIRE_RESISTANCE
    };

    public static final MobEffect[] MEDIUM_EFFECTS = {
            MobEffects.ABSORPTION,
            MobEffects.GLOWING,
            MobEffects.BLINDNESS,
            MobEffects.CONFUSION,
            MobEffects.DAMAGE_RESISTANCE
    };

    public static final Item[] EASY_ICONS = {
            Items.RABBIT_FOOT,
            Items.SUGAR,
            Items.ENDER_EYE,
            Items.SPIDER_EYE,
            Items.WITHER_ROSE,
            Items.BLAZE_POWDER,
            Items.FERMENTED_SPIDER_EYE,
            Items.HEART_OF_THE_SEA,
            Items.MAGMA_CREAM
    };

    public static final Item[] MEDIUM_ICONS = {
            Items.GOLDEN_APPLE,
            Items.GLOWSTONE_DUST,
            Items.ENDER_PEARL,
            Items.PUFFERFISH,
            Items.SCUTE
    };
}
