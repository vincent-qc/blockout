package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.common.LockoutMod;
import io.github.vincorqc.lockout.util.ItemList;
import io.github.vincorqc.lockout.util.OpponentList;
import io.github.vincorqc.lockout.util.TaskDifficulty;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Objects;
import java.util.Random;

public class OpponentTask extends Task {
    private final Item item;

    public OpponentTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Item
        Random r = new Random();
        if(difficulty == TaskDifficulty.MEDIUM) {
            index = r.nextInt(OpponentList.MEDIUM_ITEMS.length);
            this.item = OpponentList.MEDIUM_ITEMS[index];
        } else {
            index = r.nextInt(OpponentList.HARD_ITEMS.length);
            this.item = OpponentList.HARD_ITEMS[index];
        }

        title = "Opponent obtains " + new ItemStack(item).getHoverName().getString();
    }

    public OpponentTask(String difficulty, int index) {
        super(difficulty);
        this.index = index;

        if(difficulty.equals("medium")) {
            this.item = OpponentList.MEDIUM_ITEMS[index];
            this.difficulty = TaskDifficulty.MEDIUM;
        } else {
            this.item = OpponentList.HARD_ITEMS[index];
            this.difficulty = TaskDifficulty.HARD;
        }

        title = "Opponent obtains " + new ItemStack(item).getHoverName().getString();
    }

    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(item);
    }

    public Item getItem() {
        return item;
    }

}
