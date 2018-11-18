package main.task1;

import data.BrowsersData;
import drivers.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.task1.Google;

public class GoogleSearchTest {

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
    public void checkResultsOfSearch() {
        new Google(driver)
                .open()
                .setTextToSearch("Hello world")
                .executeSearch()
                .checkCollectoinElementResults()
                .checkResultsNumText();
    }

}
