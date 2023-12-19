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
        this.dropSelf(ModBlocks.ENERGY_STAIRS.get());
        this.add(ModBlocks.ENERGY_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ENERGY_SLAB.get()));
        this.dropSelf(ModBlocks.ENERGY_BUTTON.get());
        this.dropSelf(ModBlocks.ENERGY_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ENERGY_FENCE.get());
        this.dropSelf(ModBlocks.ENERGY_FENCE_GATE.get());
        this.dropSelf(ModBlocks.ENERGY_TRAPDOOR.get());
        this.add(ModBlocks.ENERGY_DOOR.get(),
                block -> createDoorTable(ModBlocks.ENERGY_DOOR.get()));
        
        this.dropSelf(ModBlocks.ENERGY_SAPLING.get());
        this.dropSelf(ModBlocks.ALT_ENERGY_SAPLING.get());

        this.add(ModBlocks.ENERGY_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.ENERGY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ModBlocks.ENERGY_LEAVES_ALT.get(), block ->
                createLeavesDrops(block, ModBlocks.ALT_ENERGY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

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

        this.dropSelf(ModBlocks.RUBY_BLOCK.get());
        this.dropSelf(ModBlocks.RUBY_BLOCK_1.get());
        this.dropSelf(ModBlocks.RUBY_BLOCK_2.get());
        this.dropSelf(ModBlocks.RUBY_BLOCK_3.get());

        this.dropSelf(ModBlocks.WAXED_RUBY_BLOCK.get());
        this.dropSelf(ModBlocks.WAXED_RUBY_BLOCK_1.get());
        this.dropSelf(ModBlocks.WAXED_RUBY_BLOCK_2.get());
        this.dropSelf(ModBlocks.WAXED_RUBY_BLOCK_3.get());

        this.dropSelf(ModBlocks.CONDUCTIVE_FURNACE.get());

        this.add(ModBlocks.POTTED_ENERGY_SAPLING.get(), createPotFlowerItemTable(ModBlocks.ENERGY_SAPLING.get()));
        this.add(ModBlocks.POTTED_ALT_ENERGY_SAPLING.get(), createPotFlowerItemTable(ModBlocks.ALT_ENERGY_SAPLING.get()));

        this.dropSelf(ModBlocks.STRENGTH_BLOCK.get());
        this.dropSelf(ModBlocks.IMPURE_STRENGTH_BLOCK.get());
        this.add(ModBlocks.STRENGTH_ORE.get(),
                block -> createOreDrop(ModBlocks.STRENGTH_ORE.get(), ModItems.IMPURE_CRYSTAL_STRENGTH_SHARD.get()));
        this.add(ModBlocks.DEEPSLATE_STRENGTH_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_STRENGTH_ORE.get(), ModItems.IMPURE_CRYSTAL_STRENGTH_SHARD.get()));
        this.add(ModBlocks.END_STRENGTH_ORE.get(),
                block -> createOreDrop(ModBlocks.END_STRENGTH_ORE.get(), ModItems.IMPURE_CRYSTAL_STRENGTH_SHARD.get()));
        this.add(ModBlocks.NETHER_STRENGTH_ORE.get(),
                block -> createOreDrop(ModBlocks.NETHER_STRENGTH_ORE.get(), ModItems.IMPURE_CRYSTAL_STRENGTH_SHARD.get()));
        this.dropSelf(ModBlocks.INFLUENCE_BLOCK.get());
        this.dropSelf(ModBlocks.IMPURE_INFLUENCE_BLOCK.get());
        this.add(ModBlocks.INFLUENCE_ORE.get(),
                block -> createOreDrop(ModBlocks.INFLUENCE_ORE.get(), ModItems.IMPURE_CRYSTAL_INFLUENCE_SHARD.get()));
        this.add(ModBlocks.DEEPSLATE_INFLUENCE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_INFLUENCE_ORE.get(), ModItems.IMPURE_CRYSTAL_INFLUENCE_SHARD.get()));
        this.add(ModBlocks.END_INFLUENCE_ORE.get(),
                block -> createOreDrop(ModBlocks.END_INFLUENCE_ORE.get(), ModItems.IMPURE_CRYSTAL_INFLUENCE_SHARD.get()));
        this.add(ModBlocks.NETHER_INFLUENCE_ORE.get(),
                block -> createOreDrop(ModBlocks.NETHER_INFLUENCE_ORE.get(), ModItems.IMPURE_CRYSTAL_INFLUENCE_SHARD.get()));
        this.dropSelf(ModBlocks.GREED_BLOCK.get());
        this.dropSelf(ModBlocks.IMPURE_GREED_BLOCK.get());
        this.add(ModBlocks.GREED_ORE.get(),
                block -> createOreDrop(ModBlocks.GREED_ORE.get(), ModItems.IMPURE_CRYSTAL_GREED_SHARD.get()));
        this.add(ModBlocks.DEEPSLATE_GREED_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_GREED_ORE.get(), ModItems.IMPURE_CRYSTAL_GREED_SHARD.get()));
        this.add(ModBlocks.END_GREED_ORE.get(),
                block -> createOreDrop(ModBlocks.END_GREED_ORE.get(), ModItems.IMPURE_CRYSTAL_GREED_SHARD.get()));
        this.add(ModBlocks.NETHER_GREED_ORE.get(),
                block -> createOreDrop(ModBlocks.NETHER_GREED_ORE.get(), ModItems.IMPURE_CRYSTAL_GREED_SHARD.get()));
        this.dropSelf(ModBlocks.CONTROL_BLOCK.get());
        this.dropSelf(ModBlocks.IMPURE_CONTROL_BLOCK.get());
        this.add(ModBlocks.CONTROL_ORE.get(),
                block -> createOreDrop(ModBlocks.CONTROL_ORE.get(), ModItems.IMPURE_CRYSTAL_CONTROL_SHARD.get()));
        this.add(ModBlocks.DEEPSLATE_CONTROL_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_CONTROL_ORE.get(), ModItems.IMPURE_CRYSTAL_CONTROL_SHARD.get()));
        this.add(ModBlocks.END_CONTROL_ORE.get(),
                block -> createOreDrop(ModBlocks.END_CONTROL_ORE.get(), ModItems.IMPURE_CRYSTAL_CONTROL_SHARD.get()));
        this.add(ModBlocks.NETHER_CONTROL_ORE.get(),
                block -> createOreDrop(ModBlocks.NETHER_CONTROL_ORE.get(), ModItems.IMPURE_CRYSTAL_CONTROL_SHARD.get()));
        this.dropSelf(ModBlocks.POWER_BLOCK.get());
        this.dropSelf(ModBlocks.IMPURE_POWER_BLOCK.get());
        this.add(ModBlocks.POWER_ORE.get(),
                block -> createOreDrop(ModBlocks.POWER_ORE.get(), ModItems.IMPURE_CRYSTAL_POWER_SHARD.get()));
        this.add(ModBlocks.DEEPSLATE_POWER_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_POWER_ORE.get(), ModItems.IMPURE_CRYSTAL_POWER_SHARD.get()));
        this.add(ModBlocks.END_POWER_ORE.get(),
                block -> createOreDrop(ModBlocks.END_POWER_ORE.get(), ModItems.IMPURE_CRYSTAL_POWER_SHARD.get()));
        this.add(ModBlocks.NETHER_POWER_ORE.get(),
                block -> createOreDrop(ModBlocks.NETHER_POWER_ORE.get(), ModItems.IMPURE_CRYSTAL_POWER_SHARD.get()));
        this.dropSelf(ModBlocks.LIFE_BLOCK.get());
        this.dropSelf(ModBlocks.IMPURE_LIFE_BLOCK.get());
        this.add(ModBlocks.LIFE_ORE.get(),
                block -> createOreDrop(ModBlocks.LIFE_ORE.get(), ModItems.IMPURE_CRYSTAL_LIFE_SHARD.get()));
        this.add(ModBlocks.DEEPSLATE_LIFE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_LIFE_ORE.get(), ModItems.IMPURE_CRYSTAL_LIFE_SHARD.get()));
        this.add(ModBlocks.END_LIFE_ORE.get(),
                block -> createOreDrop(ModBlocks.END_LIFE_ORE.get(), ModItems.IMPURE_CRYSTAL_LIFE_SHARD.get()));
        this.add(ModBlocks.NETHER_LIFE_ORE.get(),
                block -> createOreDrop(ModBlocks.NETHER_LIFE_ORE.get(), ModItems.IMPURE_CRYSTAL_LIFE_SHARD.get()));
        this.dropSelf(ModBlocks.SOUL_BLOCK.get());
        this.dropSelf(ModBlocks.IMPURE_SOUL_BLOCK.get());
        this.add(ModBlocks.SOUL_ORE.get(),
                block -> createOreDrop(ModBlocks.SOUL_ORE.get(), ModItems.IMPURE_CRYSTAL_SOUL_SHARD.get()));
        this.add(ModBlocks.DEEPSLATE_SOUL_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_SOUL_ORE.get(), ModItems.IMPURE_CRYSTAL_SOUL_SHARD.get()));
        this.add(ModBlocks.END_SOUL_ORE.get(),
                block -> createOreDrop(ModBlocks.END_SOUL_ORE.get(), ModItems.IMPURE_CRYSTAL_SOUL_SHARD.get()));
        this.add(ModBlocks.NETHER_SOUL_ORE.get(),
                block -> createOreDrop(ModBlocks.NETHER_SOUL_ORE.get(), ModItems.IMPURE_CRYSTAL_SOUL_SHARD.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}