package net.maxitheslime.twosidesmod.block.screen;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.recipe.ConductiveFurnaceRecipeBookComponent;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ConductiveFurnaceScreen  extends AbstractFurnaceScreen<ConductiveFurnaceMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(TwoSidesMod.MOD_ID, "textures/gui/conductive_furnace.png");

    public ConductiveFurnaceScreen(ConductiveFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, new ConductiveFurnaceRecipeBookComponent(), pPlayerInventory, pTitle, TEXTURE);
    }
}