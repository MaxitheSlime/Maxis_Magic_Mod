package net.maxitheslime.twosidesmod.datagen;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.block.ModBlocks;
import net.maxitheslime.twosidesmod.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> ROSE_QUARTZ_SMELTABLES = List.of(ModItems.IMPURE_ROSE_QUARTZ.get(),
            ModBlocks.ROSE_QUARTZ_ORE.get(), ModBlocks.DEEPSLATE_ROSE_QUARTZ_ORE.get(), ModBlocks.NETHER_ROSE_QUARTZ_ORE.get(),
            ModBlocks.END_ROSE_QUARTZ_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROSE_QUARTZ_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.PURE_ROSE_QUARTZ.get())
                .unlockedBy("has_pure_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROSE_QUARTZ_LAMP.get())
                .pattern("RGR")
                .pattern("SFS")
                .pattern("RGR")
                .define('R', ModItems.PURE_ROSE_QUARTZ.get())
                .define('F', ModItems.FIRE_QUARTZ.get())
                .define('G', Items.GLASS)
                .define('S', Items.REDSTONE)
                .unlockedBy("has_fire_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.FIRE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROSE_QUARTZ_STAIRS.get(), 6)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.ROSE_QUARTZ_BLOCK.get())
                .unlockedBy("has_pure_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROSE_QUARTZ_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("AAA")
                .define('A', ModBlocks.ROSE_QUARTZ_BLOCK.get())
                .unlockedBy("has_pure_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROSE_QUARTZ_PRESSURE_PLATE.get())
                .pattern(" A ")
                .pattern(" S ")
                .pattern(" A ")
                .define('A', ModBlocks.ROSE_QUARTZ_BLOCK.get())
                .define('S', Blocks.STONE_PRESSURE_PLATE)
                .unlockedBy("has_pure_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROSE_QUARTZ_BUTTON.get())
                .pattern("   ")
                .pattern("ASA")
                .pattern("   ")
                .define('A', ModBlocks.ROSE_QUARTZ_BLOCK.get())
                .define('S', Blocks.STONE_BUTTON)
                .unlockedBy("has_pure_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROSE_QUARTZ_FENCE.get(), 3)
                .pattern("   ")
                .pattern("SAS")
                .pattern("SAS")
                .define('A', ModBlocks.ROSE_QUARTZ_BLOCK.get())
                .define('S', Items.STICK)
                .unlockedBy("has_pure_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROSE_QUARTZ_FENCE_GATE.get())
                .pattern("   ")
                .pattern("ASA")
                .pattern("ASA")
                .define('A', ModBlocks.ROSE_QUARTZ_BLOCK.get())
                .define('S', Items.STICK)
                .unlockedBy("has_pure_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROSE_QUARTZ_WALL.get(),6)
                .pattern("   ")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.ROSE_QUARTZ_BLOCK.get())
                .unlockedBy("has_pure_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROSE_QUARTZ_DOOR.get(),3)
                .pattern("AA ")
                .pattern("AA ")
                .pattern("AA ")
                .define('A', ModBlocks.ROSE_QUARTZ_BLOCK.get())
                .unlockedBy("has_pure_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROSE_QUARTZ_TRAPDOOR.get())
                .pattern("   ")
                .pattern("AA ")
                .pattern("AA ")
                .define('A', ModBlocks.ROSE_QUARTZ_BLOCK.get())
                .unlockedBy("has_pure_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOUND_BLOCK.get())
                .pattern("AAA")
                .pattern("ANA")
                .pattern("AAA")
                .define('A', ModItems.PURE_ROSE_QUARTZ.get())
                .define('N', Items.NOTE_BLOCK)
                .unlockedBy("has_pure_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ROSE_QUARTZ_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" S ")
                .define('A', ModItems.PURE_ROSE_QUARTZ.get())
                .define('S', Items.STICK)
                .unlockedBy("has_pure_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DATA_TABLET.get())
                .pattern("IPI")
                .pattern("GAR")
                .pattern("S S")
                .define('A', ModItems.PURE_ROSE_QUARTZ.get())
                .define('S', Items.STICK)
                .define('G', Items.GOLD_INGOT)
                .define('R', Items.REDSTONE)
                .define('I', Items.IRON_INGOT)
                .define('P', Blocks.GLASS_PANE)
                .unlockedBy("has_pure_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ROSE_QUARTZ_AXE.get())
                .pattern("AA ")
                .pattern("AS ")
                .pattern(" S ")
                .define('A', ModItems.PURE_ROSE_QUARTZ.get())
                .define('S', Items.STICK)
                .unlockedBy("has_pure_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ROSE_QUARTZ_PICKAXE.get())
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.PURE_ROSE_QUARTZ.get())
                .define('S', Items.STICK)
                .unlockedBy("has_pure_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ROSE_QUARTZ_SHOVEL.get())
                .pattern(" A ")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.PURE_ROSE_QUARTZ.get())
                .define('S', Items.STICK)
                .unlockedBy("has_pure_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ROSE_QUARTZ_HOE.get())
                .pattern("AA ")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.PURE_ROSE_QUARTZ.get())
                .define('S', Items.STICK)
                .unlockedBy("has_pure_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ROSE_QUARTZ_PAXEL.get())
                .pattern(" P ")
                .pattern("ARV")
                .pattern(" S ")
                .define('R', ModItems.PURE_ROSE_QUARTZ.get())
                .define('P', ModItems.ROSE_QUARTZ_PICKAXE.get())
                .define('A', ModItems.ROSE_QUARTZ_AXE.get())
                .define('V', ModItems.ROSE_QUARTZ_SHOVEL.get())
                .define('S', Items.STICK)
                .unlockedBy("has_netherite_pickaxe", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.NETHERITE_PICKAXE).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ROSE_QUARTZ_HAMMER.get())
                .pattern(" R ")
                .pattern("PPP")
                .pattern(" S ")
                .define('R', ModItems.PURE_ROSE_QUARTZ.get())
                .define('P', ModItems.ROSE_QUARTZ_PICKAXE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_netherite_pickaxe", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.NETHERITE_PICKAXE).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ROSE_QUARTZ_HORSE_ARMOR.get())
                .pattern(" LR")
                .pattern("RBR")
                .pattern("RRR")
                .define('R', ModItems.PURE_ROSE_QUARTZ.get())
                .define('B', Items.BLACK_WOOL)
                .define('L', Items.LEAD)
                .unlockedBy("has_saddle", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.SADDLE).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ROSE_QUARTZ_HELMET.get())
                .pattern("RRR")
                .pattern("R R")
                .pattern("   ")
                .define('R', ModItems.PURE_ROSE_QUARTZ.get())
                .unlockedBy("has_pure_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ROSE_QUARTZ_CHESTPLATE.get())
                .pattern("R R")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.PURE_ROSE_QUARTZ.get())
                .unlockedBy("has_pure_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ROSE_QUARTZ_LEGGINGS.get())
                .pattern("RRR")
                .pattern("R R")
                .pattern("R R")
                .define('R', ModItems.PURE_ROSE_QUARTZ.get())
                .unlockedBy("has_pure_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ROSE_QUARTZ_BOOTS.get())
                .pattern("R R")
                .pattern("R R")
                .pattern("   ")
                .define('R', ModItems.PURE_ROSE_QUARTZ.get())
                .unlockedBy("has_pure_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FIRE_QUARTZ.get())
                .pattern("MMM")
                .pattern("MAM")
                .pattern("MMM")
                .define('A', ModItems.PURE_ROSE_QUARTZ.get())
                .define('M', Items.MAGMA_CREAM)
                .unlockedBy("has_magma_cream", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.MAGMA_CREAM).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CRYSTALLIZED_FLOWER.get())
                .pattern(" R ")
                .pattern(" D ")
                .pattern(" G ")
                .define('R', ModItems.PURE_ROSE_QUARTZ.get())
                .define('D', Items.TORCHFLOWER_SEEDS)
                .define('G', Blocks.ROOTED_DIRT)
                .unlockedBy("has_torchflower_seeds", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.TORCHFLOWER_SEEDS).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.METAL_DETECTOR.get())
                .pattern(" S ")
                .pattern(" C ")
                .pattern("IAI")
                .define('A', ModItems.PURE_ROSE_QUARTZ.get())
                .define('S', Items.STICK)
                .define('C', Items.COPPER_INGOT)
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_pure_rose_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BAR_BRAWL_RECORD.get())
                .pattern("DDD")
                .pattern("R R")
                .pattern("DDD")
                .define('R', ModItems.PURE_ROSE_QUARTZ.get())
                .define('D', ModItems.ROSE_QUARTZ_DISK_PIECE.get())
                .unlockedBy("has_rose_quartz_disk_piece", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.ROSE_QUARTZ_DISK_PIECE.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LEMON_SEEDS.get(), 3)
                .requires(ModItems.LEMON.get())
                .unlockedBy("has_lemon", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.LEMON.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PINK_DYE, 3)
                .requires(ModBlocks.CRYSTALLIZED_FLOWER.get())
                .unlockedBy("has_crystal_flower", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.CRYSTALLIZED_FLOWER.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PURE_ROSE_QUARTZ.get(), 9)
                .requires(ModBlocks.ROSE_QUARTZ_BLOCK.get())
                .unlockedBy("has_pure_rose_quartz_block", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.ROSE_QUARTZ_BLOCK.get()).build()))
                .save(pWriter);

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.IMPURE_ROSE_QUARTZ.get(), RecipeCategory.MISC, ModBlocks.IMPURE_ROSE_QUARTZ_BLOCK.get(),
                "twosidesmod:impure_rose_quartz", "pure_rose_quartz", "twosidesmod:impure_rose_quartz_block", "pure_rose_quartz");
        oreSmelting(pWriter, ROSE_QUARTZ_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_ROSE_QUARTZ.get(), 0.25f, 200, "pure_rose_quartz");
        oreBlasting(pWriter, ROSE_QUARTZ_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_ROSE_QUARTZ.get(), 0.25f, 100, "pure_rose_quartz");
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
                                     List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime,
                            pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, TwoSidesMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}

