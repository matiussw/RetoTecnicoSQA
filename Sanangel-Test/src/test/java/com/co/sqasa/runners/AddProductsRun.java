package com.co.sqasa.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/agregar_productos.feature",
        glue = "com/co/sqasa/stepdefinitions",
        plugin = { "pretty" },
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class AddProductsRun {
}
