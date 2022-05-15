package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.util.TaskDifficulty;
import io.github.vincorqc.lockout.util.TaskHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ObtainTask extends Task {
    private Item item;

    public ObtainTask(TaskDifficulty difficulty, int id) {
        super();
        this.difficulty = difficulty;

        // Assign Random Item
        if(difficulty == TaskDifficulty.EASY) {
            this.item = TaskHelper.EASY_ITEMS[id];
        } else if(difficulty == TaskDifficulty.MEDIUM) {
            this.item = TaskHelper.MEDIUM_ITEMS[id];
        } else if(difficulty == TaskDifficulty.HARD) {
            this.item = TaskHelper.HARD_ITEMS[id];
        } else {
            this.item = TaskHelper.EXPERT_ITEMS[id];
        }
    }

    public Item getItem() {
        return item;
    }
}
