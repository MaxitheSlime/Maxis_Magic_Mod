package net.maxitheslime.twosidesmod.sound;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TwoSidesMod.MOD_ID);

    public static final RegistryObject<SoundEvent> METAL_DETECTOR_FOUND_ORE = registerSoundEvents("metal_detector_found_ore");
    public static final RegistryObject<SoundEvent> ROSE_QUARTZ_LAMP_BREAK = registerSoundEvents("rose_quartz_lamp_break");
    public static final RegistryObject<SoundEvent> ROSE_QUARTZ_LAMP_STEP = registerSoundEvents("rose_quartz_lamp_step");
    public static final RegistryObject<SoundEvent> ROSE_QUARTZ_LAMP_PLACE = registerSoundEvents("rose_quartz_lamp_place");
    public static final RegistryObject<SoundEvent> ROSE_QUARTZ_LAMP_FALL = registerSoundEvents("rose_quartz_lamp_fall");
    public static final RegistryObject<SoundEvent> ROSE_QUARTZ_LAMP_HIT = registerSoundEvents("rose_quartz_lamp_hit");

    public static final ForgeSoundType ROSE_QUARTZ_LAMP_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.ROSE_QUARTZ_LAMP_BREAK, ModSounds.ROSE_QUARTZ_LAMP_STEP, ModSounds.ROSE_QUARTZ_LAMP_PLACE,
            ModSounds.ROSE_QUARTZ_LAMP_HIT, ModSounds.ROSE_QUARTZ_LAMP_FALL);

    public static final RegistryObject<SoundEvent> BAR_BRAWL = registerSoundEvents("bar_brawl");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        ResourceLocation id = new ResourceLocation(TwoSidesMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
