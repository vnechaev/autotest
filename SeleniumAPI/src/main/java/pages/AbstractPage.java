package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import wait.StandartWaiter;

/**
 * Base Page Pattern
 * @param <T>
 */
public abstract class AbstractPage<T> {

    protected WebDriver driver = null;
    protected StandartWaiter standartWaiter = null;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        standartWaiter = new StandartWaiter(driver);
        PageFactory.initElements(driver, this);
    }


    protected T open(String url) {
        driver.get(url);
        return (T) this;
    }

    protected T open(String urlTemplate, String... parameters) {
        String url = "";

        for(int i = 0; i < parameters.length; i++) {
            url = urlTemplate.replace("%" + (i + 1), parameters[i]);
        }

        driver.get(url);
        return (T) this;
    }

    protected abstract T pageShouldBeOpened();
}
