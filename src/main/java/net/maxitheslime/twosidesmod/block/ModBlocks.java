package net.maxitheslime.twosidesmod.block;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.block.custom.LemonBonsaiCropBlock;
import net.maxitheslime.twosidesmod.block.custom.RoseQuartzLampBlock;
import net.maxitheslime.twosidesmod.block.custom.SoundBlock;
import net.maxitheslime.twosidesmod.item.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TwoSidesMod.MOD_ID);

    public static final RegistryObject<Block> ROSE_QUARTZ_BLOCK = registerBlock("pure_rose_quartz_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> IMPURE_ROSE_QUARTZ_BLOCK = registerBlock("impure_rose_quartz_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> ROSE_QUARTZ_STAIRS = registerBlock("rose_quartz_stairs",
            () -> new StairBlock(() -> ModBlocks.ROSE_QUARTZ_BLOCK.get().defaultBlockState() ,
                    BlockBehaviour.Properties.copy(Blocks.GRANITE_STAIRS).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ROSE_QUARTZ_SLAB = registerBlock("rose_quartz_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.GRANITE_SLAB).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ROSE_QUARTZ_PRESSURE_PLATE = registerBlock("rose_quartz_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL), BlockSetType.IRON));
    public static final RegistryObject<Block> ROSE_QUARTZ_BUTTON = registerBlock("rose_quartz_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL), BlockSetType.IRON,
                    10, true));
    public static final RegistryObject<Block> ROSE_QUARTZ_FENCE = registerBlock("rose_quartz_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ROSE_QUARTZ_FENCE_GATE = registerBlock("rose_quartz_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> ROSE_QUARTZ_WALL = registerBlock("rose_quartz_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ROSE_QUARTZ_DOOR = registerBlock("rose_quartz_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(), BlockSetType.IRON));
    public static final RegistryObject<Block> ROSE_QUARTZ_TRAPDOOR = registerBlock("rose_quartz_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(), BlockSetType.IRON));

    public static final RegistryObject<Block> ROSE_QUARTZ_LAMP = registerBlock("rose_quartz_lamp",
            () -> new RoseQuartzLampBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(RoseQuartzLampBlock.CLICKED) ? 15 : 0)));

    public static final RegistryObject<Block> ROSE_QUARTZ_ORE = registerBlock("rose_quartz_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> DEEPSLATE_ROSE_QUARTZ_ORE = registerBlock("deepslate_rose_quartz_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> END_ROSE_QUARTZ_ORE = registerBlock("end_rose_quartz_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> NETHER_ROSE_QUARTZ_ORE = registerBlock("nether_rose_quartz_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));

    public static final RegistryObject<Block> BONSAI_LEMON_CROP = BLOCKS.register("bonsai_lemon_crop",
            () -> new LemonBonsaiCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem (String name, RegistryObject<T> block)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
