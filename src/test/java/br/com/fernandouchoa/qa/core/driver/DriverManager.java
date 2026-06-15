package br.com.fernandouchoa.qa.core.driver;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public final class DriverManager {

    private static final ThreadLocal<Page> PAGE = new ThreadLocal<>();
    private static final ThreadLocal<Browser> BROWSER = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> CONTEXT = new ThreadLocal<>();
    private static final ThreadLocal<Playwright> PLAYWRIGHT = new ThreadLocal<>();

    private DriverManager() {
    }

    public static Page getPage() {
        return PAGE.get();
    }

    public static void setPage(Page page) {
        PAGE.set(page);
    }

    public static Browser getBrowser() {
        return BROWSER.get();
    }

    public static void setBrowser(Browser browser) {
        BROWSER.set(browser);
    }

    public static BrowserContext getContext() {
        return CONTEXT.get();
    }

    public static void setContext(BrowserContext context) {
        CONTEXT.set(context);
    }

    public static Playwright getPlaywright() {
        return PLAYWRIGHT.get();
    }

    public static void setPlaywright(Playwright playwright) {
        PLAYWRIGHT.set(playwright);
    }

    public static void unload() {
        PAGE.remove();
        CONTEXT.remove();
        BROWSER.remove();
        PLAYWRIGHT.remove();
    }
}