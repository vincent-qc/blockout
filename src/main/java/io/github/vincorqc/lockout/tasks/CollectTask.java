package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.CollectList;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Map;
import java.util.Random;

public class CollectTask extends Task {
    private final Item[] collection;
    private static final Map<TaskDifficulty, Tuple<Item[][], String[]>> list = Map.ofEntries(
            Map.entry(TaskDifficulty.HARD, new Tuple<>(CollectList.HARD_COLLECT, CollectList.HARD_TITLES)),
            Map.entry(TaskDifficulty.EXPERT, new Tuple<>(CollectList.EXPERT_COLLECT, CollectList.EXPERT_TITLES))
    );

    public CollectTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Item
        Random r = new Random();
        Tuple<Item[][], String[]> data = list.get(difficulty);

        this.index = r.nextInt(data.getA().length);
        this.collection = data.getA()[index];
        this.title = data.getB()[index];
    }

    public CollectTask(TaskDifficulty difficulty, int index) {
        super(difficulty);

        Tuple<Item[][], String[]> data = list.get(difficulty);
        this.index = index;
        this.collection = data.getA()[index];
        this.title = data.getB()[index];
    }



    public ItemStack getItemIcon() {
        return new ItemStack(collection[0]);
    }

    public Item[] getCollection() {
        return collection;
    }

}
