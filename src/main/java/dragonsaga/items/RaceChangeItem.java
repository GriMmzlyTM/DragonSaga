package dragonsaga.items;

import dragonsaga.ExampleMod;
import dragonsaga.races.DragonRace;
import necesse.engine.localization.Localization;
import necesse.engine.network.packet.PacketOpenContainer;
import necesse.engine.network.server.ServerClient;
import necesse.engine.registries.ContainerRegistry;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.gfx.gameTexture.GameTexture;
import necesse.inventory.InventoryItem;
import necesse.inventory.container.Container;
import necesse.inventory.container.ContainerActionResult;
import necesse.inventory.container.slots.ContainerSlot;
import necesse.inventory.item.Item;

import java.util.function.Supplier;

public class RaceChangeItem extends Item {

    public DragonRace.RaceEnum Race;
    public DragonRace.RaceBase BaseStats;

    public RaceChangeItem(DragonRace.RaceEnum race) {
        super(1);

        Race = race;
        BaseStats = DragonRace.Instance.GetRaceBase(race);
        rarity = Rarity.LEGENDARY;
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
                    ActiveBuff activeBuff = new ActiveBuff(ExampleMod.NAMEKIAN_RACE_BUFF, player, Integer.MAX_VALUE, null );
                    player.buffManager.addBuff(activeBuff, true);
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
