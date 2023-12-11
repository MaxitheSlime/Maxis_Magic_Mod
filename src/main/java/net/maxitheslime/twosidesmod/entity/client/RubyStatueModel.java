package net.maxitheslime.twosidesmod.entity.client;// Made with Blockbench 4.9.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.entity.animations.ModAnimationsDefinitions;
import net.maxitheslime.twosidesmod.entity.custom.RSEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;

import java.awt.*;
import java.nio.Buffer;

import static net.maxitheslime.twosidesmod.entity.client.RubyStatueRenderer.RS_LOCATION;

public class RubyStatueModel<T extends RSEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor

	private final ModelPart body;
	private final ModelPart head;

	public RubyStatueModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = body.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -29.0F, 0.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(76, 97).addBox(-8.0F, -0.5F, -6.0F, 16.0F, 18.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(53, 0).addBox(-11.0F, -16.5F, -8.0F, 22.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition arms = torso.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, -10.5F, 0.0F));

		PartDefinition arm1 = arms.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(144, 76).addBox(-12.0F, -6.0F, -6.0F, 12.0F, 24.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, 1.0F, 0.0F));

		PartDefinition elbow1 = arm1.addOrReplaceChild("elbow1", CubeListBuilder.create().texOffs(0, 119).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 24.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 18.0F, 0.0F));

		PartDefinition sword = elbow1.addOrReplaceChild("sword", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -9.0F, 4.0F, 4.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-2.0F, -10.0F, -60.0F, 4.0F, 19.0F, 45.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-2.0F, -10.0F, -64.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(98, 44).addBox(-3.0F, -3.0F, 9.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(168, 112).addBox(-3.0F, -11.0F, -15.0F, 6.0F, 22.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 19.0F, -1.0F));

		PartDefinition cube_r1 = sword.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(104, 127).addBox(-2.0F, -9.5F, -2.0F, 4.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -62.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition arm2 = arms.addOrReplaceChild("arm2", CubeListBuilder.create().texOffs(139, 0).addBox(0.0F, -6.0F, -6.0F, 12.0F, 24.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, 1.0F, 0.0F));

		PartDefinition elbow2 = arm2.addOrReplaceChild("elbow2", CubeListBuilder.create().texOffs(120, 115).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 24.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 18.0F, 0.0F));

		PartDefinition waist = body.addOrReplaceChild("waist", CubeListBuilder.create().texOffs(76, 76).addBox(-10.0F, 0.0F, -7.0F, 20.0F, 7.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition legs = waist.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 7.0F, 0.0F));

		PartDefinition leg1 = legs.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(162, 36).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 19.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, 0.0F, 0.0F));

		PartDefinition knee1 = leg1.addOrReplaceChild("knee1", CubeListBuilder.create().texOffs(0, 155).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 19.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 0.0F));

		PartDefinition leg2 = legs.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(92, 151).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 19.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 0.0F, 0.0F));

		PartDefinition knee2 = leg2.addOrReplaceChild("knee2", CubeListBuilder.create().texOffs(140, 151).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 19.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 0.0F));

		PartDefinition shield = body.addOrReplaceChild("shield", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 10.5F, -3.098F, 0.0F, 3.1416F));

		PartDefinition base = shield.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 64).addBox(-16.0F, 3.7F, -22.3F, 32.0F, 49.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(76, 64).addBox(-20.0F, -2.1F, -20.9F, 40.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(88, 182).addBox(-20.0F, -5.5F, -20.9F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(180, 76).addBox(16.0F, -5.5F, -20.9F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(176, 149).addBox(-2.4F, -5.5F, -20.9F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(175, 0).addBox(3.52F, -5.5F, -20.9F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(168, 140).addBox(9.92F, -5.5F, -20.9F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(168, 67).addBox(-14.4F, -5.5F, -20.9F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(128, 151).addBox(-8.0F, -5.5F, -20.9F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(53, 32).addBox(-20.0F, 53.1F, -20.9F, 40.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(68, 155).addBox(16.0F, 3.7F, -20.9F, 4.0F, 49.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(48, 155).addBox(-20.0F, 3.7F, -20.9F, 4.0F, 49.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(140, 47).addBox(-20.0F, 59.3F, -20.9F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(139, 38).addBox(16.0F, 59.3F, -20.9F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(130, 76).addBox(-2.4F, 59.3F, -20.9F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(126, 53).addBox(3.52F, 59.3F, -20.9F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(122, 44).addBox(9.92F, 59.3F, -20.9F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(120, 97).addBox(-8.0F, 59.3F, -20.9F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(36, 119).addBox(-14.4F, 59.3F, -20.9F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -27.1F, 17.7F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(48, 127).addBox(-7.0F, -14.0F, -7.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -26.0F, 0.0F));

		PartDefinition crown = head.addOrReplaceChild("crown", CubeListBuilder.create().texOffs(0, 30).addBox(-9.0F, -3.0F, -9.0F, 18.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(153, 36).addBox(-2.0F, -7.0F, -9.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(146, 56).addBox(5.0F, -7.0F, -9.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 22).addBox(-9.0F, -3.0F, 5.0F, 18.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 0.0F));

		PartDefinition cube_r2 = crown.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(113, 0).addBox(-5.0F, -3.0F, -9.0F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(98, 56).addBox(-5.0F, -3.0F, 5.0F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(56, 119).addBox(-2.0F, -7.0F, -9.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(113, 8).addBox(5.0F, -7.0F, -9.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r3 = crown.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(26, 8).addBox(-2.0F, -7.0F, -9.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(26, 0).addBox(5.0F, -7.0F, -9.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r4 = crown.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(53, 8).addBox(-2.0F, -7.0F, -9.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(53, 0).addBox(5.0F, -7.0F, -9.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(entity, netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationsDefinitions.RUBY_STATUE_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(entity.idleAnimationState, ModAnimationsDefinitions.RUBY_STATUE_IDLE, ageInTicks, 1f);
		this.animate(entity.attackAnimationState, ModAnimationsDefinitions.RUBY_STATUE_ATTACK, ageInTicks, 1f);
	}

	private void applyHeadRotation(RSEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, blue, green, 0.5f);
	}

	@Override
	public ModelPart root() {
		return body;
	}
}