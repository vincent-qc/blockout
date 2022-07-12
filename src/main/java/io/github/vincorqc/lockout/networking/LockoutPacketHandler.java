package io.github.vincorqc.lockout.networking;

import io.github.vincorqc.lockout.common.LockoutMod;
import io.github.vincorqc.lockout.handlers.LockoutGameHandler;
import io.github.vincorqc.lockout.handlers.TeamHandler;
import io.github.vincorqc.lockout.networking.packets.ResetPacket;
import io.github.vincorqc.lockout.networking.packets.TaskPacket;
import io.github.vincorqc.lockout.networking.packets.TeamPacket;
import io.github.vincorqc.lockout.networking.packets.TeamScorePacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.Objects;

public class LockoutPacketHandler {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation("lockout", "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void register() {
        int id = 0;

        INSTANCE.registerMessage(id++, TaskPacket.class, TaskPacket::encode, TaskPacket::decode, TaskPacket.Handler::handle);
        INSTANCE.registerMessage(id++, TeamPacket.class, TeamPacket::encode, TeamPacket::decode, TeamPacket.Handler::handle);
        INSTANCE.registerMessage(id++, TeamScorePacket.class, TeamScorePacket::encode, TeamScorePacket::decode, TeamScorePacket.Handler::handle);
        INSTANCE.registerMessage(id++, ResetPacket.class, ResetPacket::encode, ResetPacket::decode, ResetPacket.Handler::handle);
    }

    public static void sendToPlayer(Object msg, Player p) {
        INSTANCE.sendTo(msg, Objects.requireNonNull(LockoutMod.server.getPlayerList().getPlayer(p.getUUID())).connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
    }

    public static void sendAll(Object msg) {
        INSTANCE.send(PacketDistributor.ALL.noArg(), msg);
    }

    public static void sync() {
        try {
            LockoutGameHandler.syncTasks();
            TeamHandler.syncTeamData();
            TeamHandler.syncTeamScores();
        } catch (Exception e) {
            LockoutMod.LOGGER.info("Exception caught while trying to sync: " + e);
        }
    }
}
