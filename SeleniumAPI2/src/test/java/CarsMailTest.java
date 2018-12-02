import BaseWebDrivingTest.BaseWebDrivingTest;
import org.junit.Test;
import pages.CarsMail;

public class CarsMailTest extends BaseWebDrivingTest {

    @Test
    public void testPopupCarsMail() {
        new CarsMail(driver)
                .open()
                .showFirstPlus()
                .checkPopupIsPresent()
                .checkPopupTitleContainsPlusText()
                .closePopup()
                .checkPopupIsNotPresent()
        ;

    }

}