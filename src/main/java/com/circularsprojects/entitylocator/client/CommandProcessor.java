package com.circularsprojects.entitylocator.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class CommandProcessor {
    public static boolean processChatMessage(String message) {
        String[] splitmessage = message.split(" ");
        switch (splitmessage[0]) {
            case ";;start":
                MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.translatable("§8[§bEntityLocator§8] §aStarting entity locator..."));
                getEntities.startRunning();
                return true;
            case ";;stop":
                MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.translatable("§8[§bEntityLocator§8] §cStopping entity locator..."));
                getEntities.stopRunning();
                return true;
            case ";;entitythreshold":
                if (splitmessage.length == 2) {
                    try {
                        int threshold = Integer.parseInt(splitmessage[1]);
                        MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.translatable("§8[§bEntityLocator§8] §aEntity threshold set to " + threshold + "."));
                        getEntities.setThreshold(threshold);
                        return true;
                    } catch (Exception e) {
                        MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.translatable("§8[§bEntityLocator§8] §cInvalid entity threshold!"));
                        return true;
                    }
                } else {
                    MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.translatable("§8[§bEntityLocator§8] §cInvalid entity threshold!"));
                    return true;
                }
            default:
                return false;
        }
    }
}
