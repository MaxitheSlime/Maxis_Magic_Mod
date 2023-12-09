package net.maxitheslime.twosidesmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.entity.custom.RQGEntity;
import net.maxitheslime.twosidesmod.entity.layers.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RQGRenderer extends MobRenderer<RQGEntity, RQGModel<RQGEntity>> {
    private static final ResourceLocation RQG_LOCATION = new ResourceLocation(TwoSidesMod.MOD_ID, "textures/entity/rose_quartz_golem.png");

    public RQGRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RQGModel<>(pContext.bakeLayer(ModModelLayers.RQG_LAYER)), 1.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(RQGEntity pEntity) {
        return RQG_LOCATION;
    }

    @Override
    public void render(RQGEntity pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pMatrixStack.scale(0.45f, 0.45f, 0.45f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}