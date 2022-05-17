package io.github.vincorqc.lockout.tasks;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.github.vincorqc.lockout.common.LockoutMod;
import io.github.vincorqc.lockout.handlers.TeamHandler;
import io.github.vincorqc.lockout.util.TaskDifficulty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.loading.targets.FMLServerLaunchHandler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;

public class Task {
    protected HashMap<String, String> titles = new HashMap<>();
    protected TaskDifficulty difficulty;
    protected int team = -1;
    protected String title;

    public Task(TaskDifficulty difficulty) {
        this.difficulty = difficulty;

    }

    public Task(TaskDifficulty difficulty, String titleJson) {
        try {
            ResourceLocation loc = new ResourceLocation(LockoutMod.MODID,  "data/titles/" + titleJson + ".json");
            InputStream in = Minecraft.getInstance().getResourceManager().getResource(loc).getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            titles = new Gson().fromJson(reader,  new TypeToken<HashMap<String, String>>(){}.getType());
            reader.close();

            this.difficulty = difficulty;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void complete(Player p) {
        if(team == -1) {
            team = TeamHandler.getTeam(p);
            try {
                for(Player pl : LockoutMod.server.getPlayerList().getPlayers()) {
                    LockoutMod.server.getPlayerList().broadcastMessage(new TextComponent(p.getName().getString() + " COMPLETED: " + title), ChatType.GAME_INFO, pl.getUUID());
                }

            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    public void complete(int t) {
        if(team == -1) {
            team = t;
            try {
                for(Player p : LockoutMod.server.getPlayerList().getPlayers()) {
                    LockoutMod.server.getPlayerList().broadcastMessage(new TextComponent("Team " + t + " has completed " + title), ChatType.GAME_INFO, p.getUUID());
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public int getTeam() {
        return team;
    }

    public ItemStack getItemIcon() {
        return null;
    }

    public ResourceLocation getResourceIcon() {
        return null;
    }

    public ResourceLocation getIdentifier() {
        return null;
    }
}
