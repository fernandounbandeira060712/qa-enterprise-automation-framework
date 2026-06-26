package br.com.fernandouchoa.qa.ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutPage extends BasePage {

    private final Locator addressDetails;
    private final Locator reviewOrder;
    private final Locator orderItems;

    public CheckoutPage(Page page) {
        super(page);

        this.addressDetails =
                page.locator("#address_delivery");

        this.reviewOrder =
                page.locator("#cart_info");

        this.orderItems =
                page.locator("#cart_info tbody tr");
    }

    public boolean isLoaded() {
        return page.url().contains("/checkout")
                && reviewOrder.isVisible();
    }

    public boolean hasOrderItems() {
        return orderItems.count() > 0;
    }
}