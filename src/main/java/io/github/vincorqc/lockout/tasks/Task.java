package io.github.vincorqc.lockout.tasks;

import io.github.vincorqc.lockout.handlers.TeamHandler;
import io.github.vincorqc.lockout.util.TaskDifficulty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class Task {
    protected TaskDifficulty difficulty;
    protected int team = -1;
    protected String title;

    public Task(TaskDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void complete(Player p) {
        if(team == -1) {
            team = TeamHandler.getTeam(p);
            try {
                Minecraft.getInstance().player.sendMessage(new TextComponent(p.getName().getString() + " COMPLETED: " + title), p.getUUID());
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public int getTeam() {
        return team;
    }

    public ItemStack getItemIcon() {
        return null;
    }

    public ResourceLocation getResourceIcon() {
        return null;
    }
}
