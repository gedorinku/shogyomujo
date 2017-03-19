package com.kurume_nct.shogyomujo

import net.minecraft.init.Blocks
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@Mod(modid = ShogyomujoMod.MODID, version = ShogyomujoMod.VERSION)
class ShogyomujoMod {

    @EventHandler
    fun init(event: FMLInitializationEvent) {
        // some kurume_nct code
        println("DIRT BLOCK >> " + Blocks.DIRT.unlocalizedName)
    }

    companion object {
        const val MODID = "shogyomujo"
        const val VERSION = "1.0"
    }
}
