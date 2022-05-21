package io.github.vincorqc.lockout.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.vincorqc.lockout.handlers.LockoutGameHandler;
import io.github.vincorqc.lockout.networking.LockoutPacketHandler;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;

public class DifficultyCommand implements Command<CommandSourceStack> {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("lockoutDifficulty")
                .requires(source -> source.hasPermission(3))
                .then(Commands.argument("easy", IntegerArgumentType.integer(0, 100))
                        .then(Commands.argument("medium", IntegerArgumentType.integer(0, 100))
                                .then(Commands.argument("hard", IntegerArgumentType.integer(0, 100))
                                .executes(new DifficultyCommand())))));
    }

    @Override
    public int run(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        LockoutGameHandler.setProbability(
                IntegerArgumentType.getInteger(context, "easy"),
                IntegerArgumentType.getInteger(context, "medium"),
                IntegerArgumentType.getInteger(context, "hard")
        );

        TextComponent message = new TextComponent("New probabilities have been assigned");
        Player p = (Player) context.getSource().getEntity();
        p.sendMessage(message, p.getUUID());

        LockoutPacketHandler.sync();
        return 0;
    }
}