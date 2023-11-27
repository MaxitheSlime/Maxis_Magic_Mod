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
import net.minecraftforge.fml.common.Mod;

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
                .add(Blocks.IRON_BLOCK).add(Blocks.RAW_IRON_BLOCK).add(Blocks.GOLD_BLOCK).add(Blocks.RAW_GOLD_BLOCK)
                .add(Blocks.COPPER_BLOCK).add(Blocks.RAW_COPPER_BLOCK).add(Blocks.REDSTONE_BLOCK).add(Blocks.LAPIS_BLOCK)
                .add(Blocks.COAL_BLOCK).add(Blocks.DIAMOND_BLOCK).add(Blocks.EMERALD_BLOCK).add(Blocks.AMETHYST_CLUSTER)
                .add(Blocks.BUDDING_AMETHYST).add(Blocks.QUARTZ_BLOCK).addTag(Tags.Blocks.ORES);

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
                        ModBlocks.SOUND_BLOCK.get());

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
                .add(ModBlocks.NETHER_ROSE_QUARTZ_ORE.get())
                .add(ModBlocks.END_ROSE_QUARTZ_ORE.get());

        this.tag(ModTags.Blocks.PAXEL_MINEABLE)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL);

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.ROSE_QUARTZ_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.ROSE_QUARTZ_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.ROSE_QUARTZ_WALL.get());
        this.tag(BlockTags.DOORS)
                .add(ModBlocks.ROSE_QUARTZ_DOOR.get());
        this.tag(BlockTags.TRAPDOORS)
                .add(ModBlocks.ROSE_QUARTZ_TRAPDOOR.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
