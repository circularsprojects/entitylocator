package com.circularsprojects.entitylocator.client;

import com.circularsprojects.entitylocator.client.EntitylocatorClient;
import com.mojang.brigadier.Command;

// https://github.com/hhhzzzsss/SongPlayer/blob/master/src/main/java/com/github/hhhzzzsss/songplayer/CommandProcessor.java
// https://github.com/hhhzzzsss/SongPlayer/blob/9a5b59e9f3d2d65602b221bd5331e99c9abed976/src/main/java/com/github/hhhzzzsss/songplayer/mixin/ClientPlayerEntityMixin.java#L19

public class CommandProcessor {


    public static boolean processChatMessage(String message) {
//        if (message.startsWith("$")) {
//            String[] parts = message.substring(1).split(" ", 2);
//            String name = parts.length>0 ? parts[0] : "";
//            String args = parts.length>1 ? parts[1] : "";
//            Command c = commandMap.get(name.toLowerCase());
//            if (c == null) {
//                // chat message, unrecognized command
//            } else {
//                boolean success = c.processCommand(args);
//                if (!success) {
//                    SongPlayer.addChatMessage("§cSyntax - " + c.getSyntax());
//                }
//            }
//            return true;
//        } else {
//            return false;
//        }
        switch (message) {
            case ";;start":
                // impl code later
                return true;
            case ";;stop":
                // impl code later
                return true;
        }
    }
}
