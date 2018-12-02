import BaseWebDrivingTest.BaseWebDrivingTest;
import org.junit.Test;
import pages.PetsMail;

public class PetsMailTest extends BaseWebDrivingTest {

    @Test
    public void checkExistenceOfDatePublish() {
        new PetsMail(driver)
                .open()
                .checkExistenceDateOfPublish();
    }

}