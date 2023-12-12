package net.maxitheslime.twosidesmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.entity.custom.RSEntity;
import net.maxitheslime.twosidesmod.entity.layers.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class RubyStatueRenderer extends MobRenderer<RSEntity, RubyStatueModel<RSEntity>> {
    protected static final ResourceLocation RS_LOCATION = new ResourceLocation(TwoSidesMod.MOD_ID,"textures/entity/ruby_statue.png");
    public RubyStatueRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RubyStatueModel<>(pContext.bakeLayer(ModModelLayers.RS_LAYER)), 1.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(RSEntity pEntity) {
        return RS_LOCATION;
    }

    @Override
    public void render(RSEntity pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pMatrixStack.scale(0.45f, 0.45f, 0.45f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
