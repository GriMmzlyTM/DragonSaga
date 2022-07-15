package dragonsaga.items

import ModEntrypoint
import dragonsaga.race.RaceBase
import dragonsaga.registry.DragonRaceRegistry
import dragonsaga.registry.RaceEnum
import necesse.engine.localization.Localization
import necesse.engine.network.packet.PacketOpenContainer
import necesse.engine.registries.ContainerRegistry
import necesse.gfx.gameTexture.GameTexture
import necesse.inventory.InventoryItem
import necesse.inventory.container.Container
import necesse.inventory.container.ContainerActionResult
import necesse.inventory.container.slots.ContainerSlot
import necesse.inventory.item.Item
import java.util.function.Supplier

class RaceChangeItem(var Race: RaceEnum, raceRarity: Rarity) : Item(1) {
    var BaseStats: RaceBase?

    init {
        BaseStats = DragonRaceRegistry.GetRace(Race)
        rarity = raceRarity
    }

    override fun loadTextures() {
        super.loadTextures()
        itemTexture = GameTexture.fromFile("items/book")
    }

    override fun getInventoryRightClickAction(
        container: Container,
        item: InventoryItem,
        slotIndex: Int,
        slot: ContainerSlot
    ): Supplier<ContainerActionResult> {
        val player = container.getClient().playerMob
        return Supplier {
            if (slot.inventory === container.getClient().playerMob.inv.main) {
                if (container.getClient().isServerClient) {
                    val client = container.getClient().serverClient
                    val p = PacketOpenContainer(ModEntrypoint.Companion.RACE_CHANGE_CONTAINER)
                    ContainerRegistry.openAndSendContainer(client, p)
                }
                return@Supplier ContainerActionResult(34534)
            } else {
                return@Supplier ContainerActionResult(3636, Localization.translate("itemtooltip", "rclickinvopenerror"))
            }
        }
    }
}