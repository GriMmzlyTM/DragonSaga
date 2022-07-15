package dragonsaga.patches.buffManager;

import dragonsaga.buffs.IOnRemoveBuff;
import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffManager;
import net.bytebuddy.asm.Advice;

@ModMethodPatch(target = BuffManager.class, name = "removeBuff", arguments = {int.class, boolean.class})
public class removeBuffPatch {

    @Advice.OnMethodEnter
    public static void OnEnter(@Advice.This BuffManager buffManager, @Advice.Argument(0) int buffId, @Advice.FieldValue(value = "owner") Mob owner) {
        ActiveBuff ab = buffManager.getBuff(buffId);
        if (ab != null && ab.buff instanceof IOnRemoveBuff) {
            ((IOnRemoveBuff) ab.buff).OnRemove(ab, owner);
        }

    }

}
