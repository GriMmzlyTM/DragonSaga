package dragonsaga.race;

import dragonsaga.registry.DragonRaceRegistry;
import necesse.entity.mobs.buffs.staticBuffs.Buff;

public class RaceBase {
    public Stats BaseStatModifiers;
    public DragonRaceRegistry.RaceEnum Race;
    public necesse.entity.mobs.buffs.staticBuffs.Buff Buff;

    public RaceBase(DragonRaceRegistry.RaceEnum race, Stats baseStatModifiers, Buff buff) {
        BaseStatModifiers = baseStatModifiers;
        Race = race;
        Buff = buff;
    }
}