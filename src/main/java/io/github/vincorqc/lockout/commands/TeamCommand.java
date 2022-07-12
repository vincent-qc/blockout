package io.github.vincorqc.lockout.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.vincorqc.lockout.handlers.TeamHandler;
import io.github.vincorqc.lockout.networking.LockoutPacketHandler;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.locks.Lock;

public class TeamCommand implements Command<CommandSourceStack> {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("blockoutTeam")
                .requires(source -> source.hasPermission(3))
                .then(Commands.argument("target", EntityArgument.player())
                        .then(Commands.argument("team", IntegerArgumentType.integer(0, 2))
                                .executes(new TeamCommand()))));
    }

    @Override
    public int run(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer p = EntityArgument.getPlayer(context, "target");
        int team = IntegerArgumentType.getInteger(context, "team");

        TeamHandler.setTeam(p, team);

        String text = team > 0 ? "You have been assigned to Team " + team : "You have been set to no team";
        p.sendSystemMessage(Component.literal(text));

        LockoutPacketHandler.sync();

        return 0;
    }
}
