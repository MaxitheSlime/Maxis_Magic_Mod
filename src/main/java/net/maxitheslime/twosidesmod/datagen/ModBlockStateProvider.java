package net.maxitheslime.twosidesmod.datagen;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.block.ModBlocks;
import net.maxitheslime.twosidesmod.block.custom.LemonBonsaiCropBlock;
import net.maxitheslime.twosidesmod.block.custom.RoseQuartzLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

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

        buttonBlock((ButtonBlock) ModBlocks.ROSE_QUARTZ_BUTTON.get(), blockTexture(ModBlocks.ROSE_QUARTZ_BLOCK.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.ROSE_QUARTZ_PRESSURE_PLATE.get(), blockTexture(ModBlocks.ROSE_QUARTZ_BLOCK.get()));
        blockItem(ModBlocks.ROSE_QUARTZ_PRESSURE_PLATE);
        fenceBlock((FenceBlock) ModBlocks.ROSE_QUARTZ_FENCE.get(), blockTexture(ModBlocks.ROSE_QUARTZ_BLOCK.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.ROSE_QUARTZ_FENCE_GATE.get(), blockTexture(ModBlocks.ROSE_QUARTZ_BLOCK.get()));
        wallBlock((WallBlock) ModBlocks.ROSE_QUARTZ_WALL.get(), blockTexture(ModBlocks.ROSE_QUARTZ_BLOCK.get()));
        blockItem(ModBlocks.ROSE_QUARTZ_FENCE_GATE);

        doorBlockWithRenderType((DoorBlock)ModBlocks.ROSE_QUARTZ_DOOR.get(), modLoc("block/rose_quartz_door_bottom"), modLoc("block/rose_quartz_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.ROSE_QUARTZ_TRAPDOOR.get(), modLoc("block/rose_quartz_trapdoor"), true, "cutout");
        blockItem(ModBlocks.ROSE_QUARTZ_TRAPDOOR, "_bottom");

        customLamp();

        makeCrop(((LemonBonsaiCropBlock) ModBlocks.BONSAI_LEMON_CROP.get()), "lemon_stage", "lemon_stage");
        simpleBlock(ModBlocks.CRYSTALLIZED_FLOWER.get(),
                models().cross(blockTexture(ModBlocks.CRYSTALLIZED_FLOWER.get()).getPath(), blockTexture(ModBlocks.CRYSTALLIZED_FLOWER.get())).renderType("cutout"));

        horizontalBlock(ModBlocks.PURIFICATION_TABLE.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/purification_table")));
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((LemonBonsaiCropBlock) block).getAgeProperty()),
                new ResourceLocation(TwoSidesMod.MOD_ID, "block/" + textureName + state.getValue(((LemonBonsaiCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.ROSE_QUARTZ_LAMP.get()).forAllStates(state -> {
            if (state.getValue(RoseQuartzLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("rose_quartz_lamp_on",
                        new ResourceLocation(TwoSidesMod.MOD_ID, "block/" + "rose_quartz_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("rose_quartz_lamp_off",
                        new ResourceLocation(TwoSidesMod.MOD_ID, "block/" + "rose_quartz_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.ROSE_QUARTZ_LAMP.get(), models().cubeAll("rose_quartz_lamp_on",
                new ResourceLocation(TwoSidesMod.MOD_ID, "block/" +"rose_quartz_lamp_on")));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("twosidesmod:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("twosidesmod:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
