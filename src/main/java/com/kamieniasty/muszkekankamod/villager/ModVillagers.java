package com.kamieniasty.muszkekankamod.villager;

import com.google.common.collect.ImmutableSet;
import com.kamieniasty.muszkekankamod.MuszkekankaMod;
import com.kamieniasty.muszkekankamod.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, MuszkekankaMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.PROFESSIONS, MuszkekankaMod.MOD_ID);

    public static final RegistryObject<PoiType> JUMPY_BLOCK_POI = POI_TYPES.register("jumpy_block_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.JUMPY_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> MUSZKEKANKA_EXPERT = VILLAGER_PROFESSIONS.register("muszkekanka_expert",
            () -> new VillagerProfession("muszkekanka_expert", x -> x.get() == JUMPY_BLOCK_POI.get(),
                    x -> x.get() == JUMPY_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_ARMORER));

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, JUMPY_BLOCK_POI.get());
        } catch (InvocationTargetException | IllegalAccessException exception) {
                exception.printStackTrace();
        }
    }
    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
