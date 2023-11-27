package net.maxitheslime.twosidesmod.datagen.loot;

import net.maxitheslime.twosidesmod.block.ModBlocks;
import net.maxitheslime.twosidesmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.ROSE_QUARTZ_BLOCK.get());
        this.dropSelf(ModBlocks.IMPURE_ROSE_QUARTZ_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        this.add(ModBlocks.ROSE_QUARTZ_ORE.get(),
                block -> createOreDrop(ModBlocks.ROSE_QUARTZ_ORE.get(), ModItems.IMPURE_ROSE_QUARTZ.get()));
        this.add(ModBlocks.DEEPSLATE_ROSE_QUARTZ_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_ROSE_QUARTZ_ORE.get(), ModItems.IMPURE_ROSE_QUARTZ.get()));
        this.add(ModBlocks.END_ROSE_QUARTZ_ORE.get(),
                block -> createOreDrop(ModBlocks.END_ROSE_QUARTZ_ORE.get(), ModItems.IMPURE_ROSE_QUARTZ.get()));
        this.add(ModBlocks.NETHER_ROSE_QUARTZ_ORE.get(),
                block -> createOreDrop(ModBlocks.NETHER_ROSE_QUARTZ_ORE.get(), ModItems.IMPURE_ROSE_QUARTZ.get()));
        this.dropSelf(ModBlocks.ROSE_QUARTZ_STAIRS.get());
        this.add(ModBlocks.ROSE_QUARTZ_SLAB.get(),
               block -> createSlabItemTable(ModBlocks.ROSE_QUARTZ_SLAB.get()));
        this.dropSelf(ModBlocks.ROSE_QUARTZ_BUTTON.get());
        this.dropSelf(ModBlocks.ROSE_QUARTZ_PRESSURE_PLATE.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}