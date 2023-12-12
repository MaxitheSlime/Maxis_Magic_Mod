package net.maxitheslime.twosidesmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.entity.custom.MagicMissileEntity;
import net.maxitheslime.twosidesmod.entity.layers.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class MagicMissileRenderer extends EntityRenderer<MagicMissileEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(TwoSidesMod.MOD_ID, "textures/entity/magic_missile.png");
    protected MagicMissileModel model;

    public MagicMissileRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        model = new MagicMissileModel<>(pContext.bakeLayer(ModModelLayers.MAGIC_MISSILE_LAYER));
        this.shadowRadius = 0.5f;
    }

    public void render(MagicMissileEntity entity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTick, entity.yRotO, entity.getYRot())));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTick, entity.xRotO, entity.getXRot()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(this.getTextureLocation(entity)), false, false);

        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 0.5f);
        pPoseStack.popPose();
        super.render(entity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }


    @Override
    public ResourceLocation getTextureLocation(MagicMissileEntity pEntity) {
        return TEXTURE;
    }
}