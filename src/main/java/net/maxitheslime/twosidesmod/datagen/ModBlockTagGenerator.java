package net.maxitheslime.twosidesmod.datagen;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.block.ModBlocks;
import net.maxitheslime.twosidesmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TwoSidesMod.MOD_ID, existingFileHelper);
    }
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.ROSE_QUARTZ_ORE.get()).add(ModBlocks.DEEPSLATE_ROSE_QUARTZ_ORE.get())
                .add(ModBlocks.END_ROSE_QUARTZ_ORE.get()).add(ModBlocks.NETHER_ROSE_QUARTZ_ORE.get())
                .add(ModBlocks.IMPURE_ROSE_QUARTZ_BLOCK.get()).add(ModBlocks.ROSE_QUARTZ_BLOCK.get())
                .add(ModBlocks.STRENGTH_BLOCK.get()).add(ModBlocks.IMPURE_STRENGTH_BLOCK.get())
                .add(ModBlocks.STRENGTH_ORE.get()).add(ModBlocks.DEEPSLATE_STRENGTH_ORE.get())
                .add(ModBlocks.END_STRENGTH_ORE.get()).add(ModBlocks.NETHER_STRENGTH_ORE.get())
                .add(ModBlocks.INFLUENCE_BLOCK.get()).add(ModBlocks.IMPURE_INFLUENCE_BLOCK.get())
                .add(ModBlocks.INFLUENCE_ORE.get()).add(ModBlocks.DEEPSLATE_INFLUENCE_ORE.get())
                .add(ModBlocks.END_INFLUENCE_ORE.get()).add(ModBlocks.NETHER_INFLUENCE_ORE.get())
                .add(ModBlocks.GREED_BLOCK.get()).add(ModBlocks.IMPURE_GREED_BLOCK.get())
                .add(ModBlocks.GREED_ORE.get()).add(ModBlocks.DEEPSLATE_GREED_ORE.get())
                .add(ModBlocks.END_GREED_ORE.get()).add(ModBlocks.NETHER_GREED_ORE.get())
                .add(ModBlocks.CONTROL_BLOCK.get()).add(ModBlocks.IMPURE_CONTROL_BLOCK.get())
                .add(ModBlocks.CONTROL_ORE.get()).add(ModBlocks.DEEPSLATE_CONTROL_ORE.get())
                .add(ModBlocks.END_CONTROL_ORE.get()).add(ModBlocks.NETHER_CONTROL_ORE.get())
                .add(ModBlocks.POWER_BLOCK.get()).add(ModBlocks.IMPURE_POWER_BLOCK.get())
                .add(ModBlocks.POWER_ORE.get()).add(ModBlocks.DEEPSLATE_POWER_ORE.get())
                .add(ModBlocks.END_POWER_ORE.get()).add(ModBlocks.NETHER_POWER_ORE.get())
                .add(ModBlocks.LIFE_BLOCK.get()).add(ModBlocks.IMPURE_LIFE_BLOCK.get())
                .add(ModBlocks.LIFE_ORE.get()).add(ModBlocks.DEEPSLATE_LIFE_ORE.get())
                .add(ModBlocks.END_LIFE_ORE.get()).add(ModBlocks.NETHER_LIFE_ORE.get())
                .add(ModBlocks.SOUL_BLOCK.get()).add(ModBlocks.IMPURE_SOUL_BLOCK.get())
                .add(ModBlocks.SOUL_ORE.get()).add(ModBlocks.DEEPSLATE_SOUL_ORE.get())
                .add(ModBlocks.END_SOUL_ORE.get()).add(ModBlocks.NETHER_SOUL_ORE.get())
                .add(Blocks.IRON_BLOCK).add(Blocks.RAW_IRON_BLOCK).add(Blocks.GOLD_BLOCK).add(Blocks.RAW_GOLD_BLOCK)
                .add(Blocks.COPPER_BLOCK).add(Blocks.RAW_COPPER_BLOCK).add(Blocks.REDSTONE_BLOCK).add(Blocks.LAPIS_BLOCK)
                .add(Blocks.COAL_BLOCK).add(Blocks.DIAMOND_BLOCK).add(Blocks.EMERALD_BLOCK).add(Blocks.AMETHYST_CLUSTER)
                .add(Blocks.BUDDING_AMETHYST).add(Blocks.QUARTZ_BLOCK).add(Blocks.ANCIENT_DEBRIS)
                .add(Blocks.NETHERITE_BLOCK).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ROSE_QUARTZ_BLOCK.get(),
                        ModBlocks.IMPURE_ROSE_QUARTZ_BLOCK.get(),
                        ModBlocks.ROSE_QUARTZ_ORE.get(),
                        ModBlocks.DEEPSLATE_ROSE_QUARTZ_ORE.get(),
                        ModBlocks.END_ROSE_QUARTZ_ORE.get(),
                        ModBlocks.NETHER_ROSE_QUARTZ_ORE.get(),
                        ModBlocks.ROSE_QUARTZ_STAIRS.get(),
                        ModBlocks.ROSE_QUARTZ_SLAB.get(),
                        ModBlocks.ROSE_QUARTZ_BUTTON.get(),
                        ModBlocks.ROSE_QUARTZ_PRESSURE_PLATE.get(),
                        ModBlocks.ROSE_QUARTZ_FENCE.get(),
                        ModBlocks.ROSE_QUARTZ_FENCE_GATE.get(),
                        ModBlocks.ROSE_QUARTZ_WALL.get(),
                        ModBlocks.ROSE_QUARTZ_DOOR.get(),
                        ModBlocks.ROSE_QUARTZ_TRAPDOOR.get(),
                        ModBlocks.SOUND_BLOCK.get(),
                        ModBlocks.DICE_BLOCK.get(),
                        ModBlocks.MAXI_PORTAL.get(),
                        ModBlocks.RUBY_BLOCK.get(),
                        ModBlocks.RUBY_BLOCK_1.get(),
                        ModBlocks.RUBY_BLOCK_2.get(),
                        ModBlocks.RUBY_BLOCK_3.get(),
                        ModBlocks.WAXED_RUBY_BLOCK.get(),
                        ModBlocks.WAXED_RUBY_BLOCK_1.get(),
                        ModBlocks.WAXED_RUBY_BLOCK_2.get(),
                        ModBlocks.WAXED_RUBY_BLOCK_3.get(),
                        ModBlocks.PURIFICATION_TABLE.get(),
                        ModBlocks.CONDUCTIVE_FURNACE.get(),
                        ModBlocks.STRENGTH_BLOCK.get(),
                        ModBlocks.IMPURE_STRENGTH_BLOCK.get(),
                        ModBlocks.STRENGTH_ORE.get(),
                        ModBlocks.DEEPSLATE_STRENGTH_ORE.get(),
                        ModBlocks.END_STRENGTH_ORE.get(),
                        ModBlocks.NETHER_STRENGTH_ORE.get(),
                        ModBlocks.INFLUENCE_BLOCK.get(),
                        ModBlocks.IMPURE_INFLUENCE_BLOCK.get(),
                        ModBlocks.INFLUENCE_ORE.get(),
                        ModBlocks.DEEPSLATE_INFLUENCE_ORE.get(),
                        ModBlocks.END_INFLUENCE_ORE.get(),
                        ModBlocks.NETHER_INFLUENCE_ORE.get(),
                        ModBlocks.GREED_BLOCK.get(),
                        ModBlocks.IMPURE_GREED_BLOCK.get(),
                        ModBlocks.GREED_ORE.get(),
                        ModBlocks.DEEPSLATE_GREED_ORE.get(),
                        ModBlocks.END_GREED_ORE.get(),
                        ModBlocks.NETHER_GREED_ORE.get(),
                        ModBlocks.CONTROL_BLOCK.get(),
                        ModBlocks.IMPURE_CONTROL_BLOCK.get(),
                        ModBlocks.CONTROL_ORE.get(),
                        ModBlocks.DEEPSLATE_CONTROL_ORE.get(),
                        ModBlocks.END_CONTROL_ORE.get(),
                        ModBlocks.NETHER_CONTROL_ORE.get(),
                        ModBlocks.POWER_BLOCK.get(),
                        ModBlocks.IMPURE_POWER_BLOCK.get(),
                        ModBlocks.POWER_ORE.get(),
                        ModBlocks.DEEPSLATE_POWER_ORE.get(),
                        ModBlocks.END_POWER_ORE.get(),
                        ModBlocks.NETHER_POWER_ORE.get(),
                        ModBlocks.LIFE_BLOCK.get(),
                        ModBlocks.IMPURE_LIFE_BLOCK.get(),
                        ModBlocks.LIFE_ORE.get(),
                        ModBlocks.DEEPSLATE_LIFE_ORE.get(),
                        ModBlocks.END_LIFE_ORE.get(),
                        ModBlocks.NETHER_LIFE_ORE.get(),
                        ModBlocks.SOUL_BLOCK.get(),
                        ModBlocks.IMPURE_SOUL_BLOCK.get(),
                        ModBlocks.SOUL_ORE.get(),
                        ModBlocks.DEEPSLATE_SOUL_ORE.get(),
                        ModBlocks.END_SOUL_ORE.get(),
                        ModBlocks.NETHER_SOUL_ORE.get()
                );

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.ENERGY_PLANKS.get(),
                        ModBlocks.ENERGY_LOG.get(),
                        ModBlocks.STRIPPED_ENERGY_LOG.get(),
                        ModBlocks.ENERGY_WOOD.get(),
                        ModBlocks.STRIPPED_ENERGY_WOOD.get(),
                        ModBlocks.ENERGY_STAIRS.get(),
                        ModBlocks.ENERGY_SLAB.get(),
                        ModBlocks.ENERGY_PRESSURE_PLATE.get(),
                        ModBlocks.ENERGY_BUTTON.get(),
                        ModBlocks.ENERGY_FENCE.get(),
                        ModBlocks.ENERGY_FENCE_GATE.get(),
                        ModBlocks.ENERGY_DOOR.get(),
                        ModBlocks.ENERGY_TRAPDOOR.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ROSE_QUARTZ_BLOCK.get(),
                        ModBlocks.IMPURE_ROSE_QUARTZ_BLOCK.get(),
                        ModBlocks.ROSE_QUARTZ_ORE.get(),
                        ModBlocks.ROSE_QUARTZ_STAIRS.get(),
                        ModBlocks.ROSE_QUARTZ_SLAB.get(),
                        ModBlocks.ROSE_QUARTZ_PRESSURE_PLATE.get(),
                        ModBlocks.ROSE_QUARTZ_BUTTON.get(),
                        ModBlocks.ROSE_QUARTZ_FENCE_GATE.get(),
                        ModBlocks.ROSE_QUARTZ_FENCE.get(),
                        ModBlocks.ROSE_QUARTZ_WALL.get(),
                        ModBlocks.ROSE_QUARTZ_DOOR.get(),
                        ModBlocks.ROSE_QUARTZ_TRAPDOOR.get(),
                        ModBlocks.SOUND_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DEEPSLATE_ROSE_QUARTZ_ORE.get());

        this.tag(ModTags.Blocks.NEEDS_ROSE_QUARTZ_TOOL)
                .add(ModBlocks.NETHER_ROSE_QUARTZ_ORE.get(),
                        ModBlocks.END_ROSE_QUARTZ_ORE.get(),
                        ModBlocks.ENERGY_PLANKS.get(),
                        ModBlocks.ENERGY_LOG.get(),
                        ModBlocks.STRIPPED_ENERGY_LOG.get(),
                        ModBlocks.ENERGY_WOOD.get(),
                        ModBlocks.STRIPPED_ENERGY_WOOD.get(),
                        ModBlocks.ENERGY_STAIRS.get(),
                        ModBlocks.ENERGY_SLAB.get(),
                        ModBlocks.ENERGY_PRESSURE_PLATE.get(),
                        ModBlocks.ENERGY_BUTTON.get(),
                        ModBlocks.ENERGY_FENCE.get(),
                        ModBlocks.ENERGY_FENCE_GATE.get(),
                        ModBlocks.ENERGY_DOOR.get(),
                        ModBlocks.ENERGY_TRAPDOOR.get(),
                        ModBlocks.STRENGTH_BLOCK.get(),
                        ModBlocks.IMPURE_STRENGTH_BLOCK.get(),
                        ModBlocks.STRENGTH_ORE.get(),
                        ModBlocks.DEEPSLATE_STRENGTH_ORE.get(),
                        ModBlocks.END_STRENGTH_ORE.get(),
                        ModBlocks.NETHER_STRENGTH_ORE.get(),
                        ModBlocks.INFLUENCE_BLOCK.get(),
                        ModBlocks.IMPURE_INFLUENCE_BLOCK.get(),
                        ModBlocks.INFLUENCE_ORE.get(),
                        ModBlocks.DEEPSLATE_INFLUENCE_ORE.get(),
                        ModBlocks.END_INFLUENCE_ORE.get(),
                        ModBlocks.NETHER_INFLUENCE_ORE.get(),
                        ModBlocks.GREED_BLOCK.get(),
                        ModBlocks.IMPURE_GREED_BLOCK.get(),
                        ModBlocks.GREED_ORE.get(),
                        ModBlocks.DEEPSLATE_GREED_ORE.get(),
                        ModBlocks.END_GREED_ORE.get(),
                        ModBlocks.NETHER_GREED_ORE.get(),
                        ModBlocks.CONTROL_BLOCK.get(),
                        ModBlocks.IMPURE_CONTROL_BLOCK.get(),
                        ModBlocks.CONTROL_ORE.get(),
                        ModBlocks.DEEPSLATE_CONTROL_ORE.get(),
                        ModBlocks.END_CONTROL_ORE.get(),
                        ModBlocks.NETHER_CONTROL_ORE.get(),
                        ModBlocks.POWER_BLOCK.get(),
                        ModBlocks.IMPURE_POWER_BLOCK.get(),
                        ModBlocks.POWER_ORE.get(),
                        ModBlocks.DEEPSLATE_POWER_ORE.get(),
                        ModBlocks.END_POWER_ORE.get(),
                        ModBlocks.NETHER_POWER_ORE.get(),
                        ModBlocks.LIFE_BLOCK.get(),
                        ModBlocks.IMPURE_LIFE_BLOCK.get(),
                        ModBlocks.LIFE_ORE.get(),
                        ModBlocks.DEEPSLATE_LIFE_ORE.get(),
                        ModBlocks.END_LIFE_ORE.get(),
                        ModBlocks.NETHER_LIFE_ORE.get(),
                        ModBlocks.SOUL_BLOCK.get(),
                        ModBlocks.IMPURE_SOUL_BLOCK.get(),
                        ModBlocks.SOUL_ORE.get(),
                        ModBlocks.DEEPSLATE_SOUL_ORE.get(),
                        ModBlocks.END_SOUL_ORE.get(),
                        ModBlocks.NETHER_SOUL_ORE.get()
                );

        this.tag(ModTags.Blocks.PAXEL_MINEABLE)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL);

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.ROSE_QUARTZ_FENCE.get(),
                        ModBlocks.ENERGY_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.ROSE_QUARTZ_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.ROSE_QUARTZ_WALL.get());
        this.tag(BlockTags.DOORS)
                .add(ModBlocks.ROSE_QUARTZ_DOOR.get(),
                        ModBlocks.ENERGY_DOOR.get());
        this.tag(BlockTags.TRAPDOORS)
                .add(ModBlocks.ROSE_QUARTZ_TRAPDOOR.get(),
                        ModBlocks.ENERGY_TRAPDOOR.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.ENERGY_LOG.get())
                .add(ModBlocks.ENERGY_WOOD.get())
                .add(ModBlocks.STRIPPED_ENERGY_LOG.get())
                .add(ModBlocks.STRIPPED_ENERGY_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.ENERGY_PLANKS.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
