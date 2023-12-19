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
    public static final ResourceKey<PlacedFeature> STRENGTH_ORE_PLACED_KEY = registerKey("strength_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_STRENGTH_ORE_PLACED_KEY = registerKey("nether_strength_ore_placed");
    public static final ResourceKey<PlacedFeature> END_STRENGTH_ORE_PLACED_KEY = registerKey("end_strength_ore_placed");
    public static final ResourceKey<PlacedFeature> STRENGTH_GEODE_PLACED_KEY = registerKey("strength_geode_placed");
    public static final ResourceKey<PlacedFeature> INFLUENCE_ORE_PLACED_KEY = registerKey("influence_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_INFLUENCE_ORE_PLACED_KEY = registerKey("nether_influence_ore_placed");
    public static final ResourceKey<PlacedFeature> END_INFLUENCE_ORE_PLACED_KEY = registerKey("end_influence_ore_placed");
    public static final ResourceKey<PlacedFeature> INFLUENCE_GEODE_PLACED_KEY = registerKey("influence_geode_placed");
    public static final ResourceKey<PlacedFeature> GREED_ORE_PLACED_KEY = registerKey("greed_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_GREED_ORE_PLACED_KEY = registerKey("nether_greed_ore_placed");
    public static final ResourceKey<PlacedFeature> END_GREED_ORE_PLACED_KEY = registerKey("end_greed_ore_placed");
    public static final ResourceKey<PlacedFeature> GREED_GEODE_PLACED_KEY = registerKey("greed_geode_placed");
    public static final ResourceKey<PlacedFeature> CONTROL_ORE_PLACED_KEY = registerKey("control_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_CONTROL_ORE_PLACED_KEY = registerKey("nether_control_ore_placed");
    public static final ResourceKey<PlacedFeature> END_CONTROL_ORE_PLACED_KEY = registerKey("end_control_ore_placed");
    public static final ResourceKey<PlacedFeature> CONTROL_GEODE_PLACED_KEY = registerKey("control_geode_placed");
    public static final ResourceKey<PlacedFeature> POWER_ORE_PLACED_KEY = registerKey("power_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_POWER_ORE_PLACED_KEY = registerKey("nether_power_ore_placed");
    public static final ResourceKey<PlacedFeature> END_POWER_ORE_PLACED_KEY = registerKey("end_power_ore_placed");
    public static final ResourceKey<PlacedFeature> POWER_GEODE_PLACED_KEY = registerKey("power_geode_placed");
    public static final ResourceKey<PlacedFeature> LIFE_ORE_PLACED_KEY = registerKey("life_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_LIFE_ORE_PLACED_KEY = registerKey("nether_life_ore_placed");
    public static final ResourceKey<PlacedFeature> END_LIFE_ORE_PLACED_KEY = registerKey("end_life_ore_placed");
    public static final ResourceKey<PlacedFeature> LIFE_GEODE_PLACED_KEY = registerKey("life_geode_placed");
    public static final ResourceKey<PlacedFeature> SOUL_ORE_PLACED_KEY = registerKey("soul_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_SOUL_ORE_PLACED_KEY = registerKey("nether_soul_ore_placed");
    public static final ResourceKey<PlacedFeature> END_SOUL_ORE_PLACED_KEY = registerKey("end_soul_ore_placed");
    public static final ResourceKey<PlacedFeature> SOUL_GEODE_PLACED_KEY = registerKey("soul_geode_placed");


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

        register(context, STRENGTH_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_STRENGTH_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_STRENGTH_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_STRENGTH_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, END_STRENGTH_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_STRENGTH_ORE_KEY),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, STRENGTH_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STRENGTH_GEODE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(37), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(50)),
                        BiomeFilter.biome()));
        register(context, INFLUENCE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_INFLUENCE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_INFLUENCE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_INFLUENCE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, END_INFLUENCE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_INFLUENCE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, INFLUENCE_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.INFLUENCE_GEODE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(37), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(50)),
                        BiomeFilter.biome()));
        register(context, GREED_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_GREED_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_GREED_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_GREED_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, END_GREED_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_GREED_ORE_KEY),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, GREED_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GREED_GEODE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(37), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(50)),
                        BiomeFilter.biome()));
        register(context, CONTROL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_CONTROL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_CONTROL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_CONTROL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, END_CONTROL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_CONTROL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, CONTROL_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CONTROL_GEODE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(37), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(50)),
                        BiomeFilter.biome()));
        register(context, POWER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_POWER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_POWER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_POWER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, END_POWER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_POWER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, POWER_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.POWER_GEODE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(37), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(50)),
                        BiomeFilter.biome()));
        register(context, LIFE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_LIFE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_LIFE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_LIFE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, END_LIFE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_LIFE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, LIFE_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LIFE_GEODE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(37), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(50)),
                        BiomeFilter.biome()));
        register(context, SOUL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SOUL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_SOUL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_SOUL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, END_SOUL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_SOUL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, SOUL_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SOUL_GEODE_KEY),
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
