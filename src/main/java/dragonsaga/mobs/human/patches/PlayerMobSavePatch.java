package dragonsaga.mobs.human.patches;

import race.DragonRace;
import dragonsaga.registry.DragonRaceRegistry;
import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.engine.save.SaveData;
import necesse.entity.mobs.PlayerMob;
import net.bytebuddy.asm.Advice;

@ModMethodPatch(target = PlayerMob.class, name = "addSaveData", arguments = {SaveData.class})
public class PlayerMobSavePatch {

    @Advice.OnMethodExit
    public static void OnExit(@Advice.This PlayerMob playerMob, @Advice.Argument(0) SaveData save) {
//        System.out.println("Saving " + playerMob.playerName);
//        DragonRaceRegistry.RaceEnum playerRace = DragonRace.Companion.getInstance().GetPlayerRace(playerMob);
//
//        if (playerRace != null)
//            save.addEnum("dragon_race", playerRace);
    }
}
