package com.junvu.Bai13_Alert_Popup_iFrame;

import com.junvu.common.BaseTest;
import org.testng.annotations.Test;

public class HandleiFrame extends BaseTest {

    @Test
    public void testHandleiFrame() throws InterruptedException {
        driver.get("https://demoqa.com/frames");
        Thread.sleep(2000);
        //ĐANG Ở ĐÂY
        //Chuyển hướng đến iFrame thông qua chính element của thẻ iFrame


        //Chuyển huớng về nội dung chính không thuộc iFrame nào

    }

}
