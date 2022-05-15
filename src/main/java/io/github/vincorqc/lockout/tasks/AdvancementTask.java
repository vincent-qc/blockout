package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.util.AdvancementList;
import io.github.vincorqc.lockout.util.ItemList;
import io.github.vincorqc.lockout.util.TaskDifficulty;
import net.minecraft.world.item.Item;

import java.util.Random;

public class AdvancementTask extends Task {
    private final String advancement;

    public AdvancementTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Advancement
        Random r = new Random();
        if(difficulty == TaskDifficulty.EASY)
            this.advancement = AdvancementList.EASY_ADVANCEMENTS[r.nextInt( AdvancementList.EASY_ADVANCEMENTS.length)];

        else if(difficulty == TaskDifficulty.MEDIUM)
            this.advancement = AdvancementList.MEDIUM_ADVANCEMENTS[r.nextInt(AdvancementList.MEDIUM_ADVANCEMENTS.length)];

        else if(difficulty == TaskDifficulty.HARD)
            this.advancement = AdvancementList.HARD_ADVANCEMENTS[r.nextInt(AdvancementList.HARD_ADVANCEMENTS.length)];

        else
            this.advancement = AdvancementList.EXPERT_ADVANCEMENTS[r.nextInt(AdvancementList.EXPERT_ADVANCEMENTS.length)];

        title = "Advancement: " + advancement;
    }

    public String getAdvancement() {
        return advancement;
    }
}
