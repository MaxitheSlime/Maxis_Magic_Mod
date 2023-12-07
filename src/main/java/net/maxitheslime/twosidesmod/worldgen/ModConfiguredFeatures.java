package net.maxitheslime.twosidesmod.worldgen;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ENERGY_KEY = registerKey("energy");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ROSE_QUARTZ_ORE_KEY = registerKey("rose_quartz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_ROSE_QUARTZ_ORE_KEY = registerKey("nether_rose_quartz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_ROSE_QUARTZ_ORE_KEY = registerKey("end_rose_quartz_ore");
    
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceabeles = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceabeles = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceabeles = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceabeles = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldRoseQuartzOres = List.of(OreConfiguration.target(stoneReplaceabeles,
                        ModBlocks.ROSE_QUARTZ_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceabeles, ModBlocks.DEEPSLATE_ROSE_QUARTZ_ORE.get().defaultBlockState()));

        register(context, ENERGY_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.ENERGY_LOG.get()),
                new StraightTrunkPlacer(3, 2, 1),
                BlockStateProvider.simple(ModBlocks.ENERGY_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, OVERWORLD_ROSE_QUARTZ_ORE_KEY, Feature.ORE, new OreConfiguration(overworldRoseQuartzOres, 9));
        register(context, NETHER_ROSE_QUARTZ_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceabeles,
                ModBlocks.NETHER_ROSE_QUARTZ_ORE.get().defaultBlockState(), 9));
        register(context, END_ROSE_QUARTZ_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceabeles,
                ModBlocks.END_ROSE_QUARTZ_ORE.get().defaultBlockState(), 9));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(TwoSidesMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
