package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.AdvancementList;
import io.github.vincorqc.lockout.data.CollectList;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import oshi.util.tuples.Triplet;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class CollectTask extends Task {
    private final Item[] collection;

    public CollectTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Item
        Random r = new Random();
        ArrayList<Tuple<ArrayList<Item>, String>> data = CollectList.list.get(difficulty);
        this.index = r.nextInt(data.size());

        Tuple<ArrayList<Item>, String> temp = data.get(index);
        this.collection = temp.getA().toArray(new Item[0]);
        this.title = temp.getB();
    }

    public CollectTask(TaskDifficulty difficulty, int index) {
        super(difficulty);

        ArrayList<Tuple<ArrayList<Item>, String>> data = CollectList.list.get(difficulty);
        this.index = index;

        Tuple<ArrayList<Item>, String> temp = data.get(index);
        this.collection = temp.getA().toArray(new Item[0]);
        this.title = temp.getB();
    }



    public ItemStack getItemIcon() {
        return new ItemStack(collection[0]);
    }

    public Item[] getCollection() {
        return collection;
    }

}
