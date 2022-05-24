package io.github.vincorqc.lockout.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.vincorqc.lockout.common.LockoutMod;
import io.github.vincorqc.lockout.handlers.LockoutGameHandler;
import io.github.vincorqc.lockout.handlers.TeamHandler;
import io.github.vincorqc.lockout.networking.LockoutPacketHandler;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;

import java.util.concurrent.locks.Lock;


public class StartCommand implements Command<CommandSourceStack> {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("blockoutStart")
                .requires(source -> source.hasPermission(3))
                .executes(new StartCommand())
        );
    }

    @Override
    public int run(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        if(LockoutGameHandler.getGameStarted() || LockoutGameHandler.getGameWon()) {
            TextComponent message = new TextComponent("Game is still running, please reset it first");

            Player p = (Player) context.getSource().getEntity();
            p.sendMessage(message, p.getUUID());

            return 0;
        }

        LockoutGameHandler.setGameStarted(true);
        LockoutGameHandler.reset();
        LockoutGameHandler.generateGrid();
        LockoutPacketHandler.sync();

        TextComponent message = new TextComponent("Game has Started!");

        System.out.println(LockoutGameHandler.asString());

        for (Player p : LockoutMod.server.getPlayerList().getPlayers()) {
            p.sendMessage(message, p.getUUID());
        }
        return 0;
    }
}
