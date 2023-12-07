package net.maxitheslime.twosidesmod.util;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType ENERGY = WoodType.register(new WoodType(TwoSidesMod.MOD_ID + ":hanging", BlockSetType.OAK));
}
