package dragonsaga.network.packet

import dragonsaga.race.DragonRace
import dragonsaga.registry.RaceEnum
import necesse.engine.network.NetworkPacket
import necesse.engine.network.Packet
import necesse.engine.network.PacketReader
import necesse.engine.network.PacketWriter
import necesse.engine.network.client.Client
import necesse.engine.network.server.Server
import necesse.engine.network.server.ServerClient

class PacketDragonRaceChange : Packet {
    val playerSlot: Int
    val race: RaceEnum

    // MUST HAVE - Used for construction in registry
    constructor(data: ByteArray?) : super(data) {
        val reader = PacketReader(this)
        // Important that it's same order as written in
        race = reader.getNextEnum(RaceEnum::class.java)
        playerSlot = reader.nextByteUnsigned // Since player slots never go over 255
    }

    constructor(slot: Int, playerRace: RaceEnum) {
        playerSlot = slot
        race = playerRace
        val writer = PacketWriter(this)
        // Important that it's same order as read in
        writer.putNextByteUnsigned(playerSlot)
        writer.putNextEnum(playerRace)

        // Examples how to send packets:
//        client.sendPacket(this); // To a single client
//        server.network.sendToAllClients(packet); // To all clients
    }

    override fun processClient(packet: NetworkPacket, client: Client) {
        if (client.level != null) {
            val target = client.getClient(playerSlot)
            if (target != null && target.playerMob.level != null) {
                DragonRace.Companion.Instance.SetPlayerRaceBase(playerSlot, race)
            }
        }
    }

    override fun processServer(packet: NetworkPacket, server: Server, client: ServerClient) {
        DragonRace.Companion.Instance.SetPlayerRaceBase(playerSlot, race)
        server.network.sendToAllClientsExcept(PacketDragonRaceChange(playerSlot, race), client)
    }
}