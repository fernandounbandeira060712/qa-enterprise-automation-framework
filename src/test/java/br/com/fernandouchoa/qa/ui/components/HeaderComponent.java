package br.com.fernandouchoa.qa.ui.components;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;

import br.com.fernandouchoa.qa.core.config.EnvironmentManager;
import br.com.fernandouchoa.qa.ui.pages.CartPage;
import br.com.fernandouchoa.qa.ui.pages.LoginPage;
import br.com.fernandouchoa.qa.ui.pages.ProductsPage;

public class HeaderComponent {

    private final Page page;

    public HeaderComponent(Page page) {
        this.page = page;
    }

    public LoginPage goToLoginPage() {
        page.navigate(
                EnvironmentManager.getBaseUrl() + "login",
                new Page.NavigateOptions()
                        .setWaitUntil(WaitUntilState.DOMCONTENTLOADED)
        );

        return new LoginPage(page);
    }

    public ProductsPage goToProductsPage() {
        page.navigate(
                EnvironmentManager.getBaseUrl() + "products",
                new Page.NavigateOptions()
                        .setWaitUntil(WaitUntilState.DOMCONTENTLOADED)
        );

        return new ProductsPage(page);
    }

    public CartPage goToCartPage() {
        page.navigate(
                EnvironmentManager.getBaseUrl() + "view_cart",
                new Page.NavigateOptions()
                        .setWaitUntil(WaitUntilState.DOMCONTENTLOADED)
        );

        return new CartPage(page);
    }
}