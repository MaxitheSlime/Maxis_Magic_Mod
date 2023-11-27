package net.maxitheslime.twosidesmod;

import net.maxitheslime.twosidesmod.block.ModBlocks;
import net.maxitheslime.twosidesmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TwoSidesMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TWO_SIDES_ITEMS = CREATIVE_MODE_TABS.register("two_sides_items",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PURE_ROSE_QUARTZ.get())).
                    title(Component.translatable("creativetab.two_sides_items")).displayItems((pParameters, pOutput) ->
                    {
                        pOutput.accept(ModItems.PURE_ROSE_QUARTZ.get());
                        pOutput.accept(ModItems.IMPURE_ROSE_QUARTZ.get());
                        pOutput.accept(ModItems.FIRE_QUARTZ.get());
                    }).build());
    public static final RegistryObject<CreativeModeTab> TWO_SIDES_TOOLS = CREATIVE_MODE_TABS.register("two_sides_tools",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.METAL_DETECTOR.get())).
                    title(Component.translatable("creativetab.two_sides_tools")).displayItems((pParameters, pOutput) ->
                    {
                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> TWO_SIDES_FOODS = CREATIVE_MODE_TABS.register("two_sides_foods",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LEMON.get())).
                    title(Component.translatable("creativetab.two_sides_foods")).displayItems((pParameters, pOutput) ->
                    {
                        pOutput.accept(ModItems.LEMON.get());
                    }).build());
    public static final RegistryObject<CreativeModeTab> TWO_SIDES_BLOCKS = CREATIVE_MODE_TABS.register("two_sides_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ROSE_QUARTZ_BLOCK.get())).
                    title(Component.translatable("creativetab.two_sides_blocks")).displayItems((pParameters, pOutput) ->
                    {
                        pOutput.accept(ModBlocks.ROSE_QUARTZ_BLOCK.get());
                        pOutput.accept(ModBlocks.IMPURE_ROSE_QUARTZ_BLOCK.get());
                        pOutput.accept(ModBlocks.ROSE_QUARTZ_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_ROSE_QUARTZ_ORE.get());
                        pOutput.accept(ModBlocks.END_ROSE_QUARTZ_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_ROSE_QUARTZ_ORE.get());
                        pOutput.accept(ModBlocks.SOUND_BLOCK.get());
                        pOutput.accept(ModBlocks.ROSE_QUARTZ_STAIRS.get());
                        pOutput.accept(ModBlocks.ROSE_QUARTZ_SLAB.get());
                        pOutput.accept(ModBlocks.ROSE_QUARTZ_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.ROSE_QUARTZ_BUTTON.get());
                        pOutput.accept(ModBlocks.ROSE_QUARTZ_FENCE.get());
                        pOutput.accept(ModBlocks.ROSE_QUARTZ_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.ROSE_QUARTZ_WALL.get());
                        pOutput.accept(ModBlocks.ROSE_QUARTZ_DOOR.get());
                        pOutput.accept(ModBlocks.ROSE_QUARTZ_TRAPDOOR.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
