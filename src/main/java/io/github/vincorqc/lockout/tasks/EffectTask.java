package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.CollectList;
import io.github.vincorqc.lockout.data.EffectList;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import net.minecraft.util.Tuple;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class EffectTask extends Task {
    private final MobEffect effect;

    public EffectTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Item
        Random r = new Random();
        ArrayList<Tuple<MobEffect, Item>> data = EffectList.list.get(difficulty);
        this.index = r.nextInt(data.size());
        Tuple<MobEffect, Item> temp = data.get(index);

        this.effect= temp.getA();
        this.icon = temp.getB();
        this.title = "Obtain " + effect.getDisplayName().getString();
    }

    public EffectTask(TaskDifficulty difficulty, int index) {
        super(difficulty);

        ArrayList<Tuple<MobEffect, Item>> data = EffectList.list.get(difficulty);
        this.index = index;
        Tuple<MobEffect, Item> temp = data.get(index);

        this.effect= temp.getA();
        this.icon = temp.getB();
        this.title = "Obtain " + effect.getDisplayName().getString();
    }

    public MobEffect getEffect() {
        return effect;
    }

    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(icon);
    }
}
