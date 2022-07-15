package dragonsaga.buffs

import necesse.entity.mobs.PlayerMob
import necesse.entity.mobs.buffs.ActiveBuff
import necesse.gfx.drawOptions.human.HumanDrawOptions
import necesse.gfx.gameTooltips.ListGameTooltips

class HumanRaceBuff : RacialBuff() {

    override fun init(activeBuff: ActiveBuff) {
        super.init(activeBuff)
    }

    override fun addPlayerDraws(buff: ActiveBuff, player: PlayerMob, drawOptions: HumanDrawOptions) {
        val cachedPlayerLook = player.look;
        cachedPlayerLook.skin = 5;
        super.addPlayerDraws(buff, player, HumanDrawOptions(cachedPlayerLook, false))
    }
}