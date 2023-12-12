package net.maxitheslime.twosidesmod.datagen.loot;

import net.maxitheslime.twosidesmod.block.ModBlocks;
import net.maxitheslime.twosidesmod.block.custom.EnergyCropBlock;
import net.maxitheslime.twosidesmod.block.custom.LemonBonsaiCropBlock;
import net.maxitheslime.twosidesmod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
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
        this.dropSelf(ModBlocks.ROSE_QUARTZ_FENCE.get());
        this.dropSelf(ModBlocks.ROSE_QUARTZ_FENCE_GATE.get());
        this.dropSelf(ModBlocks.ROSE_QUARTZ_WALL.get());
        this.dropSelf(ModBlocks.ROSE_QUARTZ_TRAPDOOR.get());
        this.add(ModBlocks.ROSE_QUARTZ_DOOR.get(),
                block -> createDoorTable(ModBlocks.ROSE_QUARTZ_DOOR.get()));
        this.dropSelf(ModBlocks.ROSE_QUARTZ_LAMP.get());

        LootItemCondition.Builder lootitemcondition$builder1 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BONSAI_LEMON_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LemonBonsaiCropBlock.AGE, 6));
        this.add(ModBlocks.BONSAI_LEMON_CROP.get(), this.createCropDrops(ModBlocks.BONSAI_LEMON_CROP.get(),
                ModItems.LEMON_SEEDS.get(), ModItems.LEMON.get(), lootitemcondition$builder1));
        this.dropSelf(ModBlocks.CRYSTALLIZED_FLOWER.get());
        this.add(ModBlocks.POTTED_CRYSTALLIZED_FLOWER.get(), createPotFlowerItemTable(ModBlocks.CRYSTALLIZED_FLOWER.get()));

        this.dropSelf(ModBlocks.PURIFICATION_TABLE.get());

        this.dropSelf(ModBlocks.ENERGY_LOG.get());
        this.dropSelf(ModBlocks.ENERGY_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_ENERGY_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_ENERGY_WOOD.get());
        this.dropSelf(ModBlocks.ENERGY_PLANKS.get());
        this.dropSelf(ModBlocks.ENERGY_SAPLING.get());

        this.add(ModBlocks.ENERGY_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.ENERGY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.COLORED_LEAVES.get());

        this.add(ModBlocks.ENERGY_SIGN.get(), block ->
                createSingleItemTable(ModItems.ENERGY_SIGN.get()));
        this.add(ModBlocks.ENERGY_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.ENERGY_SIGN.get()));
        this.add(ModBlocks.ENERGY_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.ENERGY_HANGING_SIGN.get()));
        this.add(ModBlocks.ENERGY_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.ENERGY_HANGING_SIGN.get()));

        this.add(ModBlocks.DICE_BLOCK.get(), block ->
                createSingleItemTable(ModItems.DICE.get()));

        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.ENERGY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(EnergyCropBlock.AGE, 7))
                .or(LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(ModBlocks.ENERGY_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(EnergyCropBlock.AGE, 8)));

        this.add(ModBlocks.ENERGY_CROP.get(), createCropDrops(ModBlocks.ENERGY_CROP.get(), ModItems.ENERGY_ORB.get(),
                ModItems.ENERGY_SEEDS.get(), lootitemcondition$builder2));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}