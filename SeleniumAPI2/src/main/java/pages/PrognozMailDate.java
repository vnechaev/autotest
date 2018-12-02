package pages;

import data.Domain;
import data.Months;
import data.PageUrl;
import data.UrlPattern;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;


@UrlPattern("/")
@Domain("https://pogoda.mail.ru")
@PageUrl("/prognoz/easter_island/10-june/#2015")
public class PrognozMailDate extends AbstractPage<PrognozMailDate> {

    @FindBy(xpath = "//div[contains(text(), 'Календарь')]")
    private WebElement calendar;

    @FindBy(xpath = "//span[contains(@class, 'calendar__month')]")
    private WebElement calendarMonth;

    @FindBy(xpath = "//span[contains(@class, 'calendar__control_prev')]")
    private WebElement monthPrevious;

    @FindBy(xpath = "//span[contains(@class, 'calendar__control_next')]")
    private WebElement monthNext;

    @FindBy(xpath = "//div[contains(@class, 'heading heading_minor heading_line')]")
    private List<WebElement> historyWeatherResultList;


    public PrognozMailDate(WebDriver driver) {
        super(driver);
    }

    public PrognozMailDate open() {
        super.open();
        return this;
    }

    public PrognozMailDate openCalendar() {
        calendar.click();
        return this;
    }

    public PrognozMailDate goToPreviousMonth() {
        monthPrevious.click();
        return this;
    }

    public PrognozMailDate goToNextMonth() {
        monthNext.click();
        return this;
    }

    public PrognozMailDate drillDownToDay(int dayNum) {
        driver.findElement(By.xpath(String.format("//table[contains(@class, 'calendar')]//a[text() = '%d']", dayNum)))
                .click();
        return this;
    }

    public PrognozMailDate checkMonthInCalendar(Months month) {
        Assert.assertEquals("Неверный месяц в календаре", month.getMonth(), calendarMonth.getText());
        return this;
    }

    public PrognozMailDate checkWeatherHistoryForTheDay(Months month, int day) {
        String monthWithoutEnding = month.getMonth().substring(0, month.getMonth().length() - 1).toUpperCase();
        String regex = day + "\\s" + monthWithoutEnding + "\\W*\\s\\d{4}";
        Assert.assertTrue("Отображается неверная исторя по месяцу/дню," +
                        "\nрегулярное выражение:\n" + regex +
                        "\nЗначение заголовков:\n" +
                        historyWeatherResultList
                                .stream()
                                .map(WebElement::getText)
                                .collect(Collectors.joining("\n")),
                historyWeatherResultList.stream()
                        .map(WebElement::getText)
                        .allMatch(elem -> elem.matches(regex)));
        return this;
    }


}
