package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.common.LockoutMod;
import io.github.vincorqc.lockout.util.ItemList;
import io.github.vincorqc.lockout.util.OpponentList;
import io.github.vincorqc.lockout.util.TaskDifficulty;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

public class OpponentTask extends Task {
    private final Item item;

    public OpponentTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Item
        Random r = new Random();
        if(difficulty == TaskDifficulty.MEDIUM)
            this.item = OpponentList.MEDIUM_ITEMS[r.nextInt(OpponentList.MEDIUM_ITEMS.length)];

        else
            this.item = OpponentList.HARD_ITEMS[r.nextInt(OpponentList.HARD_ITEMS.length)];

        title = "Opponent obtains " + item.toString();
    }

    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(item);
    }

    public Item getItem() {
        return item;
    }

    @Override
    public ResourceLocation getIdentifier() {
        return new ResourceLocation(LockoutMod.MODID, "textures/tasks/identifiers/opponent.png");
    }
}
