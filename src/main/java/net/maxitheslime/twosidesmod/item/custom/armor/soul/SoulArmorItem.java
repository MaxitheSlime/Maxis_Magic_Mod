package net.maxitheslime.twosidesmod.item.custom.armor.soul;

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.maxitheslime.twosidesmod.effect.ModEffects;
import net.maxitheslime.twosidesmod.item.ModArmorMaterials;
import net.maxitheslime.twosidesmod.item.ModItems;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class SoulArmorItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private static final Map<ArmorMaterial, MobEffectInstance> SOUL_ARMOR_EFFECT1 =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(ModArmorMaterials.SOUL, new MobEffectInstance(ModEffects.SOUL_HARROWING.get(), 200, 0))
                    .build();
    private static final Map<ArmorMaterial, MobEffectInstance> SOUL_ARMOR_EFFECT2 =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(ModArmorMaterials.SOUL, new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0))
                    .build();

    public SoulArmorItem(ArmorMaterial armorMaterial, Type type, Properties properties) {
        super(armorMaterial, type, properties);
    }

    // Create our armor model/renderer for forge and return it
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private GeoArmorRenderer<?> renderer;

            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (this.renderer == null)
                    this.renderer = new SoulArmorRenderer();

                // This prepares our GeoArmorRenderer for the current render frame.
                // These parameters may be null however, so we don't do anything further with them
                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);

                return this.renderer;
            }
        });
    }

    // Let's add our animation controller
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, 20, state -> {
            // Apply our generic idle animation.
            // Whether it plays or not is decided down below.
            state.setAnimation(DefaultAnimations.IDLE);

            // Let's gather some data from the state to use below
            // This is the entity that is currently wearing/holding the item
            Entity entity = state.getData(DataTickets.ENTITY);

            // We'll just have ArmorStands always animate, so we can return here
            if (entity instanceof ArmorStand)
                return PlayState.CONTINUE;

            // For this example, we only want the animation to play if the entity is wearing all pieces of the armor
            // Let's collect the armor pieces the entity is currently wearing
            Set<Item> wornArmor = new ObjectOpenHashSet<>();

            for (ItemStack stack : entity.getArmorSlots()) {
                // We can stop immediately if any of the slots are empty
                /*if (stack.isEmpty())
                    return PlayState.STOP;*/

                wornArmor.add(stack.getItem());
            }

            // Check each of the pieces match our set
            boolean isFullSet = wornArmor.containsAll(ObjectArrayList.of(
                    ModItems.SOUL_BOOTS.get(),
                    ModItems.SOUL_LEGGINGS.get(),
                    ModItems.SOUL_CHESTPLATE.get(),
                    ModItems.SOUL_HELMET.get()));

            // Play the animation if the full set is being worn, otherwise stop
            return isFullSet ? PlayState.CONTINUE : PlayState.STOP;
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if(!level.isClientSide && hasFullSuitofArmorOn(player)){
            evaluateArmorEffects(player);
        }
    }
    private boolean hasPlayerCorrectArmorOn(ArmorMaterial mapArmorMaterial, Player player) {
        for(ItemStack armorStack : player.getArmorSlots()){
            if(!(armorStack.getItem() instanceof ArmorItem)){
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return boots.getMaterial() == mapArmorMaterial && leggings.getMaterial() == mapArmorMaterial
                && chestplate.getMaterial() == mapArmorMaterial && helmet.getMaterial() == mapArmorMaterial;
    }

    private static boolean hasFullSuitofArmorOn(Player player){
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !boots.isEmpty() && !leggings.isEmpty() && !chestplate.isEmpty() && !helmet.isEmpty();
    }

    private void evaluateArmorEffects(Player player) {
        for(Map.Entry<ArmorMaterial, MobEffectInstance> entry : SOUL_ARMOR_EFFECT1.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffectInstance mapEffect = entry.getValue();

            if (hasPlayerCorrectArmorOn(mapArmorMaterial, player)){
                addEffectToPlayer(mapEffect, player);
            }
        }
        for(Map.Entry<ArmorMaterial, MobEffectInstance> entry : SOUL_ARMOR_EFFECT2.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffectInstance mapEffect = entry.getValue();

            if (hasPlayerCorrectArmorOn(mapArmorMaterial, player)){
                addEffectToPlayer(mapEffect, player);
            }
        }
    }

    private void addEffectToPlayer(MobEffectInstance mapEffect, Player player) {
        boolean hasPlayerEffect = player.hasEffect(mapEffect.getEffect());

        if(!hasPlayerEffect){
            player.addEffect(new MobEffectInstance(mapEffect.getEffect(),
                    mapEffect.getDuration(), mapEffect.getAmplifier()));
        }
    }
}