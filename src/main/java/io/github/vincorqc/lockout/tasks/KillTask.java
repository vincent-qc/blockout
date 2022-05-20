package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.MobList;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Map;
import java.util.Random;

public class KillTask extends Task {
    private final String mob;
    private static final Map<TaskDifficulty, Tuple<String[], Item[]>> list = Map.ofEntries(
            Map.entry(TaskDifficulty.EASY, new Tuple<>(MobList.EASY_MOBS, MobList.EASY_ICONS)),
            Map.entry(TaskDifficulty.MEDIUM, new Tuple<>(MobList.MEDIUM_MOBS, MobList.MEDIUM_ICONS)),
            Map.entry(TaskDifficulty.HARD, new Tuple<>(MobList.HARD_MOBS, MobList.HARD_ICONS)),
            Map.entry(TaskDifficulty.EXPERT, new Tuple<>(MobList.EXPERT_MOBS, MobList.EXPERT_ICONS))
    );

    public KillTask(TaskDifficulty difficulty) {
        super(difficulty);
        // Assign Random Advancement
        Random r = new Random();
        Tuple<String[], Item[]> data = list.get(difficulty);

        this.index = r.nextInt(data.getA().length);
        this.mob = data.getA()[index];
        this.icon = data.getB()[index];
        this.title = "Kill a " + mob;
    }

    public KillTask(TaskDifficulty difficulty, int index) {
        super(difficulty);

        Tuple<String[], Item[]> data = list.get(difficulty);

        this.index = index;
        this.mob = data.getA()[index];
        this.icon = data.getB()[index];
        this.title = "Kill a " + mob;
    }

    public String getMob() {
        return mob;
    }

    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(icon);
    }
}
