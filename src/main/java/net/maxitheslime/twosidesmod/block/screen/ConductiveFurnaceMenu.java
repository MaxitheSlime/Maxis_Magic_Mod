package net.maxitheslime.twosidesmod.block.screen;

import net.maxitheslime.twosidesmod.block.screen.ModMenuTypes;
import net.maxitheslime.twosidesmod.recipe.ConductiveFurnaceRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.ItemStack;

public class ConductiveFurnaceMenu extends AbstractFurnaceMenu {
    protected ConductiveFurnaceMenu(int pContainerId, Inventory pPlayerInventory, FriendlyByteBuf friendlyByteBuf) {
        this(pContainerId, pPlayerInventory);
    }

    public ConductiveFurnaceMenu(int pContainerId, Inventory pPlayerInventory, Container container, ContainerData data) {
        super(ModMenuTypes.CONDUCTIVE_FURNACE_MENU.get(), ConductiveFurnaceRecipe.Type.INSTANCE, RecipeBookType.FURNACE, pContainerId, pPlayerInventory, container, data);
    }

    public ConductiveFurnaceMenu(int pContainerId, Inventory pPlayerInventory) {
        super(ModMenuTypes.CONDUCTIVE_FURNACE_MENU.get(), ConductiveFurnaceRecipe.Type.INSTANCE, RecipeBookType.FURNACE, pContainerId, pPlayerInventory);
    }

    @Override
    protected boolean isFuel(ItemStack pStack) {
        return true;
    }
}