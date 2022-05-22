package io.github.vincorqc.lockout.data;

import net.minecraft.util.Tuple;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class EffectList {
    public static final Map<TaskDifficulty, ArrayList<Tuple<MobEffect, Item>>> list = Map.ofEntries(
            Map.entry(TaskDifficulty.EASY, new ArrayList<>(Arrays.asList(
                    new Tuple<>(MobEffects.JUMP, Items.RABBIT_FOOT),
                    new Tuple<>(MobEffects.MOVEMENT_SPEED, Items.SUGAR),
                    new Tuple<>(MobEffects.NIGHT_VISION, Items.ENDER_EYE),
                    new Tuple<>(MobEffects.POISON, Items.SPIDER_EYE),
                    new Tuple<>(MobEffects.WITHER, Items.WITHER_ROSE),
                    new Tuple<>(MobEffects.DAMAGE_BOOST, Items.BLAZE_POWDER),
                    new Tuple<>(MobEffects.WEAKNESS, Items.FERMENTED_SPIDER_EYE),
                    new Tuple<>(MobEffects.DOLPHINS_GRACE, Items.HEART_OF_THE_SEA),
                    new Tuple<>(MobEffects.FIRE_RESISTANCE, Items.MAGMA_CREAM)
            ))),

            Map.entry(TaskDifficulty.MEDIUM, new ArrayList<>(Arrays.asList(
                    new Tuple<>(MobEffects.ABSORPTION, Items.GOLDEN_APPLE),
                    new Tuple<>(MobEffects.GLOWING, Items.GLOWSTONE_DUST),
                    new Tuple<>(MobEffects.BLINDNESS, Items.ENDER_PEARL),
                    new Tuple<>(MobEffects.CONFUSION, Items.PUFFERFISH),
                    new Tuple<>(MobEffects.DAMAGE_RESISTANCE, Items.SCUTE)
            )))
    );
}
