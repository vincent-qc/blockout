package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.DamageList;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import oshi.util.tuples.Triplet;

import java.util.Map;
import java.util.Random;

public class DeathTask extends Task {
    private final DamageSource damageSource;
    private static final Map<TaskDifficulty, Triplet<DamageSource[], Item[], String[]>> list = Map.ofEntries(
            Map.entry(TaskDifficulty.EASY, new Triplet<>(DamageList.EASY_DAMAGE, DamageList.EASY_ICONS, DamageList.EASY_TITLES)),
            Map.entry(TaskDifficulty.MEDIUM, new Triplet<>(DamageList.MEDIUM_DAMAGE, DamageList.MEDIUM_ICONS, DamageList.MEDIUM_TITLES)),
            Map.entry(TaskDifficulty.HARD, new Triplet<>(DamageList.HARD_DAMAGE, DamageList.HARD_ICONS, DamageList.HARD_TITLES))
    );

    public DeathTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Item
        Random r = new Random();
        Triplet<DamageSource[], Item[], String[]> data = list.get(difficulty);

        this.index = r.nextInt(data.getA().length);
        this.damageSource = data.getA()[index];
        this.icon = data.getB()[index];
        this.title = data.getC()[index];
    }

    public DeathTask(String difficulty, int index) {
        super(difficulty);
        this.index = index;

        if(difficulty.equals("easy")) {
            this.difficulty = TaskDifficulty.EASY;
            this.damageSource = DamageList.EASY_DAMAGE[index];
            this.icon = DamageList.EASY_ICONS[index];
            title = DamageList.EASY_TITLES[index];
        } else if(difficulty.equals("medium")) {
            this.difficulty = TaskDifficulty.MEDIUM;
            this.damageSource = DamageList.MEDIUM_DAMAGE[index];
            this.icon = DamageList.MEDIUM_ICONS[index];
            title = DamageList.MEDIUM_TITLES[index];
        } else {
            this.difficulty = TaskDifficulty.HARD;
            this.damageSource = DamageList.HARD_DAMAGE[index];
            this.icon = DamageList.HARD_ICONS[index];
            title = DamageList.HARD_TITLES[index];
        }
    }

    public DamageSource getDamageSource() {
        return damageSource;
    }


    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(icon);
    }
}
