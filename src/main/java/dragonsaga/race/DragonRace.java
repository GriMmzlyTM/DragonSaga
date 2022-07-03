package dragonsaga.race;

import dragonsaga.buffs.DragonBuffRegistry;
import dragonsaga.registry.DragonRaceRegistry;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.staticBuffs.Buff;

import java.util.HashMap;
import java.util.Objects;

/**
 * Races mobs can be a part of. Each race consists of 3 tiers that increase in power.
 */
public class DragonRace {

    public static DragonRace Instance = new DragonRace();

    protected String _ownerName;
    protected DragonRaceRegistry.RaceEnum _nextPlayerRace;
    protected DragonRaceRegistry.RaceEnum _currentPlayerRace;

    public void ResetOwner(PlayerMob playerMob) {
        _ownerName = playerMob.playerName;
        _nextPlayerRace = null;
        _currentPlayerRace = null;
    }

    public void ChangePlayerRaceNextTick(PlayerMob mob, DragonRaceRegistry.RaceEnum race) {
        if (!Objects.equals(mob.playerName, _ownerName)) return;
        _nextPlayerRace = race;
    }

    public void TickPlayerRace(PlayerMob playerMob) {
        if (!Objects.equals(playerMob.playerName, _ownerName)) return;
        if (_nextPlayerRace == _currentPlayerRace || _nextPlayerRace == null) return;

        if (_currentPlayerRace != null) {
            Buff currentRaceBuff = DragonRaceRegistry.Instance.GetRace(_currentPlayerRace).Buff;

            if (playerMob.buffManager.hasBuff(currentRaceBuff))
                playerMob.buffManager.removeBuff(currentRaceBuff, true);
        }

        Buff nextRaceBuff = DragonRaceRegistry.Instance.GetRace(_nextPlayerRace).Buff;
        ActiveBuff activeBuff = new ActiveBuff(nextRaceBuff, playerMob, 0, null);
        playerMob.buffManager.addBuff(activeBuff, true);
        _currentPlayerRace = _nextPlayerRace;
    }

    public RaceBase GetPlayerRaceBase(PlayerMob playerMob) {
        if (!Objects.equals(playerMob.playerName, _ownerName)) return null;

        if (_currentPlayerRace == null) return null;
        return DragonRaceRegistry.Instance.GetRace(_currentPlayerRace);
    }

    public DragonRaceRegistry.RaceEnum GetPlayerRace(PlayerMob playerMob)  {
        if(!Objects.equals(playerMob.playerName, _ownerName)) return null;
        return _currentPlayerRace;
    }

    public void SetPlayerRaceBase(int slot, DragonRaceRegistry.RaceEnum race) {
        //_playerRaces.put(slot, GetRaceBase(race));
    }


}
