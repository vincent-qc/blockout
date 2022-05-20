package io.github.vincorqc.lockout.common;

import com.mojang.logging.LogUtils;
import io.github.vincorqc.lockout.commands.StartCommand;
import io.github.vincorqc.lockout.commands.TeamCommand;
import io.github.vincorqc.lockout.data.Keybinds;
import io.github.vincorqc.lockout.handlers.ClientHandler;
import io.github.vincorqc.lockout.handlers.EventHandler;
import io.github.vincorqc.lockout.networking.LockoutPacketHandler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("lockout")
public class LockoutMod
{
    public static final String MODID = "lockout";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static MinecraftServer server;

    public LockoutMod()
    {

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        MinecraftForge.EVENT_BUS.register(new EventHandler());
        MinecraftForge.EVENT_BUS.register(new ClientHandler());
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("\n\n PREINIT SUCCESSFUL \n\n");

        LockoutPacketHandler.register();

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> Keybinds::register);
    }


    // Irrelevant but im too scared to remove since the forge docs are sus

    private void enqueueIMC(final InterModEnqueueEvent event)
    {

    }

    private void processIMC(final InterModProcessEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("\n\n SERVER STARTED! \n\n");
        server = event.getServer();
        StartCommand.register(server.getCommands().getDispatcher());
        TeamCommand.register(server.getCommands().getDispatcher());
    }
}
