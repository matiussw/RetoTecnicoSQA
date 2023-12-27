package com.co.sqasa.stepdefinitions;

import com.co.sqasa.questions.ValidateCartProducts;
import com.co.sqasa.tasks.AddManarolaToCart;
import com.co.sqasa.tasks.AddRivieraToCart;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AddProductsStepDefinition {
    @Given("Estoy Dentro del Portal Web {string}")
    public void estoyDentroDelPortalWeb(String url) {
        theActorInTheSpotlight().wasAbleTo(Open.url(url));
    }

    @When("Seleciono Productos de Mi Agrado y Agrego {int} Cantidades de un producto y {int} Cantidades de otro")
    public void selecionoProductosDeMiAgradoYAgregoCantidadesDeUnProductoYCantidadesDeOtro(Integer int1, Integer int2) {
        theActorInTheSpotlight().attemptsTo(AddManarolaToCart.manarolaToCart(int1), AddRivieraToCart.rivieraToCart());
    }

    @Then("Puedo ver los  Productos Agregados {string} Y {string} Con Su respectiva cantidad")
    public void puedoVerLosProductosAgregadosYConSuRespectivaCantidad(String string, String string2) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateCartProducts.cartProducts(), Matchers.is(true)));
    }

}
