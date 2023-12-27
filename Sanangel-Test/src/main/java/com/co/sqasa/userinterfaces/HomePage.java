package com.co.sqasa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {
    public static final Target RIVIERA_FLOWER_ = Target.the("Viviera Flower").
            locatedBy("//h2[contains(text(),'Riviera')]");
    public static final Target MANAROLA_FLOWER_ = Target.the("Marola Flower").
            locatedBy("//h2[contains(text(),'Manarola')]");

    private HomePage() {
    }
}
