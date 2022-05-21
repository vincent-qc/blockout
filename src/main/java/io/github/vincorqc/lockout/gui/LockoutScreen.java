package io.github.vincorqc.lockout.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import io.github.vincorqc.lockout.common.LockoutMod;
import io.github.vincorqc.lockout.handlers.LockoutGameHandler;
import io.github.vincorqc.lockout.handlers.TeamHandler;
import io.github.vincorqc.lockout.tasks.Task;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;

public class LockoutScreen extends Screen {

    private final ResourceLocation GUI = new ResourceLocation(LockoutMod.MODID, "textures/gui/lockout_gui.png");
    private int xPos = -1;
    private int yPos = -1;

    public LockoutScreen(Component p_96550_) {
        super(p_96550_);
    }


    @Override
    public void render(PoseStack stack, int mouseX, int mouseY, float partialTicks) {
        renderBackground(stack, 0);

        Task[][] grid = LockoutGameHandler.grid;

        for(int r = 0 ; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                Task t = grid[r][c];
                if(t == null) continue;

                int gridX = xPos + 8 + (18 * c);
                int gridY = yPos + 24 + (18 * r);

                if(t.getItemIcon() != null) {
                    Minecraft.getInstance().getItemRenderer().renderGuiItem(t.getItemIcon(), gridX, gridY);
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
        assert Minecraft.getInstance().screen != null;
        fill(stack, 0, 0, Minecraft.getInstance().screen.width, Minecraft.getInstance().screen.height, 0x80000000);

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI);

        if(xPos == -1) {
            assert Minecraft.getInstance().screen != null;
            xPos = (Minecraft.getInstance().screen.width / 2) - 51;
            yPos = (Minecraft.getInstance().screen.height / 2) - 60;
        }

        blit(stack, xPos, yPos, 0, 0, 104, 136);

        Task[][] grid = LockoutGameHandler.grid;
        for(int r = 0 ; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                Task t = grid[r][c];
                if(t == null) continue;

                int gridX = xPos + 8 + (18 * c);
                int gridY = yPos + 24 + (18 * r);
                if(t.getTeam() == 1) fill(stack, gridX, gridY, gridX + 16, gridY + 16, 0x50FF0000);
                else if(t.getTeam() == 2) fill(stack, gridX, gridY, gridX + 16, gridY + 16, 0x500000FF);
            }
        }

        String fTOneScore = TeamHandler.getScore(1) < 10 ? "0" + TeamHandler.getScore(1): String.valueOf(TeamHandler.getScore(1));
        String fTTwoScore = TeamHandler.getScore(2) < 10 ? "0" + TeamHandler.getScore(2): String.valueOf(TeamHandler.getScore(2));

        font.draw(stack, fTOneScore, xPos + (52 - 15), yPos + 10, 0xF04040);
        font.draw(stack, "-", xPos + 52, yPos + 10, 0xFFFFFF);
        font.draw(stack, fTTwoScore, xPos + (52 + 9), yPos + 10, 0x4080F0);

        assert Minecraft.getInstance().player != null;
        int team = TeamHandler.getTeam(Minecraft.getInstance().player);
        String text = team > 0 ? "You are Team " + team : "You have no team";
        drawCenteredString(stack, font, text, xPos + 52, yPos + 118, 0xFFFFFF);

    }


}
