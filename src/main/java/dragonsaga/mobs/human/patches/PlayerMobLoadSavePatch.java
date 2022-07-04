package dragonsaga.mobs.human.patches;

import race.DragonRace;
import dragonsaga.registry.DragonRaceRegistry;
import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.engine.save.LoadData;
import necesse.entity.mobs.PlayerMob;
import net.bytebuddy.asm.Advice;

@ModMethodPatch(target = PlayerMob.class, name = "applyLoadData", arguments = {LoadData.class})
public class PlayerMobLoadSavePatch {
    @Advice.OnMethodExit
    public static void OnExit(@Advice.This PlayerMob playerMob, @Advice.Argument(0) LoadData load) {

//        System.out.println("loading for player: " + playerMob.playerName);
//
//        DragonRaceRegistry.RaceEnum race = load.getEnum(DragonRaceRegistry.RaceEnum.class,  "dragon_race", DragonRaceRegistry.RaceEnum.HUMAN_LOW);
//        System.out.println("Loaded player race ->" + race);
//        DragonRace.Companion.getInstance().ResetOwner(playerMob);
//        DragonRace.Companion.getInstance().ChangePlayerRaceNextTick(playerMob, race);

        //_playerLoadedRace = race;

        //if (race != DragonRaceRegistry.RaceEnum.NONE)
            //_playerLoadedRace = race;
            //playerMob.(new PacketDragonRaceChange(playerMob.getPlayerSlot(), race));
            //DragonRace.Instance.SetPlayerRaceBaseAndSend(playerMob.getPlayerSlot(), race, playerMob.getServerClient());
    }
}
