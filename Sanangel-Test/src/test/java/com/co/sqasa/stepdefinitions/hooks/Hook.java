package com.co.sqasa.stepdefinitions.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hook {
    @Managed(driver = "chrome")
    WebDriver hisdriver;

    @Before
    public void setSeleniumGrid() throws MalformedURLException {

        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("User");
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--allow-file-access");
        options.addArguments("--use-fake-ui-for-media-stream");
        options.addArguments("--use-fake-device-for-media-stream");
        options.addArguments("--disable-smooth-scrolling");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-download-notification");
        options.addArguments("--start-maximized");
        options.addArguments("--test-type");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--ignore-urlfetcher-cert-requests");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--always-authorize-plugins");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-translate");
        options.addArguments("--no-sandbox");

        hisdriver=new RemoteWebDriver(new URL("http://localhost:4844"), options);
        theActorInTheSpotlight().can(BrowseTheWeb.with(hisdriver));
    }

    @After
    public void quitDriver() {
        hisdriver.quit();
    }
}

