package dragonsaga.mobs.human.patches;

import race.DragonRace;
import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.buffs.ActiveBuff;
import net.bytebuddy.asm.Advice;


@ModMethodPatch(target = PlayerMob.class, name = "serverTick", arguments = {})
public class PlayerMobServerTickPatch {

    @Advice.OnMethodExit
    public static void OnExit(@Advice.This PlayerMob playerMob) {
        tickRace(playerMob);
    }

    public static void tickRace(PlayerMob playerMob) {
//        DragonRaceRegistry.RaceBase race = DragonRace.Instance.GetPlayerRaceBase(playerMob.getPlayerSlot());
//        if (race == null) return;
//
//        if (playerMob.buffManager.hasBuff(race.Buff)) return;
//
//        playerMob.buffManager.clearBuffs();
//        ActiveBuff activeBuff = new ActiveBuff(race.Buff, playerMob, 0, null);
//        playerMob.buffManager.addBuff(activeBuff, false);
    }
}
