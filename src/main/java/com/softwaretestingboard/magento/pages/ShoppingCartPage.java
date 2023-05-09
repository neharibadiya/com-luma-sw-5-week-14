package com.softwaretestingboard.magento.pages;

import com.aventstack.extentreports.Status;
import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.utilities.Utility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "(//div[@class='product-item-details'])[2]/strong/a")
    WebElement verifyTheProductName;

    @CacheLookup
    @FindBy(xpath = "//input[@class='input-text qty']")
    WebElement quantityField;

    @FindBy(xpath = "//span[@data-bind='text: getValue()'][normalize-space()='$135.00']")
    WebElement verifyTheProductPrice;
    @CacheLookup
    @FindBy(xpath = "//button[@class='action update']")
    WebElement clickOnUpdateShoppingCart;

    @FindBy(xpath = "//span[@class='cart-price']//span[@class='price'][normalize-space()='$225.00']")
    WebElement verifyTheUpdatedPrice;

    @CacheLookup
    @FindBy(xpath = "//span[@class='base']")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//dd[contains(text(),'32')]")
    WebElement theSizeOfThePants;

    @CacheLookup
    @FindBy(xpath = "//dd[contains(text(),'Black')]")
    WebElement theColourOfThePants;

    public String verifyTheProductsName() {
        CustomListeners.test.log(Status.PASS, "Get the product name " + verifyTheProductName);
        Reporter.log("Get the product name " + verifyTheProductName.toString());
        return verifyTheProductName.getText();
    }

    public String getQuantityOfProduct() {
        String quantity = quantityField.getAttribute("value");
        CustomListeners.test.log(Status.PASS, "Get quantity " + quantity);
        Reporter.log("Get quantity " + quantity.toString());
        return quantity;
    }

    public String getPriceOfTheProduct() {
        CustomListeners.test.log(Status.PASS, "Get Price " + verifyTheProductPrice);
        Reporter.log("Get Price " + verifyTheProductPrice.toString());
        return verifyTheProductPrice.getText();
    }

    public void changeTheQuantityOfTheBag(String qty) {
        quantityField.sendKeys(Keys.DELETE);
        CustomListeners.test.log(Status.PASS, "Change quantity " + quantityField);
        Reporter.log("Change quantity " + quantityField.toString());
        sendTextToElement(quantityField, qty);
    }

    public void updateTheShoppingCart() {
        clickOnElement(clickOnUpdateShoppingCart);
        CustomListeners.test.log(Status.PASS, "click on shopping cart " + clickOnUpdateShoppingCart);
        Reporter.log("click on shopping cart " + clickOnUpdateShoppingCart.toString());
    }

    public String UpdatedProductPrice() throws InterruptedException {
        Thread.sleep(500);
        CustomListeners.test.log(Status.PASS, "Updated Price " + verifyTheUpdatedPrice);
        Reporter.log("Updated price " + verifyTheUpdatedPrice.toString());
        return verifyTheUpdatedPrice.getText();
    }

    public String getTheShoppingCartPageTitle() {
        CustomListeners.test.log(Status.PASS, "Get quantity " + shoppingCartText);
        Reporter.log("Get quantity " + shoppingCartText.toString());
        return shoppingCartText.getText();
    }

    public String getTheSizeOfThePants() {
        CustomListeners.test.log(Status.PASS, "Get the size of the pant " + shoppingCartText);
        Reporter.log("Get the size of the pant " + shoppingCartText.toString());
        return theSizeOfThePants.getText();
    }

    public String getTheColourOfThePants() {
        CustomListeners.test.log(Status.PASS, "Get the colour of the pants " + theColourOfThePants);
        Reporter.log("Get the colour of the pants " + theColourOfThePants.toString());
        return theColourOfThePants.getText();
    }
}
