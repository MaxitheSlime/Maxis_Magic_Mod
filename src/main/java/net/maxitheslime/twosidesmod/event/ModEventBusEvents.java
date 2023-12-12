package net.maxitheslime.twosidesmod.event;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.entity.ModEntities;
import net.maxitheslime.twosidesmod.entity.client.MagicMissileModel;
import net.maxitheslime.twosidesmod.entity.client.RQGModel;
import net.maxitheslime.twosidesmod.entity.client.RubyStatueModel;
import net.maxitheslime.twosidesmod.entity.custom.RQGEntity;
import net.maxitheslime.twosidesmod.entity.custom.RSEntity;
import net.maxitheslime.twosidesmod.entity.layers.ModModelLayers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TwoSidesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.RQG_LAYER, RQGModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.RS_LAYER, RubyStatueModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.MAGIC_MISSILE_LAYER, MagicMissileModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.RQG.get(), RQGEntity.createAttributes().build());
        event.put(ModEntities.RUBY_STATUE.get(), RSEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacement(SpawnPlacementRegisterEvent event) {
        event.register(ModEntities.RQG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
