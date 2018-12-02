package pages;

import data.Domain;
import data.PageUrl;
import data.UrlPattern;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;


@UrlPattern("/")
@Domain("https://pogoda.mail.ru")
@PageUrl("/")
public class PogodaMailMain extends AbstractPage<PogodaMailMain> {
    private final String cityDropdownSelector = "[data-class='pm-dropdown']";
    private String townSearched;

    public PogodaMailMain(WebDriver driver) {
        super(driver);
    }
    public PogodaMailMain open() {
        return super.open();
    }

    @FindBy(xpath = "//button[contains(@class, 'search__button__input')]")
    private WebElement executeSearchButton;

    @FindBy(css = ".pm-toolbar__button__text_dropdown")
    private WebElement toolbarCityButton;

    @FindBy(xpath = "//span[contains(@title, 'Добавить в избран')]")
    private WebElement addToFavorities;

    @FindBy(xpath = "//div[@id = 'portal-menu__toolbar']//span[contains(@class, 'pm-toolbar__button_dropdown')]")
    private WebElement showDropDownistFavorites;

    @FindBy(xpath = "//input[contains(@class, 'search__input')]")
    private WebElement searchTextInput;


    public PogodaMailMain setTownForSearch(String townForSearch) {
        townSearched = townForSearch;
        searchTextInput.sendKeys(townForSearch);
        return this;
    }

    public PogodaMailMain executeSearch(){
        executeSearchButton.click();
        return this;
    }

    public PogodaMailMain showDropDownListFavorites(){
        new Actions(driver)
                .moveToElement(showDropDownistFavorites)
                .build()
                .perform();
        return this;
    }

    public PogodaMailMain addToFavorites() {
        addToFavorities.click();
        return this;
    }

    public PogodaMailMain cityDropDownShouldBeNotPresent(){
        assertTrue("Выпадающее меню города отображается на странице",
                standartWaiter.waitForCondition(ExpectedConditions.not(ExpectedConditions
                        .attributeContains(By.cssSelector(cityDropdownSelector),
                                "class", "toolbar__dropdown_show"))));
        return this;
    }

    public PogodaMailMain moveCursorToCityDropDown() {
        new Actions(driver)
                .moveToElement(toolbarCityButton)
                .build()
                .perform();
        return this;
    }

    public PogodaMailMain checkAddingNewFavouriteTown(){
        Assert.assertTrue("Город, добавленный в изранное, отобразился в выпадающем списке",
                driver
                .findElement(By.xpath(String.format("//span[contains(@class, 'city-select')]/a//span[contains(text(), '%s')]", townSearched)))
                .isEnabled());
        return  this;
    }




}
