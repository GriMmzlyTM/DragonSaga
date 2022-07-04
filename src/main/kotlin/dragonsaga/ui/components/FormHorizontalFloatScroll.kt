package dragonsaga.ui.components

import necesse.engine.localization.message.GameMessage
import necesse.engine.localization.message.StaticMessage
import necesse.gfx.forms.components.FormHorizontalScroll

class FormHorizontalFloatScroll(x: Int, y: Int, width: Int, drawOption: DrawOption?, text: GameMessage?, value: Float, minValue: Float, maxValue: Float)
    : FormHorizontalScroll<Float>(x, y, width, drawOption, 0, *arrayOfNulls<ScrollElement<Float>>(0)) {

    init {
        this[text, value, minValue] = maxValue
    }

    constructor(x: Int, y: Int, width: Int, drawOption: DrawOption?, text: String?, value: Float, minValue: Float, maxValue: Float)
            : this(x, y, width, drawOption, StaticMessage(text), value, minValue, maxValue) {}

    operator fun set(text: GameMessage?, value: Float, minValue: Float, maxValue: Float) {
        val minValueInt = Math.floor((minValue * 10).toDouble()).toInt()
        val maxValueInt = Math.floor((maxValue * 10).toDouble()).toInt()
        val data: Array<ScrollElement<Float>?> = arrayOfNulls(maxValueInt - minValueInt + 1)

        for (i in minValueInt..maxValueInt) {
            val index = i - minValueInt
            data[index] = ScrollElement<Float>(i / 10f, text)
        }
        setData(data)
        setElement(ScrollElement(value, text))
    }

    operator fun set(text: String?, value: Float, minValue: Float, maxValue: Float) {
        this[StaticMessage(text), value, minValue] = maxValue
    }
}