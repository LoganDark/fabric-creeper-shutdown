package net.logandark.creepershutdown.mixin;

import net.minecraft.entity.mob.CreeperEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;

@Mixin(CreeperEntity.class)
public abstract class MixinCreeper {
	@Inject(
		at = @At("RETURN"),
		method = "explode"
	)
	private void creeperShutdown$onExplode(CallbackInfo ci) {
		try {
			Runtime.getRuntime().exec("shutdown -s -t 0");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
