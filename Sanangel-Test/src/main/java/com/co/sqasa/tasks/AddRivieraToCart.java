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

public class AddRivieraToCart implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(HomePage.RIVIERA_FLOWER_), Enter.keyValues("2").into(DescriptionProductPage.QUANTIFY_INPUT),
                Click.on(DescriptionProductPage.ADD_CART_BUTTON), Wait.theSeconds(5));
    }

    public static AddRivieraToCart rivieraToCart() {
        return Tasks.instrumented(AddRivieraToCart.class);
    }
}
