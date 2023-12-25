package net.maxitheslime.twosidesmod.item;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.block.ModBlocks;
import net.maxitheslime.twosidesmod.entity.ModEntities;
import net.maxitheslime.twosidesmod.entity.custom.ModBoatEntity;
import net.maxitheslime.twosidesmod.fluid.ModFluids;
import net.maxitheslime.twosidesmod.item.custom.*;
import net.maxitheslime.twosidesmod.item.custom.armor.soul.SoulArmorItem;
import net.maxitheslime.twosidesmod.item.custom.rosequartz.*;
import net.maxitheslime.twosidesmod.item.custom.soul.*;
import net.maxitheslime.twosidesmod.sound.ModSounds;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TwoSidesMod.MOD_ID);

    public static final RegistryObject<Item> PURE_ROSE_QUARTZ = ITEMS.register("pure_rose_quartz",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IMPURE_ROSE_QUARTZ = ITEMS.register("impure_rose_quartz",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIRE_QUARTZ = ITEMS.register("fire_quartz",
            () -> new FuelItem(new Item.Properties(), 1800));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(512)));
    public static final RegistryObject<Item> DATA_TABLET = ITEMS.register("data_tablet",
            () -> new DataTabletItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ROSE_QUARTZ_SWORD = ITEMS.register("rose_quartz_sword",
            () -> new LGSwordItem(ModToolTiers.ROSE_QUARTZ, 4, 3, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> ROSE_QUARTZ_PICKAXE = ITEMS.register("rose_quartz_pickaxe",
            () -> new LGPickItem(ModToolTiers.ROSE_QUARTZ, 3, 2, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> ROSE_QUARTZ_SHOVEL = ITEMS.register("rose_quartz_shovel",
            () -> new LGShovelItem(ModToolTiers.ROSE_QUARTZ, 3.5f, 3, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> ROSE_QUARTZ_AXE = ITEMS.register("rose_quartz_axe",
            () -> new LGShovelItem(ModToolTiers.ROSE_QUARTZ, 7, 3, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> ROSE_QUARTZ_HOE = ITEMS.register("rose_quartz_hoe",
            () -> new LGHoeItem(ModToolTiers.ROSE_QUARTZ, 2, 3, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> ROSE_QUARTZ_PAXEL = ITEMS.register("rose_quartz_paxel",
            () -> new LGPaxelItem(ModToolTiers.ROSE_QUARTZ, 3, 3, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> ROSE_QUARTZ_HAMMER = ITEMS.register("rose_quartz_hammer",
            () -> new LGHammerItem(ModToolTiers.ROSE_QUARTZ, 8, -3, new Item.Properties().durability(300)));
    public static final RegistryObject<Item> ROSE_QUARTZ_BOW = ITEMS.register("rose_quartz_bow",
            () -> new BowItem(new Item.Properties().durability(500)));
    public static final RegistryObject<Item> ROSE_QUARTZ_SHIELD = ITEMS.register("rose_quartz_shield",
            () -> new ShieldItem(new Item.Properties().durability(500)));

    public static final RegistryObject<Item> ROSE_QUARTZ_HELMET = ITEMS.register("rose_quartz_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ROSE_QUARTZ, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ROSE_QUARTZ_CHESTPLATE = ITEMS.register("rose_quartz_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.ROSE_QUARTZ, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ROSE_QUARTZ_LEGGINGS = ITEMS.register("rose_quartz_leggings",
            () -> new ModArmorItem(ModArmorMaterials.ROSE_QUARTZ, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ROSE_QUARTZ_BOOTS = ITEMS.register("rose_quartz_boots",
            () -> new ModArmorItem(ModArmorMaterials.ROSE_QUARTZ, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> ROSE_QUARTZ_HORSE_ARMOR = ITEMS.register("rose_quartz_horse_armor",
            () -> new HorseArmorItem(12, new ResourceLocation(TwoSidesMod.MOD_ID, "textures/entity/horse/armor/horse_armor_rose_quartz.png"),
                    new Item.Properties()));

    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BONSAI_LEMON)));
    public static final RegistryObject<Item> LEMON_SEEDS = ITEMS.register("lemon_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BONSAI_LEMON_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> BAR_BRAWL_RECORD = ITEMS.register("bar_brawl_record",
            () -> new RecordItem(4, ModSounds.BAR_BRAWL, new Item.Properties().stacksTo(1),
                    2440));
    public static final RegistryObject<Item> ROSE_QUARTZ_DISK_PIECE = ITEMS.register("rose_quartz_disk_piece",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ROSE_QUARTZ_LIGHTBULB = ITEMS.register("rose_quartz_lightbulb",
            () -> new RQBulbItem(new Item.Properties().durability(1024)));

    public static final RegistryObject<Item> LEMON_JUICE_BUCKET = ITEMS.register("lemon_juice_bucket",
            () -> new BucketItem(ModFluids.SOURCE_LEMON_JUICE, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> ROSE_QUARTZ_FLUID_BUCKET = ITEMS.register("rose_quartz_bucket",
            () -> new BucketItem(ModFluids.SOURCE_ROSE_QUARTZ, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> ENERGY_SIGN = ITEMS.register("energy_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.ENERGY_SIGN.get(), ModBlocks.ENERGY_WALL_SIGN.get()));
    public static final RegistryObject<Item> ENERGY_HANGING_SIGN = ITEMS.register("energy_hanging_sign",
            () -> new HangingSignItem(ModBlocks.ENERGY_HANGING_SIGN.get(), ModBlocks.ENERGY_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> REMOTE_CONTROL = ITEMS.register("remote_control",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> RQG_SPAWN_EGG = ITEMS.register("rqg_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.RQG, 0x50ba11, 0xff7d7d,
                    new Item.Properties()));
    public static final RegistryObject<Item> RS_SPAWN_EGG = ITEMS.register("rs_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.RUBY_STATUE, 0xff0000, 0xff0000,
                    new Item.Properties()));

    public static final RegistryObject<Item> ENERGY_BOAT = ITEMS.register("energy_boat",
            () -> new ModBoatItem(false, ModBoatEntity.Type.ENERGY, new Item.Properties()));
    public static final RegistryObject<Item> ENERGY_CHEST_BOAT = ITEMS.register("energy_chest_boat",
            () -> new ModBoatItem(true, ModBoatEntity.Type.ENERGY, new Item.Properties()));

    public static final RegistryObject<Item> DICE = ITEMS.register("dice",
            () -> new DiceItem(new Item.Properties()));

    public static final RegistryObject<Item> ENERGY_ORB = ITEMS.register("energy_orb",
            () -> new ModWaxingItem(new Item.Properties().food(ModFoodProperties.ENERGY_ORB)));
    public static final RegistryObject<Item> ENERGY_SEEDS = ITEMS.register("energy_seeds",
            () -> new ItemNameBlockItem(ModBlocks.ENERGY_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> CRYSTAL_STRENGTH_SHARD = ITEMS.register("crystal_strength_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IMPURE_CRYSTAL_STRENGTH_SHARD = ITEMS.register("impure_crystal_strength_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_INFLUENCE_SHARD = ITEMS.register("crystal_influence_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IMPURE_CRYSTAL_INFLUENCE_SHARD = ITEMS.register("impure_crystal_influence_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_GREED_SHARD = ITEMS.register("crystal_greed_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IMPURE_CRYSTAL_GREED_SHARD = ITEMS.register("impure_crystal_greed_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_CONTROL_SHARD = ITEMS.register("crystal_control_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IMPURE_CRYSTAL_CONTROL_SHARD = ITEMS.register("impure_crystal_control_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_POWER_SHARD = ITEMS.register("crystal_power_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IMPURE_CRYSTAL_POWER_SHARD = ITEMS.register("impure_crystal_power_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_LIFE_SHARD = ITEMS.register("crystal_life_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IMPURE_CRYSTAL_LIFE_SHARD = ITEMS.register("impure_crystal_life_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_SOUL_SHARD = ITEMS.register("crystal_soul_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IMPURE_CRYSTAL_SOUL_SHARD = ITEMS.register("impure_crystal_soul_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SOUL_SWORD = ITEMS.register("soul_sword",
            () -> new SHSwordItem(ModToolTiers.ROSE_QUARTZ, 5, 2, new Item.Properties().durability(300)));
    public static final RegistryObject<Item> SOUL_AXE = ITEMS.register("soul_axe",
            () -> new SHAxeItem(ModToolTiers.ROSE_QUARTZ, 8, 2, new Item.Properties().durability(300)));
    public static final RegistryObject<Item> SOUL_SHOVEL = ITEMS.register("soul_shovel",
            () -> new SHShovelItem(ModToolTiers.ROSE_QUARTZ, 4, 4, new Item.Properties().durability(300)));
    public static final RegistryObject<Item> SOUL_HOE = ITEMS.register("soul_hoe",
            () -> new SHHoeItem(ModToolTiers.ROSE_QUARTZ, 3, 2, new Item.Properties().durability(300)));
    public static final RegistryObject<Item> SOUL_PICKAXE = ITEMS.register("soul_pickaxe",
            () -> new SHPickaxeItem(ModToolTiers.ROSE_QUARTZ, 4, 3, new Item.Properties().durability(300)));
    public static final RegistryObject<Item> SOUL_PAXEL = ITEMS.register("soul_paxel",
            () -> new SHPaxelItem(ModToolTiers.ROSE_QUARTZ, 4, 2, new Item.Properties().durability(300)));
    public static final RegistryObject<Item> SOUL_HAMMER = ITEMS.register("soul_hammer",
            () -> new SHHammerItem(ModToolTiers.ROSE_QUARTZ, 9, -2, new Item.Properties().durability(300)));
    public static final RegistryObject<Item> SOUL_BOW = ITEMS.register("soul_bow",
            () -> new BowItem(new Item.Properties().durability(500)));
    public static final RegistryObject<Item> SOUL_SHIELD = ITEMS.register("soul_shield",
            () -> new ShieldItem(new Item.Properties().durability(500)));
    public static final RegistryObject<Item> SOUL_HELMET = ITEMS.register("soul_helmet",
            () -> new SoulArmorItem(ModArmorMaterials.SOUL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SOUL_CHESTPLATE = ITEMS.register("soul_chestplate",
            () -> new SoulArmorItem(ModArmorMaterials.SOUL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SOUL_LEGGINGS = ITEMS.register("soul_leggings",
            () -> new SoulArmorItem(ModArmorMaterials.SOUL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SOUL_BOOTS = ITEMS.register("soul_boots",
            () -> new SoulArmorItem(ModArmorMaterials.SOUL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> SOUL_HORSE_ARMOR = ITEMS.register("soul_horse_armor",
            () -> new HorseArmorItem(12, new ResourceLocation(TwoSidesMod.MOD_ID, "textures/entity/horse/armor/horse_armor_soul.png"),
                    new Item.Properties()));
    
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
