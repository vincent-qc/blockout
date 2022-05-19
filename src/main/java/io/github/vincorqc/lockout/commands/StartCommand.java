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


public class StartCommand implements Command<CommandSourceStack> {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("lockoutStart")
                .requires(source -> source.hasPermission(3))
                .executes(new StartCommand())
        );
    }

    @Override
    public int run(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        LockoutGameHandler.setGameStarted(true);
        LockoutGameHandler.generateGrid();
        LockoutPacketHandler.sync();

        TextComponent message = new TextComponent("Game has Started!");

        for (Player p : LockoutMod.server.getPlayerList().getPlayers()) {
            p.sendMessage(message, p.getUUID());
        }
        return 0;
    }
}
