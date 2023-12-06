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
import net.maxitheslime.twosidesmod.recipe.PurificationRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class PurificationRecipeCategory implements IRecipeCategory<PurificationRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(TwoSidesMod.MOD_ID, "purification");
    public static final ResourceLocation TEXTURE = new ResourceLocation(TwoSidesMod.MOD_ID,
            "textures/gui/purification_table_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public static final RecipeType<PurificationRecipe> PURIFICATION_TYPE =
            new RecipeType<>(UID, PurificationRecipe.class);

    public PurificationRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.PURIFICATION_TABLE.get()));
    }

    @Override
    public RecipeType<PurificationRecipe> getRecipeType() {
        return PURIFICATION_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Purification Station");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, PurificationRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 11).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 59).addItemStack(recipe.getResultItem(null));
    }
}
