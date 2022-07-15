package dragonsaga.items

import necesse.entity.projectile.Projectile
import necesse.inventory.item.toolItem.projectileToolItem.ProjectileToolItem
import necesse.inventory.item.toolItem.projectileToolItem.gunProjectileToolItem.GunProjectileToolItem

open class KiProjectileToolItem(enchantCost: Int) : ProjectileToolItem(enchantCost) {

    init {
        this.setItemCategory(*arrayOf("dragonsaga", "ki", "ability"))
    }
}