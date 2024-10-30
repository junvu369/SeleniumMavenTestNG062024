package com.junvu.Bai11_Assertions;

import com.junvu.common.BaseTest;
import com.junvu.common.LocatorsCRM;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoHardAsserts extends BaseTest {

    @Test
    public void testLoginSuccess(){

        createDriver();

        driver.get("https://crm.anhtester.com/admin/authentication");

        //Kiểm tra đối tượng header và giá trị header

        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.headerLogin)).isDisplayed(), "Header login page not display");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerLogin)).getText(),"Login");

        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        closeDriver();
    }
}
