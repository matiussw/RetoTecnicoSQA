package com.co.sqasa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

import javax.swing.*;

public class DescriptionProductPage {
    public static final Target QUANTIFY_INPUT = Target.the("Quantify Input").
            locatedBy("//input[@type='number']");

    public static final Target ADD_CART_BUTTON = Target.the("Add Cart Button").
            locatedBy("//button[@type='submit']");


    private DescriptionProductPage() {
    }
}
