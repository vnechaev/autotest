package pages;


import data.Domain;
import data.PageUrl;
import data.UrlPattern;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@UrlPattern("/")
@Domain("https://sportmail.ru/")
@PageUrl("/")
public class SportMail extends AbstractPage<SportMail>{
    public SportMail(WebDriver driver) {
        super(driver);
    }

    public SportMail open(){
        super.open();
        return this;
    }

    public SportMail checkBrowserLogs(){
        List<?> types = new ArrayList<>();
        Set logTypes = driver.manage().logs().getAvailableLogTypes();
        types.addAll(logTypes);

        List<LogEntry> list = driver.manage().logs().get(types.get(0).toString()).getAll();
        for (LogEntry log: list) {
            System.out.println(log.getMessage());
        }
        return this;
    }
}
