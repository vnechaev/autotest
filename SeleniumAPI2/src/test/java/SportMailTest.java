import BaseWebDrivingTest.BaseWebDrivingTest;
import data.PageUrl;
import org.junit.Test;
import pages.SportMail;

import static org.junit.Assert.*;

public class SportMailTest  extends BaseWebDrivingTest {

    @Test
    public void checkLogMessages(){
        new SportMail(driver)
                .open()
                .checkBrowserLogs();
    }

}