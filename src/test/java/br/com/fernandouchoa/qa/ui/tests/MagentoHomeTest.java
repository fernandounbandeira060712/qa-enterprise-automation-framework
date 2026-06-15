package br.com.fernandouchoa.qa.ui.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MagentoHomeTest extends BaseTest {

    @Test
    public void deveAcessarHomeDoMagentoComSucesso() {

        page.navigate("https://magento.softwaretestingboard.com/");

        Assertions.assertTrue(
                page.url().contains("magento.softwaretestingboard.com"),
                "A URL da página não corresponde ao esperado."
        );
    }
}
