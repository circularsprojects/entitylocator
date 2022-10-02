package com.circularsprojects.entitylocator.client;

import com.circularsprojects.entitylocator.mixin.clientProfilerAccessor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.profiler.ProfileResult;
import net.minecraft.util.profiler.ProfilerTiming;

import java.util.Timer;
import java.util.TimerTask;

@Environment(EnvType.CLIENT)
public class EntitylocatorClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        try {
            Timer timer = new Timer();
            timer.schedule(new getEntities(), 0, 5000);
        } catch (Exception e) {
            System.out.println("[ENTITYLOCATOR] encountered an error in client init!");
            System.out.println(e);
        }
    }
}

class getEntities extends TimerTask {
    //    private void addDebugMessage(Formatting formatting, Text text) {
//        MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.empty().append((Text)Text.translatable("debug.prefix").formatted(formatting, Formatting.BOLD)).append(" ").append(text));
//    }
//    private void debugLog(Text text) {
//        this.addDebugMessage(Formatting.YELLOW, text);
//    }
//    private void debugLog(String key, Object... args) {
//        this.debugLog(Text.translatable(key, args));
//    }
    public void run() {
        try {
//            MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.translatable(MinecraftClient.getInstance().worldRenderer.getEntitiesDebugString()));
            if (MinecraftClient.getInstance().world.getRegularEntityCount() >= 100) {
                MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.translatable("Detected entity count above 100! Entity count: " + MinecraftClient.getInstance().world.getRegularEntityCount()));
            }
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                System.out.println("[ENTITYLOCATOR] Time loop #1 (entity count) is unable to function, likely as a world is not loaded.");
            } else {
                System.out.println("[ENTITYLOCATOR] encountered an error in time loop! (entity count)");
                System.out.println(e);
            }
        }
        try {
            ProfileResult profileResult = ((clientProfilerAccessor) MinecraftClient.getInstance()).getTickProfilerResult();

//            if (MinecraftClient.getInstance().toggleDebugProfiler(this::debugLog)) {
//                this.debugLog("debug.profiling.start", 10);
//            } else {
//                MinecraftClient.getInstance().toggleDebugProfiler(this::debugLog);
//            }
            for (ProfilerTiming profilerRes : profileResult.getTimings("root\u001Etick\u001Elevel\u001EblockEntities")) {
                // detect chest, ender_chest, enchanting_table, shulker_box
                switch (profilerRes.name) {
                    case "minecraft:ender_chest" ->
                            MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.translatable("Detected ender chest!"));
                    case "minecraft:enchanting_table" ->
                            MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.translatable("Detected enchanting table!"));
                    case "minecraft:shulker_box" ->
                            MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.translatable("Detected shulker box!"));
                }
            }
        } catch (Exception e) {
            // check if the error is a java.lang.NullPointerException
            if (e instanceof NullPointerException) {
                System.out.println("[ENTITYLOCATOR] Time loop #2 (profiler) is unable to function because the profiler is not open.");
            } else {
                System.out.println("[ENTITYLOCATOR] encountered an error in time loop #2!");
            }
        }
    }
}