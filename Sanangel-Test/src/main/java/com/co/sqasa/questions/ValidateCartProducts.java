package com.co.sqasa.questions;

import com.co.sqasa.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateCartProducts implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return CartPage.PRODUCT_NAME_LABEL.resolveFor(actor).isPresent();
    }
    public static ValidateCartProducts cartProducts(){
        return new ValidateCartProducts();
    }
}
