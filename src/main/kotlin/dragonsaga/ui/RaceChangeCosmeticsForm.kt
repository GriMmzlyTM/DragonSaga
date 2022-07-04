package dragonsaga.ui

import necesse.entity.mobs.PlayerMob
import necesse.gfx.forms.Form
import necesse.gfx.forms.components.FormPlayerIcon

class RaceChangeCosmeticsForm(x: Int, y: Int, width: Int, player: PlayerMob) : Form(width, 0) {
    val icon: FormPlayerIcon
    private val _player: PlayerMob

    init {
        this.setPosition(x, y)
        drawBase = false
        _player = player
        icon = this.addComponent(FormPlayerIcon(8, 4, 128, 128, _player))
    }
}