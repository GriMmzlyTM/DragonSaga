package dragonsaga.race;

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