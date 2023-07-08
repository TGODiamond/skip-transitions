package com.trufflez.skiptransitions.mixin;

import com.trufflez.skiptransitions.config.ModConfig;
import net.minecraft.client.sounds.SoundManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.minecraft.client.gui.components.toasts.Toast$Visibility")
public class ToastMixin {
    /*
    
    Toasts
    - Removes sound effect for toasts
    
     */
	
	@Inject(method = "playSound", at = @At("HEAD"), cancellable = true)
	public void playSound(SoundManager soundManager, CallbackInfo ci) {
		if(ModConfig.INSTANCE.removeToastsSFX) {
			ci.cancel();
		}
	}
}
