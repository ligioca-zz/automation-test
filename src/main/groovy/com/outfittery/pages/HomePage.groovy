package com.outfittery.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

public class HomePage {

    WebDriver driver

    def HomePage(WebDriver driver){
        this.driver = driver
        pageValidation()
    }

    def pageValidation(){
        def helloMsg = driver.findElement(By.cssSelector(".mb.lead.ellipsis")).text
        def myOrders = driver.findElement(By.id("orders"))

        assert helloMsg.contains("Hello")
        assert myOrders.isDisplayed()
    }

    public goToMyProfile(){
        println("Going to My Profile page.")

        def myProfileMenu = driver.findElement(By.cssSelector(".subnav-list li:nth-child(3)"))
        myProfileMenu.click()

        def welcomeMsg = driver.findElement(By.cssSelector(".mb.lead")).text
        assert welcomeMsg.contains("Welcome to your profile")

        return new MyProfilePage(driver)
    }
}
