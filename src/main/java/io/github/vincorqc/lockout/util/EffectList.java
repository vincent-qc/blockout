package io.github.vincorqc.lockout.util;

import com.mojang.blaze3d.shaders.Effect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
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
}
