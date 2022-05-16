package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.util.TaskDifficulty;
import io.github.vincorqc.lockout.util.ItemList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

public class ObtainTask extends Task {
    private final Item item;

    public ObtainTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Item
        Random r = new Random();
        if(difficulty == TaskDifficulty.EASY)
            this.item = ItemList.EASY_ITEMS[r.nextInt(ItemList.EASY_ITEMS.length)];

        else if(difficulty == TaskDifficulty.MEDIUM)
            this.item = ItemList.MEDIUM_ITEMS[r.nextInt(ItemList.MEDIUM_ITEMS.length)];

        else if(difficulty == TaskDifficulty.HARD)
            this.item = ItemList.HARD_ITEMS[r.nextInt(ItemList.HARD_ITEMS.length)];

        else
            this.item = ItemList.EXPERT_ITEMS[r.nextInt(ItemList.EXPERT_ITEMS.length)];

        title = "Obtain " + item.toString();
    }

    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(item);
    }

    public Item getItem() {
        return item;
    }
}
