package dragonsaga.ui

import dragonsaga.items.containers.RaceChangeContainer
import dragonsaga.registry.RaceEnum
import necesse.engine.Screen
import necesse.engine.network.client.Client
import necesse.gfx.forms.components.FormButton
import necesse.gfx.forms.components.FormComponent
import necesse.gfx.forms.components.FormFlow
import necesse.gfx.forms.components.FormInputSize
import necesse.gfx.forms.components.localComponents.FormLocalTextButton
import necesse.gfx.forms.events.FormInputEvent
import necesse.gfx.forms.presets.containerComponent.ContainerForm
import necesse.gfx.ui.ButtonColor

class RaceChangeMenuForm(client: Client?, container: RaceChangeContainer) :
    ContainerForm<RaceChangeContainer?>(client, 300, 0, container) {
    private val dragonStatForm: RaceChangeStatForm
    private val _changeRaceButton: FormLocalTextButton

    init {
        setDefaultPos()
        val statFormWidth = 120
        val cosmeticsFormWidth = 120
        val flow = FormFlow()
        dragonStatForm = this.addComponent(flow.next(RaceChangeStatForm(width - statFormWidth, 0, statFormWidth), 5) as FormComponent) as RaceChangeStatForm
        height = flow.next() + 100

        _changeRaceButton = addComponent(
            FormLocalTextButton(
                "ui",
                "mageconfirm",
                10,
                height / 2,
                100,
                FormInputSize.SIZE_16,
                ButtonColor.BASE
            )
        )
        _changeRaceButton.onClicked { e: FormInputEvent<FormButton?>? -> container.playerRaceButton.runAndSend(RaceEnum.HUMAN_GUARDIAN) }
    }

    override fun setDefaultPos() {
        setPosMiddle(Screen.getHudWidth() / 2, Screen.getHudHeight() / 2 + 25)
    }
}