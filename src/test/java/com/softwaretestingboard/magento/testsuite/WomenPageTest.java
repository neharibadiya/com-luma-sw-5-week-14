package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.pages.HomePage;
import com.softwaretestingboard.magento.pages.WomenPage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
@Listeners(CustomListeners.class)
public class WomenPageTest extends BaseTest {
    WomenPage womenPage;
    HomePage homePage;
    @BeforeMethod(alwaysRun = true)
    public void setBrowser() {
        womenPage = new WomenPage();
        homePage = new HomePage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        homePage.mouseHoverOnWomenMenu();
        homePage.mouseHoverOnWomenTopMenu();
        homePage.clickOnWomenJacketMenu();
        womenPage.selectFilterFromDropDownList();
        List originalList=womenPage.getList();
        Collections.sort(originalList);
        Thread.sleep(1000);
        womenPage.selectFilterFromDropDownList();
        Thread.sleep(1000);
        List listAfterSorting=womenPage.getList();
        Assert.assertEquals(originalList, listAfterSorting);
    }

    @Test(groups = {"smoke","regression"})
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        homePage.mouseHoverOnWomenMenu();
        homePage.mouseHoverOnWomenTopMenu();
        homePage.clickOnWomenJacketMenu();
        List originalList=womenPage.getPriceList();
        Collections.sort(originalList);
        womenPage.setSelectByFilterPrice();
        List actualList=womenPage.getPriceList();
        System.out.println(originalList);
        System.out.println(actualList);
        Assert.assertEquals(originalList, actualList);
    }
}
