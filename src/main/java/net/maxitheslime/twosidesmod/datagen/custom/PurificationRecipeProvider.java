package net.maxitheslime.twosidesmod.datagen.custom;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.recipe.PurificationRecipe;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class PurificationRecipeProvider implements RecipeBuilder {
    private final Item result;
    private final Ingredient ingredient;
    private final int count;
    private final int craftTime;
    private final int energyAmount;
    private final FluidStack fluidStack;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    public PurificationRecipeProvider(ItemLike ingredient, ItemLike result, int count,
                                      int craftTime, int energyAmount, FluidStack fluidStack) {
        this.ingredient = Ingredient.of(ingredient);
        this.result = result.asItem();
        this.count = count;
        this.craftTime = craftTime;
        this.energyAmount = energyAmount;
        this.fluidStack = fluidStack;
    }

    @Override
    public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, new Criterion(pCriterionTrigger));
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String pGroupName) {
        return this;
    }

    @Override
    public Item getResult() {
        return result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
        this.advancement.parent(new ResourceLocation("recipes/root"))
                .addCriterion("has_the_recipe", new Criterion(RecipeUnlockedTrigger.unlocked(pRecipeId)))
                .rewards(AdvancementRewards.Builder.recipe(pRecipeId))
                .requirements(RequirementsStrategy.f_15978_); //LOOK AT ME

        pFinishedRecipeConsumer.accept(new Result(pRecipeId, this.result, this.count, this.ingredient,
                this.advancement, new ResourceLocation(pRecipeId.getNamespace(), "recipes/"
                + pRecipeId.getPath()), this.craftTime, this.energyAmount, this.fluidStack));

    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Item result;
        private final Ingredient ingredient;
        private final int count;
        private final int craftTime;
        private final int energyAmount;
        private final FluidStack fluidStack;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation pId, Item pResult, int pCount, Ingredient ingredient, Advancement.Builder pAdvancement,
                      ResourceLocation pAdvancementId, int craftTime, int energyAmount, FluidStack fluidStack) {
            this.id = pId;
            this.result = pResult;
            this.count = pCount;
            this.ingredient = ingredient;
            this.advancement = pAdvancement;
            this.advancementId = pAdvancementId;
            this.craftTime = craftTime;
            this.energyAmount = energyAmount;
            this.fluidStack = fluidStack;
        }

        @Override
        public void serializeRecipeData(JsonObject pJson) {
            JsonArray jsonarray = new JsonArray();
            jsonarray.add(ingredient.toJson());

            pJson.add("ingredients", jsonarray);
            JsonObject jsonobject = new JsonObject();
            jsonobject.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());

            pJson.addProperty("fluidType", ForgeRegistries.FLUIDS.getKey(this.fluidStack.getFluid()).toString());
            pJson.addProperty("fluidAmount", this.fluidStack.getAmount());

            if (this.count > 1) {
                jsonobject.addProperty("count", this.count);
            }

            pJson.addProperty("craftTime", this.craftTime);
            pJson.addProperty("energyAmount", this.energyAmount);

            pJson.add("output", jsonobject);
        }

        @Override
        public ResourceLocation m_6445_() {
            return new ResourceLocation(TwoSidesMod.MOD_ID,
                    ForgeRegistries.ITEMS.getKey(this.result).getPath() + "_from_purification");
        }

        @Override
        public RecipeSerializer<?> m_6637_() {
            return PurificationRecipe.Serializer.INSTANCE;
        }

        @org.jetbrains.annotations.Nullable
        @Override
        public JsonObject m_5860_() {
                return this.advancement.m_138400_();
        }

        @org.jetbrains.annotations.Nullable
        @Override
        public ResourceLocation m_6448_() {
            return this.advancementId;
        }
    }
}