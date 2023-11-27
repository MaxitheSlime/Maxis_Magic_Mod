package net.maxitheslime.twosidesmod.datagen;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TwoSidesMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ROSE_QUARTZ_BLOCK);
        blockWithItem(ModBlocks.IMPURE_ROSE_QUARTZ_BLOCK);

        blockWithItem(ModBlocks.ROSE_QUARTZ_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ROSE_QUARTZ_ORE);
        blockWithItem(ModBlocks.END_ROSE_QUARTZ_ORE);
        blockWithItem(ModBlocks.NETHER_ROSE_QUARTZ_ORE);

        blockWithItem(ModBlocks.SOUND_BLOCK);

        stairsBlock((StairBlock) ModBlocks.ROSE_QUARTZ_STAIRS.get(), blockTexture(ModBlocks.ROSE_QUARTZ_BLOCK.get()));
        slabBlock((SlabBlock) ModBlocks.ROSE_QUARTZ_SLAB.get(), blockTexture(ModBlocks.ROSE_QUARTZ_BLOCK.get()),blockTexture(ModBlocks.ROSE_QUARTZ_BLOCK.get()));

        blockItem(ModBlocks.ROSE_QUARTZ_STAIRS);
        blockItem(ModBlocks.ROSE_QUARTZ_SLAB);
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("twosidesmod:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
