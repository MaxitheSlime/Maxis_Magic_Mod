package net.maxitheslime.twosidesmod.entity;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.entity.custom.RQGEntity;
import net.maxitheslime.twosidesmod.entity.custom.RSEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TwoSidesMod.MOD_ID);

    public static final RegistryObject<EntityType<RQGEntity>> RQG =
            ENTITY_TYPES.register("rqg", () -> EntityType.Builder.of(RQGEntity::new, MobCategory.CREATURE)
                    .sized(2.5f, 3f).build("rqg"));

    public static final RegistryObject<EntityType<RSEntity>> RUBY_STATUE =
            ENTITY_TYPES.register("ruby_statue", () -> EntityType.Builder.of(RSEntity::new, MobCategory.CREATURE)
                    .sized(2.9f, 99f).build("ruby_statue"));
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
