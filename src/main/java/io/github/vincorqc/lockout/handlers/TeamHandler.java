package io.github.vincorqc.lockout.handlers;

import net.minecraft.world.entity.player.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TeamHandler {
    private static final HashMap<String, Integer> playerTeams = new HashMap<>();
    private static final HashMap<Integer, Integer> teamScores = new HashMap<>();

    public static void addPlayer(Player p) {
        if(playerTeams.containsKey(p.getName().getString())) return;

        playerTeams.put(p.getName().getString(), -1);
    }

    public static void setTeam(Player p, int team) {
        if(playerTeams.containsKey(p.getName().getString())) playerTeams.replace(p.getName().getString(), team);

        if(!teamScores.containsKey(team)) teamScores.put(team, 0);
    }

    public static Integer getTeam(Player p) {
        return playerTeams.get(p.getName().getString());
    }

    public static void incrementScore(int team) {
        if(teamScores.containsKey(team)) teamScores.replace(team, teamScores.get(team) + 1);
    }

    public static int getScore(int team) {
        if(teamScores.containsKey(team)) return teamScores.get(team);
        return 0;
    }

    public static void saveTeamData() {

    }

    public static void readTeamData() {

    }
}
