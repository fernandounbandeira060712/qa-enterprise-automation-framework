package br.com.fernandouchoa.qa.ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import br.com.fernandouchoa.qa.core.config.EnvironmentManager;
import br.com.fernandouchoa.qa.ui.components.CartModalComponent;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class ProductsPage extends BasePage {

    private final Locator productsSection;
    private final Locator searchInput;
    private final Locator searchButton;
    private final Locator productCards;

    public ProductsPage(Page page) {
        super(page);

        this.productsSection =
                page.locator(".features_items");

        this.searchInput =
                page.locator("#search_product");

        this.searchButton =
                page.locator("#submit_search");

        this.productCards =
                page.locator(".product-image-wrapper");
    }
    
    @Step("Adicionar produto ao carrinho")
    public CartModalComponent addProductToCartById(String productId) {

        Allure.parameter("ID do produto", productId);

        page.locator(".productinfo a[data-product-id='" + productId + "']")
                .click();

        page.waitForSelector("#cartModal",
                new Page.WaitForSelectorOptions()
                        .setState(WaitForSelectorState.VISIBLE));

        return new CartModalComponent(page);
    }
    
    @Step("Visualizar detalhes do produto")
    public ProductDetailsPage viewProductById(String productId) {

        Allure.parameter("ID do produto", productId);

        page.navigate(EnvironmentManager.getBaseUrl() + "product_details/" + productId);

        return new ProductDetailsPage(page);
    }

    @Step("Validar se a página de produtos foi carregada")
    public boolean isLoaded() {
        return productsSection.isVisible();
    }

    @Step("Pesquisar produto: {productName}")
    public ProductsPage searchProduct(String productName) {
        searchInput.fill(productName);
        searchButton.click();
        page.waitForSelector(".product-image-wrapper");
        return this;
    }

    @Step("Validar se existem produtos exibidos")
    public boolean hasProductsDisplayed() {
        return productCards.count() > 0;
    }

    @Step("Capturar quantidade de produtos exibidos")
    public int getProductsCount() {
        return productCards.count();
    }

}