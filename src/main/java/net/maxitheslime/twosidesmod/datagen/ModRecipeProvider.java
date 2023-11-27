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
                .unlockedBy("has_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOUND_BLOCK.get())
                .pattern("AAA")
                .pattern("ANA")
                .pattern("AAA")
                .define('A', ModItems.PURE_ROSE_QUARTZ.get())
                .define('N', Items.NOTE_BLOCK)
                .unlockedBy("has_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.METAL_DETECTOR.get())
                .pattern(" S ")
                .pattern(" C ")
                .pattern("IAI")
                .define('A', ModItems.PURE_ROSE_QUARTZ.get())
                .define('S', Items.STICK)
                .define('C', Items.COPPER_INGOT)
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PURE_ROSE_QUARTZ.get()).build()))
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
