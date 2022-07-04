package dragonsaga.mobs

import dragonsaga.registry.DragonTextureRegistry
import dragonsaga.registry.Textures
import necesse.engine.tickManager.TickManager
import necesse.engine.util.GameRandom
import necesse.entity.mobs.Mob
import necesse.entity.mobs.MobDrawable
import necesse.entity.mobs.PlayerMob
import necesse.entity.mobs.ai.behaviourTree.BehaviourTreeAI
import necesse.entity.mobs.ai.behaviourTree.trees.PlayerChaserWandererAI
import necesse.entity.mobs.hostile.HostileMob
import necesse.entity.particle.FleshParticle
import necesse.entity.particle.Particle
import necesse.gfx.camera.GameCamera
import necesse.gfx.drawOptions.human.HumanDrawOptions
import necesse.gfx.drawables.OrderableDrawables
import necesse.inventory.InventoryItem
import necesse.level.maps.Level
import java.awt.Point
import java.awt.Rectangle

abstract class MartialArtistMob(health: Int) : HostileMob(health) {
    private val _baseTile: Point?

    init {
        speed = 40f
        friction = 1f
        setArmor(20)
        collision = Rectangle(-10, -7, 20, 14)
        hitBox = Rectangle(-14, -12, 28, 24)
        selectBox = Rectangle(-14, -41, 28, 48)
        canDespawn = false
        _baseTile = null
    }

    override fun spawnDeathParticles(knockbackX: Float, knockbackY: Float) {
        for (i in 0..3) {
            level.entityManager.addParticle(FleshParticle(level, Textures.MARTIAL_ARTIST_BASE!!.body, GameRandom.globalRandom.nextInt(5), 8, 32, x, y, 20.0f, knockbackX, knockbackY), Particle.GType.IMPORTANT_COSMETIC)
        }
    }

    public override fun addDrawables(list: MutableList<MobDrawable>, tileList: OrderableDrawables, topList: OrderableDrawables, level: Level, x: Int, y: Int, tickManager: TickManager, camera: GameCamera, perspective: PlayerMob) {
        super.addDrawables(list, tileList, topList, level, x, y, tickManager, camera, perspective)
        val light = level.getLightLevel(x / 32, y / 32)
        val drawX = camera.getDrawX(x) - 22 - 10
        var drawY = camera.getDrawY(y) - 44 - 7
        val sprite = this.getAnimSprite(x, y, dir)
        drawY += this.getBobbing(x, y)
        drawY += this.level.getTile(x / 32, y / 32).getMobSinkingAmount(this)

        val humanDrawOptions = HumanDrawOptions(Textures.MARTIAL_ARTIST_BASE)
            .sprite(sprite)
            .dir(dir)
            .light(light)

        if (this.inLiquid(x, y)) {
            drawY -= 10
            humanDrawOptions.armSprite(2)
        }
        val drawOptions = humanDrawOptions.pos(drawX, drawY)
        list.add(object : MobDrawable() {
            override fun draw(tickManager: TickManager) {
                drawOptions.draw()
            }
        })
        addShadowDrawables(tileList, x, y, light, camera)
    }

    protected fun addAttackDraw(drawOptions: HumanDrawOptions, attackProgress: Float) {
        addMeleeAttackDraw(drawOptions, attackProgress)
    }

    protected fun addMeleeAttackDraw(drawOptions: HumanDrawOptions, attackProgress: Float) {
        drawOptions.itemAttack(InventoryItem("nunchucks"), null, attackProgress, attackDir.x, attackDir.y)
    }

    fun setupAI() {
        //ai = new BehaviourTreeAI(this, new DragonHumanoidAI(640, 50, true, true, 60000));
        ai = BehaviourTreeAI(
            this,
            object : PlayerChaserWandererAI<MartialArtistMob>(null, 200, 0, 10000, true, true) {
                override fun shootTarget(martialArtistMob: MartialArtistMob?, mob: Mob): Boolean {
                    return false
                }
            })
    }

    override fun init() {
        super.init()
        setupAI()
    }
}