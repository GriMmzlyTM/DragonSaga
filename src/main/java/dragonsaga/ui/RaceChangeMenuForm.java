package dragonsaga.ui;

import dragonsaga.items.containers.RaceChangeContainer;
import necesse.engine.Screen;
import necesse.engine.network.client.Client;
import necesse.engine.registries.ContainerRegistry;
import necesse.entity.mobs.PlayerMob;
import necesse.gfx.forms.Form;
import necesse.gfx.forms.components.FormComponent;
import necesse.gfx.forms.components.FormFlow;
import necesse.gfx.forms.presets.containerComponent.ContainerForm;

public class RaceChangeMenuForm extends ContainerForm<RaceChangeContainer> {

    public static RaceChangeMenuForm Instance;
    private RaceChangeStatForm dragonStatForm;

    public RaceChangeMenuForm(Client client, RaceChangeContainer container) {
        super(client, 300, 0, container);
        Instance = this;
        this.setDefaultPos();

        int statFormWidth = 120;
        int cosmeticsFormWidth = 120;

        FormFlow flow = new FormFlow();
        this.dragonStatForm = (RaceChangeStatForm)this.addComponent((FormComponent)flow.next(new RaceChangeStatForm(this.getWidth() - statFormWidth, 0, statFormWidth), 5));
        this.setHeight(flow.next() + 100);

    }
    public void setDefaultPos() {
        this.setPosMiddle(Screen.getHudWidth() / 2, (Screen.getHudHeight() / 2) + 25);
    }
}
