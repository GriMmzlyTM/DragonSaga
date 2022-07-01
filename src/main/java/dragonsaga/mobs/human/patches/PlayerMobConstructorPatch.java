package dragonsaga.mobs.human.patches;

import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.engine.network.NetworkClient;
import necesse.entity.mobs.PlayerMob;
import net.bytebuddy.asm.Advice;

@ModConstructorPatch(target = PlayerMob.class, arguments = {long.class, NetworkClient.class})
public class PlayerMobConstructorPatch {

    @Advice.OnMethodExit
    public static void OnExit(@Advice.This PlayerMob playerMob) {
        playerMob.setSpeed(60);
        playerMob.setFriction(7);
    }
}
