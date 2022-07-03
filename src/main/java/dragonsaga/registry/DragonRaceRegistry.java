package dragonsaga.registry;

import dragonsaga.buffs.DragonBuffRegistry;
import dragonsaga.race.DragonRace;
import dragonsaga.race.RaceBase;
import dragonsaga.race.Stats;

import java.util.HashMap;

public class DragonRaceRegistry {

    public static DragonRaceRegistry Instance = new DragonRaceRegistry();

    protected HashMap<DragonRaceRegistry.RaceEnum, RaceBase> _raceDB = new HashMap<DragonRaceRegistry.RaceEnum, RaceBase>() {{
        // 60 points
        put(DragonRaceRegistry.RaceEnum.HUMAN_LOW, new RaceBase(DragonRaceRegistry.RaceEnum.HUMAN_LOW, new Stats(1, 1, 0.5f, 0.5f, 0.8f, 1.2f, 2f), DragonBuffRegistry.HUMAN_LOW_BUFF));
        // 75 points
        put(DragonRaceRegistry.RaceEnum.HUMAN, new RaceBase(DragonRaceRegistry.RaceEnum.HUMAN, new Stats(1.2f, 1.2f, 0.5f, 0.5f, 1, 1.6f, 1.5f), DragonBuffRegistry.HUMAN_BUFF));
        // 90 points
        put(DragonRaceRegistry.RaceEnum.HUMAN_GUARDIAN, new RaceBase(DragonRaceRegistry.RaceEnum.HUMAN_GUARDIAN ,new Stats(1.5f, 1.5f, 1, 1, 1, 2f, 1f), DragonBuffRegistry.HUMAN_GUARDIAN_BUFF));
    }};

    public RaceBase GetRace(RaceEnum race) {
        return _raceDB.get(race);
    }

    public enum RaceEnum {
        // Human
        HUMAN_LOW,
        HUMAN,
        HUMAN_GUARDIAN,

        // Namekian
        NAMEKIAN,
        NAMEKIAN_WARRIOR,
        NAMEKIAN_SUPER,

        // Saiyan
        SAIYAN_LOW_CLASS,
        SAIYAN_ELITE,
        SAIYAN_LEGENDARY
    }
}
