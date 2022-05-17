package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.util.MobList;
import io.github.vincorqc.lockout.util.TaskDifficulty;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.Random;

public class ExperienceTask extends Task {
    private final int level;

    public ExperienceTask(TaskDifficulty difficulty) {
        super(difficulty);

        if(difficulty == TaskDifficulty.MEDIUM)
            level = 20;

        else
            level = 30;

        title = "Reach level +" + this.level;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(Items.EXPERIENCE_BOTTLE);
    }
}
