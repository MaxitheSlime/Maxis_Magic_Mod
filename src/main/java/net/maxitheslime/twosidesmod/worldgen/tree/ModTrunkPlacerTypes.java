package net.maxitheslime.twosidesmod.worldgen.tree;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.worldgen.tree.custom.EnergyTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, TwoSidesMod.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<EnergyTrunkPlacer>> ENERGY_TRUNK_PLACER =
            TRUNK_PLACERS.register("energy_trunk_placer", () -> new TrunkPlacerType<>(EnergyTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACERS.register(eventBus);
    }
}
