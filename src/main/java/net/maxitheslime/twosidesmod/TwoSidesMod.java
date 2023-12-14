package net.maxitheslime.twosidesmod;

import com.mojang.logging.LogUtils;
import net.maxitheslime.twosidesmod.block.ModBlocks;
import net.maxitheslime.twosidesmod.block.entity.ModBlockEntities;
import net.maxitheslime.twosidesmod.block.screen.ConductiveFurnaceScreen;
import net.maxitheslime.twosidesmod.block.screen.ModMenuTypes;
import net.maxitheslime.twosidesmod.block.screen.PurificationTableScreen;
import net.maxitheslime.twosidesmod.effect.ModEffects;
import net.maxitheslime.twosidesmod.enchantment.ModEnchantments;
import net.maxitheslime.twosidesmod.entity.ModEntities;
import net.maxitheslime.twosidesmod.entity.client.MagicMissileRenderer;
import net.maxitheslime.twosidesmod.entity.client.ModBoatRenderer;
import net.maxitheslime.twosidesmod.entity.client.RQGRenderer;
import net.maxitheslime.twosidesmod.entity.client.RubyStatueRenderer;
import net.maxitheslime.twosidesmod.entity.layers.ModModelLayers;
import net.maxitheslime.twosidesmod.fluid.ModFluidTypes;
import net.maxitheslime.twosidesmod.fluid.ModFluids;
import net.maxitheslime.twosidesmod.item.ModItemProperties;
import net.maxitheslime.twosidesmod.item.ModItems;
import net.maxitheslime.twosidesmod.loot.ModLootModifiers;
import net.maxitheslime.twosidesmod.painting.ModPaintings;
import net.maxitheslime.twosidesmod.particle.ModParticles;
import net.maxitheslime.twosidesmod.potion.BetterBrewingRecipe;
import net.maxitheslime.twosidesmod.potion.ModPotions;
import net.maxitheslime.twosidesmod.recipe.ModRecipes;
import net.maxitheslime.twosidesmod.sound.ModSounds;
import net.maxitheslime.twosidesmod.util.ModWoodTypes;
import net.maxitheslime.twosidesmod.villager.ModVillagers;
import net.maxitheslime.twosidesmod.worldgen.biome.ModTerraBlenderAPI;
import net.maxitheslime.twosidesmod.worldgen.biome.surface.ModSurfaceRules;
import net.maxitheslime.twosidesmod.worldgen.tree.ModFoliagePlacerTypes;
import net.maxitheslime.twosidesmod.worldgen.tree.ModTrunkPlacerTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TwoSidesMod.MOD_ID)
public class TwoSidesMod {
        // Define mod id in a common place for everything to reference
        public static final String MOD_ID = "twosidesmod";
        // Directly reference a slf4j logger
        public static final Logger LOGGER = LogUtils.getLogger();
        // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace


        public TwoSidesMod()
        {
            IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

            // Register the commonSetup method for modloading
            modEventBus.addListener(this::commonSetup);
            modEventBus.addListener(this::addCreative);

            ModItems.register(modEventBus);
            ModBlocks.register(modEventBus);
            ModCreativeModeTabs.register(modEventBus);
            ModEnchantments.register(modEventBus);
            ModSounds.register(modEventBus);
            ModLootModifiers.register(modEventBus);
            ModPaintings.register(modEventBus);
            ModEffects.register(modEventBus);
            ModPotions.register(modEventBus);
            ModVillagers.register(modEventBus);
            ModParticles.register(modEventBus);
            ModFluidTypes.register(modEventBus);
            ModFluids.register(modEventBus);
            ModBlockEntities.register(modEventBus);
            ModMenuTypes.register(modEventBus);
            ModRecipes.register(modEventBus);
            ModEntities.register(modEventBus);
            ModTrunkPlacerTypes.register(modEventBus);
            ModFoliagePlacerTypes.register(modEventBus);
            ModTerraBlenderAPI.registerRegions();

            // Register ourselves for server and other game events we are interested in
            MinecraftForge.EVENT_BUS.register(this);
        }

        private void commonSetup(final FMLCommonSetupEvent event)
        {
            event.enqueueWork(() -> {
                ComposterBlock.COMPOSTABLES.put(ModItems.LEMON.get(), 0.35f);
                ComposterBlock.COMPOSTABLES.put(ModItems.LEMON_SEEDS.get(), 0.20f);

                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CRYSTALLIZED_FLOWER.getId(), ModBlocks.POTTED_CRYSTALLIZED_FLOWER);

                BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.THICK, ModItems.PURE_ROSE_QUARTZ.get(), ModPotions.SLIMEY_POTION.get()));

                SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRules.makeRules());

            });
        }

        // Add the example block item to the building blocks tab
        private void addCreative(BuildCreativeModeTabContentsEvent event)
        {        }

        // You can use SubscribeEvent and let the Event Bus discover methods to call
        @SubscribeEvent
        public void onServerStarting(ServerStartingEvent event)
        {        }

        // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
        @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
        public static class ClientModEvents
        {
            @SubscribeEvent
            public static void onClientSetup(FMLClientSetupEvent event)
            {
                event.enqueueWork(() -> {
                    Sheets.addWoodType(ModWoodTypes.ENERGY);

                    ModItemProperties.addCustomItemProperties();

                    ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_LEMON_JUICE.get(), RenderType.translucent());
                    ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_LEMON_JUICE.get(), RenderType.translucent());

                    MenuScreens.register(ModMenuTypes.PURIFICATION_MENU.get(), PurificationTableScreen::new);
                    MenuScreens.register(ModMenuTypes.CONDUCTIVE_FURNACE_MENU.get(), ConductiveFurnaceScreen::new);
                    
                    EntityRenderers.register(ModEntities.RQG.get(), RQGRenderer::new);
                    EntityRenderers.register(ModEntities.RUBY_STATUE.get(), RubyStatueRenderer::new);
                    EntityRenderers.register(ModEntities.DICE_PROJECTILE.get(), ThrownItemRenderer::new);
                    EntityRenderers.register(ModEntities.MAGIC_MISSILE_PROJECTILE.get(), MagicMissileRenderer::new);
                    EntityRenderers.register(ModEntities.MOD_BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
                    EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));

                });
            }
        }

}
