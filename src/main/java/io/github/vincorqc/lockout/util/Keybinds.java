package io.github.vincorqc.lockout.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;

public class Keybinds {
    public static final KeyMapping key = new KeyMapping("key.lockout.opengui", InputConstants.KEY_BACKSLASH, "key.categories.lockout.lockout" );


    public static void register() {
        ClientRegistry.registerKeyBinding(key);
    }
}
