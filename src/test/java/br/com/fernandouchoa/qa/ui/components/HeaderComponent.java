package br.com.fernandouchoa.qa.ui.components;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;

import br.com.fernandouchoa.qa.core.config.EnvironmentManager;
import br.com.fernandouchoa.qa.ui.pages.CartPage;
import br.com.fernandouchoa.qa.ui.pages.LoginPage;
import br.com.fernandouchoa.qa.ui.pages.ProductsPage;
import br.com.fernandouchoa.qa.utils.WaitUtils;
import io.qameta.allure.Step;

public class HeaderComponent {

    private final Page page;

    public HeaderComponent(Page page) {
        this.page = page;
    }

    @Step("Acessar página de Login")
    public LoginPage goToLoginPage() {
        page.navigate(
                EnvironmentManager.getBaseUrl() + "login",
                new Page.NavigateOptions()
                        .setWaitUntil(WaitUntilState.DOMCONTENTLOADED)
        );

        WaitUtils.waitForPageLoad(page);

        return new LoginPage(page);
    }

    @Step("Acessar página de Produtos")
    public ProductsPage goToProductsPage() {
        page.navigate(
                EnvironmentManager.getBaseUrl() + "products",
                new Page.NavigateOptions()
                        .setWaitUntil(WaitUntilState.DOMCONTENTLOADED)
        );

        WaitUtils.waitForPageLoad(page);

        return new ProductsPage(page);
    }

    @Step("Acessar página do Carrinho")
    public CartPage goToCartPage() {
        page.navigate(
                EnvironmentManager.getBaseUrl() + "view_cart",
                new Page.NavigateOptions()
                        .setWaitUntil(WaitUntilState.DOMCONTENTLOADED)
        );

        WaitUtils.waitForPageLoad(page);

        return new CartPage(page);
    }
}