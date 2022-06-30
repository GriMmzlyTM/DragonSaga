package dragonsaga.ui.patches.maingameformmanager;

import dragonsaga.ui.RaceChangeMenuForm;
import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.gfx.forms.Form;
import necesse.gfx.forms.MainGameFormManager;
import net.bytebuddy.asm.Advice;

@ModMethodPatch(target = MainGameFormManager.class, name = "setup", arguments = {})
public class MainGameFormManagerSetupPatch {

    public static Form RaceChangeForm;

    @Advice.OnMethodExit
    public static void onExit(@Advice.This MainGameFormManager mainGameForm) {
        RaceChangeForm = mainGameForm.addComponent(new RaceChangeMenuForm("Race Change Form"));
        RaceChangeForm.setHidden(false);
    }
}
