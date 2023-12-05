package net.maxitheslime.twosidesmod.datagen;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class ModAdvancementProvider implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
        Advancement rootAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.PURE_ROSE_QUARTZ.get()),
                        Component.literal("2 Sides Mod"), Component.literal("Magic at Your Fingertips!"),
                        new ResourceLocation(TwoSidesMod.MOD_ID, "textures/block/rose_quartz_ore.png"), FrameType.TASK,
                        true, true, false))
                .addCriterion("has_impure_rose_quartz", new Criterion(InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IMPURE_ROSE_QUARTZ.get())))
                .save(saver, new ResourceLocation(TwoSidesMod.MOD_ID, "twosidesmod"), existingFileHelper);


        Advancement metalDetector = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.METAL_DETECTOR.get()),
                        Component.literal("Ore Detector"), Component.literal("Batteries not included! (Actually doesn't need batteries)"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(rootAdvancement)
                .addCriterion("has_metal_detector", new Criterion(InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.METAL_DETECTOR.get())))
                .save(saver, new ResourceLocation(TwoSidesMod.MOD_ID, "metal_detector"), existingFileHelper);



    }
}
