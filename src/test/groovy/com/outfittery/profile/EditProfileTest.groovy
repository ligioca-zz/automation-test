package com.outfittery.profile

import com.outfittery.BaseTest
import org.testng.annotations.Test
import com.outfittery.pages.LoggedOutPage

public class EditProfileTest extends BaseTest {

    @Test
    public void testUpdatePhoneNumber(){
        LoggedOutPage loggedOutPage = new LoggedOutPage(driver)

        assert loggedOutPage.login()
                .goToMyProfile()
                .updatePhoneNumber()
    }

    @Test
    public void testUpdateClothingSize(){
        LoggedOutPage loggedOutPage = new LoggedOutPage(driver)

        assert loggedOutPage.login()
                .goToMyProfile()
                .updateClothingSize()
    }
}
