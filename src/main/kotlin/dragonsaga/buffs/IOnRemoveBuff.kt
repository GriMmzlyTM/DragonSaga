package dragonsaga.buffs

import necesse.entity.mobs.Mob
import necesse.entity.mobs.buffs.ActiveBuff

interface IOnRemoveBuff {
    fun OnRemove(buff: ActiveBuff, mob: Mob);
}