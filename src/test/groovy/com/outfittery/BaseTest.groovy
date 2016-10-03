package com.outfittery

import org.openqa.selenium.WebDriver
import org.testng.annotations.AfterClass
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod

public abstract class BaseTest {

    WebDriver driver

    @BeforeMethod
    public void setUp() {
        driver = com.outfiterry.BrowserFactory.systemChromeDriver()
        driver.get("https://www.outfittery.com/")
    }

    @AfterMethod
    public void tearDown() {
        driver.quit()
    }
}
