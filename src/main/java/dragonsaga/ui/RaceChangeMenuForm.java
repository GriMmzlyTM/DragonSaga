package dragonsaga.ui;

import necesse.engine.Screen;
import necesse.gfx.forms.Form;
import necesse.gfx.forms.components.FormComponent;
import necesse.gfx.forms.components.FormFlow;

public class RaceChangeMenuForm extends Form {
    private RaceChangeStatForm dragonStatForm;
    public RaceChangeMenuForm(String name) {
        super(name, 300, 0);
        this.setDefaultPos();

        int statFormWidth = 150;

        FormFlow flow = new FormFlow();
        this.dragonStatForm = (RaceChangeStatForm)this.addComponent((FormComponent)flow.next(new RaceChangeStatForm(this.getWidth() - statFormWidth, 0, statFormWidth), 5));
        this.setHeight(flow.next() + 100);
    }
    public void setDefaultPos() {
        this.setPosMiddle(Screen.getHudWidth() / 2, (Screen.getHudHeight() / 2) + 25);
    }
}
