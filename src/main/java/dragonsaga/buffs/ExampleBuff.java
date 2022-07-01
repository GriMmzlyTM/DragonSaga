package dragonsaga.buffs;

import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.Buff;

public class ExampleBuff extends Buff {

    public ExampleBuff() {
        canCancel = true;
        isVisible = true;
        shouldSave = true;
        isPassive = true;
    }

    @Override
    public void init(ActiveBuff activeBuff) {
        // Apply modifiers here
        activeBuff.setModifier(BuffModifiers.SPEED, 2f);
        ((PlayerMob)activeBuff.owner).look.setSkin(4);
    }

    @Override
    public void serverTick(ActiveBuff buff) {
        // You can do server ticks here
    }

    @Override
    public void clientTick(ActiveBuff buff) {
        // You can do client ticks here, like adding particles to buff.owner
    }

}
