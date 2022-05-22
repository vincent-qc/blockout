package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.data.AdvancementList;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import oshi.util.tuples.Triplet;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class AdvancementTask extends Task {
    private final String advancement;

    public AdvancementTask(TaskDifficulty difficulty) {
        super(difficulty);

        // Assign Random Advancement
        Random r = new Random();
        ArrayList<Triplet<String, Item, String>> data = AdvancementList.list.get(difficulty);
        this.index = r.nextInt(data.size());
        Triplet<String, Item, String> temp = data.get(index);
        this.advancement = temp.getA();
        this.icon = temp.getB();
        this.title = temp.getC();
    }

    public AdvancementTask(TaskDifficulty difficulty, int index) {
        super(difficulty);


        ArrayList<Triplet<String, Item, String>> data = AdvancementList.list.get(difficulty);
        this.index = index;
        Triplet<String, Item, String> temp = data.get(index);
        this.advancement = temp.getA();
        this.icon = temp.getB();
        this.title = temp.getC();
    }

    public String getAdvancement() {
        return advancement;
    }


    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(icon);
    }
}
