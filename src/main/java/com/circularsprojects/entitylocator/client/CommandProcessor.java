package com.circularsprojects.entitylocator.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class CommandProcessor {
    public static boolean processChatMessage(String message) {
        switch (message) {
            case ";;start":
                MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.translatable("§8[§bEntityLocator§8] §aStarting entity locator..."));
                getEntities.startRunning();
                return true;
            case ";;stop":
                MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.translatable("§8[§bEntityLocator§8] §cStopping entity locator..."));
                getEntities.stopRunning();
                return true;
            default:
                return false;
        }
    }
}
