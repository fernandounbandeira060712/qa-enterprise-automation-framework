package br.com.fernandouchoa.qa.ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import br.com.fernandouchoa.qa.model.User;

public class LoginPage extends BasePage {

    private final Locator emailField;
    private final Locator passwordField;
    private final Locator loginButton;
    private final Locator loginErrorMessage;

    public LoginPage(Page page) {

        super(page);

        this.emailField =
                page.locator("input[data-qa='login-email']");

        this.passwordField =
                page.locator("input[data-qa='login-password']");

        this.loginButton =
                page.locator("button[data-qa='login-button']");

        this.loginErrorMessage =
                page.locator("p:has-text('Your email or password is incorrect!')");
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

    public LoginPage clickLogin() {
        loginButton.click();
        return this;
    }

    public LoginPage login(User user) {
        fillEmail(user.getEmail());
        fillPassword(user.getPassword());
        clickLogin();
        return this;
    }

    public AccountPage loginSuccessfully(User user) {
        fillEmail(user.getEmail());
        fillPassword(user.getPassword());
        loginButton.click();
        return new AccountPage(page);
    }

    public boolean isInvalidLoginMessageDisplayed() {
        return loginErrorMessage.isVisible();
    }
}