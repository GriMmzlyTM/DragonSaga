package dragonsaga.ui;

import dragonsaga.ui.components.FormHorizontalFloatScroll;
import dragonsaga.ui.models.StatElementData;
import necesse.engine.localization.message.LocalMessage;
import necesse.gfx.forms.Form;
import necesse.gfx.forms.components.*;
import necesse.gfx.forms.components.localComponents.FormLocalLabel;
import necesse.gfx.gameFont.FontOptions;

public class RaceChangeStatForm extends Form {

    private FormLocalLabel label;
    private StatElementData hp;
    private StatElementData def;
    private StatElementData atk;
    private StatElementData ki;
    private StatElementData spd;

    private int scrollX;
    private int scrollWidth;

    public RaceChangeStatForm(int x, int y, int width) {
        super(width, 0);
        this.setPosition(x, y);
        this.drawBase = false;
        this.scrollX = width - 60;
        this.scrollWidth = 50;

        FormFlow scrollFlow = new FormFlow(5);

        this.label = this.addComponent(new FormLocalLabel(new LocalMessage("dragonstats", "modifierlabel"), new FontOptions(14), FormLabel.ALIGN_MID, width/2, scrollFlow.next(25)));

        this.hp = DrawStatElement(new LocalMessage("dragonstats", "hp"), scrollFlow);
        this.def = DrawStatElement(new LocalMessage("dragonstats", "def"), scrollFlow);
        this.atk = DrawStatElement(new LocalMessage("dragonstats", "atk"), scrollFlow);
        this.ki = DrawStatElement(new LocalMessage("dragonstats", "ki"), scrollFlow);
        this.spd = DrawStatElement(new LocalMessage("dragonstats", "spd"), scrollFlow);

        scrollFlow.next(5);

        this.setHeight(scrollFlow.next());

    }

    private StatElementData DrawStatElement(LocalMessage labelMessage, FormFlow scrollFlow) {
        StatElementData data = new StatElementData();
        data.label = this.addComponent(new FormLocalLabel(labelMessage, new FontOptions(12), FormLabel.ALIGN_LEFT, 20, scrollFlow.next()));
        data.value = this.addComponent(new FormHorizontalFloatScroll(scrollX, scrollFlow.next(20), scrollWidth, FormHorizontalScroll.DrawOption.value, "", 2, 1, 3));
        return data;
    }
}
