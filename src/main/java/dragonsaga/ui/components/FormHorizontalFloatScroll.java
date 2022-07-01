package dragonsaga.ui.components;

import necesse.engine.localization.message.GameMessage;
import necesse.engine.localization.message.StaticMessage;
import necesse.gfx.forms.components.FormHorizontalScroll;

public class FormHorizontalFloatScroll extends FormHorizontalScroll<Float> {
    public FormHorizontalFloatScroll(int x, int y, int width, FormHorizontalScroll.DrawOption drawOption, GameMessage text, float value, float minValue, float maxValue) {
        super(x, y, width, drawOption, 0, new FormHorizontalScroll.ScrollElement[0]);
        this.set(text, value, minValue, maxValue);
    }

    public FormHorizontalFloatScroll(int x, int y, int width, FormHorizontalScroll.DrawOption drawOption, String text, float value, float minValue, float maxValue) {
        this(x, y, width, drawOption, new StaticMessage(text), value, minValue, maxValue);
    }

    public void set(GameMessage text, float value, float minValue, float maxValue) {

        int minValueInt = (int)Math.floor(minValue * 10);
        int maxValueInt = (int)Math.floor(maxValue * 10);

        FormHorizontalScroll.ScrollElement<Float>[] data = new FormHorizontalScroll.ScrollElement[maxValueInt - minValueInt + 1];

        for(int i = minValueInt; i <= maxValueInt; ++i) {
            int index = i - minValueInt;
            data[index] = new FormHorizontalScroll.ScrollElement(i / 10f, text);
        }

        this.setData(data);
        this.setElement(new FormHorizontalScroll.ScrollElement(value, text));
    }

    public void set(String text, float value, float minValue, float maxValue) {
        this.set(new StaticMessage(text), value, minValue, maxValue);
    }
}

