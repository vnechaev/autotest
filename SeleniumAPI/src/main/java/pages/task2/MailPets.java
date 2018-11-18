package pages.task2;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;

import static org.junit.Assert.assertEquals;

public class MailPets extends AbstractPage<MailPets> {

    private final String url = "https://pets.mail.ru/news/";

    public MailPets(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[./span/div[contains(text(), 'Показать еще')]]")
    private WebElement showMoreButton;

    public MailPets open() {
        return super.open(url);
    }


    protected MailPets pageShouldBeOpened() {
        String actual = driver.getCurrentUrl();
        assertEquals(String.format("Должна быть открыта страница %s", url), url, actual);
        return this;
    }

    public MailPets checkShowMoreButton() {
        standartWaiter.waitForCondition(ExpectedConditions.visibilityOf(showMoreButton));
        Assert.assertTrue("Кнопка Показать еще не отображается", showMoreButton.isDisplayed());
        return this;
    }


}
