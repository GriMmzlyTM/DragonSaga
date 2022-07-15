package dragonsaga.registry

import dragonsaga.items.abilities.KamehamehaAbility
import dragonsaga.items.trinkets.RaceChangeTrinket
import necesse.engine.registries.ItemRegistry
import necesse.entity.mobs.buffs.staticBuffs.armorBuffs.trinketBuffs.TrinketBuff
import necesse.inventory.item.Item
import necesse.inventory.item.Item.Rarity
import necesse.inventory.item.ItemCategory
import necesse.inventory.item.armorItem.SetHelmetArmorItem

object DragonItemRegistry {
    fun RegisterAll() {
        RegisterCategories()

        ItemRegistry.registerItem("humanrace-t1", RaceChangeTrinket(RaceEnum.HUMAN_LOW, Rarity.UNCOMMON, DragonRaceRegistry.GetRace(RaceEnum.HUMAN_LOW)?.Buff as TrinketBuff), 30f, true)
        ItemRegistry.registerItem("humanrace-t2", RaceChangeTrinket(RaceEnum.HUMAN, Rarity.RARE, DragonRaceRegistry.GetRace(RaceEnum.HUMAN)?.Buff as TrinketBuff), 30f, true)
        ItemRegistry.registerItem("humanrace-t3", RaceChangeTrinket(RaceEnum.HUMAN_GUARDIAN, Rarity.EPIC, DragonRaceRegistry.GetRace(RaceEnum.HUMAN_GUARDIAN)?.Buff as TrinketBuff), 30f, true)
        ItemRegistry.registerItem("demongihat", SetHelmetArmorItem(1, 150, Rarity.RARE, "demongihat", "copperchestplate", "copperboots", "coppersetbonus"), 15f, true)

        ItemRegistry.registerItem("kamehameha", KamehamehaAbility(), 15f, true)
    }

    private fun RegisterCategories() {
        ItemCategory.createCategory("D-B-Z", "dragonsaga");
        ItemCategory.createCategory("D-B-Z", "dragonsaga", "ki");
        ItemCategory.createCategory("D-B-Z", "dragonsaga", "ki", "ability");
    }
}