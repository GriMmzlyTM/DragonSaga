package dragonsaga.registry;

import dragonsaga.items.RaceChangeItem;
import dragonsaga.race.DragonRace;
import necesse.engine.registries.ItemRegistry;
import necesse.inventory.item.Item;
import necesse.inventory.item.armorItem.SetHelmetArmorItem;

public class DragonItemRegistry {

    public static void Register() {
        ItemRegistry.registerItem("dragonhumanracechanget1", new RaceChangeItem(DragonRaceRegistry.RaceEnum.HUMAN_LOW, Item.Rarity.UNCOMMON), 30, true);
        ItemRegistry.registerItem("dragonhumanracechanget2", new RaceChangeItem(DragonRaceRegistry.RaceEnum.HUMAN, Item.Rarity.RARE), 30, true);
        ItemRegistry.registerItem("dragonhumanracechanget3", new RaceChangeItem(DragonRaceRegistry.RaceEnum.HUMAN_GUARDIAN, Item.Rarity.EPIC), 30, true);
        ItemRegistry.registerItem("demongihat", new SetHelmetArmorItem(1, 150, Item.Rarity.RARE, "demongihat", "copperchestplate", "copperboots", "coppersetbonus"), 15f, true);
    }
}
