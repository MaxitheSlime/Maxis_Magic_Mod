package net.maxitheslime.twosidesmod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.block.ModBlocks;
import net.maxitheslime.twosidesmod.command.ReturnHomeCommand;
import net.maxitheslime.twosidesmod.command.SetHomeCommand;
import net.maxitheslime.twosidesmod.item.ModItems;
import net.maxitheslime.twosidesmod.item.custom.HammerItem;
import net.maxitheslime.twosidesmod.villager.ModVillagers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = TwoSidesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModForgeBusEvents {

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();
    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initalBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initalBlockPos)) {
                return;
            }

            for (BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initalBlockPos, serverPlayer)) {
                if(pos == initalBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                // Have to add them to a Set otherwise, the same code right here will get called for each block!
                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        event.getEntity().getPersistentData().putIntArray("twosidesmod.homepos",
                event.getOriginal().getPersistentData().getIntArray("twosidesmod.homepos"));
    }

    @SubscribeEvent
    public static void livingDamage(LivingDamageEvent event) {
        if(event.getEntity() instanceof Villager) {
            if(event.getSource().getDirectEntity() instanceof Player player) {
                if(player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == ModItems.ROSE_QUARTZ_AXE.get()) {
                    TwoSidesMod.LOGGER.info("Villager was slashed at with a Rose Quartz Axe by " + player.getName().getString());
                }else if(player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == Items.EMERALD) {
                    TwoSidesMod.LOGGER.info("Villager was smacked with an Emerald by " + player.getName().getString());
                } else {
                    TwoSidesMod.LOGGER.info("Villager was hit with something by " + player.getName().getString());
                }
            }
        }
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.FARMER){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> TRADES = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.LEMON.get(), 6);
            int VillagerLevel = 1;

            TRADES.get(VillagerLevel).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2), stack, 10, 2, 0.02f
            ));

            TRADES.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ModItems.LEMON_SEEDS.get(), 1), 3, 2, 0.02f
            ));
        }
        if(event.getType() == VillagerProfession.TOOLSMITH){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> TRADES = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.ROSE_QUARTZ_PAXEL.get(), 1);
            int VillagerLevel = 3;

            TRADES.get(VillagerLevel).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 15), stack, 2, 5, 0.06f
            ));
        }
        if(event.getType() == ModVillagers.SOUND_MASTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack AlertStack = new ItemStack(ModBlocks.SOUND_BLOCK.get(), 1);
            ItemStack DiskStack = new ItemStack(ModItems.ROSE_QUARTZ_DISK_PIECE.get(), 2);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 25), AlertStack, 20, 5, 0.06f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 30), DiskStack, 3, 5, 0.06f
            ));
        }
    }

    @SubscribeEvent
    public static void addWanderingCustomTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> GenTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> RareTrades = event.getRareTrades();
        ItemStack stack = new ItemStack(ModItems.LEMON.get(), 6);

        GenTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 2), stack, 10, 2, 0.02f
        ));
        GenTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 4),
                new ItemStack(ModBlocks.CRYSTALLIZED_FLOWER.get(), 3), 2, 4, 0.10f
        ));

        RareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 3),
                new ItemStack(ModItems.ROSE_QUARTZ_DISK_PIECE.get(), 1), 6, 4, 0.08f
        ));
    }
}
