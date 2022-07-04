package dragonsaga.items.trinkets

import dragonsaga.registry.DragonRaceRegistry
import dragonsaga.registry.RaceEnum
import necesse.engine.network.Packet
import necesse.entity.mobs.PlayerMob
import necesse.entity.mobs.buffs.ActiveBuff
import necesse.entity.mobs.buffs.BuffAbility
import necesse.entity.mobs.buffs.staticBuffs.armorBuffs.trinketBuffs.TrinketBuff
import necesse.inventory.InventoryItem
import necesse.inventory.item.trinketItem.TrinketItem

class RaceChangeTrinket(race : RaceEnum, rarity : Rarity, vararg _racialBuffs : TrinketBuff) : TrinketItem(rarity, 0), BuffAbility {
    val racialBuffs = _racialBuffs;
    val race = race;

    init {
        stackSize = 1;
        dropsAsMatDeathPenalty = false;
        dropDecayTimeMillis = 1;
    }

    override fun getBuffs(p0: InventoryItem?): Array<TrinketBuff> = arrayOf(*racialBuffs);

    override fun isAbilityTrinket(item: InventoryItem?): Boolean = true;

    override fun runAbility(playerMob: PlayerMob, activeBuff: ActiveBuff, packet: Packet) {
        TODO("Not yet implemented")
    }

    override fun canRunAbility(playerMob: PlayerMob, activeBuff: ActiveBuff, packet: Packet): Boolean {
        TODO("Not yet implemented")
    }
}