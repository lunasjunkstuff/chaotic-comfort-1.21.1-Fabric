package lunaastryx.chaotic_comfort.mixin;

import lunaastryx.chaotic_comfort.ChaoticComfort;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ModelLoader.class)
public abstract class ModelLoaderMixin {
    @Shadow
    protected abstract void loadItemModel(ModelIdentifier id);

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;loadItemModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 1))
    private void onInit(CallbackInfo ci) {
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(ChaoticComfort.MOD_ID, "electric_guitar_3d")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(ChaoticComfort.MOD_ID, "glitchy_electric_guitar_3d")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(ChaoticComfort.MOD_ID, "baguette_3d")));
    }
}