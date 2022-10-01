package com.circularsprojects.entitylocator.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.profiler.ProfileResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MinecraftClient.class)
public interface clientProfilerAccessor {
    @Accessor("tickProfilerResult")
    ProfileResult getTickProfilerResult();

    @Accessor("openProfilerSection")
    String getOpenProfilerSection();
}
