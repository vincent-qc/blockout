package io.github.vincorqc.lockout.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.vincorqc.lockout.common.LockoutMod;
import io.github.vincorqc.lockout.handlers.TeamHandler;
import io.github.vincorqc.lockout.networking.LockoutPacketHandler;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

import java.util.concurrent.locks.Lock;

public class TeamDisplayCommand implements Command<CommandSourceStack> {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("blockoutDisplayTeams")
                .requires(source -> source.hasPermission(1))
                .then(Commands.argument("team", IntegerArgumentType.integer(1, 2))
                                .executes(new TeamCommand())));
    }

    @Override
    public int run(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        int team = IntegerArgumentType.getInteger(context, "team");

        StringBuilder str = new StringBuilder("Team " + team + " players:\n");

        for(Player p : TeamHandler.getTeamPlayers(team)) {
            str.append(p.getName().getString()).append("\n");
        }

        TextComponent message = new TextComponent(str.toString());

        return 0;
    }
}
