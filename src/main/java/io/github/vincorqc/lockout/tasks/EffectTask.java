package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.util.EffectList;
import io.github.vincorqc.lockout.util.ItemList;
import io.github.vincorqc.lockout.util.TaskDifficulty;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;

import java.util.Random;

public class EffectTask extends Task {
    private final MobEffect effect;

    public EffectTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Item
        Random r = new Random();
        if(difficulty == TaskDifficulty.EASY)
            this.effect = EffectList.EASY_EFFECTS[r.nextInt(EffectList.EASY_EFFECTS.length)];

        else
            this.effect = EffectList.MEDIUM_EFFECTS[r.nextInt(EffectList.MEDIUM_EFFECTS.length)];

    }

    public MobEffect getItem() {
        return effect;
    }
}
