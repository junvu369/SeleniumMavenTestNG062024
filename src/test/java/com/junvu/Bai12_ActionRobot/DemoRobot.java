package com.junvu.Bai12_ActionRobot;

import com.junvu.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class DemoRobot extends BaseTest {
    @Test
    public void inputText() throws InterruptedException, AWTException {

        createDriver();

        driver.get("https://anhtester.com/");

        Thread.sleep(1000);
        WebElement inputCourseElement = driver.findElement(By.name("key"));

        inputCourseElement.click();

        Robot robot = new Robot();

        // Nhập từ khóa selenium
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_E);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_L);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_E);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_N);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_I);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_U);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_M);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);

        //Đè 2 phím liên tục
        robot.keyPress(KeyEvent.VK_FINAL);
        robot.keyPress(KeyEvent.VK_PRINTSCREEN);
        //Nhấc 2 phím liên tục
        robot.keyRelease(KeyEvent.VK_PRINTSCREEN);
        robot.keyRelease(KeyEvent.VK_FINAL);

        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyRelease(KeyEvent.VK_WINDOWS);

        Thread.sleep(2000);
        closeDriver();
    }
}

