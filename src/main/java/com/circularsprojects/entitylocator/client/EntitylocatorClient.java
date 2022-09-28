package com.circularsprojects.entitylocator.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.Text;

import java.util.Timer;
import java.util.TimerTask;

@Environment(EnvType.CLIENT)
public class EntitylocatorClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        try {
            Timer timer = new Timer();
            timer.schedule(new SayHello(), 0, 5000);
        } catch (Exception e) {
            System.out.println("[ENTITYLOCATOR] encountered an error in client init!");
        }
    }
}

class SayHello extends TimerTask {
    public void run() {
        try {
//            MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.translatable(MinecraftClient.getInstance().worldRenderer.getEntitiesDebugString()));
            if (MinecraftClient.getInstance().world.getRegularEntityCount() >= 100) {
                MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.translatable("Detected entity count above 100! Entity count: " + MinecraftClient.getInstance().world.getRegularEntityCount()));
            }
        } catch(Exception e) {
            System.out.println("[ENTITYLOCATOR] encountered an error in time loop!");
        }
    }
}

//    public String getEntitiesDebugString() {
//        return "E: " + this.regularEntityCount + "/" + this.world.getRegularEntityCount() + ", B: " + this.blockEntityCount + ", SD: " + this.world.getSimulationDistance();
//    }
