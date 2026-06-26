package br.com.fernandouchoa.qa.ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import br.com.fernandouchoa.qa.model.User;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

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

    @Step("Validar se página de Login foi carregada")
    public boolean isLoginPageLoaded() {
        return page.url().contains("/login");
    }

    @Step("Preencher email do usuário")
    public LoginPage fillEmail(String email) {
        emailField.fill(email);
        return this;
    }

    @Step("Preencher senha do usuário")
    public LoginPage fillPassword(String password) {
        passwordField.fill(password);
        return this;
    }

    @Step("Clicar no botão Login")
    public LoginPage clickLogin() {
        loginButton.click();
        return this;
    }

    @Step("Realizar tentativa de login com usuário inválido")
    public LoginPage login(User user) {

        Allure.parameter("Email utilizado", user.getEmail());

        emailField.fill(user.getEmail());
        passwordField.fill(user.getPassword());
        loginButton.click();

        return this;
    }

    @Step("Realizar login com usuário válido")
    public AccountPage loginSuccessfully(User user) {

        Allure.parameter("Email utilizado", user.getEmail());

        emailField.fill(user.getEmail());
        passwordField.fill(user.getPassword());
        loginButton.click();

        return new AccountPage(page);
    }

    @Step("Validar mensagem de login inválido")
    public boolean isInvalidLoginMessageDisplayed() {
        return loginErrorMessage.isVisible();
    }
}