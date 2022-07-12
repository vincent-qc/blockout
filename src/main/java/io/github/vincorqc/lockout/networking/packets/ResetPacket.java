package io.github.vincorqc.lockout.networking.packets;

import io.github.vincorqc.lockout.handlers.LockoutGameHandler;
import io.github.vincorqc.lockout.handlers.TeamHandler;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ResetPacket {

    public ResetPacket() {

    }

    public static void encode(ResetPacket msg, FriendlyByteBuf buffer) {
    }

    public static ResetPacket decode(FriendlyByteBuf buffer) {
        return new ResetPacket();
    }

    public static class Handler {
        public static void handle(ResetPacket msg, Supplier<NetworkEvent.Context> ctx){
            ctx.get().enqueueWork( ()-> {
                DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> LockoutGameHandler::reset);
            });

            ctx.get().setPacketHandled(true);
        }
    }
}
