package net.maxitheslime.twosidesmod.worldgen.tree;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.worldgen.tree.custom.EnergyFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacerTypes {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, TwoSidesMod.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<EnergyFoliagePlacer>> ENERGY_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("energy_foliage_placer", () -> new FoliagePlacerType<>(EnergyFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}
