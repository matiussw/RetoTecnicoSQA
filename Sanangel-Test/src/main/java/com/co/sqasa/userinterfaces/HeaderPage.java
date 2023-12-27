package com.co.sqasa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HeaderPage {
    public static final Target CART_BUTTON = Target.the("Cart Button").
            locatedBy("/(//i[@class='fa fa-shopping-bag'])[1]");

    public static final Target LOGO_PAGE = Target.the("Logo Page").
            locatedBy("(//div[@class='header-logo'])[1]");
}
