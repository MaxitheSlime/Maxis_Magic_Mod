package net.maxitheslime.twosidesmod.util;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Items{
        private static TagKey<Item> Tag(String name){
            return ItemTags.create(new ResourceLocation(TwoSidesMod.MOD_ID, name));
        }
        private static TagKey<Item> forgeTag(String name){
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("md_values");
        public static final TagKey<Block> NEEDS_ROSE_QUARTZ_TOOL = tag("needs_rose_quartz_tool");
        public static final TagKey<Block> PAXEL_MINEABLE = tag("mineable/paxel");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(TwoSidesMod.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}
