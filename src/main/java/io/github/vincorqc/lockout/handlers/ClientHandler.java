package io.github.vincorqc.lockout.handlers;

import io.github.vincorqc.lockout.common.LockoutMod;
import io.github.vincorqc.lockout.data.Keybinds;
import io.github.vincorqc.lockout.gui.LockoutScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.checkerframework.checker.units.qual.C;

public class ClientHandler {
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void openLockoutGUI(TickEvent.ClientTickEvent event) {

        if(Keybinds.key.isDown()) {

            Minecraft.getInstance().setScreen(new LockoutScreen(new TextComponent("Blockout")));
        }
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void leaveServer(ClientPlayerNetworkEvent.LoggedOutEvent event) {
        LockoutGameHandler.reset();
        LockoutMod.LOGGER.info("LOGGED OUT");
    }
}
