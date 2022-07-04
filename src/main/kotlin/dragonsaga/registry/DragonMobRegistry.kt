package dragonsaga.registry

import dragonsaga.mobs.KrillManMob
import necesse.engine.registries.MobRegistry
import necesse.level.maps.biomes.Biome
import necesse.level.maps.biomes.ForestBiome

object DragonMobRegistry {
    fun RegisterAll() {
        MobRegistry.registerMob("martialartistbase", KrillManMob::class.java , true)
    }

    fun RegisterAllBiomes() {
        ForestBiome.defaultSurfaceCritters.add(15, "martialartistbase")
    }
}