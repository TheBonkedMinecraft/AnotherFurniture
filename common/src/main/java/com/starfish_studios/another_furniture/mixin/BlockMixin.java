package com.starfish_studios.another_furniture.mixin;

import com.starfish_studios.another_furniture.registry.AFBlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class BlockMixin {
    @Inject(method = "isExceptionForConnection", at = @At("HEAD"), cancellable = true)
    private static void onIsExceptionForConnection(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (state.is(AFBlockTags.DONT_CONNECT_TO_PANES)) {
            cir.setReturnValue(true);
        }
    }
}
