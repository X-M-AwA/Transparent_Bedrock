package com.transparent_bedrock.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Blocks.class)
@Environment(EnvType.CLIENT)
public abstract class BlocksMixin {

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/Blocks;register(Ljava/lang/String;Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)Lnet/minecraft/world/level/block/Block;"
            )
    )
    private static Block redirectRegister(String string, BlockBehaviour.Properties properties) {
        if ("bedrock".equals(string)) {
            return BlocksRegisterAccessor.invokeRegister(string, TransparentBlock::new, properties.noOcclusion());
        }
        return BlocksRegisterAccessor.register(string, properties);
    }
}
