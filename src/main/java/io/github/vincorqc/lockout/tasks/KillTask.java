package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.EffectList;
import io.github.vincorqc.lockout.data.MobList;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import net.minecraft.util.Tuple;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class KillTask extends Task {
    private final String mob;

    public KillTask(TaskDifficulty difficulty) {
        super(difficulty);
        // Assign Random Advancement
        Random r = new Random();
        ArrayList<Tuple<String, Item>> data = MobList.list.get(difficulty);
        this.index = r.nextInt(data.size());
        Tuple<String, Item> temp = data.get(index);

        this.mob = temp.getA();
        this.icon = temp.getB();
        this.title = "Kill a " + mob;
    }

    public KillTask(TaskDifficulty difficulty, int index) {
        super(difficulty);

        ArrayList<Tuple<String, Item>> data = MobList.list.get(difficulty);
        this.index = index;
        Tuple<String, Item> temp = data.get(index);

        this.mob = temp.getA();
        this.icon = temp.getB();
        this.title = "Kill a " + mob;
    }

    public String getMob() {
        return mob;
    }

    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(icon);
    }
}
