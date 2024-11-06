package com.junvu.Bai15_Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.junvu.common.BaseTest.driver;

public class DemoExplicitWait {

    @BeforeMethod
    public void setDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); //Chờ load trang
    }

    @Test(priority = 2)
    public void demoImplicitWait2() throws InterruptedException {

        driver.get("https://hrm.anhtester.com/");

        WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("iusername"))); //Chờ đợi element hiển thị lên màn hình
        driver.findElement(By.id("iusername")).sendKeys("admin_example");
        driver.findElement(By.id("ipassword")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Click menu dự án
        driver.findElement(By.xpath("//span[contains(text(),'Projects')]")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }


}

