package dragonsaga.items.abilities.projectiles

import necesse.engine.tickManager.TickManager
import necesse.entity.mobs.GameDamage
import necesse.entity.mobs.Mob
import necesse.entity.mobs.PlayerMob
import necesse.entity.projectile.Projectile
import necesse.entity.trails.Trail
import necesse.gfx.camera.GameCamera
import necesse.gfx.drawables.LevelSortedDrawable
import necesse.gfx.drawables.OrderableDrawables
import necesse.level.maps.Level

class KiBeamProjectile() : Projectile() {

    init {
        super.init()
        givesLight = true
        piercing = 100
        width = 100f
        height = 20f
    }

    constructor(x: Float, y: Float, targetX: Float, targetY: Float, speed: Int, distance: Int, damage: GameDamage?, knockback: Int, owner: Mob?, level: Level) : this() {

        setLevel(level)
        applyData(x, y, targetX, targetY, speed.toFloat(), 600, damage, knockback, owner)
    }

    override fun getTrail(): Trail {
        val trail = Trail(this, level, java.awt.Color.CYAN, 200f, 1000, 50f)
        return Trail(this, level, java.awt.Color.CYAN, 200f, 1000, 50f)
    }

    override fun getParticleColor(): java.awt.Color {
        return java.awt.Color.BLUE;
    }

    override fun addDrawables(sortedDrawable: MutableList<LevelSortedDrawable>?, orderableDrawables: OrderableDrawables?, orderableDrawables2: OrderableDrawables?, orderableDrawables3: OrderableDrawables?, level: Level?, tickManager: TickManager?, gameCamera: GameCamera?, playerMob: PlayerMob?) {
        TODO("Not yet implemented")
    }

    override fun getParticleChance(): Float {
       return 0.8f;
    }

}