package io.github.vincorqc.lockout.handlers;

import io.github.vincorqc.lockout.common.LockoutMod;
import io.github.vincorqc.lockout.networking.LockoutPacketHandler;
import io.github.vincorqc.lockout.networking.packets.TeamPacket;
import io.github.vincorqc.lockout.networking.packets.TeamScorePacket;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class TeamHandler {
    private static final HashMap<String, Integer> playerTeams = new HashMap<>();
    private static final HashMap<Integer, Integer> teamScores = new HashMap<>();

    public static void addPlayer(Player p) {
        if(playerTeams.containsKey(p.getName().getString())) return;

        playerTeams.put(p.getName().getString(), 0);
    }

    public static void addPlayer(String p) {
        if(playerTeams.containsKey(p)) return;

        playerTeams.put(p, 0);
    }

    public static void setTeam(Player p, int team) {
        if(playerTeams.containsKey(p.getName().getString())) {
            playerTeams.replace(p.getName().getString(), team);
        } else {
            addPlayer(p);
        }

        if(team < 1) return;
        if(!teamScores.containsKey(team)) teamScores.put(team, 0);
    }

    public static void setTeam(String p, int team) {
        if(playerTeams.containsKey(p)) {
            playerTeams.replace(p, team);
        } else {
            addPlayer(p);
        }

        if(team == -1) return;
        if(!teamScores.containsKey(team)) teamScores.put(team, 0);
    }

    public static int getTeam(Player p) {
        return playerTeams.get(p.getName().getString());
    }

    public static void incrementScore(int team) {
        if(teamScores.containsKey(team)) {
            teamScores.replace(team, teamScores.get(team) + 1);
            if(teamScores.get(team) > 12) {
                LockoutGameHandler.setGameStarted(false);
                LockoutGameHandler.setGameWon(true);

                for(Player p : LockoutMod.server.getPlayerList().getPlayers()) {
                    p.sendSystemMessage(Component.literal("Team " + team + " won!"));
                    p.playNotifySound(SoundEvents.UI_TOAST_CHALLENGE_COMPLETE, SoundSource.MASTER, 80, 1);
                }
            }
        }
    }

    public static ArrayList<Player> getTeamPlayers(int team) {
        ArrayList<Player> players = new ArrayList<>();
        for(Player p : LockoutMod.server.getPlayerList().getPlayers()) {
            if(getTeam(p) == team) players.add(p);
        }

        return players;
    }

    public static int getScore(int team) {
        if(teamScores.containsKey(team)) return teamScores.get(team);
        return 0;
    }

    public static void setScore(int team, int score) {
        teamScores.put(team, score);
    }

    public static void reset() {
        for(int team : teamScores.keySet()) {
            teamScores.replace(team, 0);
        }

        for(String p : playerTeams.keySet()) {
            playerTeams.replace(p, 0);
        }
    }

    public static void syncTeamData() {
        for(String name : playerTeams.keySet()) {
            LockoutPacketHandler.sendAll(new TeamPacket(name, playerTeams.get(name)));
        }
    }

    public static void syncTeamScores() {
        for(int team : teamScores.keySet()) {
            if(teamScores.containsKey(team)) LockoutPacketHandler.sendAll(new TeamScorePacket(team, teamScores.get(team)));
        }
    }
}
