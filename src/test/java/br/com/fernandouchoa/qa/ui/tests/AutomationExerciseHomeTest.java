package br.com.fernandouchoa.qa.ui.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.fernandouchoa.qa.ui.pages.HomePage;

public class AutomationExerciseHomeTest extends BaseTest {

    @Test
    public void deveAcessarHomeDoMagentoComSucesso() {

        HomePage homePage = new HomePage(page);

        homePage.open();

        Assertions.assertTrue(
                homePage.isHomePageLoaded(),
                "Home page não foi carregada."
        );
    }
}
