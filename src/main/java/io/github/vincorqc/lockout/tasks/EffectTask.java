package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.EffectList;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import net.minecraft.util.Tuple;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Map;
import java.util.Random;

public class EffectTask extends Task {
    private final MobEffect effect;
    private static final Map<TaskDifficulty, Tuple<MobEffect[], Item[]>> list = Map.ofEntries(
            Map.entry(TaskDifficulty.EASY, new Tuple<>(EffectList.EASY_EFFECTS, EffectList.EASY_ICONS)),
            Map.entry(TaskDifficulty.MEDIUM, new Tuple<>(EffectList.MEDIUM_EFFECTS, EffectList.MEDIUM_ICONS))
    );

    public EffectTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Item
        Random r = new Random();
        Tuple<MobEffect[], Item[]> data = list.get(difficulty);

        this.index = r.nextInt(data.getA().length);
        this.effect = data.getA()[index];
        this.icon = data.getB()[index];
        this.title = "Obtain " + effect.getDisplayName().getString();
    }

    public EffectTask(String difficulty, int index) {
        super(difficulty);
        this.index = index;
        if(difficulty.equals("easy")) {
            this.difficulty = TaskDifficulty.EASY;
            this.effect = EffectList.EASY_EFFECTS[index];
            this.icon = EffectList.EASY_ICONS[index];
        } else {
            this.difficulty = TaskDifficulty.MEDIUM;
            this.effect = EffectList.MEDIUM_EFFECTS[index];
            this.icon = EffectList.MEDIUM_ICONS[index];
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
