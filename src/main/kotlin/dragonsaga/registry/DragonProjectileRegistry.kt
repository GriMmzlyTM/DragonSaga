package dragonsaga.registry

import dragonsaga.items.abilities.projectiles.KiBeamProjectile
import necesse.engine.registries.ProjectileRegistry

object DragonProjectileRegistry {

    fun RegisterAll() {
        ProjectileRegistry.registerProjectile("kibeam", KiBeamProjectile::class.java, null, null)
    }
}