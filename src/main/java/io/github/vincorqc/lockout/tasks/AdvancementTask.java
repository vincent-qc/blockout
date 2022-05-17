package io.github.vincorqc.lockout.tasks;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.github.vincorqc.lockout.common.LockoutMod;
import io.github.vincorqc.lockout.util.AdvancementList;
import io.github.vincorqc.lockout.util.ItemList;
import io.github.vincorqc.lockout.util.TaskDifficulty;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.openjdk.nashorn.internal.parser.JSONParser;

import javax.json.JsonObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class AdvancementTask extends Task {
    private final String advancement;
    private Item icon;

    public AdvancementTask(TaskDifficulty difficulty) {
        super(difficulty, "advancement_titles");

        // Assign Random Advancement
        Random r = new Random();
        int index;
        if(difficulty == TaskDifficulty.EASY) {
            index = r.nextInt(AdvancementList.EASY_ADVANCEMENTS.length);
            this.advancement = AdvancementList.EASY_ADVANCEMENTS[index];
            icon = AdvancementList.EASY_ICONS[index];
        } else if(difficulty == TaskDifficulty.MEDIUM){
            index  = r.nextInt(AdvancementList.MEDIUM_ADVANCEMENTS.length);
            this.advancement = AdvancementList.MEDIUM_ADVANCEMENTS[index];
            icon = AdvancementList.MEDIUM_ICONS[index];
        } else if(difficulty == TaskDifficulty.HARD) {
            index  = r.nextInt(AdvancementList.HARD_ADVANCEMENTS.length);
            this.advancement = AdvancementList.HARD_ADVANCEMENTS[index];
            icon = AdvancementList.HARD_ICONS[index];
        } else {
            index  = r.nextInt(AdvancementList.EXPERT_ADVANCEMENTS.length);
            this.advancement = AdvancementList.EXPERT_ADVANCEMENTS[index];
            icon = AdvancementList.EXPERT_ICONS[index];
        }


        System.out.println(titles.keySet());
        title = titles.get(this.advancement);
        System.out.println(title);
    }

    public String getAdvancement() {
        return advancement;
    }

    @Override
    public ResourceLocation getIdentifier() {
        return new ResourceLocation(LockoutMod.MODID, "textures/tasks/identifiers/advancement.png");
    }

    @Override
    public ItemStack getItemIcon() {
        return new ItemStack(icon);
    }
}
