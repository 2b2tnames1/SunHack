package me.names.sunhack.mixin;


import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinMinecraft {


@Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo ci) {
    System.out.println("Client Working");
}
}
