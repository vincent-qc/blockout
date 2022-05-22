package io.github.vincorqc.lockout.data;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class OpponentList {

    public static final Map<TaskDifficulty, ArrayList<Item>> list = Map.ofEntries(
            Map.entry(TaskDifficulty.MEDIUM, new ArrayList<>(Arrays.asList(
                    Items.CRAFTING_TABLE,
                    Items.FURNACE
            ))),

            Map.entry(TaskDifficulty.HARD, new ArrayList<>(Arrays.asList(
                    Items.DIAMOND,
                    Items.IRON_INGOT,
                    Items.STICK
            )))
    );
}
