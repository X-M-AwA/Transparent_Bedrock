package com.transparent_bedrock.mixin;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TransparentBlock.class)
public class TransparentBlockMixin {
    @Inject(
            method = "propagatesSkylightDown",
            at = @At("HEAD"),
            cancellable = true
    )
    private void skyLight(BlockState blockState, CallbackInfoReturnable<Boolean> cir) {
        if (blockState.is(Blocks.BEDROCK)) {
            cir.cancel();
        }
    }
}
