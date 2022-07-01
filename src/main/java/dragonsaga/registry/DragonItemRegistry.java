package dragonsaga.registry;

import dragonsaga.items.RaceChangeItem;
import necesse.engine.registries.ItemRegistry;
import necesse.inventory.item.Item;
import necesse.inventory.item.armorItem.SetHelmetArmorItem;

public class DragonItemRegistry {

    public static void Register() {
        ItemRegistry.registerItem("namekianracechange", new RaceChangeItem(), 30, true);
        ItemRegistry.registerItem("demongihat", new SetHelmetArmorItem(1, 150, Item.Rarity.RARE, "demongihat", "copperchestplate", "copperboots", "coppersetbonus"), 15f, true);
    }
}
