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
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class DifficultyCommand implements Command<CommandSourceStack> {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("blockoutDifficulty")
                .requires(source -> source.hasPermission(3))
                .then(Commands.argument("easy", IntegerArgumentType.integer(0, 25))
                        .then(Commands.argument("medium", IntegerArgumentType.integer(0, 25))
                                .then(Commands.argument("hard", IntegerArgumentType.integer(0, 25))
                                        .then(Commands.argument("expert", IntegerArgumentType.integer(0, 21))
                                                .executes(new DifficultyCommand()))))));
    }

    @Override
    public int run(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        int easy = IntegerArgumentType.getInteger(context, "easy");
        int medium = IntegerArgumentType.getInteger(context, "medium") + easy;
        int hard = IntegerArgumentType.getInteger(context, "hard") + medium;
        int expert = IntegerArgumentType.getInteger(context, "expert") + hard;

        if(expert != 25) {
            context.getSource().sendFailure(Component.literal("The sum of the rates must be equal to 25"));
            return 0;
        }

        LockoutGameHandler.setProbability(
                easy,
                medium,
                hard,
                expert
        );

        context.getSource().sendSuccess(Component.literal("New rates have been assigned"), false);

        LockoutPacketHandler.sync();
        return 0;
    }
}