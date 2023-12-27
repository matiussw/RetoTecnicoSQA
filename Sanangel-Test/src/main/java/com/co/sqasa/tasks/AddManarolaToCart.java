package com.co.sqasa.tasks;

import com.co.sqasa.interactions.Wait;
import com.co.sqasa.userinterfaces.DescriptionProductPage;
import com.co.sqasa.userinterfaces.HeaderPage;
import com.co.sqasa.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class AddManarolaToCart implements Task {

    private int quantify;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(HomePage.MANAROLA_FLOWER_), Wait.theSeconds(3), Enter.keyValues("5").into(DescriptionProductPage.QUANTIFY_INPUT), Click.on(DescriptionProductPage.ADD_CART_BUTTON),
                Click.on(HeaderPage.LOGO_PAGE), Wait.theSeconds(5));
    }

    public static AddManarolaToCart manarolaToCart(int quantify) {
        return Tasks.instrumented(AddManarolaToCart.class, quantify);
    }
}
