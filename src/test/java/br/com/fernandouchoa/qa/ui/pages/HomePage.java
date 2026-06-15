package br.com.fernandouchoa.qa.ui.pages;

import com.microsoft.playwright.Page;

import br.com.fernandouchoa.qa.core.config.EnvironmentManager;
import br.com.fernandouchoa.qa.ui.components.HeaderComponent;

public class HomePage extends BasePage {

    public HomePage(Page page) {
        super(page);
    }

    public HomePage open() {
        navigateTo(EnvironmentManager.getBaseUrl());
        return this;
    }

    public boolean isHomePageLoaded() {
        return page.title().contains("Automation Exercise");
    }
    
    public HeaderComponent header() {
        return new HeaderComponent(page);
    }
    
    
}