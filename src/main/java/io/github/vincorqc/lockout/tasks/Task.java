package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.common.LockoutMod;
import io.github.vincorqc.lockout.handlers.LockoutGameHandler;
import io.github.vincorqc.lockout.handlers.TeamHandler;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import io.github.vincorqc.lockout.networking.LockoutPacketHandler;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;

public class Task {
    protected HashMap<String, String> titles = new HashMap<>();
    protected TaskDifficulty difficulty;
    protected int team = 0;
    protected String title;
    protected int index;
    protected Item icon;

    public Task(TaskDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public boolean complete(Player p) {
        if (!LockoutGameHandler.getGameStarted()) return false;
        int pTeam = TeamHandler.getTeam(p);

        if (team < 1 && pTeam > 0) {
            team = pTeam;

            sendAnnouncement();
            TeamHandler.incrementScore(team);
            LockoutPacketHandler.sync();
            return true;
        }

        return false;
    }

    public boolean complete(int t) {
        if (!LockoutGameHandler.getGameStarted()) return false;

        if (team < 1 && t > 0) {
            team = t;

            sendAnnouncement();
            TeamHandler.incrementScore(team);
            LockoutPacketHandler.sync();
            return true;
        }

        return false;
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

    private void sendAnnouncement() {
        TextComponent text = new TextComponent("Team " + team + " has completed " + title);

        for (Player pl : LockoutMod.server.getPlayerList().getPlayers()) {
            pl.sendMessage(text, pl.getUUID());

            pl.playNotifySound(SoundEvents.PLAYER_LEVELUP, SoundSource.MASTER, 90, 1);
        }
    }
}
