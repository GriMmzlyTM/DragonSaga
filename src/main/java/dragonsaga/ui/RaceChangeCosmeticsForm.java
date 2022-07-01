package dragonsaga.ui;

import necesse.entity.mobs.PlayerMob;
import necesse.gfx.forms.Form;
import necesse.gfx.forms.components.FormPlayerIcon;

public class RaceChangeCosmeticsForm extends Form {
    public final FormPlayerIcon icon;
    private PlayerMob _player;

    public RaceChangeCosmeticsForm(int x, int y, int width, PlayerMob player) {
        super(width, 0);
        this.setPosition(x, y);
        this.drawBase = false;
        _player = player;

        this.icon = this.addComponent(new FormPlayerIcon(8, 4, 128, 128, _player));
    }
}
