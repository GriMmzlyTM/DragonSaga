package dragonsaga.items;

import dragonsaga.ExampleMod;
import dragonsaga.race.DragonRace;
import dragonsaga.race.RaceBase;
import dragonsaga.registry.DragonRaceRegistry;
import necesse.engine.localization.Localization;
import necesse.engine.network.packet.PacketOpenContainer;
import necesse.engine.network.server.ServerClient;
import necesse.engine.registries.ContainerRegistry;
import necesse.entity.mobs.PlayerMob;
import necesse.gfx.gameTexture.GameTexture;
import necesse.inventory.InventoryItem;
import necesse.inventory.container.Container;
import necesse.inventory.container.ContainerActionResult;
import necesse.inventory.container.slots.ContainerSlot;
import necesse.inventory.item.Item;

import java.util.function.Supplier;

public class RaceChangeItem extends Item {

    public DragonRaceRegistry.RaceEnum Race;
    public RaceBase BaseStats;

    public RaceChangeItem(DragonRaceRegistry.RaceEnum race, Rarity raceRarity) {
        super(1);

        Race = race;
        BaseStats = DragonRaceRegistry.Instance.GetRace(race);
        rarity = raceRarity;
    }

    @Override
    public void loadTextures() {
        super.loadTextures();
        itemTexture = GameTexture.fromFile("items/book");
    }

    @Override
    public Supplier<ContainerActionResult> getInventoryRightClickAction(Container container, InventoryItem item, int slotIndex, ContainerSlot slot) {
        PlayerMob player = container.getClient().playerMob;
        return () -> {
            if (slot.getInventory() == container.getClient().playerMob.getInv().main) {
                if (container.getClient().isServerClient()) {
                    ServerClient client = container.getClient().getServerClient();
                    PacketOpenContainer p = new PacketOpenContainer(ExampleMod.RACE_CHANGE_CONTAINER);
                    ContainerRegistry.openAndSendContainer(client, p);
                }

                return new ContainerActionResult(34534);
            } else {
                return new ContainerActionResult(3636, Localization.translate("itemtooltip", "rclickinvopenerror"));
            }
        };
    }
}
