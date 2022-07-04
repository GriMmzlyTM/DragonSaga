import dragonsaga.examples.ExampleChatCommand
import dragonsaga.examples.ExampleObject
import dragonsaga.items.containers.RaceChangeContainer
import dragonsaga.mobs.KrillManMob
import dragonsaga.network.packet.PacketDragonRaceChange
import dragonsaga.registry.*
import dragonsaga.ui.RaceChangeMenuForm
import necesse.engine.commands.CommandsManager
import necesse.engine.modLoader.annotations.ModEntry
import necesse.engine.network.Packet
import necesse.engine.network.client.Client
import necesse.engine.network.server.ServerClient
import necesse.engine.registries.ContainerRegistry
import necesse.engine.registries.MobRegistry
import necesse.engine.registries.ObjectRegistry
import necesse.engine.registries.PacketRegistry

@ModEntry
class ModEntrypoint {
    fun init() {
        // Register our tiles
        //TileRegistry.registerTile("exampletile", new ExampleTile(), 1, true);

        // Register out objects
        DragonObjectRegistry.RegisterAll()

        DragonBuffRegistry.RegisterAll()
        DragonItemRegistry.RegisterAll()
        DragonMobRegistry.RegisterAll()

        // Register our projectile
        //ProjectileRegistry.registerProjectile("exampleprojectile", ExampleProjectile.class, "exampleprojectile", "exampleprojectile_shadow");

        // Level

        // Containers
        RACE_CHANGE_CONTAINER =
            ContainerRegistry.registerContainer({ client: Client, uniqueSeed: Int, content: Packet? ->
                RaceChangeMenuForm(
                    client,
                    RaceChangeContainer(client.client, uniqueSeed)
                )
            }) { client: ServerClient, uniqueSeed: Int, content: Packet?, serverObject: Any? ->
                RaceChangeContainer(
                    client,
                    uniqueSeed
                )
            }

        // World Gen

        // Packet
        PacketRegistry.registerPacket(PacketDragonRaceChange::class.java)

        // Quests
    }

    fun initResources() {
        DragonTextureRegistry.RegisterAll()
    }

    fun postInit() {

        // Add recipes
        // Example item recipe, crafted in inventory for 2 iron bars
        DragonRecipeRegistry.RegisterAll()
        DragonMobRegistry.RegisterAllBiomes()

        // Register our server chat command
        CommandsManager.registerServerCommand(ExampleChatCommand())


    }

    companion object {
        var RACE_CHANGE_CONTAINER = 0
    }
}