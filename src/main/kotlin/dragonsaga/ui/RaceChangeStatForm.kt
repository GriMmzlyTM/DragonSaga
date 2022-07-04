package dragonsaga.ui

import dragonsaga.ui.components.FormHorizontalFloatScroll
import dragonsaga.ui.models.StatElementData
import necesse.engine.localization.message.LocalMessage
import necesse.gfx.forms.Form
import necesse.gfx.forms.components.FormFlow
import necesse.gfx.forms.components.FormHorizontalScroll.DrawOption
import necesse.gfx.forms.components.FormLabel
import necesse.gfx.forms.components.localComponents.FormLocalLabel
import necesse.gfx.gameFont.FontOptions

class RaceChangeStatForm(x: Int, y: Int, width: Int) : Form(width, 0) {
    private val label: FormLocalLabel
    private val hp: StatElementData
    private val def: StatElementData
    private val atk: StatElementData
    private val ki: StatElementData
    private val spd: StatElementData
    private val scrollX: Int
    private val scrollWidth: Int

    init {
        this.setPosition(x, y)
        drawBase = false
        scrollX = width - 60
        scrollWidth = 50
        val scrollFlow = FormFlow(5)
        label = this.addComponent(FormLocalLabel(LocalMessage("dragonstats", "modifierlabel"), FontOptions(14), FormLabel.ALIGN_MID, width / 2, scrollFlow.next(25)))

        hp = DrawStatElement(LocalMessage("dragonstats", "hp"), scrollFlow)
        def = DrawStatElement(LocalMessage("dragonstats", "def"), scrollFlow)
        atk = DrawStatElement(LocalMessage("dragonstats", "atk"), scrollFlow)
        ki = DrawStatElement(LocalMessage("dragonstats", "ki"), scrollFlow)
        spd = DrawStatElement(LocalMessage("dragonstats", "spd"), scrollFlow)
        scrollFlow.next(5)
        height = scrollFlow.next()
    }

    private fun DrawStatElement(labelMessage: LocalMessage, scrollFlow: FormFlow): StatElementData =
        StatElementData(
            this.addComponent(FormLocalLabel(labelMessage, FontOptions(12), FormLabel.ALIGN_LEFT, 20, scrollFlow.next())),
            this.addComponent(FormHorizontalFloatScroll(scrollX, scrollFlow.next(20), scrollWidth, DrawOption.value, "", 2f, 1f, 3f)))
}