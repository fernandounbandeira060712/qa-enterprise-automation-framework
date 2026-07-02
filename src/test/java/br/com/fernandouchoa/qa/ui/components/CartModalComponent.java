package br.com.fernandouchoa.qa.ui.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import br.com.fernandouchoa.qa.ui.pages.CartPage;
import br.com.fernandouchoa.qa.utils.WaitUtils;
import io.qameta.allure.Step;

public class CartModalComponent {

    private final Page page;

    private final Locator modal;
    private final Locator continueShoppingButton;
    private final Locator viewCartButton;

    public CartModalComponent(Page page) {
        this.page = page;

        this.modal =
                page.locator("#cartModal");

        this.continueShoppingButton =
                page.locator(".close-modal");

        this.viewCartButton =
                page.locator("#cartModal a[href='/view_cart']");
    }

    @Step("Validar se o modal de produto adicionado foi exibido")
    public boolean isDisplayed() {
        return WaitUtils.isVisible(modal);
    }

    @Step("Continuar comprando")
    public void continueShopping() {
        WaitUtils.click(continueShoppingButton);
    }

    @Step("Visualizar carrinho pelo modal")
    public CartPage viewCart() {
        WaitUtils.click(viewCartButton);
        return new CartPage(page);
    }

    @Step("Aguardar modal de produto adicionado")
    public CartModalComponent waitUntilDisplayed() {
        page.waitForSelector("#cartModal",
                new Page.WaitForSelectorOptions()
                        .setState(WaitForSelectorState.VISIBLE));

        return this;
    }
}