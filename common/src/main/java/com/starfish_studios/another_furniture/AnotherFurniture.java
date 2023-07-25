package com.starfish_studios.another_furniture;

import com.starfish_studios.another_furniture.integration.IntegrationHandler;
import com.starfish_studios.another_furniture.registry.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnotherFurniture {
    public static final String MOD_ID = "another_furniture";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final CreativeModeTab TAB = AFRegistry.registerCreativeModeTab(new ResourceLocation(MOD_ID, "tab"), () -> new ItemStack(AFBlocks.OAK_CHAIR.get()));

    public static void init() {
        AFBlocks.init();
        AFItems.init();
        AFSoundEvents.init();
        AFEntityTypes.init();
        AFBlockEntityTypes.init();

        AFItemTags.init();
        AFBlockTags.init();

        IntegrationHandler.init();

    }
}