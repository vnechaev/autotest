package pages.task3;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;

import java.util.List;
import java.util.stream.Collectors;

public class NameSecret extends AbstractPage<NameSecret> {

    private final String url = "https://horo.mail.ru/namesecret/";

    public NameSecret(WebDriver driver) {
        super(driver);
    }

    public NameSecret open() {
        return super.open(url);
    }

    @FindBy(xpath = "//button[./span/div[contains(text(), 'Узнать тайну имени')]]")
    private WebElement discoverNameSecret;

    @FindBy(xpath = "//input[./ancestor::div[./div[contains(text(), 'Имя')]]]")
    private WebElement nameTextInput;

    @FindBy(xpath = "//div[contains(@class, 'dropdown') and contains(text(), 'Все')]")
    private WebElement openDropDownSelect;

    @FindBy(xpath = "//div[./div[@class = 'newsitem__params']]")
    private WebElement searchResult;


    protected NameSecret pageShouldBeOpened() {
        return null;
    }

    public NameSecret fillNameForSearch(String name) {
        nameTextInput.sendKeys(name);
        return this;
    }


    public NameSecret doSearchByLetter(String letterUpperCase) {
        driver.findElements(By.cssSelector(".filter__text")).stream()
                .filter(elem -> elem.getText().equals(letterUpperCase))
                .findFirst().get().click();
        return this;
    }

    public NameSecret checkAlphaBetaFilter(String letterUpperCase) {
        List<String> valueList = driver.findElements(By.xpath("//div[@class='p-terms-list']//span[@class = 'link__text']")).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        for (String value : valueList) {
            Assert.assertTrue(
                    String.format("Результат применения фильтра по букве %s оказался некорректным, найдено имя %s", letterUpperCase, value),
                    value.contains(letterUpperCase));
        }
        return this;
    }

    public int getResultNum() {
        standartWaiter.waitForCondition(ExpectedConditions.visibilityOf(searchResult));
        return driver.findElements(By.xpath("//div[./div[@class = 'newsitem__params']]")).size();
    }

    public int getSexFilteredResultFromNotFiltered(Sex sex) {
        standartWaiter.waitForCondition(ExpectedConditions.visibilityOf(searchResult));
        return (int)driver.findElements(By.xpath("//span[@class='newsitem__param']")).stream()
                .filter(elem -> elem.getText().equals(sex.getResultNameType())).count();
    }

    public NameSecret selectSex(Sex sex) {
        openDropDownSelect.click();
        driver.findElement(By.xpath(String.format("//div[contains(text(), '%s')]", sex.getSearchTypeSex()))).click();
        return this;
    }

    public NameSecret executeSearch() {
        discoverNameSecret.click();
        return this;
    }

}
