package dragonsaga.buffs

import dragonsaga.race.PlayerLookCache
import necesse.entity.mobs.Mob
import necesse.entity.mobs.PlayerMob
import necesse.entity.mobs.buffs.ActiveBuff
import necesse.entity.mobs.buffs.staticBuffs.armorBuffs.trinketBuffs.TrinketBuff
import necesse.gfx.HumanLook

abstract class RacialBuff : TrinketBuff(), IOnRemoveBuff {
    init {
        canCancel = false
        isVisible = true
        shouldSave = false
        isPassive = true
    }

    override fun init(activeBuff: ActiveBuff) {

        var player : PlayerMob = activeBuff.owner as PlayerMob;

        // Apply modifiers here
        player.speed = 60f
        player.friction = 7f

    }

    override fun OnRemove(buff: ActiveBuff, mob: Mob) {
    }

    override fun serverTick(buff: ActiveBuff) {
        // You can do server ticks here
    }

    override fun clientTick(buff: ActiveBuff) {
        // You can do client ticks here, like adding particles to buff.owner
    }
}