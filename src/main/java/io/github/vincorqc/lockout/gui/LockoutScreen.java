package io.github.vincorqc.lockout.gui;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import io.github.vincorqc.lockout.common.LockoutMod;
import io.github.vincorqc.lockout.handlers.LockoutGameHandler;
import io.github.vincorqc.lockout.tasks.Task;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import net.minecraft.client.gui.screens.PopupScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class LockoutScreen extends Screen {

    private final ResourceLocation GUI = new ResourceLocation(LockoutMod.MODID, "textures/gui/lockout_gui.png");
    private int xPos = -1;
    private int yPos = -1;

    public LockoutScreen(Component p_96550_) {
        super(p_96550_);
        assert Minecraft.getInstance().screen != null;

    }


    @Override
    public void render(PoseStack stack, int mouseX, int mouseY, float p_96565_) {
        renderBackground(stack, 0);

        Task[][] grid = LockoutGameHandler.grid;

        for(int r = 0 ; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                int gridX = xPos + 8 + (18 * c);
                int gridY = yPos + 24 + (18 * r);
                Task t = grid[r][c];

                if(t.getItemIcon() != null) {
                    Minecraft.getInstance().getItemRenderer().renderGuiItem(t.getItemIcon(), gridX, gridY);
                } else {
                    Minecraft.getInstance().getItemRenderer().renderGuiItem(new ItemStack(Blocks.BARRIER.asItem()), gridX, gridY);
                }

                if(isMouseOver(mouseX, mouseY, gridX, gridY, 18, 18)) {
                    renderTooltip(stack, new TextComponent(grid[r][c].getTitle()), mouseX, mouseY);
                }
            }
        }
    }

    public boolean isMouseOver(double mx, double my, double x, double y, double w, double h) {
        return (mx > x && mx < x + w) && (my > y && my < y + h);
    }

    @Override
    public void renderBackground(PoseStack stack, int p_96560_) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI);

        if(xPos == -1) {
            assert Minecraft.getInstance().screen != null;
            xPos = (Minecraft.getInstance().screen.width / 2) - 51;
            yPos = (Minecraft.getInstance().screen.height / 2) - 60;
        }

        blit(stack, xPos, yPos, 0, 0, 104, 120);

        Task[][] grid = LockoutGameHandler.grid;
        for(int r = 0 ; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                int gridX = xPos + 8 + (18 * c);
                int gridY = yPos + 24 + (18 * r);
                Task t = grid[r][c];

                if(t.getTeam() == 0) fill(stack, gridX, gridY, gridX + 16, gridY + 16, 0xD0FF0000);
                else if(t.getTeam() == 1) fill(stack, gridX, gridY, gridX + 16, gridY + 16, 0xD00000F0);
            }
        }
    }


}
