package com.junvu.Bai12_ActionRobot;

import com.junvu.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoAction extends BaseTest {

    @Test
    public void testSendKeys() throws InterruptedException {

        createDriver();

        //driver kế thừa từ class Basetest
        driver.get("https://www.google.com/");

        // Element search box
        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));

        // Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element, "Anh Tester").perform();
        Thread.sleep(2000);

        closeDriver();
    }

    @Test
    public void testPressEnterKey() throws InterruptedException {
        createDriver();
        //driver kế thừa từ class SetupBrowser
        driver.get("https://www.google.com/");

        // Element search box
        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));

        // Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element, "Anh Tester").perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.ENTER).perform();

        Thread.sleep(2000);

        closeDriver();
    }

    @Test
    public void testClick() throws InterruptedException {
        createDriver();
        //driver kế thừa từ class SetupBrowser
        driver.get("https://www.google.com/");

        // Element search box
        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));

        // Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element, "Anh Tester").perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        // Get element title of page
        WebElement elementTitlePage = driver.findElement(By.xpath("//h3[normalize-space()='Anh Tester Automation Testing']"));

        Assert.assertEquals(elementTitlePage.getText(), "123 Anh Tester Automation Testing", "The title is wrong");
        // Gọi hàm click để click element trên
        action.click(elementTitlePage).perform();

        Thread.sleep(2000);

        closeDriver();
    }

    @Test
    public void doubleClick() throws InterruptedException {
        createDriver();

        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-7']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));

        Actions action = new Actions(driver);

        action.doubleClick(element).perform();
        Thread.sleep(2000);

        closeDriver();
    }

    @Test
    public void moveToElement() throws InterruptedException {
        createDriver();

        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//h2[contains(text(),'Kiến thức Automation Testing')]"));

        Actions action = new Actions(driver);

        //Move to element (di chuyển tới title Kiến thức Automation Testing)
        action.moveToElement(element).perform();

        Thread.sleep(2000);

        closeDriver();
    }

    @Test
    public void demoDragAndDropWithActionClass() throws InterruptedException {

        createDriver();

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        Thread.sleep(1000);

        // Bắt element cần kéo
        WebElement From = driver.findElement(By.xpath("//div[@id='box6']"));
        // Bắt element cần thả đến
        WebElement To = driver.findElement(By.xpath("//div[@id='countries']//div[1]"));

        Thread.sleep(1000);
        Actions action = new Actions(driver);
        // Kéo và thả
        action.dragAndDrop(From, To).perform();

        Thread.sleep(2000);

        closeDriver();
    }

    @Test
    public void inputTextUppercase() throws InterruptedException {
        createDriver();

        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));

        Actions action = new Actions(driver);

        // Đè giữ phím SHIFT và nhập text -> Chữ in hoa -> Nhấc phím SHIFT
        action.keyDown(element, Keys.SHIFT).sendKeys("anh tester").keyUp(Keys.SHIFT).build().perform();
        action.sendKeys("Automation Testing").perform();

        Thread.sleep(2000);
        closeDriver();
    }

    @Test
    public void scrollPageDownAndUp() throws InterruptedException {
        createDriver();
        driver.get("https://anhtester.com/");
        Actions action = new Actions(driver);

        Thread.sleep(1000);
        // Scroll down
        action.keyDown(Keys.END).perform();
        action.keyUp(Keys.END).perform();
        Thread.sleep(2000);
        // Scroll up
        action.keyDown(Keys.HOME).perform();
        action.keyUp(Keys.HOME).perform();
        Thread.sleep(2000);
        closeDriver();
    }

    @Test
    public void copyAndPaste() throws InterruptedException {
        createDriver();

        driver.get("https://anhtester.com/blogs");
        Thread.sleep(2000);

        WebElement inputCourseElement = driver.findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm khóa học')]"));
        WebElement inputBlogElement = driver.findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm bài viết')]"));

        Actions action = new Actions(driver);

        Thread.sleep(1000);
        // Nhập text vào ô search course
        inputCourseElement.sendKeys("Selenium");
        Thread.sleep(1000);
        //Ctrl + a để bôi đen
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(1000);
        //Ctrl + c để copy
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        //Ctrl + x để cắt data
//        action.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(1000);
        //click vào ô Blog search
        inputBlogElement.click();
        Thread.sleep(1000);
        //Ctrl + v để dán
        action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

        Thread.sleep(2000);

        closeDriver();
    }
}


