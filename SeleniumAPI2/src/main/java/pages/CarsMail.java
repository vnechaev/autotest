package pages;

import data.Domain;
import data.PageUrl;
import data.UrlPattern;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;

@UrlPattern("/")
@Domain("https://auto.mail.ru")
@PageUrl("/catalog/ford/focus/iii_restailing/sedan/")
public class CarsMail extends AbstractPage<CarsMail> {
    private String parametr;

    private final String popup = "//div[contains(@class,'popup__wrapper')]";

    public CarsMail(WebDriver driver) {
        super(driver);
    }

    public CarsMail open() {
        super.open();
        return this;
    }

    @FindBy(xpath = "//a[@data-type-tag = 'plus']")
    private WebElement plusElement;

    @FindBy(xpath = "//div[contains(@class,'popup__wrapper')]/div/span[contains(@class, 'text')]")
    private WebElement popupHeader;

    @FindBy(xpath = "//span[contains(@class,'popup__close')]")
    private WebElement closePopup;


    public CarsMail showFirstPlus() {
        plusElement.click();
        parametr = plusElement.findElement(By.xpath("//span[contains(@class, 'link__text margin_right_5')]")).getText();
        return this;
    }

    public CarsMail checkPopupIsPresent() {
        assertTrue("Popup не появился",
                standartWaiter.waitForCondition(
                        ExpectedConditions
                                .visibilityOf(driver.findElement(By.xpath(popup))
                                )));
        return this;
    }

    public CarsMail checkPopupIsNotPresent() {
        assertTrue("Popup присутствует после закрытия",
                standartWaiter.waitForCondition(
                        not(ExpectedConditions
                                .visibilityOf(driver.findElement(By.xpath(popup))))
                ));
        return this;
    }

    public CarsMail checkPopupTitleContainsPlusText() {
//        Assert.assertThat(popupHeader.getText(), Matchers.matchesPattern(parametr +"\\s\\W*"));
        Assert.assertTrue("Заголовок popup не содержит названия параметра " + parametr,
                popupHeader.getText().contains(parametr));
        return this;
    }

    public CarsMail closePopup() {
        closePopup.click();
        return this;
    }
}
