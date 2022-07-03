package dragonsaga.mobs.human.patches;

import dragonsaga.network.packet.PacketDragonRaceChange;
import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.engine.network.PacketReader;
import necesse.entity.mobs.PlayerMob;
import net.bytebuddy.asm.Advice;

@ModMethodPatch(target = PlayerMob.class, name = "applySpawnPacket", arguments = {PacketReader.class})
public class PlayerMobApplySpawnPacketPatch {

    @Advice.OnMethodExit
    public static void OnExit(@Advice.This PlayerMob playerMob, @Advice.Argument(0) PacketReader packetReader) {
//        if(PlayerMobLoadSavePatch._playerLoadedRace != null)
//            playerMob.getLevel().getClient().network.sendPacket(new PacketDragonRaceChange(playerMob.getPlayerSlot(), PlayerMobLoadSavePatch._playerLoadedRace));
    }
}
