package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.FoodList;
import io.github.vincorqc.lockout.data.ItemList;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Map;
import java.util.Random;

public class EatTask extends Task {
    private final Item item;
    private static final Map<TaskDifficulty, Item[]> list = Map.ofEntries(
            Map.entry(TaskDifficulty.EASY, FoodList.EASY_FOOD),
            Map.entry(TaskDifficulty.MEDIUM, FoodList.MEDIUM_FOOD),
            Map.entry(TaskDifficulty.HARD, FoodList.HARD_FOOD)
    );

    public EatTask(TaskDifficulty difficulty) {
        super(difficulty);
        // Assign Random Item
        Random r = new Random();
        Item[] data = list.get(difficulty);

        this.index = r.nextInt(data.length);
        this.item = data[index];
        this.title = "Consume " + new ItemStack(item).getHoverName().getString();
    }

    public EatTask(TaskDifficulty difficulty, int index) {
        super(difficulty);

        Item[] data = list.get(difficulty);

        this.index = index;
        this.item = data[index];
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
