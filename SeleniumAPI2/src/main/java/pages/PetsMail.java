package pages;

import data.Domain;
import data.PageUrl;
import data.UrlPattern;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Domain("https://pets.mail.ru")
@PageUrl("/how-to/nyanya-dlya-sobak-i-koshek-kak-podgotovitsya-k-raz/")
@UrlPattern("/")
public class PetsMail extends AbstractPage<PetsMail> {
    @FindBy(xpath = "//time")
    private WebElement dateOfPublish;

    public PetsMail checkExistenceDateOfPublish(){
        Assert.assertTrue("Дата публикации не отображается", dateOfPublish.isEnabled());
        return this;
    }

    public PetsMail(WebDriver driver) {
        super(driver);
    }

    public PetsMail open() {
        super.open();
        return this;
    }
}
