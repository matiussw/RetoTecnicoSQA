package com.co.sqasa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    public static final Target PRODUCT_NAME_LABEL = Target.the("Add Cart Button").
            locatedBy("//div[contains(text(),'Manarola')]");
    public static final Target PRODUCT_NAME_LABEL2 = Target.the("Add Cart Button").
            locatedBy("//div[contains(text(),'Riviera')]");



}
