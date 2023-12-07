package net.maxitheslime.twosidesmod.worldgen;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_TREE_ENERGY = registerKey("add_tree_energy");

    public static final ResourceKey<BiomeModifier> ADD_ROSE_QUARTZ_ORE = registerKey("add_rose_quartz_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_ROSE_QUARTZ_ORE = registerKey("add_nether_rose_quartz_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_ROSE_QUARTZ_ORE = registerKey("add_end_rose_quartz_ore");


    public static final ResourceKey<BiomeModifier> ADD_CRYSTALLIZED_FLOWER = registerKey("add_crystallized_flower");
    
    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_TREE_ENERGY, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ENERGY_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_ROSE_QUARTZ_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ROSE_QUARTZ_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_NETHER_ROSE_QUARTZ_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_ROSE_QUARTZ_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_END_ROSE_QUARTZ_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.END_ROSE_QUARTZ_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_CRYSTALLIZED_FLOWER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CRYSTALLIZED_FLOWER_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(TwoSidesMod.MOD_ID, name));
    }
}
