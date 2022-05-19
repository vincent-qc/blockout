package io.github.vincorqc.lockout.data;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;

public class Keybinds {
    public static final KeyMapping key = new KeyMapping("key.lockout.opengui", InputConstants.KEY_BACKSLASH, "key.categories.ui" );


    public static void register() {
        ClientRegistry.registerKeyBinding(key);
        System.out.println("\n\n\nHERE");
    }
}
