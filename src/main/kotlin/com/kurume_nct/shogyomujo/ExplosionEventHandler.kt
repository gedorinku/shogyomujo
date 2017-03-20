package com.kurume_nct.shogyomujo

import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.monster.EntityCreeper
import net.minecraft.entity.projectile.EntityTippedArrow
import net.minecraftforge.event.world.ExplosionEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

/**
 * Created by gedorinku on 2017/03/20.
 */
class ExplosionEventHandler {

    @SubscribeEvent
    fun onExplosionStart(event: ExplosionEvent.Start) {
        val exploder: EntityLivingBase? = event.explosion.explosivePlacedBy
        val world = event.world
        if (exploder !is EntityCreeper ||
                world.isRemote) return

        val random = world.rand

        for (i in 1..100) {
            val arrow = EntityTippedArrow(world, exploder)
            val vx = random.nextDouble() - 0.5
            val vy = random.nextDouble() - 0.5
            val vz = random.nextDouble() - 0.5
            val len = Math.sqrt(vx * vx + vy * vy + vz * vz)
            arrow.motionX = vx / len
            arrow.motionY = vy / len
            arrow.motionZ = vz / len
            world.spawnEntity(arrow)
        }
    }
}