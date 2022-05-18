package io.github.vincorqc.lockout.networking.packets;

import io.github.vincorqc.lockout.common.LockoutMod;
import io.github.vincorqc.lockout.handlers.TeamHandler;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;

public class TeamScorePacket {
    private final int team;
    private final int score;

    public TeamScorePacket(int team, int score) {
        this.team = team;
        this.score = score;
    }

    public static void encode(TeamScorePacket msg, FriendlyByteBuf buffer) {
        buffer.writeInt(msg.team);
        buffer.writeInt(msg.score);
    }

    public static TeamScorePacket decode(FriendlyByteBuf buffer) {
        return new TeamScorePacket(buffer.readInt(), buffer.readInt());
    }

    public static class Handler {
        public static void handle(TeamScorePacket msg, Supplier<NetworkEvent.Context> ctx){
            ctx.get().enqueueWork( ()-> {
                DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                    TeamHandler.setScore(msg.team, msg.score);
                });
            });
            ctx.get().setPacketHandled(true);
        }
    }
}
