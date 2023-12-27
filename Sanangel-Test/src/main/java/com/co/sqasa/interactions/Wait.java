package com.co.sqasa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class Wait implements Interaction {

    private int waitValue;

    public Wait(int waitValue) {
        this.waitValue = waitValue;
    }

    public static Wait theSeconds(int waitValue) {
        return Tasks.instrumented(Wait.class, waitValue);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(waitValue * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}