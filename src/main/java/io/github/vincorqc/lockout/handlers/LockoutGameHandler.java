package io.github.vincorqc.lockout.handlers;

import io.github.vincorqc.lockout.tasks.*;
import io.github.vincorqc.lockout.util.TaskDifficulty;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.Random;

public class LockoutGameHandler {

    private static final Task[][] grid = new Task[5][5];

    protected static final ArrayList<ObtainTask> obtainTasks = new ArrayList<>();
    protected static final ArrayList<AdvancementTask> advancementTasks = new ArrayList<>();

    public static void generateGrid() {
        for(int r = 0; r < 5; r++) {
            for(int c = 0; c < 5; c++) {
                grid[r][c] = generateTask();
            }
        }
    }


    /*-----------------*/
    /* PRIVATE METHODS */
    /*-----------------*/

    private static Task generateTask() {
        Task t = null;

        Random r = new Random();
        TaskDifficulty diff = TaskDifficulty.EASY; //TaskDifficulty.values()[r.nextInt(5)];

        if(diff == TaskDifficulty.EASY) {
            int type = r.nextInt(2);

            if(type == 0) {
                t = new AdvancementTask(diff);
            } else if(type == 1) {
                t = new ObtainTask(diff);
            } else if(type == 2) {
                t = new EffectTask(diff);
            } else if(type == 3) {
                t = new KillTask(diff);
            } else {
                t = new MineTask(diff);
            }
        }

        if(t instanceof ObtainTask) obtainTasks.add((ObtainTask) t);
        if(t instanceof AdvancementTask) advancementTasks.add((AdvancementTask) t);

        return t;
    }

    public static String asString() {
        String res = "";

        for(Task[] r : grid) {
            for(Task t : r) {
                res += t.getTitle() + " - TEAM: " + t.getTeam() + "\n";
            }
        }

        return res;
    }
}
