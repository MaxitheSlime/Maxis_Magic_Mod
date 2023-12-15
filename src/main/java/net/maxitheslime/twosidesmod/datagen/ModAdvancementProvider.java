package net.maxitheslime.twosidesmod.datagen;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.block.ModBlocks;
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
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class ModAdvancementProvider implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
        //Iron pick grants access to the starting mod ores
        Advancement rqRootAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(Items.IRON_PICKAXE),
                        Component.literal("2 Sides Mod"), Component.literal("Magic at Your Fingertips!"),
                        new ResourceLocation(TwoSidesMod.MOD_ID, "textures/block/rose_quartz_ore.png"), FrameType.TASK,
                        true, true, false))
                .addCriterion("has_iron_pickaxe", new Criterion(InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_PICKAXE)))
                .save(saver, new ResourceLocation(TwoSidesMod.MOD_ID, "twosidesmod"), existingFileHelper);

        //Mined rose quartz or or ds rose quartz ore
        Advancement rqGet = Advancement.Builder.advancement()
        .display(new DisplayInfo(new ItemStack(ModBlocks.ROSE_QUARTZ_ORE.get()),
                Component.literal("Impure Rose Quartz"), Component.literal("Let's go smelt this!"),
                null, FrameType.TASK,
                true, true, false))
                .parent(rqRootAdvancement)
                .addCriterion("has_impure_rose_quartz", new Criterion(InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IMPURE_ROSE_QUARTZ.get())))
                .save(saver, new ResourceLocation(TwoSidesMod.MOD_ID, "impure_rose_quartz"), existingFileHelper);

        //Crafted the ore detetor
        Advancement metalDetector = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.METAL_DETECTOR.get()),
                        Component.literal("Ore Detector"), Component.literal("Batteries not included! (Actually doesn't need batteries)"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(rqGet)
                .addCriterion("has_metal_detector", new Criterion(InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.METAL_DETECTOR.get())))
                .save(saver, new ResourceLocation(TwoSidesMod.MOD_ID, "metal_detector"), existingFileHelper);

        //Crafted the data tablet
        Advancement dataTablet = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.DATA_TABLET.get()),
                        Component.literal("Data Tablet"), Component.literal("Batteries still not included. But a SD card is!"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(metalDetector)
                .addCriterion("has_data_tablet", new Criterion(InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DATA_TABLET.get())))
                .save(saver, new ResourceLocation(TwoSidesMod.MOD_ID, "data_tablet"), existingFileHelper);

        //Crafted the rose quartz block
        Advancement rqBlock = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModBlocks.ROSE_QUARTZ_BLOCK.get()),
                        Component.literal("Purified Rose Quartz Block"), Component.literal("Why not stack them up?"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(rqRootAdvancement)
                .addCriterion("has_pure_rose_quartz_block", new Criterion(InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.ROSE_QUARTZ_BLOCK.get())))
                .save(saver, new ResourceLocation(TwoSidesMod.MOD_ID, "pure_rose_quartz_block"), existingFileHelper);

        //Crafted the roae quartz pick
        Advancement rqPick = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.ROSE_QUARTZ_PICKAXE.get()),
                        Component.literal("Rose Quartz Pickaxe"), Component.literal("Now We're getting serious... -ly wealthy."),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(rqBlock)
                .addCriterion("has_rose_quartz_pickaxe", new Criterion(InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ROSE_QUARTZ_PICKAXE.get())))
                .save(saver, new ResourceLocation(TwoSidesMod.MOD_ID, "rose_quartz_pickaxe"), existingFileHelper);

        //Farm some Lemons to start off your mod crop farm
        Advancement cropRootAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.LEMON_SEEDS.get()),
                        Component.literal("Lemon Seeds"), Component.literal("When Life gives you lemons..."),
                        new ResourceLocation(TwoSidesMod.MOD_ID, "textures/item/energy_seeds.png"), FrameType.TASK,
                        true, true, false))
                .addCriterion("has_lemon_seeds", new Criterion(InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LEMON_SEEDS.get())))
                .save(saver, new ResourceLocation(TwoSidesMod.MOD_ID, "lemon_farming"), existingFileHelper);

        //Crafted the lemon juice bucket
        Advancement lemonade = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.LEMON_JUICE_BUCKET.get()),
                        Component.literal("Lemon Juice Bucket"), Component.literal("...make Lemonade!"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(cropRootAdvancement)
                .addCriterion("has_lemon_juice_bucket", new Criterion(InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LEMON_JUICE_BUCKET.get())))
                .save(saver, new ResourceLocation(TwoSidesMod.MOD_ID, "lemon_juice_bucket"), existingFileHelper);
    }
}
