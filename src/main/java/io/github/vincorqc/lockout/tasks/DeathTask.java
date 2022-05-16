package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.util.DamageList;
import io.github.vincorqc.lockout.util.EffectList;
import io.github.vincorqc.lockout.util.TaskDifficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;

import java.util.Random;

public class DeathTask extends Task {
    private final DamageSource damageSource;

    public DeathTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Item
        Random r = new Random();
        if(difficulty == TaskDifficulty.EASY)
            this.damageSource = DamageList.EASY_DAMAGE[r.nextInt(DamageList.EASY_DAMAGE.length)];

        else if(difficulty == TaskDifficulty.MEDIUM)
            this.damageSource = DamageList.MEDIUM_DAMAGE[r.nextInt(DamageList.MEDIUM_DAMAGE.length)];
        else
            this.damageSource = DamageList.HARD_DAMAGE[r.nextInt(DamageList.HARD_DAMAGE.length)];

        title = "Die by " + damageSource.getMsgId();
    }

    public DamageSource getDamageSource() {
        return damageSource;
    }
}
