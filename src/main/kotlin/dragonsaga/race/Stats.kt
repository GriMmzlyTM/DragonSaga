package dragonsaga.race

class Stats(
    var HP: Float, var Def: Float, // Basic survivablilty stats
    var Ki: Float, var KiControl: Float, // Ki stats. Ki = dmg. KiControl = Ki amount, Ki ability speed
    var Spd: Float,  // Movement speed, melee speed
    var Str: Float, // Offensive melee (Non ki) damage
    var HiddenPotential: Float)// Growth stat - Higher potential helps learn and master abilities faster, as well as unlock transformations faster
{
    fun CalculateTrueStats(playerStats: Stats, racialStatModifiers: Stats): Stats {
        return Stats(
            playerStats.HP * racialStatModifiers.HP,
            playerStats.Def * racialStatModifiers.Def,
            playerStats.Ki * racialStatModifiers.Ki,
            playerStats.KiControl * racialStatModifiers.KiControl,
            playerStats.Spd * racialStatModifiers.Spd,
            playerStats.Str * racialStatModifiers.Str,
            playerStats.HiddenPotential * racialStatModifiers.HiddenPotential
        )
    }

    fun SumStatModifiers(modifierA: Stats, modifierB: Stats): Stats {
        return Stats(
            modifierA.HP + modifierB.HP,
            modifierA.Def + modifierB.Def,
            modifierA.Ki + modifierB.Ki,
            modifierA.KiControl + modifierB.KiControl,
            modifierA.Spd + modifierB.Spd,
            modifierA.Str + modifierB.Str,
            modifierA.HiddenPotential + modifierB.HiddenPotential
        )
    }
}