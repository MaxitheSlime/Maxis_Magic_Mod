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
                        pOutput.accept(ModItems.ROSE_QUARTZ_DISK_PIECE.get());
                        pOutput.accept(ModItems.BAR_BRAWL_RECORD.get());
                        pOutput.accept(ModItems.ROSE_QUARTZ_LIGHTBULB.get());
                    }).build());
    public static final RegistryObject<CreativeModeTab> TWO_SIDES_TOOLS = CREATIVE_MODE_TABS.register("two_sides_tools",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.METAL_DETECTOR.get())).
                    title(Component.translatable("creativetab.two_sides_tools")).displayItems((pParameters, pOutput) ->
                    {
                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                        pOutput.accept(ModItems.DATA_TABLET.get());
                        pOutput.accept(ModItems.ROSE_QUARTZ_SWORD.get());
                        pOutput.accept(ModItems.ROSE_QUARTZ_PICKAXE.get());
                        pOutput.accept(ModItems.ROSE_QUARTZ_SHOVEL.get());
                        pOutput.accept(ModItems.ROSE_QUARTZ_AXE.get());
                        pOutput.accept(ModItems.ROSE_QUARTZ_HOE.get());
                        pOutput.accept(ModItems.ROSE_QUARTZ_PAXEL.get());
                        pOutput.accept(ModItems.ROSE_QUARTZ_HAMMER.get());
                        pOutput.accept(ModItems.ROSE_QUARTZ_BOW.get());

                        pOutput.accept(ModItems.ROSE_QUARTZ_HELMET.get());
                        pOutput.accept(ModItems.ROSE_QUARTZ_CHESTPLATE.get());
                        pOutput.accept(ModItems.ROSE_QUARTZ_LEGGINGS.get());
                        pOutput.accept(ModItems.ROSE_QUARTZ_BOOTS.get());
                        pOutput.accept(ModItems.ROSE_QUARTZ_SHIELD.get());
                        pOutput.accept(ModItems.ROSE_QUARTZ_HORSE_ARMOR.get());

                        pOutput.accept(ModItems.REMOTE_CONTROL.get());

                        pOutput.accept(ModItems.DICE.get());

                        pOutput.accept(ModItems.ENERGY_BOAT.get());
                        pOutput.accept(ModItems.ENERGY_CHEST_BOAT.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> TWO_SIDES_FOODS = CREATIVE_MODE_TABS.register("two_sides_foods",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LEMON.get())).
                    title(Component.translatable("creativetab.two_sides_foods")).displayItems((pParameters, pOutput) ->
                    {
                        pOutput.accept(ModItems.LEMON.get());
                        pOutput.accept(ModItems.LEMON_SEEDS.get());
                        pOutput.accept(ModItems.ENERGY_ORB.get());
                        pOutput.accept(ModItems.ENERGY_SEEDS.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> TWO_SIDES_MOBS = CREATIVE_MODE_TABS.register("two_sides_mobs",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RQG_SPAWN_EGG.get())).
                    title(Component.translatable("creativetab.two_sides_mobs")).displayItems((pParameters, pOutput) ->
                    {
                        pOutput.accept(ModItems.RQG_SPAWN_EGG.get());
                        pOutput.accept(ModItems.RS_SPAWN_EGG.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> TWO_SIDES_FLUIDS = CREATIVE_MODE_TABS.register("two_sides_fluids",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LEMON_JUICE_BUCKET.get())).
                    title(Component.translatable("creativetab.two_sides_fluids")).displayItems((pParameters, pOutput) ->
                    {
                        pOutput.accept(ModItems.LEMON_JUICE_BUCKET.get());
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
                        pOutput.accept(ModBlocks.ROSE_QUARTZ_LAMP.get());
                        pOutput.accept(ModBlocks.PURIFICATION_TABLE.get());
                        pOutput.accept(ModBlocks.ENERGY_PLANKS.get());
                        pOutput.accept(ModItems.ENERGY_SIGN.get());
                        pOutput.accept(ModItems.ENERGY_HANGING_SIGN.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> TWO_SIDES_NATURE_BLOCKS = CREATIVE_MODE_TABS.register("two_sides_nature_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CRYSTALLIZED_FLOWER.get())).
                    title(Component.translatable("creativetab.two_sides_nature_blocks")).displayItems((pParameters, pOutput) ->
                    {
                        pOutput.accept(ModBlocks.ENERGY_LOG.get());
                        pOutput.accept(ModBlocks.ENERGY_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_ENERGY_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_ENERGY_WOOD.get());
                        pOutput.accept(ModBlocks.ENERGY_LEAVES.get());
                        pOutput.accept(ModBlocks.ENERGY_LEAVES_ALT.get());
                        pOutput.accept(ModBlocks.ENERGY_SAPLING.get());
                        pOutput.accept(ModBlocks.CRYSTALLIZED_FLOWER.get());
                        pOutput.accept(ModBlocks.MAXI_PORTAL.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
