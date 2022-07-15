package dragonsaga.items.containers

import dragonsaga.registry.RaceEnum
import dragonsaga.race.DragonRace
import necesse.engine.network.NetworkClient
import necesse.inventory.container.Container
import necesse.inventory.container.customAction.EmptyCustomAction
import necesse.inventory.container.customAction.EnumCustomAction

class RaceChangeContainer(client: NetworkClient, uniqueSeed: Int) : Container(client, uniqueSeed) {
    var playerRaceButton: EnumCustomAction<RaceEnum>
    var applyRace: EmptyCustomAction? = null

    init {
        playerRaceButton = registerAction(object : EnumCustomAction<RaceEnum>(RaceEnum::class.java) {
            override fun run(race: RaceEnum?) {
                DragonRace.Instance.ChangePlayerRaceNextTick(client.playerMob, race)
            }
        })
    }
}