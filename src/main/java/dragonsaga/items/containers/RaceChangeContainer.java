package dragonsaga.items.containers;

import necesse.engine.network.NetworkClient;
import necesse.inventory.container.Container;
import necesse.inventory.container.customAction.BooleanCustomAction;
import necesse.inventory.container.customAction.EmptyCustomAction;
import necesse.inventory.container.customAction.IntCustomAction;

public class RaceChangeContainer extends Container {

    BooleanCustomAction boolTest;
    IntCustomAction intTest;
    EmptyCustomAction emptyTest;

    boolean booleanValue;
    int intValue;

    public RaceChangeContainer(NetworkClient client, int uniqueSeed) {
        super(client, uniqueSeed);

        this.boolTest = this.registerAction(new BooleanCustomAction() {
            @Override
            protected void run(boolean b) {
                booleanValue = b;
            }
        });

        this.intTest = this.registerAction(new IntCustomAction() {
            @Override
            protected void run(int i) {
                intValue = i;
            }
        });

        this.emptyTest = this.registerAction(new EmptyCustomAction() {
            @Override
            protected void run() {

            }
        });

    }
}
