package dragonsaga.items.containers;

import dragonsaga.race.DragonRace;
import dragonsaga.registry.DragonRaceRegistry;
import necesse.engine.network.NetworkClient;
import necesse.inventory.container.Container;
import necesse.inventory.container.customAction.BooleanCustomAction;
import necesse.inventory.container.customAction.EmptyCustomAction;
import necesse.inventory.container.customAction.EnumCustomAction;
import necesse.inventory.container.customAction.IntCustomAction;

public class RaceChangeContainer extends Container {

    public EnumCustomAction<DragonRaceRegistry.RaceEnum> playerRaceButton;
    EmptyCustomAction applyRace;

    public RaceChangeContainer(NetworkClient client, int uniqueSeed) {
        super(client, uniqueSeed);

        this.playerRaceButton = this.registerAction(new EnumCustomAction<DragonRaceRegistry.RaceEnum>(DragonRaceRegistry.RaceEnum.class) {
            @Override
            protected void run(DragonRaceRegistry.RaceEnum race) {
                DragonRace.Instance.ChangePlayerRaceNextTick(client.playerMob, race);
            }
        });

    }
}
