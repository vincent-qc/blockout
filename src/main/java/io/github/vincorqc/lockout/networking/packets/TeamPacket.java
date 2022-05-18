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

public class TeamPacket {
    private String name;
    private int team;

    public TeamPacket(String name, int team) {
            this.name = name;
            this.team = team;
    }

    public static void encode(TeamPacket msg, FriendlyByteBuf buffer) {
        buffer.writeUtf(msg.name);
        buffer.writeInt(msg.team);
    }

    public static TeamPacket decode(FriendlyByteBuf buffer) {
        return new TeamPacket(buffer.readUtf(), buffer.readInt());
    }

    public static class Handler {
        public static void handle(TeamPacket msg, Supplier<NetworkEvent.Context> ctx){
            ctx.get().enqueueWork( ()-> {
                DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                    if(LockoutMod.server != null)
                        TeamHandler.setTeam(Objects.requireNonNull(
                                LockoutMod.server.getPlayerList().getPlayer(UUID.fromString(msg.name))), msg.team);
                        });
            });
            ctx.get().setPacketHandled(true);
        }
    }
}
