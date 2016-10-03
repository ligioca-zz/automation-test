package com.outfittery.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

public class MyProfilePage {

    WebDriver driver
    Random random = new Random()

    def MyProfilePage(WebDriver driver) {
        this.driver = driver
    }

    def updatePhoneNumber() {
        def phoneNumber = driver.findElement(By.id("phoneNumber"))
        def saveData = driver.findElement(By.id("submitSave"))
        phoneNumber.clear()
        phoneNumber.sendKeys("023423123")
        saveData.click()

        return driver.findElement(By.cssSelector(".modal-content.alert.bg-success.text-white")).isDisplayed()
    }

    def updateClothingSize() {
        def generalClothingItens = ["heightInCm", "weightInKg", "shirtSize", "trousersSizeWidth", "trousersSizeLength", "shoeSize"]
        def newValues = []
        def savedValues = []
        def savedValuesText = []

        generalClothingItens.each {
            def item = driver.findElement(By.id(it))
            def newItemValue = getRandomValueIn(it)

            item.sendKeys(newItemValue)

            newValues.add(newItemValue)
            Thread.sleep(1000)
        }

        def saveButton = driver.findElement(By.cssSelector(".profile_edit_submit.btn.btn-primary.btn-block.uppercase.mt-md.mb-md"))
        saveButton.click()

        savedValues = driver.findElements(By.cssSelector(".panel-body .row .form-control option[selected]"))
        savedValues.each { savedValuesText.add(it.text) }

        println("New values: "+ newValues)
        println("New values after saved: "+ savedValuesText)

        return savedValuesText == newValues
    }

    def getRandomValueIn(String locator) {
        def listOfOptions = []
        def optionSelected = driver.findElement(By.cssSelector("#" + locator + " option[selected]")).text
        def optionsList = driver.findElements(By.cssSelector("#" + locator + " option[value]"))
        optionsList.each {
            if (it.text != optionSelected && it.text != "") {
                listOfOptions.add(it.text)
            }
        }
        def randomId = random.nextInt(listOfOptions.size())
        return listOfOptions.get(randomId).toString()
    }
}
