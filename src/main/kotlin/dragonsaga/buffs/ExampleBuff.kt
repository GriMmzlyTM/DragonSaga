package dragonsaga.buffs

import necesse.entity.mobs.PlayerMob
import necesse.entity.mobs.buffs.ActiveBuff
import necesse.entity.mobs.buffs.staticBuffs.Buff
import necesse.entity.mobs.buffs.staticBuffs.armorBuffs.trinketBuffs.TrinketBuff

class ExampleBuff : TrinketBuff() {
    init {
        canCancel = false
        isVisible = true
        shouldSave = false
        isPassive = true
    }

    override fun init(activeBuff: ActiveBuff) {
        // Apply modifiers here
        //activeBuff.setModifier(BuffModifiers.SPEED, 2f);
        (activeBuff.owner as PlayerMob).speed = 60f
        (activeBuff.owner as PlayerMob).friction = 7f
        (activeBuff.owner as PlayerMob).look.skin = 4
    }

    override fun serverTick(buff: ActiveBuff) {
        // You can do server ticks here
    }

    override fun clientTick(buff: ActiveBuff) {
        // You can do client ticks here, like adding particles to buff.owner
    }
}