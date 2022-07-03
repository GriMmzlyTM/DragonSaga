package dragonsaga.network.packet;

import dragonsaga.race.DragonRace;
import dragonsaga.registry.DragonRaceRegistry;
import necesse.engine.GameLog;
import necesse.engine.network.NetworkPacket;
import necesse.engine.network.Packet;
import necesse.engine.network.PacketReader;
import necesse.engine.network.PacketWriter;
import necesse.engine.network.client.Client;
import necesse.engine.network.client.ClientClient;
import necesse.engine.network.packet.PacketDisconnect;
import necesse.engine.network.packet.PacketRequestPlayerData;
import necesse.engine.network.server.Server;
import necesse.engine.network.server.ServerClient;

public class PacketDragonRaceChange extends Packet{

    public final int playerSlot;
    public final DragonRaceRegistry.RaceEnum race;

    // MUST HAVE - Used for construction in registry
    public PacketDragonRaceChange(byte[] data) {
        super(data);
        PacketReader reader = new PacketReader(this);
        // Important that it's same order as written in
        race = reader.getNextEnum(DragonRaceRegistry.RaceEnum.class);
        playerSlot = reader.getNextByteUnsigned(); // Since player slots never go over 255
    }

    public PacketDragonRaceChange(int slot, DragonRaceRegistry.RaceEnum playerRace) {
        playerSlot = slot;
        race  = playerRace;

        PacketWriter writer = new PacketWriter(this);
        // Important that it's same order as read in
        writer.putNextByteUnsigned(playerSlot);
        writer.putNextEnum(playerRace);

        // Examples how to send packets:
//        client.sendPacket(this); // To a single client
//        server.network.sendToAllClients(packet); // To all clients
    }


    @Override
    public void processClient(NetworkPacket packet, Client client) {
        if (client.getLevel() != null) {
            ClientClient target = client.getClient(playerSlot);
            if (target != null && target.playerMob.getLevel() != null) {
                DragonRace.Instance.SetPlayerRaceBase(playerSlot, race);
            }
        }
    }

    @Override
    public void processServer(NetworkPacket packet, Server server, ServerClient client) {
        DragonRace.Instance.SetPlayerRaceBase(playerSlot, race);
        server.network.sendToAllClientsExcept(new PacketDragonRaceChange(playerSlot, race), client);

    }
}
