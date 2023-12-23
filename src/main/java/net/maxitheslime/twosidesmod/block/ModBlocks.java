package net.maxitheslime.twosidesmod.block;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.block.custom.*;
import net.maxitheslime.twosidesmod.fluid.ModFluids;
import net.maxitheslime.twosidesmod.item.ModItems;
import net.maxitheslime.twosidesmod.sound.ModSounds;
import net.maxitheslime.twosidesmod.util.ModWoodTypes;
import net.maxitheslime.twosidesmod.worldgen.tree.AltEnergyTreeGrower;
import net.maxitheslime.twosidesmod.worldgen.tree.EnergyTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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
                    80, true));
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
            () -> new RoseQuartzLampBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED)
                    .sound(ModSounds.ROSE_QUARTZ_LAMP_SOUNDS).strength(1f)
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

    public static final RegistryObject<Block> CRYSTALLIZED_FLOWER = registerBlock("crystal_flower",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 6, BlockBehaviour.Properties.copy(Blocks.ALLIUM)));
    public static final RegistryObject<Block> POTTED_CRYSTALLIZED_FLOWER = BLOCKS.register("potted_crystal_flower",
            () -> new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), CRYSTALLIZED_FLOWER,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)));

    public static final RegistryObject<Block> PURIFICATION_TABLE = registerBlock("purification_table",
            () -> new PurifyingTableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> CONDUCTIVE_FURNACE = registerBlock("conductive_furnace",
            () -> new ConductiveFurnaceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> ENERGY_LOG = registerBlock("energy_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> ENERGY_WOOD = registerBlock("energy_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_ENERGY_LOG = registerBlock("stripped_energy_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_ENERGY_WOOD = registerBlock("stripped_energy_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> ENERGY_PLANKS = registerBlock("energy_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> ENERGY_LEAVES = registerBlock("energy_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });
    public static final RegistryObject<Block> ENERGY_LEAVES_ALT = registerBlock("colored_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });
    public static final RegistryObject<Block> ENERGY_SIGN = BLOCKS.register("energy_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.ENERGY));
    public static final RegistryObject<Block> ENERGY_WALL_SIGN = BLOCKS.register("energy_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.ENERGY));

    public static final RegistryObject<Block> ENERGY_HANGING_SIGN = BLOCKS.register("energy_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.ENERGY));
    public static final RegistryObject<Block> ENERGY_WALL_HANGING_SIGN = BLOCKS.register("energy_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.ENERGY));

    public static final RegistryObject<Block> ENERGY_STAIRS = registerBlock("energy_stairs",
            () -> new StairBlock(() -> ModBlocks.ENERGY_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ENERGY_SLAB = registerBlock("energy_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ENERGY_PRESSURE_PLATE = registerBlock("energy_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(ModBlocks.ENERGY_PLANKS.get()).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final RegistryObject<Block> ENERGY_BUTTON = registerBlock("energy_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(ModBlocks.ENERGY_PLANKS.get()).sound(SoundType.WOOD), BlockSetType.OAK,
                    40, true));
    public static final RegistryObject<Block> ENERGY_FENCE = registerBlock("energy_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(ModBlocks.ENERGY_PLANKS.get())));
    public static final RegistryObject<Block> ENERGY_FENCE_GATE = registerBlock("energy_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(ModBlocks.ENERGY_PLANKS.get()), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> ENERGY_DOOR = registerBlock("energy_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(ModBlocks.ENERGY_PLANKS.get()).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> ENERGY_TRAPDOOR = registerBlock("energy_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(ModBlocks.ENERGY_PLANKS.get()).noOcclusion(), BlockSetType.OAK));


    public static final RegistryObject<Block> ENERGY_SAPLING = registerBlock("energy_sapling",
            () -> new ModSaplingBlock(new EnergyTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> ALT_ENERGY_SAPLING = registerBlock("alt_energy_sapling",
            () -> new ModSaplingBlock(new AltEnergyTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> POTTED_ALT_ENERGY_SAPLING = BLOCKS.register("potted_alt_energy_sapling",
            () -> new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), ALT_ENERGY_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)));
    public static final RegistryObject<Block> POTTED_ENERGY_SAPLING = BLOCKS.register("potted_energy_sapling",
            () -> new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), ENERGY_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)));

    public static final RegistryObject<Block> ENERGY_CROP = BLOCKS.register("energy_crop",
            () -> new EnergyCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> DICE_BLOCK = BLOCKS.register("dice_block",
            () -> new DiceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(6f)));

    public static final RegistryObject<Block> MAXI_PORTAL = registerBlock("maxi_portal",
            () -> new MaxiPortalBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_PORTAL).noLootTable().noOcclusion().noCollission()));

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new DegradableRubyBlock(GemDegradable.GemDegradationLevel.UNAFFECTED,
                    BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> RUBY_BLOCK_1 = registerBlock("ruby_block_1",
            () -> new DegradableRubyBlock(GemDegradable.GemDegradationLevel.EXPOSED,
                    BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> RUBY_BLOCK_2 = registerBlock("ruby_block_2",
            () -> new DegradableRubyBlock(GemDegradable.GemDegradationLevel.WEATHERED,
                    BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> RUBY_BLOCK_3 = registerBlock("ruby_block_3",
            () -> new DegradableRubyBlock(GemDegradable.GemDegradationLevel.DEGRADED,
                    BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> WAXED_RUBY_BLOCK = registerBlock("waxed_ruby_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> WAXED_RUBY_BLOCK_1 = registerBlock("waxed_ruby_block_1",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> WAXED_RUBY_BLOCK_2 = registerBlock("waxed_ruby_block_2",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> WAXED_RUBY_BLOCK_3 = registerBlock("waxed_ruby_block_3",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> STRENGTH_BLOCK = registerBlock("crystal_strength_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> IMPURE_STRENGTH_BLOCK = registerBlock("impure_crystal_strength_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> STRENGTH_ORE = registerBlock("strength_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> DEEPSLATE_STRENGTH_ORE = registerBlock("deepslate_strength_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> END_STRENGTH_ORE = registerBlock("end_strength_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> NETHER_STRENGTH_ORE = registerBlock("nether_strength_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> INFLUENCE_BLOCK = registerBlock("crystal_influence_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> IMPURE_INFLUENCE_BLOCK = registerBlock("impure_crystal_influence_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> INFLUENCE_ORE = registerBlock("influence_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> DEEPSLATE_INFLUENCE_ORE = registerBlock("deepslate_influence_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> END_INFLUENCE_ORE = registerBlock("end_influence_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> NETHER_INFLUENCE_ORE = registerBlock("nether_influence_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> GREED_BLOCK = registerBlock("crystal_greed_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> IMPURE_GREED_BLOCK = registerBlock("impure_crystal_greed_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> GREED_ORE = registerBlock("greed_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> DEEPSLATE_GREED_ORE = registerBlock("deepslate_greed_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> END_GREED_ORE = registerBlock("end_greed_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> NETHER_GREED_ORE = registerBlock("nether_greed_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> CONTROL_BLOCK = registerBlock("crystal_control_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> IMPURE_CONTROL_BLOCK = registerBlock("impure_crystal_control_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> CONTROL_ORE = registerBlock("control_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> DEEPSLATE_CONTROL_ORE = registerBlock("deepslate_control_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> END_CONTROL_ORE = registerBlock("end_control_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> NETHER_CONTROL_ORE = registerBlock("nether_control_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> POWER_BLOCK = registerBlock("crystal_power_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> IMPURE_POWER_BLOCK = registerBlock("impure_crystal_power_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> POWER_ORE = registerBlock("power_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> DEEPSLATE_POWER_ORE = registerBlock("deepslate_power_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> END_POWER_ORE = registerBlock("end_power_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> NETHER_POWER_ORE = registerBlock("nether_power_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> LIFE_BLOCK = registerBlock("crystal_life_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> IMPURE_LIFE_BLOCK = registerBlock("impure_crystal_life_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> LIFE_ORE = registerBlock("life_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> DEEPSLATE_LIFE_ORE = registerBlock("deepslate_life_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> END_LIFE_ORE = registerBlock("end_life_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> NETHER_LIFE_ORE = registerBlock("nether_life_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> SOUL_BLOCK = registerBlock("crystal_soul_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> IMPURE_SOUL_BLOCK = registerBlock("impure_crystal_soul_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> SOUL_ORE = registerBlock("soul_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> DEEPSLATE_SOUL_ORE = registerBlock("deepslate_soul_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> END_SOUL_ORE = registerBlock("end_soul_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> NETHER_SOUL_ORE = registerBlock("nether_soul_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));

    public static final RegistryObject<LiquidBlock> LEMON_JUICE_BLOCK = BLOCKS.register("lemon_juice_block",
            () -> new LiquidBlock(ModFluids.SOURCE_LEMON_JUICE, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> ROSE_QUARTZ_FLUID_BLOCK = BLOCKS.register("rose_quartz_block",
            () -> new LiquidBlock(ModFluids.SOURCE_ROSE_QUARTZ, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));


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
