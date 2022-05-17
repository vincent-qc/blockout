package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.util.EffectList;
import io.github.vincorqc.lockout.util.ItemList;
import io.github.vincorqc.lockout.util.TaskDifficulty;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

public class EffectTask extends Task {
    private final MobEffect effect;
    private Item icon;

    public EffectTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Item
        Random r = new Random();
        int index;
        if(difficulty == TaskDifficulty.EASY) {
            index = r.nextInt(EffectList.EASY_EFFECTS.length);
            this.effect = EffectList.EASY_EFFECTS[index];
            icon = EffectList.EASY_ICONS[index];
        } else {
            index = r.nextInt(EffectList.MEDIUM_EFFECTS.length);
            this.effect = EffectList.MEDIUM_EFFECTS[index];
            icon = EffectList.MEDIUM_ICONS[index];
        }

        title = "Obtain " + effect.getDisplayName().getString();
    }

    public MobEffect getEffect() {
        return effect;
    }

    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(icon);
    }
}
