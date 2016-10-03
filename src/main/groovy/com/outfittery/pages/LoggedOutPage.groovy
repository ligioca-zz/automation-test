package com.outfittery.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

public class LoggedOutPage {

    WebDriver driver

    def LoggedOutPage(WebDriver driver){
        this.driver = driver
    }

    def login(){
        println("Logging in home page.")
        def customerLogin = driver.findElement(By.cssSelector(".login.open-login"))
        customerLogin.click()

        def username = driver.findElement(By.id("username"))
        def password = driver.findElement(By.id("password"))
        def submit = driver.findElement(By.id("submit"))

        username.sendKeys("ligia.affonsoandre@gmail.com")
        password.sendKeys("1234qwer")
        submit.click()

        return new HomePage(driver)
    }

}
