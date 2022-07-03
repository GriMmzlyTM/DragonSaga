package dragonsaga.buffs;

import necesse.engine.registries.BuffRegistry;
import necesse.entity.mobs.buffs.staticBuffs.Buff;

public class DragonBuffRegistry {

    public static Buff HUMAN_BUFF;
    public static Buff HUMAN_LOW_BUFF;
    public static Buff HUMAN_GUARDIAN_BUFF;

    public static void Register() {
        HUMAN_BUFF = BuffRegistry.registerBuff("dragon_human", new ExampleBuff());
        HUMAN_LOW_BUFF = BuffRegistry.registerBuff("dragon_human_low", new ExampleBuff());
        HUMAN_GUARDIAN_BUFF = BuffRegistry.registerBuff("dragon_human_guardian", new ExampleBuff());
    }
}
