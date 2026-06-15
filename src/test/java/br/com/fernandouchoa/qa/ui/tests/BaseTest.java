package br.com.fernandouchoa.qa.ui.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.microsoft.playwright.Page;

import br.com.fernandouchoa.qa.core.factory.PlaywrightFactory;

public class BaseTest {

    protected Page page;

    @BeforeEach
    public void setup() {
        PlaywrightFactory.createInstance();
        page = PlaywrightFactory.getPage();
    }

    @AfterEach
    public void tearDown() {
        PlaywrightFactory.closeInstance();
    }
}