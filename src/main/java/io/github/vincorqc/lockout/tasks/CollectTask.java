package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.util.CollectList;
import io.github.vincorqc.lockout.util.EffectList;
import io.github.vincorqc.lockout.util.TaskDifficulty;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;

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

    public Item[] getCollection() {
        return collection;
    }
}
