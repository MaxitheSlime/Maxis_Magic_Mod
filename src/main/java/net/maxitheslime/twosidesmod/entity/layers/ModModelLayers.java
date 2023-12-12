package net.maxitheslime.twosidesmod.entity.layers;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation RQG_LAYER = new ModelLayerLocation(
            new ResourceLocation(TwoSidesMod.MOD_ID, "rqg_layer"), "rqg_layer");

    public static final ModelLayerLocation RS_LAYER = new ModelLayerLocation(
            new ResourceLocation(TwoSidesMod.MOD_ID, "ruby_statue_layer"), "ruby_statue_layer");

    public static final ModelLayerLocation MAGIC_MISSILE_LAYER = new ModelLayerLocation(
            new ResourceLocation(TwoSidesMod.MOD_ID, "magic_missile_layer"), "magic_missile_layer");

    public static final ModelLayerLocation ENERGY_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(TwoSidesMod.MOD_ID, "boat/energy"), "main");
    public static final ModelLayerLocation ENERGY_CHEST_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(TwoSidesMod.MOD_ID, "chest_boat/energy"), "main");

}
