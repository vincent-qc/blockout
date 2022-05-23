package io.github.vincorqc.lockout.data;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import oshi.util.tuples.Triplet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;


public class DamageList {
    public static final Map<TaskDifficulty, ArrayList<Triplet<DamageSource, Item, String>>> list = Map.ofEntries(
            Map.entry(TaskDifficulty.EASY, new ArrayList<>(Arrays.asList(
                    new Triplet<>(DamageSource.IN_FIRE, Items.FLINT_AND_STEEL, "Burn to death"),
                    new Triplet<>(DamageSource.HOT_FLOOR, Items.MAGMA_BLOCK, "Die by magma cube"),
                    new Triplet<>(DamageSource.LAVA, Items.LAVA_BUCKET, "Swim in lava"),
                    new Triplet<>(DamageSource.SWEET_BERRY_BUSH, Items.SWEET_BERRIES, "Get pricked to death by sweetberries"),
                    new Triplet<>(DamageSource.IN_WALL, Items.SAND, "Suffocate to death"),
                    new Triplet<>(DamageSource.CACTUS, Items.CACTUS, "Get pricked to death by cactus")
            ))),

            Map.entry(TaskDifficulty.MEDIUM, new ArrayList<>(Arrays.asList(
                    new Triplet<>(DamageSource.FALLING_STALACTITE, Items.POINTED_DRIPSTONE, "Die from falling dripstone"),
                    new Triplet<>(DamageSource.WITHER, Items.WITHER_ROSE, "Wither to death"),
                    new Triplet<>(DamageSource.STARVE, Items.BREAD, "Starve to death")
            ))),

            Map.entry(TaskDifficulty.HARD, new ArrayList<>(Arrays.asList(
                    new Triplet<>(DamageSource.CRAMMING, Items.SKELETON_SKULL, "Die from entity cramming"),
                    new Triplet<>(DamageSource.ANVIL, Items.ANVIL, "Get squashed by an anvil"),
                    new Triplet<>(DamageSource.FREEZE, Items.POWDER_SNOW_BUCKET, "Freeze to death")
            ))),

            Map.entry(TaskDifficulty.EXPERT, new ArrayList<>(Arrays.asList(
                    new Triplet<>(DamageSource.DRAGON_BREATH, Items.DRAGON_BREATH, "Die from dragon's breath"),
                    new Triplet<>(DamageSource.OUT_OF_WORLD, Items.END_PORTAL_FRAME, "Jump into the void")
            )))
    );
}
