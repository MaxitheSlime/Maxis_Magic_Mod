package net.maxitheslime.twosidesmod.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;

public class PurificationRecipe implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputItems;
    private final ItemStack output;
    private final ResourceLocation id;
    private final int craftTime;
    private final int energyAmount;
    private final FluidStack fluidStack;

    public PurificationRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> inputItems,
                              int craftTime, int energyAmount, FluidStack fluidStack) {
        this.inputItems = inputItems;
        this.output = output;
        this.id = id;
        this.craftTime = craftTime;
        this.energyAmount = energyAmount;
        this.fluidStack = fluidStack;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if(pLevel.isClientSide()) {
            return false;
        }

        return inputItems.get(0).test(pContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(SimpleContainer p_44001_, RegistryAccess p_267165_) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return output.copy();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.inputItems;
    }

    @Override
    public ResourceLocation m_6423_() {
        return id;
    }

    public int getCraftTime() {
        return craftTime;
    }

    public int getEnergyAmount() {
        return energyAmount;
    }

    public FluidStack getFluidStack() {
        return fluidStack;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<PurificationRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "purification";
    }

    public static class Serializer implements RecipeSerializer<PurificationRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(TwoSidesMod.MOD_ID,"purification");

        @Override
        public PurificationRecipe m_6729_(ResourceLocation id, JsonObject json) {
            ItemStack output = ShapedRecipe.m_151274_(GsonHelper.getAsJsonObject(json, "output"));
            FluidStack fluidStack = new FluidStack(ForgeRegistries.FLUIDS.getValue(new ResourceLocation(json.get("fluidType").getAsString())),
                    json.get("fluidAmount").getAsInt());

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.m_43917_(ingredients.get(i)));
            }

            int craftTime = json.get("craftTime").getAsInt();
            int energyAmount = json.get("energyAmount").getAsInt();
            return new PurificationRecipe(id, output, inputs, craftTime, energyAmount, fluidStack);
        }

        @Override
        public PurificationRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);
            FluidStack fluidStack = buf.readFluidStack();

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            int craftTime = buf.readInt();
            int energyAmount = buf.readInt();
            ItemStack output = buf.readItem();
            return new PurificationRecipe(id, output, inputs, craftTime, energyAmount, fluidStack);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, PurificationRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            buf.writeFluidStack(recipe.fluidStack);

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }

            buf.writeInt(recipe.craftTime);
            buf.writeInt(recipe.energyAmount);
            buf.writeItemStack(recipe.getResultItem(null), false);
        }
    }
}