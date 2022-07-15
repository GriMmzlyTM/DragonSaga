package dragonsaga.items.abilities

import dragonsaga.items.KiProjectileToolItem
import dragonsaga.items.abilities.projectiles.KiBeamProjectile
import necesse.engine.network.PacketReader
import necesse.engine.network.packet.PacketSpawnProjectile
import necesse.engine.util.GameRandom
import necesse.entity.mobs.GameDamage
import necesse.entity.mobs.PlayerMob
import necesse.entity.projectile.Projectile
import necesse.gfx.gameTooltips.ListGameTooltips
import necesse.inventory.InventoryItem
import necesse.inventory.PlayerInventorySlot
import necesse.inventory.item.bulletItem.BulletItem
import necesse.level.maps.Level

class KamehamehaAbility : KiProjectileToolItem(0) {

    init {
        rarity = Rarity.UNIQUE;
        animSpeed = 500;
        attackDmg = GameDamage(GameDamage.DamageType.RANGED, 5F);
        knockback = 2;
        attackRange = 1000;
        cooldown = 0
        velocity = 200
        attackYOffset = 14
        attackXOffset = 12
        addGlobalIngredient(*arrayOf("bulletuser"))

    }

    override fun getTooltips(item: InventoryItem?, perspective: PlayerMob?): ListGameTooltips? {
        val tooltips = super.getTooltips(item, perspective)
        tooltips.add(getAttackDamageTip(item, perspective))
        tooltips.add(getAttackSpeedTip(item, perspective))
        addCritChanceTip(tooltips, item, perspective)
        return tooltips
    }

    override fun onAttack(level: Level, x: Int, y: Int, player: PlayerMob, attackHeight: Int, item: InventoryItem?, slot: PlayerInventorySlot?, animAttack: Int, seed: Int, contentReader: PacketReader?): InventoryItem {
        val kiBeam = KiBeamProjectile(player.x, player.y, x.toFloat(), y.toFloat(), getAttackRange(item), getVelocity(item, player), getDamage(item), getKnockback(item, player), player, level)

        kiBeam.resetUniqueID(GameRandom(seed.toLong()))
        level!!.entityManager.projectiles.addHidden(kiBeam)
        if (level.isServerLevel) {
            level.server.network.sendToClientsAtExcept(
                PacketSpawnProjectile(kiBeam),
                player!!.serverClient,
                player.serverClient
            )
        }

        return item!!
    }


}