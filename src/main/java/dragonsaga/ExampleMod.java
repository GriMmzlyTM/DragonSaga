package dragonsaga;

import dragonsaga.buffs.ExampleBuff;
import dragonsaga.database.DragonMobDatabase;
import dragonsaga.examples.*;
import dragonsaga.items.RaceChangeItem;
import dragonsaga.items.containers.RaceChangeContainer;
import dragonsaga.mobs.human.KrillManMob;
import dragonsaga.mobs.human.MartialArtistMob;
import dragonsaga.registry.DragonItemRegistry;
import dragonsaga.registry.DragonRecipeRegistry;
import dragonsaga.ui.RaceChangeMenuForm;
import necesse.engine.commands.CommandsManager;
import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.*;
import necesse.entity.mobs.HumanTexture;
import necesse.entity.mobs.buffs.staticBuffs.Buff;
import necesse.gfx.GameMusic;
import necesse.gfx.gameSound.GameSound;
import necesse.gfx.gameTexture.GameTexture;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;
import necesse.level.maps.biomes.Biome;

@ModEntry
public class ExampleMod {

    public static int RACE_CHANGE_CONTAINER;
    public static Buff NAMEKIAN_RACE_BUFF;

    public void init() {
        System.out.println("Hello world from my example mod!");

        // Register our tiles
        //TileRegistry.registerTile("exampletile", new ExampleTile(), 1, true);

        // Register out objects
        //ObjectRegistry.registerObject("exampleobject", new ExampleObject(), 2, true);

        // Register our buff
        NAMEKIAN_RACE_BUFF = BuffRegistry.registerBuff("namekian", new ExampleBuff());

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
        PacketRegistry.registerPacket(ExamplePacket.class);

        // Quests


    }

    public void initResources() {
        MobRegistry.Textures.rabbit = GameTexture.fromFile("mobs/examplemob");

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
