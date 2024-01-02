package com.example.automationtest.User;

import com.example.automationtest.Library.BestFunction;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;

public class News extends BestFunction {
    ChromeDriver chromeDriver;
    private String user = "kd2002";
    private String password = "Khoa25112002!";
    private String url = "https://www.weallnet.com/";
    private String newsVN = "read-news-english/vietnamplus/vietnam-rok-cooperate-to-streamline-customs-p/64a482b0-5096-11ee-84f5-e6df297f79be/True";
    private String Categories = "tin-nuoc-ngoai/education/20";
    private String newsEN = "bao-tieng-anh/dantri/hundreds-wait-overnight-for-school-enrollment/b8f058d8-83fb-4d0a-bacc-465ee7e7d054/True";
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
    }

    public void Login(){
        chromeDriver.get("https://www.weallnet.com/");
        MaxiumWin(chromeDriver);
        WebElement login = chromeDriver.findElement(By.id("login"));
        login.click();
        // chromeDriver.get("https://auth.weallnet.com/vi/dang-nhap?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3DWANBMS%26redirect_uri%3Dhttps%253A%252F%252Fwww.weallnet.com%252Fsignin-oidc%26response_type%3Dcode%2520id_token%26scope%3Dopenid%2520profile%2520offline_access%2520WANAPI%26response_mode%3Dform_post%26nonce%3D638299434489383602.NzdiZTkwODktZTZjZS00ZTEwLTlkOGEtODdhYjlhYzZkMDVhODk0ZmQ1ZTMtNWUxZS00ZGYxLThkYTgtN2FlZjMyN2IyODAz%26state%3DCfDJ8NPyX7F8XcxLnz6zSlziQShhR7fl0xcegY1zIypwZwIDNkKw_skYKzhzRWAt99Bwrc1tBWXzx9y8o3QjC6D3k0QU2dk9YVI2n6ZdId1sDSQ7mr-mXwN4UTO5abYr3B87PxvB2j1AH6tPe3Gjp8U5WQvVosHJ1GhDP37O_2IxiES4Khf0qiCm7zcqRblJ99KnNpOOoM_ThQAYYdUAM4sa97mKxh6xvzwMOzPgJ5z0VWTiRJpMw7QttLfh34_X-u4S-KxwZP6_IssQFRqRUasuagzXRC1DNfkACTVkqgpxYHz55Xig_iJMroy9_rbOp0KU9nWV50oWFr4Lp5MDjiMCn5dkXHDSIjVBk1pR-5Y_-iZw%26x-client-SKU%3DID_NETSTANDARD2_0%26x-client-ver%3D6.7.1.0");
        WebElement element = chromeDriver.findElement(By.id("Username"));
        WebElement element1= chromeDriver.findElement(By.id("ctrlPassword"));
        WebElement element2 = chromeDriver.findElement(By.name("button"));
        element.sendKeys("kd2002");
        sleep(5000);
        element1.sendKeys("Khoa25112002!");
        sleep(5000);
        element2.click();
    }

    public void News(String[] urlNews){
        for (String urlN: urlNews) {
            chromeDriver.get(url + urlN);
            sleep(3000);
        }
    }
    //Test News tiếng việt
    @Test
    public void NewsVn(){
        // Gọi phương thức Login để đăng nhập
        Login();
        // Tìm và click vào phần tử có id là "exp"
        WebElement exp = chromeDriver.findElement(By.id("exp"));
        exp.click();
       // Tìm và click vào phần tử có id là "Newsdropdown"
        WebElement newsDropDown = chromeDriver.findElement(By.id("Newsdropdown"));
        newsDropDown.click();
        // Tạm dừng thực thi trong 3 giây (3000 mili giây) để cho drop down thành công
        sleep(3000);
        // Tìm và click vào phần tử có id là "viet-nam-new"
        WebElement newsVN = chromeDriver.findElement(By.id("viet-nam-new"));
        newsVN.click();
        // Tạm dừng thực thi trong 3 giây (3000 mili giây) để cho tải hết các đầu báo thành công
        sleep(3000);
        //Bắt các id bài báo do scan từ đầu nên nó sẽ cho bài báo đầu tiên nó thấy
        WebElement newsVNFirst = chromeDriver.findElement(By.id("vn-new"));
        newsVNFirst.click();
    }
    //Test News tiếng anh
    @Test
    public void NewsEn(){
        // Gọi phương thức Login để đăng nhập
        Login();
        // Tìm và click vào phần tử có id là "exp"
        WebElement exp = chromeDriver.findElement(By.id("exp"));
        exp.click();
        // Tìm và click vào phần tử có id là "Newsdropdown"
        WebElement newsDropDown = chromeDriver.findElement(By.id("Newsdropdown"));
        newsDropDown.click();
        // Tạm dừng thực thi trong 3 giây (3000 mili giây) để cho drop down thành công
        sleep(3000);
        // Tìm và click vào phần tử có id là "english-new"
        WebElement newsEN = chromeDriver.findElement(By.id("english-new"));
        newsEN.click();
        // Tạm dừng thực thi trong 3 giây (3000 mili giây) để cho tải hết các đầu báo thành công
        sleep(3000);
        //Bắt các id bài báo do scan từ đầu nên nó sẽ cho bài báo đầu tiên nó thấy
        WebElement newsENFirst = chromeDriver.findElement(By.id("en-new"));
        newsENFirst.click();
    }
    @AfterMethod
    public void takeScreenShotForFailures(ITestResult testResult){
        if(ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) chromeDriver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") + "/resources/screenshots/"+ testResult.getName()+".png");
            try {
                FileHandler.copy(source, destination);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public void NewsfollowCatelogiries(){
        News(new String[]{"" +
                "/vi/"+Categories,
                "/vi/"+ "bao-tieng-anh/dantri/hundreds-wait-overnight-for-school-enrollment/b8f058d8-83fb-4d0a-bacc-465ee7e7d054/True"});
    }
}
