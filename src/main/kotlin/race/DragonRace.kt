package race

import dragonsaga.registry.DragonRaceRegistry
import dragonsaga.registry.RaceEnum
import necesse.entity.mobs.PlayerMob
import necesse.entity.mobs.buffs.ActiveBuff
import necesse.entity.mobs.buffs.staticBuffs.Buff

/**
 * Races mobs can be a part of. Each race consists of 3 tiers that increase in power.
 */
class DragonRace {
    protected var _ownerName: String? = null
    protected var _nextPlayerRace: RaceEnum? = null
    protected var _currentPlayerRace: RaceEnum? = null
    fun ResetOwner(playerMob: PlayerMob) {
        _ownerName = playerMob.playerName
        _nextPlayerRace = null
        _currentPlayerRace = null
    }

    fun ChangePlayerRaceNextTick(mob: PlayerMob, race: RaceEnum?) {
        if (mob.playerName != _ownerName) return
        _nextPlayerRace = race
    }

    fun TickPlayerRace(playerMob: PlayerMob) {
        if (playerMob.playerName != _ownerName) return
        if (_nextPlayerRace == _currentPlayerRace || _nextPlayerRace == null) return
        if (_currentPlayerRace != null) {
            val currentRaceBuff: Buff = DragonRaceRegistry.GetRace(_currentPlayerRace!!)!!.Buff
            if (playerMob.buffManager.hasBuff(currentRaceBuff)) playerMob.buffManager.removeBuff(currentRaceBuff, true)
        }

        val nextRaceBuff: Buff = DragonRaceRegistry.GetRace(_nextPlayerRace!!)!!.Buff
        val activeBuff = ActiveBuff(nextRaceBuff, playerMob, 0, null)
        playerMob.buffManager.addBuff(activeBuff, true)
        _currentPlayerRace = _nextPlayerRace
    }

    fun GetPlayerRaceBase(playerMob: PlayerMob): RaceBase? {
        if (playerMob.playerName != _ownerName) return null
        return if (_currentPlayerRace == null) null else DragonRaceRegistry.GetRace(
            _currentPlayerRace!!
        )
    }

    fun GetPlayerRace(playerMob: PlayerMob): RaceEnum? {
        return if (playerMob.playerName != _ownerName) null else _currentPlayerRace
    }

    fun SetPlayerRaceBase(slot: Int, race: RaceEnum?) {
        //_playerRaces.put(slot, GetRaceBase(race));
    }

    companion object {
        var Instance = DragonRace()
    }
}