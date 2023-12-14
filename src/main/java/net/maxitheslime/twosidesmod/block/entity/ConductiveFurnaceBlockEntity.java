package net.maxitheslime.twosidesmod.block.entity;

import net.maxitheslime.twosidesmod.block.screen.ConductiveFurnaceMenu;
import net.maxitheslime.twosidesmod.item.ModItems;
import net.maxitheslime.twosidesmod.recipe.ConductiveFurnaceRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

public class ConductiveFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    private Map<Item, Integer> BURN_DURATION_MAP =
            Map.of(ModItems.FIRE_QUARTZ.get(), 100,
                    ModItems.ENERGY_ORB.get(), 6400,
                    Items.BLAZE_POWDER, 800);

    public ConductiveFurnaceBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.CONDUCTIVE_FURNACE_BLOCK_ENTITY.get(), pPos, pBlockState, ConductiveFurnaceRecipe.Type.INSTANCE);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("block.twosidesmod.conductive_furnace");
    }

    @Override
    protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
        return new ConductiveFurnaceMenu(pContainerId, pInventory, this, dataAccess);
    }

    @Override
    protected int getBurnDuration(ItemStack pFuel) {
        return BURN_DURATION_MAP.getOrDefault(pFuel.getItem(), 0);
    }
}