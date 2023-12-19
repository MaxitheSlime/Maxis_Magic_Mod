package net.maxitheslime.twosidesmod.worldgen;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.block.ModBlocks;
import net.maxitheslime.twosidesmod.worldgen.tree.custom.EnergyFoliagePlacer;
import net.maxitheslime.twosidesmod.worldgen.tree.custom.EnergyTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ENERGY_KEY = registerKey("energy");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALT_ENERGY_KEY = registerKey("alt_energy");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ROSE_QUARTZ_ORE_KEY = registerKey("rose_quartz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_ROSE_QUARTZ_ORE_KEY = registerKey("nether_rose_quartz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_ROSE_QUARTZ_ORE_KEY = registerKey("end_rose_quartz_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYSTALLIZED_FLOWER_KEY = registerKey("crystallized_flower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RQ_GEODE_KEY = registerKey("rose_quartz_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_STRENGTH_ORE_KEY = registerKey("strength_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_STRENGTH_ORE_KEY = registerKey("nether_strength_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_STRENGTH_ORE_KEY = registerKey("end_strength_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STRENGTH_GEODE_KEY = registerKey("strength_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_INFLUENCE_ORE_KEY = registerKey("influence_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_INFLUENCE_ORE_KEY = registerKey("nether_influence_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_INFLUENCE_ORE_KEY = registerKey("end_influence_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> INFLUENCE_GEODE_KEY = registerKey("influence_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_GREED_ORE_KEY = registerKey("greed_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_GREED_ORE_KEY = registerKey("nether_greed_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_GREED_ORE_KEY = registerKey("end_greed_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREED_GEODE_KEY = registerKey("greed_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_CONTROL_ORE_KEY = registerKey("control_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_CONTROL_ORE_KEY = registerKey("nether_control_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_CONTROL_ORE_KEY = registerKey("end_control_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CONTROL_GEODE_KEY = registerKey("control_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_POWER_ORE_KEY = registerKey("power_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_POWER_ORE_KEY = registerKey("nether_power_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_POWER_ORE_KEY = registerKey("end_power_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> POWER_GEODE_KEY = registerKey("power_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_LIFE_ORE_KEY = registerKey("life_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_LIFE_ORE_KEY = registerKey("nether_life_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_LIFE_ORE_KEY = registerKey("end_life_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIFE_GEODE_KEY = registerKey("life_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SOUL_ORE_KEY = registerKey("soul_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_SOUL_ORE_KEY = registerKey("nether_soul_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_SOUL_ORE_KEY = registerKey("end_soul_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_GEODE_KEY = registerKey("soul_geode");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceabeles = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceabeles = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceabeles = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceabeles = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldRoseQuartzOres = List.of(OreConfiguration.target(stoneReplaceabeles,
                        ModBlocks.ROSE_QUARTZ_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceabeles, ModBlocks.DEEPSLATE_ROSE_QUARTZ_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldStrengthOres = List.of(OreConfiguration.target(stoneReplaceabeles,
                        ModBlocks.STRENGTH_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceabeles, ModBlocks.DEEPSLATE_STRENGTH_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldInfluenceOres = List.of(OreConfiguration.target(stoneReplaceabeles,
                        ModBlocks.INFLUENCE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceabeles, ModBlocks.DEEPSLATE_INFLUENCE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldGreedOres = List.of(OreConfiguration.target(stoneReplaceabeles,
                        ModBlocks.GREED_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceabeles, ModBlocks.DEEPSLATE_GREED_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldControlOres = List.of(OreConfiguration.target(stoneReplaceabeles,
                        ModBlocks.CONTROL_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceabeles, ModBlocks.DEEPSLATE_CONTROL_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldPowerOres = List.of(OreConfiguration.target(stoneReplaceabeles,
                        ModBlocks.POWER_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceabeles, ModBlocks.DEEPSLATE_POWER_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldLifeOres = List.of(OreConfiguration.target(stoneReplaceabeles,
                        ModBlocks.LIFE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceabeles, ModBlocks.DEEPSLATE_LIFE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldSoulOres = List.of(OreConfiguration.target(stoneReplaceabeles,
                        ModBlocks.SOUL_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceabeles, ModBlocks.DEEPSLATE_SOUL_ORE.get().defaultBlockState()));

        
        register(context, ENERGY_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.ENERGY_LOG.get()),
                new EnergyTrunkPlacer(3, 2, 1),
                BlockStateProvider.simple(ModBlocks.ENERGY_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                new TwoLayersFeatureSize(1, 0, 2))
                .dirt(BlockStateProvider.simple(Blocks.DEEPSLATE_EMERALD_ORE)).build());

        register(context, ALT_ENERGY_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.ENERGY_LOG.get()),
                new EnergyTrunkPlacer(3, 2, 1),
                BlockStateProvider.simple(ModBlocks.ENERGY_LEAVES_ALT.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                new TwoLayersFeatureSize(1, 0, 2))
                .dirt(BlockStateProvider.simple(Blocks.DEEPSLATE_EMERALD_ORE)).build());

        register(context, OVERWORLD_ROSE_QUARTZ_ORE_KEY, Feature.ORE, new OreConfiguration(overworldRoseQuartzOres, 9));
        register(context, NETHER_ROSE_QUARTZ_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceabeles,
                ModBlocks.NETHER_ROSE_QUARTZ_ORE.get().defaultBlockState(), 9));
        register(context, END_ROSE_QUARTZ_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceabeles,
                ModBlocks.END_ROSE_QUARTZ_ORE.get().defaultBlockState(), 9));

        register(context, CRYSTALLIZED_FLOWER_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CRYSTALLIZED_FLOWER.get())))));

        register(context, RQ_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(ModBlocks.IMPURE_ROSE_QUARTZ_BLOCK.get()),
                        BlockStateProvider.simple(ModBlocks.DEEPSLATE_ROSE_QUARTZ_ORE.get()),
                        BlockStateProvider.simple(ModBlocks.ROSE_QUARTZ_ORE.get()),
                        BlockStateProvider.simple(ModBlocks.ROSE_QUARTZ_BLOCK.get()),
                        List.of(ModBlocks.ROSE_QUARTZ_BLOCK.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 1.2D, 2.5D, 3.5D),
                        new GeodeCrackSettings(0.25D, 1.5D, 1), 0.5D, 0.1D,
                        true, UniformInt.of(3, 8),
                        UniformInt.of(2, 6), UniformInt.of(1, 2),
                        -18, 18, 0.075D, 1));

        register(context, OVERWORLD_STRENGTH_ORE_KEY, Feature.ORE, new OreConfiguration(overworldStrengthOres, 9));
        register(context, NETHER_STRENGTH_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceabeles,
                ModBlocks.NETHER_STRENGTH_ORE.get().defaultBlockState(), 9));
        register(context, END_STRENGTH_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceabeles,
                ModBlocks.END_STRENGTH_ORE.get().defaultBlockState(), 9));
        register(context, STRENGTH_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(ModBlocks.IMPURE_STRENGTH_BLOCK.get()),
                        BlockStateProvider.simple(ModBlocks.DEEPSLATE_STRENGTH_ORE.get()),
                        BlockStateProvider.simple(ModBlocks.STRENGTH_ORE.get()),
                        BlockStateProvider.simple(ModBlocks.STRENGTH_BLOCK.get()),
                        List.of(ModBlocks.STRENGTH_BLOCK.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 1.2D, 2.5D, 3.5D),
                        new GeodeCrackSettings(0.25D, 1.5D, 1), 0.5D, 0.1D,
                        true, UniformInt.of(3, 8),
                        UniformInt.of(2, 6), UniformInt.of(1, 2),
                        -18, 18, 0.075D, 1));
        register(context, OVERWORLD_INFLUENCE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldInfluenceOres, 9));
        register(context, NETHER_INFLUENCE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceabeles,
                ModBlocks.NETHER_INFLUENCE_ORE.get().defaultBlockState(), 9));
        register(context, END_INFLUENCE_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceabeles,
                ModBlocks.END_INFLUENCE_ORE.get().defaultBlockState(), 9));
        register(context, INFLUENCE_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(ModBlocks.IMPURE_INFLUENCE_BLOCK.get()),
                        BlockStateProvider.simple(ModBlocks.DEEPSLATE_INFLUENCE_ORE.get()),
                        BlockStateProvider.simple(ModBlocks.INFLUENCE_ORE.get()),
                        BlockStateProvider.simple(ModBlocks.INFLUENCE_BLOCK.get()),
                        List.of(ModBlocks.INFLUENCE_BLOCK.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 1.2D, 2.5D, 3.5D),
                        new GeodeCrackSettings(0.25D, 1.5D, 1), 0.5D, 0.1D,
                        true, UniformInt.of(3, 8),
                        UniformInt.of(2, 6), UniformInt.of(1, 2),
                        -18, 18, 0.075D, 1));
        register(context, OVERWORLD_GREED_ORE_KEY, Feature.ORE, new OreConfiguration(overworldGreedOres, 9));
        register(context, NETHER_GREED_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceabeles,
                ModBlocks.NETHER_GREED_ORE.get().defaultBlockState(), 9));
        register(context, END_GREED_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceabeles,
                ModBlocks.END_GREED_ORE.get().defaultBlockState(), 9));
        register(context, GREED_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(ModBlocks.IMPURE_GREED_BLOCK.get()),
                        BlockStateProvider.simple(ModBlocks.DEEPSLATE_GREED_ORE.get()),
                        BlockStateProvider.simple(ModBlocks.GREED_ORE.get()),
                        BlockStateProvider.simple(ModBlocks.GREED_BLOCK.get()),
                        List.of(ModBlocks.GREED_BLOCK.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 1.2D, 2.5D, 3.5D),
                        new GeodeCrackSettings(0.25D, 1.5D, 1), 0.5D, 0.1D,
                        true, UniformInt.of(3, 8),
                        UniformInt.of(2, 6), UniformInt.of(1, 2),
                        -18, 18, 0.075D, 1));
        register(context, OVERWORLD_CONTROL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldControlOres, 9));
        register(context, NETHER_CONTROL_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceabeles,
                ModBlocks.NETHER_CONTROL_ORE.get().defaultBlockState(), 9));
        register(context, END_CONTROL_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceabeles,
                ModBlocks.END_CONTROL_ORE.get().defaultBlockState(), 9));
        register(context, CONTROL_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(ModBlocks.IMPURE_CONTROL_BLOCK.get()),
                        BlockStateProvider.simple(ModBlocks.DEEPSLATE_CONTROL_ORE.get()),
                        BlockStateProvider.simple(ModBlocks.CONTROL_ORE.get()),
                        BlockStateProvider.simple(ModBlocks.CONTROL_BLOCK.get()),
                        List.of(ModBlocks.CONTROL_BLOCK.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 1.2D, 2.5D, 3.5D),
                        new GeodeCrackSettings(0.25D, 1.5D, 1), 0.5D, 0.1D,
                        true, UniformInt.of(3, 8),
                        UniformInt.of(2, 6), UniformInt.of(1, 2),
                        -18, 18, 0.075D, 1));
        register(context, OVERWORLD_POWER_ORE_KEY, Feature.ORE, new OreConfiguration(overworldPowerOres, 9));
        register(context, NETHER_POWER_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceabeles,
                ModBlocks.NETHER_POWER_ORE.get().defaultBlockState(), 9));
        register(context, END_POWER_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceabeles,
                ModBlocks.END_POWER_ORE.get().defaultBlockState(), 9));
        register(context, POWER_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(ModBlocks.IMPURE_POWER_BLOCK.get()),
                        BlockStateProvider.simple(ModBlocks.DEEPSLATE_POWER_ORE.get()),
                        BlockStateProvider.simple(ModBlocks.POWER_ORE.get()),
                        BlockStateProvider.simple(ModBlocks.POWER_BLOCK.get()),
                        List.of(ModBlocks.POWER_BLOCK.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 1.2D, 2.5D, 3.5D),
                        new GeodeCrackSettings(0.25D, 1.5D, 1), 0.5D, 0.1D,
                        true, UniformInt.of(3, 8),
                        UniformInt.of(2, 6), UniformInt.of(1, 2),
                        -18, 18, 0.075D, 1));
        register(context, OVERWORLD_LIFE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldLifeOres, 9));
        register(context, NETHER_LIFE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceabeles,
                ModBlocks.NETHER_LIFE_ORE.get().defaultBlockState(), 9));
        register(context, END_LIFE_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceabeles,
                ModBlocks.END_LIFE_ORE.get().defaultBlockState(), 9));
        register(context, LIFE_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(ModBlocks.IMPURE_LIFE_BLOCK.get()),
                        BlockStateProvider.simple(ModBlocks.DEEPSLATE_LIFE_ORE.get()),
                        BlockStateProvider.simple(ModBlocks.LIFE_ORE.get()),
                        BlockStateProvider.simple(ModBlocks.LIFE_BLOCK.get()),
                        List.of(ModBlocks.LIFE_BLOCK.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 1.2D, 2.5D, 3.5D),
                        new GeodeCrackSettings(0.25D, 1.5D, 1), 0.5D, 0.1D,
                        true, UniformInt.of(3, 8),
                        UniformInt.of(2, 6), UniformInt.of(1, 2),
                        -18, 18, 0.075D, 1));
        register(context, OVERWORLD_SOUL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSoulOres, 9));
        register(context, NETHER_SOUL_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceabeles,
                ModBlocks.NETHER_SOUL_ORE.get().defaultBlockState(), 9));
        register(context, END_SOUL_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceabeles,
                ModBlocks.END_SOUL_ORE.get().defaultBlockState(), 9));
        register(context, SOUL_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(ModBlocks.IMPURE_SOUL_BLOCK.get()),
                        BlockStateProvider.simple(ModBlocks.DEEPSLATE_SOUL_ORE.get()),
                        BlockStateProvider.simple(ModBlocks.SOUL_ORE.get()),
                        BlockStateProvider.simple(ModBlocks.SOUL_BLOCK.get()),
                        List.of(ModBlocks.SOUL_BLOCK.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 1.2D, 2.5D, 3.5D),
                        new GeodeCrackSettings(0.25D, 1.5D, 1), 0.5D, 0.1D,
                        true, UniformInt.of(3, 8),
                        UniformInt.of(2, 6), UniformInt.of(1, 2),
                        -18, 18, 0.075D, 1));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(TwoSidesMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
