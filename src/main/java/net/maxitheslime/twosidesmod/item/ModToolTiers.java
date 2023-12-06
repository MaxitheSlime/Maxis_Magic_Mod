package net.maxitheslime.twosidesmod.item;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.item.ModItems;
import net.maxitheslime.twosidesmod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier ROSE_QUARTZ = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1400, 11f, 3f, 26,
                    ModTags.Blocks.NEEDS_ROSE_QUARTZ_TOOL, () -> Ingredient.of(ModItems.PURE_ROSE_QUARTZ.get())),
            new ResourceLocation(TwoSidesMod.MOD_ID, "pure_rose_quartz"), List.of(Tiers.NETHERITE), List.of());
}
