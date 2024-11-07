package com.junvu.Bai16_ThuchanhWait;


import com.junvu.common.BaseTest;
import com.junvu.common.LocatorsCRM;
import com.junvu.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ThucHanhCRM_Part1 extends BaseTest {

    @Test
    public void testCustomerCRM() throws InterruptedException {
        String companyName = "Viettel";

        new WebUI(driver); //Khởi tạo class WebUI để truyền driver vào

//        createDriver();
//        loginCRM();
        driver.get("https://crm.anhtester.com/admin/authentication");

        WebUI.clearText(By.xpath(LocatorsCRM.inputEmail));
        WebUI.clearText(By.xpath(LocatorsCRM.inputPassword));

        WebUI.setText(By.xpath(LocatorsCRM.inputEmail), "admin@example.com");
        WebUI.setText(By.xpath(LocatorsCRM.inputPassword), "123456");

        WebUI.clickElement(By.xpath(LocatorsCRM.buttonLogin));

        WebUI.clickElement(By.xpath(LocatorsCRM.menuCustomers));
//        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();

        System.out.println(WebUI.getTextElement(By.xpath(LocatorsCRM.headerCustomerPage)));
//        System.out.println(driver.findElement(By.xpath(LocatorsCRM.headerCustomerPage)).getText());

        WebUI.clickElement(By.xpath(LocatorsCRM.buttonAddNewCustomer));
//        driver.findElement(By.xpath(LocatorsCRM.buttonAddNewCustomer)).click();
//        Thread.sleep(2000);
        WebUI.setText(By.xpath(LocatorsCRM.inputCompany), "VNPT IT Ha Noi 03");
//        driver.findElement(By.xpath(LocatorsCRM.inputCompany)).sendKeys("VNPT IT Ha Noi 03");

        WebUI.setText(By.xpath(LocatorsCRM.inputVat), "10");
//        driver.findElement(By.xpath(LocatorsCRM.inputVat)).sendKeys("10");

        WebUI.setText(By.xpath(LocatorsCRM.inputPhoneNumber), "0123456789");
//        driver.findElement(By.xpath(LocatorsCRM.inputPhoneNumber)).sendKeys("0123456789");

        WebUI.setText(By.xpath(LocatorsCRM.inputWebsite),"https://vnptit.vn/");
//        driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).sendKeys("https://vnptit.vn/");

        WebUI.clickElement(By.xpath(LocatorsCRM.dropdownGroup));
//        driver.findElement(By.xpath(LocatorsCRM.dropdownGroup)).click();
//        Thread.sleep(1000);

        WebUI.setText(By.xpath(LocatorsCRM.inputSearchGroup),"VIP");
//        driver.findElement(By.xpath(LocatorsCRM.inputSearchGroup)).sendKeys("VIP");
//        Thread.sleep(1000);

        WebUI.clickElement(By.xpath(LocatorsCRM.itemVIP));
//        driver.findElement(By.xpath(LocatorsCRM.itemVIP)).click();

        WebUI.clickElement(By.xpath(LocatorsCRM.dropdownGroup));
//        driver.findElement(By.xpath(LocatorsCRM.dropdownGroup)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.dropdownLanguage)).click();
        Thread.sleep(1000);

        //ĐANG Ở ĐÂY

        driver.findElement(By.xpath(LocatorsCRM.itemVietnamese)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputAddress)).sendKeys("Ha Noi");
        driver.findElement(By.xpath(LocatorsCRM.inputCity)).sendKeys("Ha Noi");
        driver.findElement(By.xpath(LocatorsCRM.inputState)).sendKeys("Hoan Kiem");
        driver.findElement(By.xpath(LocatorsCRM.inputZipCode)).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.dropdownCountry)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCountry)).sendKeys("Vietnam");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.itemVietnamCountry)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.buttonSave)).click();
        //Check alert message nếu có
        //Tiếp theo check item customer hiển thị tại trang Cutsomer list
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCustomer)).sendKeys("VNPT IT Ha Noi 03");
        Thread.sleep(2000);

        System.out.println(driver.findElement(By.xpath(LocatorsCRM.itemCustomerFirst)).isDisplayed());
        System.out.println("Customer in List: " + driver.findElement(By.xpath(LocatorsCRM.itemCustomerFirst)).getText());
        //Tiếp theo check Customer đúng hết data sau khi add
        driver.findElement(By.xpath(LocatorsCRM.itemCustomerFirst)).click();
        Thread.sleep(2000);
        System.out.println("Company Detail: " + driver.findElement(By.xpath(LocatorsCRM.inputCompany)).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath(LocatorsCRM.inputVat)).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath(LocatorsCRM.inputPhoneNumber)).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath(LocatorsCRM.dropdownGroup)).getAttribute("title"));
        System.out.println(driver.findElement(By.xpath(LocatorsCRM.dropdownLanguage)).getAttribute("title"));

        //Cuối cùng phải check dạng Integration (liên kết với module khác)
        //Ví dụ customer sẽ được hiển thị bên trang project (nằm trong dropdown)
        Thread.sleep(2000);
        closeDriver();

    }
}

