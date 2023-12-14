package net.maxitheslime.twosidesmod.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.block.ModBlocks;
import net.maxitheslime.twosidesmod.recipe.ConductiveFurnaceRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class ConductiveFurnaceRecipeCategory implements IRecipeCategory<ConductiveFurnaceRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(TwoSidesMod.MOD_ID, "conductive_furnace");
    public static final ResourceLocation TEXTURE = new ResourceLocation(TwoSidesMod.MOD_ID,
            "textures/gui/conductive_furnace.png");

    public static final RecipeType<ConductiveFurnaceRecipe> CONDUCTIVE_FURNACE_TYPE =
            new RecipeType<>(UID, ConductiveFurnaceRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public ConductiveFurnaceRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.CONDUCTIVE_FURNACE.get()));
    }

    @Override
    public RecipeType<ConductiveFurnaceRecipe> getRecipeType() {
        return CONDUCTIVE_FURNACE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.twosidesmod.conductive_furnace");
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ConductiveFurnaceRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 56, 17).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 116, 35).addItemStack(recipe.getResultItem(null));
    }
}