package net.maxitheslime.twosidesmod.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.entity.custom.RQGEntity;
import net.maxitheslime.twosidesmod.entity.layers.ModModelLayers;
import net.maxitheslime.twosidesmod.entity.variant.RQGVariant;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class RQGRenderer extends MobRenderer<RQGEntity, RQGModel<RQGEntity>> {
    private static final Map<RQGVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(RQGVariant.class), map -> {
                map.put(RQGVariant.DEFAULT,
                        new ResourceLocation(TwoSidesMod.MOD_ID, "textures/entity/rose_quartz_golem.png"));
                map.put(RQGVariant.GOLD,
                        new ResourceLocation(TwoSidesMod.MOD_ID, "textures/entity/rose_quartz_golem_alt.png"));
            });
    public RQGRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RQGModel<>(pContext.bakeLayer(ModModelLayers.RQG_LAYER)), 1.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(RQGEntity pEntity) {
        return LOCATION_BY_VARIANT.get(pEntity.getVariant());
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