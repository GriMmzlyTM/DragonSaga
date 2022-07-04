package dragonsaga.registry

import dragonsaga.buffs.ExampleBuff
import necesse.engine.registries.BuffRegistry
import necesse.entity.mobs.buffs.staticBuffs.Buff

var HUMAN_BUFF: Buff? = null;
var HUMAN_LOW_BUFF: Buff? = null
var HUMAN_GUARDIAN_BUFF: Buff? = null

object DragonBuffRegistry {

    fun RegisterAll() {
        HUMAN_BUFF = BuffRegistry.registerBuff("dragon_human", ExampleBuff())
        HUMAN_LOW_BUFF = BuffRegistry.registerBuff("dragon_human_low", ExampleBuff())
        HUMAN_GUARDIAN_BUFF = BuffRegistry.registerBuff("dragon_human_guardian", ExampleBuff())
    }
}