package net.maxitheslime.twosidesmod.block.entity;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TwoSidesMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<PurificationTableEntity>> PURIFICATION_TABLE_BE =
            BLOCK_ENTITIES.register("purification_table_block_entity", () ->
                    BlockEntityType.Builder.of(PurificationTableEntity::new,
                            ModBlocks.PURIFICATION_TABLE.get()).build(null));

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN =
            BLOCK_ENTITIES.register("mod_sign", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ModBlocks.ENERGY_SIGN.get(), ModBlocks.ENERGY_WALL_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN =
            BLOCK_ENTITIES.register("mod_hanging_sign", () ->
                    BlockEntityType.Builder.of(ModHangingSignBlockEntity::new,
                            ModBlocks.ENERGY_HANGING_SIGN.get(), ModBlocks.ENERGY_WALL_HANGING_SIGN.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
