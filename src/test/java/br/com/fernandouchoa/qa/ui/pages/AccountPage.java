package br.com.fernandouchoa.qa.ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AccountPage extends BasePage {

    private final Locator loggedUser;
    private final Locator logoutButton;

    public AccountPage(Page page) {
        super(page);

        this.loggedUser =
                page.locator("a:has-text('Logged in as')");
        this.logoutButton =
                page.locator("a[href='/logout']");
    }

    public boolean isLoaded() {
        return loggedUser.isVisible();
    }
    
    public LoginPage logout() {

        logoutButton.click();

        return new LoginPage(page);
    }
    
    
}