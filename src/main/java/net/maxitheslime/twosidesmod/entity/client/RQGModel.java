package net.maxitheslime.twosidesmod.entity.client;// Made with Blockbench 4.9.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.maxitheslime.twosidesmod.entity.animations.ModAnimationsDefinitions;
import net.maxitheslime.twosidesmod.entity.custom.RQGEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class RQGModel<T extends RQGEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart total;
	private final ModelPart head;

	public RQGModel(ModelPart root) {
		this.total = root.getChild("total");
		this.head = total.getChild("body").getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition total = partdefinition.addOrReplaceChild("total", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition body = total.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition main = body.addOrReplaceChild("main", CubeListBuilder.create().texOffs(65, 23).addBox(-6.0F, -25.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(37, 48).addBox(6.0F, -25.0F, -8.0F, 2.0F, 12.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 48).addBox(-8.0F, -25.0F, -8.0F, 2.0F, 12.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-8.0F, -13.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(73, 0).addBox(-8.0F, -27.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, -11.0F, -9.0F, 18.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition frame6_r1 = main.addOrReplaceChild("frame6_r1", CubeListBuilder.create().texOffs(51, 122).addBox(7.39F, -18.0F, -7.99F, 2.0F, 9.0F, 1.99F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition frame5_r1 = main.addOrReplaceChild("frame5_r1", CubeListBuilder.create().texOffs(60, 122).addBox(7.39F, 9.0F, -7.99F, 2.0F, 9.0F, 1.99F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition frame4_r1 = main.addOrReplaceChild("frame4_r1", CubeListBuilder.create().texOffs(69, 122).addBox(-19.51F, 9.0F, -7.99F, 2.0F, 9.0F, 1.99F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition frame3_r1 = main.addOrReplaceChild("frame3_r1", CubeListBuilder.create().texOffs(78, 122).addBox(-19.51F, -18.0F, -7.99F, 2.0F, 9.0F, 1.99F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition frame1_r1 = main.addOrReplaceChild("frame1_r1", CubeListBuilder.create().texOffs(0, 77).addBox(6.0F, -25.0F, -6.0F, 2.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(74, 48).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 134).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(34, 113).addBox(-2.0F, -14.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -19.0F, 0.0F));

		PartDefinition arm0 = body.addOrReplaceChild("arm0", CubeListBuilder.create().texOffs(104, 113).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.0F, -16.0F, 0.0F));

		PartDefinition forearm_r1 = arm0.addOrReplaceChild("forearm_r1", CubeListBuilder.create().texOffs(68, 113).addBox(2.0F, -13.1F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 13.0F, 0.0F, 0.0F, 1.5708F, -1.5708F));

		PartDefinition elbow_r1 = arm0.addOrReplaceChild("elbow_r1", CubeListBuilder.create().texOffs(87, 113).addBox(-13.0F, 2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 13.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition upperarm_r1 = arm0.addOrReplaceChild("upperarm_r1", CubeListBuilder.create().texOffs(29, 77).addBox(-2.0F, -12.5F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 13.0F, 0.0F, 0.0F, 0.0F, -1.2217F));

		PartDefinition hand = arm0.addOrReplaceChild("hand", CubeListBuilder.create().texOffs(51, 113).addBox(-16.5F, -13.0F, -12.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(17, 113).addBox(-11.5F, -12.01F, -18.0F, 2.0F, 2.01F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 113).addBox(-19.5F, -12.01F, -18.0F, 2.0F, 2.01F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(29, 91).addBox(-17.5F, -12.01F, -19.0F, 2.0F, 2.01F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 102).addBox(-13.5F, -12.01F, -19.0F, 2.0F, 2.01F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, 24.0F, 0.0F));

		PartDefinition arm1 = body.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(63, 102).addBox(3.2F, 11.8F, -8.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, -16.0F, 0.0F));

		PartDefinition elbow_r2 = arm1.addOrReplaceChild("elbow_r2", CubeListBuilder.create().texOffs(17, 122).addBox(-13.5F, -6.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.0F, 13.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition upperarm_r2 = arm1.addOrReplaceChild("upperarm_r2", CubeListBuilder.create().texOffs(29, 84).addBox(6.0F, -13.0F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.0F, 13.0F, 0.0F, 0.0F, 0.0F, -1.9199F));

		PartDefinition shoulder_r1 = arm1.addOrReplaceChild("shoulder_r1", CubeListBuilder.create().texOffs(34, 122).addBox(-19.0F, -15.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.0F, 13.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition hand2 = arm1.addOrReplaceChild("hand2", CubeListBuilder.create().texOffs(0, 122).addBox(-17.3F, -12.7F, -12.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(42, 102).addBox(-18.3F, -11.71F, -19.0F, 2.0F, 2.01F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(21, 102).addBox(-14.3F, -11.71F, -19.0F, 2.0F, 2.01F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(99, 102).addBox(-12.3F, -11.71F, -18.0F, 2.0F, 2.01F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(82, 102).addBox(-20.3F, -11.71F, -18.0F, 2.0F, 2.01F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(20.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(entity, netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationsDefinitions.RQG_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(entity.idleAnimationState, ModAnimationsDefinitions.RQG_IDLE, ageInTicks, 1f);
	}

	private void applyHeadRotation(RQGEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		total.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return total;
	}
}