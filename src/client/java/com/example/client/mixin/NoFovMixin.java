package com.example.client.mixin;

import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class NoFovMixin {

    @Shadow
    private float fovModifier;

    @Shadow
    private float oldFovModifier;

    @Inject(method = "tickFov", at = @At("HEAD"), cancellable = true)
    private void onTickFov(CallbackInfo ci) {
        this.oldFovModifier = 1.0F;
        this.fovModifier = 1.0F;
        ci.cancel();
    }
}
