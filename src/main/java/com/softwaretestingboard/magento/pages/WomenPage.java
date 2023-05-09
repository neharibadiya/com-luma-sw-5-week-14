package com.softwaretestingboard.magento.pages;

import com.aventstack.extentreports.Status;
import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class WomenPage extends Utility {
    @FindBy(id = "sorter")
    WebElement selectByFilter;
    @FindBy(xpath = "//strong[@class='product name product-item-name']")
    List<WebElement> listLink;
    @FindBy(xpath = "//span[@class='price-wrapper ']//span")
    List<WebElement> productLink;


    public void selectFilterFromDropDownList() throws InterruptedException {
        Thread.sleep(500);
        selectByVisibleTextFromDropDown(selectByFilter,
                "Product Name");
        CustomListeners.test.log(Status.PASS, "Click on " + selectByFilter);
        Reporter.log("click on " + selectByFilter.toString());
    }
    public  void setSelectByFilterPrice() throws InterruptedException {
        Thread.sleep(500);
        selectByValueFromDropDown(selectByFilter,"price");
        CustomListeners.test.log(Status.PASS, "Click on " + selectByFilter);
        Reporter.log("click on " + selectByFilter.toString());
    }
    public List getList() throws InterruptedException {
        Thread.sleep(500);
        List<WebElement> list=getListOfElements(listLink);
        List<String> orignalList= new ArrayList<>();
        for(WebElement e:list){
            orignalList.add(e.getText());
        }
        CustomListeners.test.log(Status.PASS, "Get list " + listLink);
        Reporter.log("Get list " + listLink.toString());
        return orignalList;
    }
    public List getPriceList() throws InterruptedException {
        Thread.sleep(500);
        List<WebElement> products = getListOfElements(productLink);
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsPrice.add(Double.valueOf(e.getText().replace("$", "")));
        }
        CustomListeners.test.log(Status.PASS, "Get list " + productLink);
        Reporter.log("Get list " + productLink.toString());
        return originalProductsPrice;
    }

}
