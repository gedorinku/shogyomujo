package com.kurume_nct.shogyomujo

import net.minecraft.entity.EntityList
import net.minecraft.entity.monster.EntityCreeper
import net.minecraftforge.event.world.WorldEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

/**
 * Created by gedorinku on 2017/03/20.
 */
class WorldEventHandler {

    @SubscribeEvent
    fun onWorldPotentialSpawns(event: WorldEvent.PotentialSpawns) {
        val world = event.world
        if (world.isRemote) return

        val random = world.rand
        if (random.nextInt(100000) != 0) return
        val targetPlayer = world.playerEntities[random.nextInt(world.playerEntities.size)]

        val creeper = EntityList.createEntityByID(EntityList.getID(EntityCreeper::class.java), world) as EntityCreeper
        creeper.setLocationAndAngles(targetPlayer.posX, targetPlayer.posY + 5, targetPlayer.posZ, 0.0f, 0.0f)

        creeper.tags.add(ShogyomujoMod.MOB_TAG)

        world.spawnEntity(creeper)
    }
}