package com.junvu.Bai14_JavascriptExecutor;

import com.junvu.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DemoJavascriptExecutor extends BaseTest {

    @Test
    public void jsExecutorDemo01() throws InterruptedException {
        createDriver();

        // Creating the JavascriptExecutor interface object
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://anhtester.com/");
        Thread.sleep(1000);

        // Click on "Website Testing" module using JavascriptExecutor
        WebElement button = driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']"));
        js.executeScript("arguments[0].click();", button);
        Thread.sleep(1000);

        // Get page title and Domain using JavascriptExecutor
        String titleText = js.executeScript("return document.title;").toString();
        System.out.println("Page Title is: " + titleText);

        String domainName = js.executeScript("return document.domain;").toString();
        System.out.println("Domain is: " + domainName);

        // Add Alert window using JavascriptExecutor
        js.executeScript("alert('Successfully Logged In');");

        Thread.sleep(2000);

        closeDriver();
    }

    @Test
    public void jsExecutorDemo02() throws InterruptedException {
        createDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(1000);

        // sendKeys text on input
        js.executeScript("document.getElementById('email').setAttribute('value','admin@example.com');");
        js.executeScript("document.getElementById('password').setAttribute('value','123456');");

        js.executeScript("document.getElementsByClassName('btn-primary')[0].click()");
        Thread.sleep(2000);
        closeDriver();
    }
}
