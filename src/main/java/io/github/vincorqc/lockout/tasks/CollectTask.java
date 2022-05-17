package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.common.LockoutMod;
import io.github.vincorqc.lockout.util.CollectList;
import io.github.vincorqc.lockout.util.EffectList;
import io.github.vincorqc.lockout.util.TaskDifficulty;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

public class CollectTask extends Task {
    private final Item[] collection;

    public CollectTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Item
        Random r = new Random();
        if (difficulty == TaskDifficulty.HARD) {
            int index = r.nextInt(CollectList.HARD_COLLECT.length);
            this.collection = CollectList.HARD_COLLECT[index];
            title = CollectList.HARD_TITLES[index];
        } else {
            int index = r.nextInt(CollectList.EXPERT_COLLECT.length);
            this.collection = CollectList.EXPERT_COLLECT[index];
            title = CollectList.EXPERT_TITLES[index];
        }
    }

    public ItemStack getItemIcon() {
        return new ItemStack(collection[0]);
    }

    public Item[] getCollection() {
        return collection;
    }

    @Override
    public ResourceLocation getIdentifier() {
        return new ResourceLocation(LockoutMod.MODID, "textures/tasks/identifiers/collect.png");
    }
}
