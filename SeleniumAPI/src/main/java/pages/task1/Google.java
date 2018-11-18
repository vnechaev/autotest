package pages.task1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

import java.util.List;

import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

public class Google extends AbstractPage<Google> {

    private final String url = "https://www.google.ru/";

    public Google(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@title='Поиск']")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@value='Поиск в Google']")
    private WebElement executeSearch;

    @FindBy(xpath = "//div[@id = 'resultStats']")
    private WebElement resultQuantityText;

    @FindBy(xpath = "//*[@data-base-uri]")
    private List<WebElement> resultCollection;

    public Google open() {
        return super.open(url);
    }

    public Google pageShouldBeOpened() {
        String actual = driver.getCurrentUrl();
        assertEquals(String.format("Должна быть открыта страница %s", url), url, actual);
        return this;
    }

    public Google setTextToSearch(String text) {
        searchInput.sendKeys(text);
        return this;
    }

    public Google executeSearch() {
        executeSearch.click();
        return this;
    }

    public Google checkCollectoinElementResults() {
        assertNotEquals("Количество элементов для поиска неверно", 0, resultCollection.size());
        return this;
    }

    public Google checkResultsNumText() {
        /*
        При отсутствии результатов поиска(результатов поиска 0) используются другие html элементы,
        фраза "Результатов поиска 0" не используется
        */
        assertTrue("Строка с упомнинанием количества результатов отсутствует", resultQuantityText.isDisplayed());
        return this;
    }
}
