package com.circularsprojects.entitylocator.client;

import com.circularsprojects.entitylocator.mixin.clientProfilerAccessor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
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
            MinecraftClient.getInstance();
        } catch (Exception e) {
            System.out.println("[ENTITYLOCATOR] encountered an error in client init!");
        }
    }
}

class getEntities extends TimerTask {
    public void run() {
        try {
//            MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.translatable(MinecraftClient.getInstance().worldRenderer.getEntitiesDebugString()));
            if (MinecraftClient.getInstance().world.getRegularEntityCount() >= 100) {
                MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.translatable("Detected entity count above 100! Entity count: " + MinecraftClient.getInstance().world.getRegularEntityCount()));
            }
        } catch(Exception e) {
            System.out.println("[ENTITYLOCATOR] encountered an error in time loop!");
        }
        try {
            ProfileResult profileResult = ((clientProfilerAccessor) MinecraftClient.getInstance()).getTickProfilerResult();
            String openProfilerSection = ((clientProfilerAccessor) MinecraftClient.getInstance()).getOpenProfilerSection();

            System.out.println(openProfilerSection);
            System.out.println(profileResult.getTimings(openProfilerSection));
            // GITHUB COPILOT RAMBLING:
            // profileResult.getTimings(openProfilerSection) is a list containing several ProfilerTiming objects
            // each ProfilerTiming object contains:
            // a string name
            // a double parentSectionUsagePercentage
            // a double totalUsagePercentage
            // get these values and display them as "Name [parentSectionUsagePercentage]/[totalUsagePercentage]"
            for (ProfilerTiming profilerRes : profileResult.getTimings(openProfilerSection)) {
                System.out.println();
                System.out.println(profilerRes.name);
                System.out.println(profilerRes.parentSectionUsagePercentage);
                System.out.println(profilerRes.totalUsagePercentage);
                System.out.println();
            }
        } catch(Exception e) {
            System.out.println("[ENTITYLOCATOR] encountered an error in time loop #2!");
        }
    }
}

//    public String getEntitiesDebugString() {
//        return "E: " + this.regularEntityCount + "/" + this.world.getRegularEntityCount() + ", B: " + this.blockEntityCount + ", SD: " + this.world.getSimulationDistance();
//    }
