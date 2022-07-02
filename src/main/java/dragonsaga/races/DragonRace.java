package dragonsaga.races;

import java.util.HashMap;

/**
 * Races mobs can be a part of. Each race consists of 3 tiers that increase in power.
 */

public class DragonRace {

    public static DragonRace Instance = new DragonRace();
    protected HashMap<RaceEnum, RaceBase> _raceDB = new HashMap<RaceEnum, RaceBase>() {{
        // 60 points
        put(RaceEnum.HUMAN_LOW, new DragonRace.RaceBase(RaceEnum.HUMAN_LOW, new Stats(1, 1, 0.5f, 0.5f, 0.8f, 1.2f, 2f)));
        // 75 points
        put(RaceEnum.HUMAN, new DragonRace.RaceBase(RaceEnum.HUMAN, new Stats(1.2f, 1.2f, 0.5f, 0.5f, 1, 1.6f, 1.5f)));
        // 90 points
        put(RaceEnum.HUMAN_GUARDIAN, new DragonRace.RaceBase(RaceEnum.HUMAN_GUARDIAN ,new Stats(1.5f, 1.5f, 1, 1, 1, 2f, 1f)));
    }};

    public RaceBase GetRaceBase(RaceEnum race) {
        return _raceDB.get(race);
    }

    public class RaceBase {
        public Stats BaseStatModifiers;
        public RaceEnum Race;

        public RaceBase(RaceEnum race, Stats baseStatModifiers) {
            BaseStatModifiers = baseStatModifiers;
            Race = race;
        }
    }

    /**
     * Stats used as true stat numbers, base stat modifiers for races and additional stat modifiers.
     */
    public class Stats {

        public float HP, Def;           // Basic survivablilty stats
        public float Ki, KiControl;     // Ki stats. Ki = dmg. KiControl = Ki amount, Ki ability speed
        public float Spd;               // Movement speed, melee speed
        public float Str;               // Offensive melee (Non ki) damage
        public float HiddenPotential;   // Growth stat - Higher potential helps learn and master abilities faster, as well as unlock transformations faster

        public Stats(float hp, float def, float ki, float kiControl, float spd, float str, float hiddenPotential) {
            HP = hp;
            Def = def;
            Ki = ki;
            KiControl = kiControl;
            Spd = spd;
            Str = str;
            HiddenPotential = hiddenPotential;
        }

        public Stats CalculateTrueStats(Stats playerStats, Stats racialStatModifiers) {
            return new Stats(playerStats.HP * racialStatModifiers.HP,
                    playerStats.Def * racialStatModifiers.Def,
                    playerStats.Ki * racialStatModifiers.Ki,
                    playerStats.KiControl * racialStatModifiers.KiControl,
                    playerStats.Spd * racialStatModifiers.Spd,
                    playerStats.Str * racialStatModifiers.Str,
                    playerStats.HiddenPotential * racialStatModifiers.HiddenPotential);
        }

        public Stats SumStatModifiers(Stats modifierA, Stats modifierB) {
            return new Stats(
                    modifierA.HP + modifierB.HP,
                    modifierA.Def + modifierB.Def,
                    modifierA.Ki + modifierB.Ki,
                    modifierA.KiControl + modifierB.KiControl,
                    modifierA.Spd + modifierB.Spd,
                    modifierA.Str + modifierB.Str,
                    modifierA.HiddenPotential + modifierB.HiddenPotential);
        }
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
