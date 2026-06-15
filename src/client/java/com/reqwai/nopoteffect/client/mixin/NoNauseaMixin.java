package com.reqwai.nopoteffect.client.mixin;

import com.reqwai.nopoteffect.ModConfig;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class NoNauseaMixin {

    @Shadow
    private float spinningEffectTime;

    @Shadow
    private float spinningEffectSpeed;

    @Inject(method = "tick", at = @At("RETURN"))
    private void onTick(CallbackInfo ci) {
        if (ModConfig.isNauseaDisabled()) {
            this.spinningEffectTime = 0.0F;
            this.spinningEffectSpeed = 0.0F;
        }
    }
}
