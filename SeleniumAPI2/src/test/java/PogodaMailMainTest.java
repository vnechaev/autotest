import BaseWebDrivingTest.BaseWebDrivingTest;
import org.junit.Test;
import pages.PogodaMailMain;

public class PogodaMailMainTest extends BaseWebDrivingTest {

    @Test
    public void add_city_in_favourite_list_for_not_auth_user() {
        new PogodaMailMain(driver)
                .open()
                .setTownForSearch("Санкт-Петербург")
                .executeSearch()
                .cityDropDownShouldBeNotPresent()
                .addToFavorites()
                .moveCursorToCityDropDown()
                .checkAddingNewFavouriteTown();

    }

}