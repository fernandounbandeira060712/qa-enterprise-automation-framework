package br.com.fernandouchoa.qa.ui.tests;

import br.com.fernandouchoa.qa.utils.TestDataManager;
import org.junit.jupiter.api.Test;

import br.com.fernandouchoa.qa.model.User;
import br.com.fernandouchoa.qa.ui.pages.HomePage;

public class AutomationExerciseHomeTest extends BaseTest {

	@Test
	public void deveRealizarLogin() {

	    User validUser =
	            TestDataManager.getUser("validUser");

	    HomePage homePage =
	            new HomePage(page);

	    homePage.open();

	    homePage.header()
	            .goToLoginPage()
	            .login(validUser);
	}
    
    
}
