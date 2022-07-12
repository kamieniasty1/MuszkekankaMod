package com.kamieniasty.muszkekankamod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab MUSZKEKANKA_TAB = new CreativeModeTab("muszkekankatab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.MUSZKEKANKA_BOTTLE.get());
        }
    };
}
