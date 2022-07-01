package dragonsaga.items;

import dragonsaga.ExampleMod;
import dragonsaga.buffs.ExampleBuff;
import dragonsaga.ui.RaceChangeMenuForm;
import necesse.engine.localization.Localization;
import necesse.engine.network.packet.PacketOpenContainer;
import necesse.engine.network.server.ServerClient;
import necesse.engine.registries.ContainerRegistry;
import necesse.engine.registries.ItemRegistry;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.gfx.gameTexture.GameTexture;
import necesse.inventory.InventoryItem;
import necesse.inventory.container.Container;
import necesse.inventory.container.ContainerActionResult;
import necesse.inventory.container.item.CraftingGuideContainer;
import necesse.inventory.container.slots.ContainerSlot;
import necesse.inventory.item.Item;

import java.util.function.Supplier;

public class RaceChangeItem extends Item {

    public RaceChangeItem() {
        super(1);

        this.rarity = Rarity.LEGENDARY;
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


//
//    @Override
//    public InventoryItem onPlace(Level level, int x, int y, PlayerMob player, InventoryItem item, PacketReader contentReader) {
//
//        ActiveBuff activeBuff = new ActiveBuff(new ExampleBuff(), player, Integer.MAX_VALUE, null );
//        player.addBuff(activeBuff, true);
//        RaceChangeMenuForm.Instance.setHidden(false);
//
//        if (level.isServerLevel()) {
//            level.getServer().network.sendToAllClientsExcept(new PacketPlayerGeneral(player.getServerClient()), player.getServerClient());
//        } else if (level.isClientLevel()) {
//            Screen.playSound(GameResources.drink, SoundEffect.effect(player));
//        }
//
//        if (this.singleUse) {
//            item.setAmount(item.getAmount() - 1);
//        }
//        return item;
//    }
//
//    @Override
//    public InventoryItem onAttemptPlace(Level level, int x, int y, PlayerMob player, InventoryItem item, PacketReader contentReader, String error) {
//        return super.onAttemptPlace(level, x, y, player, item, contentReader, error);
//    }
}
