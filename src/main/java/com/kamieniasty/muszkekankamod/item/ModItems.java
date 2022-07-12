package com.kamieniasty.muszkekankamod.item;

import com.kamieniasty.muszkekankamod.MuszkekankaMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MuszkekankaMod.MOD_ID);

    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MUSZKEKANKA_TAB)));

    public static final RegistryObject<Item> RAW_ZIRCON = ITEMS.register("raw_zircon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MUSZKEKANKA_TAB)));

    public static final RegistryObject<Item> MUSZKEKANKA_BOTTLE = ITEMS.register("muszkekanka_bottle",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MUSZKEKANKA_TAB)));

    public static final RegistryObject<Item> PLASTIC_NUGGET = ITEMS.register("plastic_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MUSZKEKANKA_TAB)));

    public static final RegistryObject<Item> RAW_PLASTIC = ITEMS.register("raw_plastic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MUSZKEKANKA_TAB)));

    public static final RegistryObject<Item> PLASTIC = ITEMS.register("plastic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MUSZKEKANKA_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

