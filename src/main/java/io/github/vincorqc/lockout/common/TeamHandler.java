package io.github.vincorqc.lockout.common;

import net.minecraft.world.entity.player.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TeamHandler {
    private static final HashMap<Player, Integer> playerTeams = new HashMap<>();

    public static void addPlayer(Player p) {
        if(playerTeams.containsKey(p)) return;

        playerTeams.put(p, -1);
    }

    public static void setTeam(Player p, int team) {
        if(!playerTeams.containsKey(p)) return;

        playerTeams.replace(p, team);
    }

    public static Integer getTeam(Player p) {
        return playerTeams.get(p);
    }

    public static void saveTeamData() {

    }

    public static void readTeamData() {

    }
}
