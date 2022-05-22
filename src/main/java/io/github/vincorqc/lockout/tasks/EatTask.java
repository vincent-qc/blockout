package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.DamageList;
import io.github.vincorqc.lockout.data.FoodList;
import io.github.vincorqc.lockout.data.ItemList;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import oshi.util.tuples.Triplet;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class EatTask extends Task {
    private final Item item;

    public EatTask(TaskDifficulty difficulty) {
        super(difficulty);
        // Assign Random Item
        Random r = new Random();
        ArrayList<Item> data = FoodList.list.get(difficulty);
        this.index = r.nextInt(data.size());

        this.item = data.get(index);
        this.title = "Consume " + new ItemStack(item).getHoverName().getString();
    }

    public EatTask(TaskDifficulty difficulty, int index) {
        super(difficulty);

        ArrayList<Item> data = FoodList.list.get(difficulty);
        this.index = index;

        this.item = data.get(index);
        this.title = "Consume " + new ItemStack(item).getHoverName().getString();
    }

    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(item);
    }

    public Item getItem() {
        return item;
    }
}
