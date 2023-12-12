package net.maxitheslime.twosidesmod.entity.client;// Made with Blockbench 4.9.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class MagicMissileModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart missile;

	public MagicMissileModel(ModelPart root) {
		this.missile = root.getChild("missile");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition missile = partdefinition.addOrReplaceChild("missile", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Inner = missile.addOrReplaceChild("Inner", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -1.0F, -2.7045F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-0.5F, -0.5F, -1.7045F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(8, 9).addBox(0.0F, -2.0F, -3.7045F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(4, 9).addBox(0.0F, 1.0F, -3.7045F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 7).addBox(0.0F, 0.0F, -4.7045F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 8).addBox(0.0F, -1.0F, -4.7045F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -0.2955F));

		PartDefinition cube_r1 = Inner.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(8, 6).addBox(0.0F, -1.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(4, 8).addBox(0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(9, 3).addBox(0.0F, -2.0F, 0.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.7045F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r2 = Inner.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(6, 4).addBox(0.0F, -1.5F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 0).addBox(0.0F, 0.5F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.2955F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = Inner.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(4, 6).addBox(0.0F, 0.5F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 1).addBox(0.0F, -1.5F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.2955F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r4 = Inner.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(5, 3).addBox(0.0F, -3.0F, 0.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 8).addBox(0.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, 2.0F, 0.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 5).addBox(0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.2955F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r5 = Inner.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 1).addBox(0.0F, 2.0F, 0.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(4, 7).addBox(0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 6).addBox(0.0F, -3.0F, 0.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 7).addBox(0.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.2955F, 0.0F, 0.0F, 0.7854F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		missile.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}