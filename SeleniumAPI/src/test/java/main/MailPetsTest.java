package main;

import data.BrowsersData;
import drivers.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MailPets;

public class MailPetsTest {

    private WebDriver driver = null;

    @Before
    public void init() {
        driver = WebDriverFactory.getWebDriverInstance(BrowsersData.Chrome);
    }

    @After
    public void killSession() {
        driver.close();
        driver.quit();
    }

    @Test
    public void checkShowMoreButton() {
        new MailPets(driver)
                .open()
                .checkShowMoreButton();
    }

}
