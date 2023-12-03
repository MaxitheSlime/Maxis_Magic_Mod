package net.maxitheslime.twosidesmod.datagen;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModPaintingVariantTagProvider extends PaintingVariantTagsProvider {
    public ModPaintingVariantTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, TwoSidesMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(PaintingVariantTags.PLACEABLE)
                .addOptional(new ResourceLocation(TwoSidesMod.MOD_ID, "saw_them"))
                .addOptional(new ResourceLocation(TwoSidesMod.MOD_ID, "shrimp"))
                .addOptional(new ResourceLocation(TwoSidesMod.MOD_ID, "world"));
    }
}
