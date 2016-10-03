package com.outfiterry

import org.openqa.selenium.chrome.ChromeDriver

public class BrowserFactory {

    def static getOS() {
        def os = null
        def system = System.getProperty("os.name")

        if (system.toLowerCase().contains("linux")) {
            os = "linux"
        } else if (system.toLowerCase().contains("mac")) {
            os = "mac"
        } else if (system.toLowerCase().contains("windows")) {
            os = "windows"
        } else {
            throw new IllegalStateException("OS not supported")
        }
        return os
    }

    def static systemChromeDriver() {
        def os = getOS()
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/" + os + "/chromedriver")
        return new ChromeDriver()
    }


}
