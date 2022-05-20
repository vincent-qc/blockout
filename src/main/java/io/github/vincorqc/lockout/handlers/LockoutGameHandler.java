package io.github.vincorqc.lockout.handlers;

import io.github.vincorqc.lockout.networking.LockoutPacketHandler;
import io.github.vincorqc.lockout.networking.packets.TaskPacket;
import io.github.vincorqc.lockout.data.TaskDifficulty;
import io.github.vincorqc.lockout.tasks.*;

import java.util.ArrayList;
import java.util.Random;

public class LockoutGameHandler {

    private static boolean gameStarted = false;

    public static final Task[][] grid = new Task[5][5];

    protected static final ArrayList<ObtainTask> obtainTasks = new ArrayList<>();
    protected static final ArrayList<AdvancementTask> advancementTasks = new ArrayList<>();
    protected static final ArrayList<KillTask> killTasks = new ArrayList<>();
    protected static final ArrayList<EffectTask> effectTasks = new ArrayList<>();
    protected static final ArrayList<MineTask> mineTasks = new ArrayList<>();
    protected static final ArrayList<DeathTask> deathTasks = new ArrayList<>();
    protected static final ArrayList<CollectTask> collectTasks = new ArrayList<>();
    protected static final ArrayList<ExperienceTask> experienceTasks = new ArrayList<>();
    protected static final ArrayList<OpponentTask> opponentTasks = new ArrayList<>();

    private static final ArrayList<String> usedTasks = new ArrayList<>();

    public static void generateGrid() {
        for(int r = 0; r < 5; r++) {
            for(int c = 0; c < 5; c++) {
                Task t = generateTask();

                while(usedTasks.contains(t.getTitle())) {
                    t = generateTask();
                }

                usedTasks.add(t.getTitle());
                addToLists(t);

                grid[r][c] = t;
            }
        }

        System.out.println("\n\n\n\n\n\n\n" + asString());
    }

    public static void amendGrid(int r, int c, Task t) {
        grid[r][c] = t;
    }

    public static void syncTasks() {
        for(int r = 0; r < 5; r++) {
            for(int c = 0; c < 5; c++) {
                Task t = grid[r][c];
                if(t == null) continue;

                LockoutPacketHandler.sendAll(new TaskPacket(getType(t), t.getDifficulty(), t.getIndex(), t.getTeam(), r, c));
            }
        }
    }

    public static void setGameStarted(boolean b) {
        gameStarted = b;
    }

    public static boolean getGameStarted() {
        return gameStarted;
    }


    /*-----------------*/
    /* PRIVATE METHODS */
    /*-----------------*/

    private static Task generateTask() {
        Task t = null;

        Random r = new Random();
        int diff = r.nextInt(100);

        if(diff < 25) {
            int type = r.nextInt(100);
            TaskDifficulty d = TaskDifficulty.EASY;

            if(type < 25) t = new AdvancementTask(d);
            else if(type < 40) t = new ObtainTask(d);
            else if(type < 50) t = new KillTask(d);
            else if(type < 70) t = new EffectTask(d);
            else if(type < 85) t = new MineTask(d);
            else if(type < 100) t = new DeathTask(d);

        } else if(diff < 60) {
            int type = r.nextInt(100);
            TaskDifficulty d = TaskDifficulty.MEDIUM;

            if(type < 20) t = new AdvancementTask(d);
            else if(type < 35) t = new ObtainTask(d);
            else if(type < 45) t = new KillTask(d);
            else if(type < 60) t = new EffectTask(d);
            else if(type < 75) t = new MineTask(d);
            else if(type < 83) t = new OpponentTask(d);
            else if(type < 85) t = new ExperienceTask(d);
            else if(type < 100) t = new DeathTask(d);

        } else if(diff < 90) {
            int type = r.nextInt(100);
            TaskDifficulty d = TaskDifficulty.HARD;

            if(type < 15) t = new AdvancementTask(d);
            else if(type < 25) t = new ObtainTask(d);
            else if(type < 35) t = new KillTask(d);
            else if(type < 50) t = new CollectTask(d);
            else if(type < 56) t = new MineTask(d);
            else if(type < 80) t = new OpponentTask(d);
            else if(type < 85) t = new ExperienceTask(d);
            else if(type < 100) t = new DeathTask(d);

        } else {
            int type = r.nextInt(100);
            TaskDifficulty d = TaskDifficulty.EXPERT;

            if(type < 25) t = new AdvancementTask(d);
            else if(type < 50) t = new ObtainTask(d);
            else if(type < 75) t = new KillTask(d);
            else if(type < 100) t = new CollectTask(d);
        }

        return t;
    }

    private static void addToLists(Task t) {
        if(t instanceof ObtainTask) obtainTasks.add((ObtainTask) t);
        else if(t instanceof AdvancementTask) advancementTasks.add((AdvancementTask) t);
        else if(t instanceof KillTask) killTasks.add((KillTask) t);
        else if(t instanceof EffectTask) effectTasks.add((EffectTask) t);
        else if(t instanceof MineTask) mineTasks.add((MineTask) t);
        else if(t instanceof DeathTask) deathTasks.add((DeathTask) t);
        else if(t instanceof CollectTask) collectTasks.add((CollectTask) t);
        else if(t instanceof ExperienceTask) experienceTasks.add((ExperienceTask) t);
        else if(t instanceof OpponentTask) opponentTasks.add((OpponentTask) t);
    }

    private static String getType(Task t) {
        if(t instanceof ObtainTask) return "obtain";
        else if(t instanceof AdvancementTask) return "advancement";
        else if(t instanceof KillTask) return "kill";
        else if(t instanceof EffectTask) return "effect";
        else if(t instanceof MineTask) return "mine";
        else if(t instanceof DeathTask) return "death";
        else if(t instanceof CollectTask) return "collect";
        else if(t instanceof ExperienceTask) return "experience";
        else if(t instanceof OpponentTask) return "opponent";
        return null;
    }

    public static String asString() {
        StringBuilder res = new StringBuilder();

        for(Task[] r : grid) {
            for(Task t : r) {
                res.append(t.getTitle()).append(" - TEAM: ").append(t.getTeam()).append("\n");
            }
        }

        return res.toString();
    }
}
