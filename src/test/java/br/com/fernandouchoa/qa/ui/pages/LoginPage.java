package br.com.fernandouchoa.qa.ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import br.com.fernandouchoa.qa.model.User;

public class LoginPage extends BasePage {

    private final Locator emailField;
    private final Locator passwordField;
    private final Locator loginButton;

    public LoginPage(Page page) {

        super(page);

        this.emailField =
                page.locator("input[data-qa='login-email']");

        this.passwordField =
                page.locator("input[data-qa='login-password']");

        this.loginButton =
                page.locator("button[data-qa='login-button']");
    }

    public boolean isLoginPageLoaded() {
        return page.url().contains("/login");
    }

    public LoginPage fillEmail(String email) {

        emailField.fill(email);

        return this;
    }

    public LoginPage fillPassword(String password) {

        passwordField.fill(password);

        return this;
    }

    public HomePage clickLogin() {

        loginButton.click();

        return new HomePage(page);
    }

    public HomePage login(String email, String password) {

        fillEmail(email);
        fillPassword(password);

        return clickLogin();
    }

    public HomePage login(User user) {

        return login(
                user.getEmail(),
                user.getPassword());
    }
}