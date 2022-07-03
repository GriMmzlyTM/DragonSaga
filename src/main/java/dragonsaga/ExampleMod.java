package dragonsaga;

import dragonsaga.buffs.DragonBuffRegistry;
import dragonsaga.database.DragonMobDatabase;
import dragonsaga.examples.ExampleChatCommand;
import dragonsaga.examples.ExampleObject;
import dragonsaga.items.containers.RaceChangeContainer;
import dragonsaga.mobs.human.KrillManMob;
import dragonsaga.network.packet.PacketDragonRaceChange;
import dragonsaga.registry.DragonItemRegistry;
import dragonsaga.registry.DragonRecipeRegistry;
import dragonsaga.ui.RaceChangeMenuForm;
import necesse.engine.commands.CommandsManager;
import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.modifiers.ModifierValue;
import necesse.engine.registries.*;
import necesse.entity.mobs.HumanTexture;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.Buff;
import necesse.entity.mobs.buffs.staticBuffs.armorBuffs.setBonusBuffs.SimpleSetBonusBuff;
import necesse.entity.mobs.friendly.human.HumanMob;
import necesse.gfx.gameTexture.GameTexture;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.armorItem.ArmorModifiers;
import necesse.inventory.item.armorItem.SetHelmetArmorItem;
import necesse.level.maps.biomes.Biome;


@ModEntry
public class ExampleMod {

    public static int RACE_CHANGE_CONTAINER;
    public static Buff NAMEKIAN_RACE_BUFF;

    public void init() {
        // Register our tiles
        //TileRegistry.registerTile("exampletile", new ExampleTile(), 1, true);

        // Register out objects
        ObjectRegistry.registerObject("medicalmachine", new ExampleObject(), 2, true);

        // Register our buff
        DragonBuffRegistry.Register();

        // Register our items
        DragonItemRegistry.Register();

        // Register our mob
        MobRegistry.registerMob("martialartistbase", KrillManMob.class, true);

        // Register our projectile
        //ProjectileRegistry.registerProjectile("exampleprojectile", ExampleProjectile.class, "exampleprojectile", "exampleprojectile_shadow");

        // Level

        // Containers
        RACE_CHANGE_CONTAINER = ContainerRegistry.registerContainer((client, uniqueSeed, content) -> {
            return new RaceChangeMenuForm(client, new RaceChangeContainer(client.getClient(), uniqueSeed));
        }, (client, uniqueSeed, content, serverObject) -> {
            return new RaceChangeContainer(client, uniqueSeed);
        });

        // World Gen

        // Packet
        PacketRegistry.registerPacket(PacketDragonRaceChange.class);

        // Quests

    }

    public void initResources() {
        DragonMobDatabase.Textures.MartialArtistBase = new HumanTexture(
                GameTexture.fromFile("mobs/martial_artist/MartialArtistBase"),
                GameTexture.fromFile("mobs/martial_artist/MartialArtistBase_LeftArm"),
                GameTexture.fromFile("mobs/martial_artist/MartialArtistBase_RightArm"))
;    }

    public void postInit() {

        // Add recipes
        // Example item recipe, crafted in inventory for 2 iron bars
        DragonRecipeRegistry.Register();

        Biome.defaultSurfaceMobs.add(100, "martialartistbase");

        // Register our server chat command
        CommandsManager.registerServerCommand(new ExampleChatCommand());

    }

}
