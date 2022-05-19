package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.common.LockoutMod;
import io.github.vincorqc.lockout.handlers.LockoutGameHandler;
import io.github.vincorqc.lockout.handlers.TeamHandler;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import io.github.vincorqc.lockout.networking.LockoutPacketHandler;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;

public class Task {
    protected HashMap<String, String> titles = new HashMap<>();
    protected TaskDifficulty difficulty;
    protected int team = -1;
    protected String title;
    protected int index;
    protected Item icon;

    public Task(TaskDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Task(String difficulty) {
        if(difficulty.equals("easy")) this.difficulty = TaskDifficulty.EASY;
        else if(difficulty.equals("medium")) this.difficulty = TaskDifficulty.MEDIUM;
        else if(difficulty.equals("hard")) this.difficulty = TaskDifficulty.HARD;
        else this.difficulty = TaskDifficulty.EXPERT;
    }

    public void complete(Player p) {
        if(!LockoutGameHandler.getGameStarted()) return;

        if(team == -1) {
            team = TeamHandler.getTeam(p);
            try {
                TextComponent text = new TextComponent("Team " + team + " has completed " + title);

                for(Player pl : LockoutMod.server.getPlayerList().getPlayers()) {
                    pl.sendMessage(text, pl.getUUID());
                    pl.playNotifySound(SoundEvents.PLAYER_LEVELUP, SoundSource.MASTER, 90, 1);
                }

            } catch (Exception e) {
                System.out.println(e.toString());
            }

            TeamHandler.incrementScore(team);

            LockoutPacketHandler.sync();

        }
    }

    public void complete(int t) {
        if(!LockoutGameHandler.getGameStarted()) return;

        if(team == -1) {
            team = t;
            try {
                TextComponent text = new TextComponent("Team " + t + " has completed " + title);

                for(Player pl : LockoutMod.server.getPlayerList().getPlayers()) {
                    pl.sendMessage(text, pl.getUUID());
                    pl.playNotifySound(SoundEvents.PLAYER_LEVELUP, SoundSource.MASTER, 90, 1);
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            TeamHandler.incrementScore(team);
            LockoutPacketHandler.sync();
        }
    }

    public String getTitle() {
        return title;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public ItemStack getItemIcon() {
        return null;
    }

    public TaskDifficulty getDifficulty() {
        return difficulty;
    }

    public int getIndex() {
        return index;
    }
}
