package com.kamieniasty.muszkekankamod;

import com.kamieniasty.muszkekankamod.block.ModBlocks;
import com.kamieniasty.muszkekankamod.item.ModItems;
import com.kamieniasty.muszkekankamod.villager.ModVillagers;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MuszkekankaMod.MOD_ID)
public class MuszkekankaMod {
    public static final String MOD_ID = "muszkekankamod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MuszkekankaMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        /* registering ModItems and any item */
        ModItems.register(modEventBus);
        /* registering ModBlocks and any block */
        ModBlocks.register(modEventBus);

        ModVillagers.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModVillagers.registerPOIs();
        });

        }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLUEBERRY_CROP.get(), RenderType.cutout());
        }
    }
}
