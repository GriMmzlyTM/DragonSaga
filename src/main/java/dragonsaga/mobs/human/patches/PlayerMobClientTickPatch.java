package dragonsaga.mobs.human.patches;

import race.DragonRace;
import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.mobs.PlayerMob;
import net.bytebuddy.asm.Advice;

@ModMethodPatch(target = PlayerMob.class, name = "clientTick", arguments = {})
public class PlayerMobClientTickPatch {

    @Advice.OnMethodExit
    public static void OnExit(@Advice.This PlayerMob playerMob) {
//        DragonRace.Companion.getInstance().TickPlayerRace(playerMob);
    }
}