package dragonsaga.ui;

import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.engine.network.client.Client;
import necesse.engine.state.MainGame;
import necesse.gfx.forms.Form;
import necesse.gfx.forms.components.FormComponent;
import necesse.gfx.forms.components.FormFlow;
import necesse.gfx.forms.components.localComponents.FormLocalTextButton;
import necesse.gfx.forms.presets.PauseMenuForm;

import net.bytebuddy.asm.Advice;

@ModConstructorPatch(target = PauseMenuForm.class, arguments = {MainGame.class, Client.class})
public class SettingsMenuPatch {

    @Advice.OnMethodExit
    public static void onExit(@Advice.This PauseMenuForm pauseForm) {
        pauseForm.mainForm.setHeight(240);
        
        FormFlow mainFlow = new FormFlow(40);
        pauseForm.mainForm.addComponent(new FormLocalTextButton("ui", "settingstest", 4, mainFlow.next(40), pauseForm.mainForm.getWidth() - 8));
        System.out.println("Exiting pause");
    }
}
