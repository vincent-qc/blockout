package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.AdvancementList;
import io.github.vincorqc.lockout.data.DamageList;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import oshi.util.tuples.Triplet;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class DeathTask extends Task {
    private final DamageSource damageSource;

    public DeathTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Item
        Random r = new Random();
        ArrayList<Triplet<DamageSource, Item, String>> data = DamageList.list.get(difficulty);
        this.index = r.nextInt(data.size());
        Triplet<DamageSource, Item, String> temp = data.get(index);

        this.damageSource = temp.getA();
        this.icon = temp.getB();
        this.title = temp.getC();
    }

    public DeathTask(TaskDifficulty difficulty, int index) {
        super(difficulty);

        ArrayList<Triplet<DamageSource, Item, String>> data = DamageList.list.get(difficulty);
        this.index = index;
        Triplet<DamageSource, Item, String> temp = data.get(index);

        this.damageSource = temp.getA();
        this.icon = temp.getB();
        this.title = temp.getC();
    }

    public DamageSource getDamageSource() {
        return damageSource;
    }


    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(icon);
    }
}
