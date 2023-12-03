package net.maxitheslime.twosidesmod.item;

import net.maxitheslime.twosidesmod.ModArmorMaterials;
import net.maxitheslime.twosidesmod.ModFoodProperties;
import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.block.ModBlocks;
import net.maxitheslime.twosidesmod.item.custom.*;
import net.maxitheslime.twosidesmod.ModToolTiers;
import net.maxitheslime.twosidesmod.sound.ModSounds;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
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
            () -> new SappingSwordItem(ModToolTiers.ROSE_QUARTZ, 4, 3, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> ROSE_QUARTZ_PICKAXE = ITEMS.register("rose_quartz_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ROSE_QUARTZ, 3, 2, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> ROSE_QUARTZ_SHOVEL = ITEMS.register("rose_quartz_shovel",
            () -> new ShovelItem(ModToolTiers.ROSE_QUARTZ, 3.5f, 3, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> ROSE_QUARTZ_AXE = ITEMS.register("rose_quartz_axe",
            () -> new AxeItem(ModToolTiers.ROSE_QUARTZ, 7, 3, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> ROSE_QUARTZ_HOE = ITEMS.register("rose_quartz_hoe",
            () -> new HoeItem(ModToolTiers.ROSE_QUARTZ, 2, 3, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> ROSE_QUARTZ_PAXEL = ITEMS.register("rose_quartz_paxel",
            () -> new PaxelItem(ModToolTiers.ROSE_QUARTZ, 3, 3, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> ROSE_QUARTZ_HAMMER = ITEMS.register("rose_quartz_hammer",
            () -> new HammerItem(ModToolTiers.ROSE_QUARTZ, 8, 0, new Item.Properties().durability(256)));
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
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
