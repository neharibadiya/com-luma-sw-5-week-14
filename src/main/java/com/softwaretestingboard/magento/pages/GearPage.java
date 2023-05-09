package com.softwaretestingboard.magento.pages;

import com.aventstack.extentreports.Status;
import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.utilities.Utility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class GearPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Overnight Duffle']")
    WebElement overnightDuffle;
    @CacheLookup
    @FindBy(xpath = "//span[contains(.,'Overnight Duffle')]")
    WebElement bagTitle;
    @CacheLookup
    @FindBy(xpath = "//input[@id='qty']")
    WebElement quantityField;
    @CacheLookup
    @FindBy(id = "product-addtocart-button")
    WebElement addToCartButton;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@data-bind,'html: $parent.prepareMessageForHtml(message.text)')]")
    WebElement addedSuccessfullyText;
    @CacheLookup
    @FindBy(linkText = "shopping cart")
    WebElement clickOnShoppingLink;

    public void clickOnNightDuffleBag() {
        clickOnElement(overnightDuffle);
    }

    public String verifyTheBagText() {
        CustomListeners.test.log(Status.PASS, "Bag title " + bagTitle);
        return getTextFromElement(bagTitle);
    }

    public void changeTheQuantityOfTheBag(String qty) {
        quantityField.sendKeys(Keys.DELETE);
        sendTextToElement(quantityField, qty);
        CustomListeners.test.log(Status.PASS, "quantity of the bag is  " +quantityField);
        Reporter.log("Get heading text " + qty.toString());
    }

    public void clickOnAddToCartButton() {
        CustomListeners.test.log(Status.PASS, "add to cart button " + addToCartButton);
        clickOnElement(addToCartButton);
        Reporter.log("Add to cart " + addToCartButton.toString());
    }

    public String bagAddedToCartSuccessfullyMessage() {
        CustomListeners.test.log(Status.PASS, "added successfully " + addedSuccessfullyText);
        Reporter.log("Added to cart " + addedSuccessfullyText.toString());
        return getTextFromElement(addedSuccessfullyText);
    }

    public void clickOnShoppingCartLink() {
        CustomListeners.test.log(Status.PASS, " shopping cart button " + clickOnShoppingLink);
        clickOnElement(clickOnShoppingLink);
        Reporter.log("Shopping cart button " + clickOnShoppingLink.toString());
    }
}
