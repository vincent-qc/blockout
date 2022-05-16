package io.github.vincorqc.lockout.util;

import net.minecraft.world.damagesource.DamageSource;

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
}
