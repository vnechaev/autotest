package main;

import data.BrowsersData;
import drivers.WebDriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.NameSecret;
import data.Sex;

public class NameSecretTest {

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
    public void testSexFilter() {
        String unisexName = "Саша";// есть три варианта: Александр, Александра, Александрина
        NameSecret nameSecret = new NameSecret(driver);
        int femaleFromNotFilteredSearch = nameSecret
                .open()
                .fillNameForSearch(unisexName)
                .selectSex(Sex.ALL)
                .executeSearch()
                .getSexFilteredResultFromNotFiltered(Sex.FEMALE);

        int femaleFromFilteredSearch = nameSecret
                .open()
                .fillNameForSearch(unisexName)
                .selectSex(Sex.FEMALE)
                .executeSearch()
                .getResultNum();
        System.out.println(femaleFromNotFilteredSearch);
        System.out.println(femaleFromFilteredSearch);
        Assert.assertEquals(
                "Фильтр не работает на женский пол, неверное количество результатов поиска",
                femaleFromFilteredSearch,
                femaleFromNotFilteredSearch
        );
    }

    @Test
    public void testAlphaBetaFilter(){
        String letterForFilter = "Я";
        new NameSecret(driver)
                .open()
                .doSearchByLetter(letterForFilter)
                .checkAlphaBetaFilter(letterForFilter);
    }

}
