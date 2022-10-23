package com.circularsprojects.entitylocator.mixin;

import com.circularsprojects.entitylocator.client.CommandProcessor;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    @Inject(at = @At("HEAD"), method = "sendChatMessage(Ljava/lang/String;Lnet/minecraft/text/Text;)V", cancellable = true)
    private void onSendChatMessage(String message, @Nullable Text preview, CallbackInfo ci) {
        if (CommandProcessor.processChatMessage(message)) {
            ci.cancel();
        }
    }
}