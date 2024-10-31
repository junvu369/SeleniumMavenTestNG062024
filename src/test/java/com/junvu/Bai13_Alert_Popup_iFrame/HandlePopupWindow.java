package com.junvu.Bai13_Alert_Popup_iFrame;

import com.junvu.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

public class HandlePopupWindow extends BaseTest {

    @Test
    public void testOpenNewTab() {
        driver.get("https://anhtester.com");

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://google.com");

    }

    @Test
    public void testOpenNewWindow() {
        driver.get("https://anhtester.com");

        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get("https://google.com");
    }

    @Test
    public void demoNotSwitchToTab() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        Thread.sleep(1000);
        //Sau khi chuyển hướng sang Tab mới thì getText cái header
        System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
        Thread.sleep(1000);
    }

    @Test
    public void demoPopupWindow() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(2000);
        //Button tab mới
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        //Button window mới
        driver.findElement(By.xpath("//button[@id='windowButton']")).click();

        Thread.sleep(1000);
        // Lưu lại lớp window đầu tiên - mã ID hơi dài, in ra sẽ thấy :)
        String MainWindow = driver.getWindowHandle();
        System.out.println("Main Window:" + MainWindow);

        // Lấy tất cả các mã định danh Tab Window.
//        Set<String> windows = driver.getWindowHandles();

        //Set là một Collection để lưu các phần tử giá trị KHÔNG trùng lặp.

        //Cách 1: duyệt từng phần tử không trùng lặp trong Collection (Set) - Java Basic
        //Duyệt từng phần tử bằng for cải tiến
//        for (String window : windows) {
//            System.out.println(window);
//            //Duyệt và so sánh
//            if (!MainWindow.equals(window)) {
//                //So sánh nếu thằng nào khác thằng Chính (đầu tiên) thì chuyển hướng qua nó mới thao tác được
//                //Chuyển hướng driver đến Tab mới (Tab con)
//                driver.switchTo().window(window);
//                Thread.sleep(1000);
//                System.out.println("Đã chuyển đến Tab Window mới");
//                //Bên dưới chỉ là phụ
//                //Một số hàm hỗ trợ
//                System.out.println(driver.switchTo().window(window).getTitle());
//                System.out.println(driver.switchTo().window(window).getCurrentUrl());
//
//                Thread.sleep(1000);
//                //Sau khi chuyển hướng sang Tab mới thì getText cái header
//                System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
//
//                // Tắt cái Tab Window mới.
//                Thread.sleep(1000);
//                driver.close();
//            }
//
//        }
        //Cách 2: Dùng index cụ thể của tab/window
        // Lấy tất cả các mã định danh Tab Window.
        Set<String> windows = driver.getWindowHandles();

        String firstWindow = (String)windows.toArray()[0]; //Cửa sổ đầu
        String secondWindow = (String)windows.toArray()[1]; //Cửa sổ thứ hai
        //Chuyển hướng đến cửa sổ thứ 2
        driver.switchTo().window(secondWindow);
        Thread.sleep(1000);

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //ĐANG Ở ĐÂY
        Thread.sleep(1000);
        //Sau khi chuyển hướng sang Tab mới thì getText cái header
        System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());

        // Tắt cái Tab Window mới.
        Thread.sleep(1000);
        driver.close();

//firstWindow ý nghĩa là main window (cái cần lưu đầu tiên)
        // Chuyển hướng về lại tab chính ban đầu (Main Window)
        driver.switchTo().window(MainWindow);
        System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

        Thread.sleep(1000);
    }
}
