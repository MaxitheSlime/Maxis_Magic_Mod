package net.maxitheslime.twosidesmod.worldgen;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> ENERGY_PLACED_KEY = registerKey("energy_placed");
    public static final ResourceKey<PlacedFeature> ALT_ENERGY_PLACED_KEY = registerKey("alt_energy_placed");
    public static final ResourceKey<PlacedFeature> ROSE_QUARTZ_ORE_PLACED_KEY = registerKey("rose_quartz_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_ROSE_QUARTZ_ORE_PLACED_KEY = registerKey("nether_rose_quartz_ore_placed");
    public static final ResourceKey<PlacedFeature> END_ROSE_QUARTZ_ORE_PLACED_KEY = registerKey("end_rose_quartz_ore_placed");
    public static final ResourceKey<PlacedFeature> CRYSTALLIZED_FLOWER_PLACED_KEY = registerKey("crystallized_flower_placed");
    public static final ResourceKey<PlacedFeature> RQ_GEODE_PLACED_KEY = registerKey("rose_quartz_geode_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, ENERGY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ENERGY_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.ENERGY_SAPLING.get()));

        register(context, ALT_ENERGY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ALT_ENERGY_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.ALT_ENERGY_SAPLING.get()));

        register(context, ROSE_QUARTZ_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ROSE_QUARTZ_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_ROSE_QUARTZ_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_ROSE_QUARTZ_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, END_ROSE_QUARTZ_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_ROSE_QUARTZ_ORE_KEY),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, CRYSTALLIZED_FLOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTALLIZED_FLOWER_KEY),
                List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, RQ_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RQ_GEODE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(37), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(50)),
                        BiomeFilter.biome()));

    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(TwoSidesMod.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
