import BaseWebDrivingTest.BaseWebDrivingTest;
import data.Months;
import org.junit.Test;
import pages.PrognozMailDate;

public class PrognozMailDateTest extends BaseWebDrivingTest {

    @Test
    public void check_calendar() {
        new PrognozMailDate(driver)
                .open()
                .openCalendar()
                .checkMonthInCalendar(Months.June)
                .goToPreviousMonth()
                .checkMonthInCalendar(Months.May)
                .goToNextMonth()
                .goToNextMonth()
                .checkMonthInCalendar(Months.July)
                .drillDownToDay(14)
                .checkWeatherHistoryForTheDay(Months.July, 14)
        ;
    }

}