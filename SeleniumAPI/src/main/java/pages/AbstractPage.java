package pages;

import data.Domain;
import data.PageUrl;
import data.UrlPattern;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import wait.StandartWaiter;

/**
 * Base Page Pattern
 *
 * @param <T>
 */
public abstract class AbstractPage<T> {
    protected WebDriver driver = null;
    protected StandartWaiter standartWaiter = null;
    private static Logger log = Logger.getLogger(AbstractPage.class.getName());


    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        standartWaiter = new StandartWaiter(driver);
        PageFactory.initElements(driver, this);
    }


    protected T open() {
        System.out.println(getDomain() + getPagetUrl());
        driver.get(getDomain() + getPagetUrl());

        return (T) this;
    }

    protected T pageShouldBeOpened(){
        Assert.assertThat(driver.getCurrentUrl().substring(getDomain().length()), Matchers.matchesPattern(getUrlPattern()));
        return (T)this;
    };

    private String getUrlPattern(){
        Class<? extends AbstractPage> clazz = getClass();
        if (clazz.isAnnotationPresent(UrlPattern.class)) {
            UrlPattern annotation = clazz.getAnnotation(UrlPattern.class);
            return annotation.value();
        }
        return "";
    }

    private String getPagetUrl() {
        Class<? extends AbstractPage> clazz = getClass();
        if (clazz.isAnnotationPresent(PageUrl.class)) {
            PageUrl annotation = clazz.getAnnotation(PageUrl.class);
            return annotation.value();
        }
        return "";
    }

    private String getDomain() {
        Class<? extends AbstractPage> clazz = getClass();
        if (clazz.isAnnotationPresent(Domain.class)) {
            Domain annotation = clazz.getAnnotation(Domain.class);
            return annotation.value();
        }
        return "";
    }
}
