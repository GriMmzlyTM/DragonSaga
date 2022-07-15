package dragonsaga.registry

import dragonsaga.buffs.HumanRaceBuff
import dragonsaga.buffs.RacialBuff
import necesse.engine.registries.BuffRegistry
import necesse.entity.mobs.buffs.staticBuffs.Buff

var HUMAN_BUFF: Buff? = null;
var HUMAN_LOW_BUFF: Buff? = null
var HUMAN_GUARDIAN_BUFF: Buff? = null

object DragonBuffRegistry {

    fun RegisterAll() {
        HUMAN_LOW_BUFF = BuffRegistry.registerBuff("humanrace-t1-buff", HumanRaceBuff())
        HUMAN_BUFF = BuffRegistry.registerBuff("humanrace-t2-buff", HumanRaceBuff())
        HUMAN_GUARDIAN_BUFF = BuffRegistry.registerBuff("humanrace-t3-buff", HumanRaceBuff())
    }
}