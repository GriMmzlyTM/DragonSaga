package dragonsaga.registry

import dragonsaga.race.RaceBase
import dragonsaga.race.Stats

enum class RaceEnum {
    // Human
    HUMAN_LOW, HUMAN, HUMAN_GUARDIAN,
    // Namekian
    NAMEKIAN, NAMEKIAN_WARRIOR, NAMEKIAN_SUPER,
    // Saiyan
    SAIYAN_LOW_CLASS, SAIYAN_ELITE, SAIYAN_LEGENDARY
}

object DragonRaceRegistry {
    private var _raceDB: HashMap<RaceEnum, RaceBase> = object : HashMap<RaceEnum, RaceBase>() {
        init {
            // 60 points
            put(
                RaceEnum.HUMAN_LOW,
                RaceBase(RaceEnum.HUMAN_LOW, Stats(1f, 1f, 0.5f, 0.5f, 0.8f, 1.2f, 2f), HUMAN_LOW_BUFF!!)
            )
            // 75 points
            put(RaceEnum.HUMAN, RaceBase(RaceEnum.HUMAN, Stats(1.2f, 1.2f, 0.5f, 0.5f, 1f, 1.6f, 1.5f), HUMAN_BUFF!!))
            // 90 points
            put(
                RaceEnum.HUMAN_GUARDIAN,
                RaceBase(RaceEnum.HUMAN_GUARDIAN, Stats(1.5f, 1.5f, 1f, 1f, 1f, 2f, 1f), HUMAN_GUARDIAN_BUFF!!)
            )
        }
    }

    fun GetRace(race: RaceEnum): RaceBase? {
        return _raceDB[race]
    }
}