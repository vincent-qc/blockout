package io.github.vincorqc.lockout.networking.packets;

import io.github.vincorqc.lockout.common.LockoutMod;
import io.github.vincorqc.lockout.gui.LockoutScreen;
import io.github.vincorqc.lockout.handlers.LockoutGameHandler;
import io.github.vincorqc.lockout.tasks.*;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;
import org.checkerframework.checker.units.qual.K;

import java.util.function.Supplier;

public class TaskPacket {

    private final String type;
    private final String difficulty;
    private final int index;
    private final int team;
    private final int row;
    private final int col;

    public TaskPacket(String type, String difficulty, int index, int team, int row, int col) {
        this.type = type;
        this.difficulty = difficulty;
        this.index = index;
        this.team = team;
        this.row = row;
        this.col = col;
    }

    public static void encode(TaskPacket msg, FriendlyByteBuf buffer) {
        buffer.writeUtf(msg.type);
        buffer.writeUtf(msg.difficulty);
        buffer.writeInt(msg.index);
        buffer.writeInt(msg.team);
        buffer.writeInt(msg.row);
        buffer.writeInt(msg.col);
    }

    public static TaskPacket decode(FriendlyByteBuf buffer) {
        return new TaskPacket(buffer.readUtf(), buffer.readUtf(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt());
    }

    public static class Handler {
        public static void handle(TaskPacket msg, Supplier<NetworkEvent.Context> ctx){
            ctx.get().enqueueWork( ()-> {
                DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                    LockoutGameHandler.amendGrid(msg.row, msg.col, generateTask(msg.type, msg.difficulty, msg.index, msg.team));
                    LockoutMod.LOGGER.info("ROW: " + msg.row + " COL: " + msg.col);
                    LockoutMod.LOGGER.info("TYPE: " + msg.type + " DIFF: " + msg.difficulty + " INDEX: " + msg.index);
                });
            });
            ctx.get().setPacketHandled(true);
        }
    }

    private static Task generateTask(String type, String difficulty, int index, int team) {
        Task t;

        switch (type) {
            case "advancement" -> {
                t = new AdvancementTask(difficulty, index);
            }
            case "collect" -> {
                t = new CollectTask(difficulty, index);
            }
            case "death" -> {
                t = new DeathTask(difficulty, index);
            }
            case "effect" -> {
                t = new EffectTask(difficulty, index);
            }
            case "experience" -> {
                t = new ExperienceTask(difficulty);
            }
            case "kill" -> {
                t = new KillTask(difficulty, index);
            }
            case "mine" -> {
                t = new MineTask(difficulty, index);
            }
            case "obtain" -> {
                t = new ObtainTask(difficulty, index);
            }
            case "opponent" -> {
                t = new OpponentTask(difficulty, index);
            }
            default -> {
                t = null;
            }
        }

        assert t != null;
        t.setTeam(team);

        return t;
    }
}
