package dragonsaga.registry

import dragonsaga.examples.ExampleObject
import necesse.engine.registries.ObjectRegistry

object DragonObjectRegistry {
    fun RegisterAll() {
        ObjectRegistry.registerObject("medicalmachine", ExampleObject(), 2f, true)
    }
}