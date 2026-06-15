package com.transparent_bedrock.mixin;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Blocks.class)
public interface BlocksRegisterAccessor {
    @Invoker("register")
    static Block invokeRegister(String string, BlockBehaviour.Properties properties) {
        throw new AssertionError();
    }
}
