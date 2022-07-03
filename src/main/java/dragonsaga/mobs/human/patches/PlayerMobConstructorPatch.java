package dragonsaga.mobs.human.patches;

import dragonsaga.race.DragonRace;
import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.engine.network.NetworkClient;
import necesse.entity.mobs.PlayerMob;
import net.bytebuddy.asm.Advice;

@ModConstructorPatch(target = PlayerMob.class, arguments = {long.class, NetworkClient.class})
public class PlayerMobConstructorPatch {

    @Advice.OnMethodExit
    public static void OnExit(@Advice.This PlayerMob playerMob,  @Advice.Argument(0) long tempNameIdentifier, @Advice.Argument(1) NetworkClient networkClient) {
    }
}
