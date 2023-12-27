package net.maxitheslime.twosidesmod.fluid;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.block.ModBlocks;
import net.maxitheslime.twosidesmod.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, TwoSidesMod.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_LEMON_JUICE = FLUIDS.register("lemon_juice_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.LEMON_JUICE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_LEMON_JUICE = FLUIDS.register("flowing_lemon_juice_fluid",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.LEMON_JUICE_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties LEMON_JUICE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.LEMON_JUICE_FLUID_TYPE, SOURCE_LEMON_JUICE, FLOWING_LEMON_JUICE)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModBlocks.LEMON_JUICE_BLOCK)
            .bucket(ModItems.LEMON_JUICE_BUCKET);
    

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
