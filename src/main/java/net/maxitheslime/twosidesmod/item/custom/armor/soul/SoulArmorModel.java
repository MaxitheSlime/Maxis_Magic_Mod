package net.maxitheslime.twosidesmod.item.custom.armor.soul;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SoulArmorModel extends GeoModel<SoulArmorItem> {
    private final ResourceLocation modelResource = new ResourceLocation(TwoSidesMod.MOD_ID, "geo/soul_armor.geo.json");
    private final ResourceLocation textureResource = new ResourceLocation(TwoSidesMod.MOD_ID, "textures/item/armor/soul_armor.png");
    private final ResourceLocation animationResource = new ResourceLocation(TwoSidesMod.MOD_ID, "animations/soul_armor.animation.json");

    @Override
    public ResourceLocation getModelResource(SoulArmorItem soulArmorItem) {
        return this.modelResource;
    }

    @Override
    public ResourceLocation getTextureResource(SoulArmorItem soulArmorItem) {
        return this.textureResource;
    }

    @Override
    public ResourceLocation getAnimationResource(SoulArmorItem soulArmorItem) {
        return this.animationResource;
    }
}
