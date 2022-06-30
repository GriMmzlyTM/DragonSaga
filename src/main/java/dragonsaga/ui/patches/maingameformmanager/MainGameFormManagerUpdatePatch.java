package dragonsaga.ui.patches.maingameformmanager;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.gfx.forms.MainGameFormManager;
import net.bytebuddy.asm.Advice;

@ModMethodPatch(target = MainGameFormManager.class, name = "updateActive", arguments = { boolean.class })
public class MainGameFormManagerUpdatePatch {

    @Advice.OnMethodExit
    public static void onExit(@Advice.This MainGameFormManagerUpdatePatch mainGameForm, @Advice.Argument(0) boolean forceUpdate) {

    }
}
