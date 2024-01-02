package com.example.automationtest.User;

import com.example.automationtest.Library.BestFunction;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.asn1.x500.style.RFC4519Style;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;

public class CheckITOut extends BestFunction {
    ChromeDriver chromeDriver;
    private String user = "kd2002";
    private String password = "Khoa25112002!";
    private String url = "https://www.weallnet.com";
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();

    }

    public void Login(){
        chromeDriver.get("https://localhost:44399/");
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
    public void Media(String[] urlvideo){
//        chromeDriver.get(url+"/vi/giai-tri");
        chromeDriver.get(url + urlvideo[0]);
        sleep(3000);
        chromeDriver.get(url + urlvideo[1]);
        sleep(3000);
        WebElement playButton = chromeDriver.findElement(By.xpath("//button[@title='Play Video']"));
        WebElement playButto1n = chromeDriver.findElement(By.className("container-video-overlay"));
        // Click the button
        playButton.click();
        sleep(3000);
        playButto1n.click();
        sleep(3000);
    }
    @Test
    public void AllMedia(){
        Login();
        sleep(3000);
        chromeDriver.get(url + "/vi/trai-nghiem");
        Media(new String[]{ "/vi/giai-tri", "/vi/xem-video/ngoi-ghe-nghe-ke-chuyen/truc-vong/ea720d41-b0e0-4324-956b-575deb4a3261"});
    }
    public void Movie(String[] urlMovie){
        for (String urlM : urlMovie ) {
            //        chromeDriver.get(url + "/vi/giai-tri");
            chromeDriver.get(url + urlM);
            sleep(3000);
//        chromeDriver.get(url + "/en/giai-tri");
//        chromeDriver.get(url + "/vi/chon-phim-xem");
//        chromeDriver.get(url + "/en/chon-phim-xem");
//        chromeDriver.get(url + "/vi/xem-phim/ben-eagles-center/tiem-thu-y-ba-dao-phim-ngan-hanh-dong-hai-eag/1e55cb71-d77c-4665-b81a-ea195314edc3");
//        chromeDriver.get(url + "/en/xem-phim/ben-eagles-center/tiem-thu-y-ba-dao-phim-ngan-hanh-dong-hai-eag/1e55cb71-d77c-4665-b81a-ea195314edc3");
        }

//        WebElement playButton = chromeDriver.findElement(By.xpath("//button[@title='Play Video']"));
        WebElement playButton = chromeDriver.findElement(By.id("video-player"));
        // Click the button
//        playButton.click();
//        sleep(3000);
        playButton.click();
        sleep(3000);
    }
    @Test
    public void AllMovie() {
        Login();
        sleep(3000);
        WebElement exp = chromeDriver.findElement(By.id("exp"));
        exp.click();
        sleep(3000);
        WebElement buttonexperience = chromeDriver.findElement(By.id("icon-media"));
        buttonexperience.click();
        sleep(3000);
        WebElement movie = chromeDriver.findElement(By.id("Movies"));
        movie.click();
        sleep(3000);
        WebElement joymovie = chromeDriver.findElement(By.id("Movievideo"));
        joymovie.click();
//        Movie(new String[]{
//                "/vi/giai-tri",
//                "/en/giai-tri",
//                "/vi/chon-phim-xem",
//                "/en/chon-phim-xem",
//                "/vi/xem-phim/ben-eagles-center/tiem-thu-y-ba-dao-phim-ngan-hanh-dong-hai-eag/1e55cb71-d77c-4665-b81a-ea195314edc3",
//                "/en/xem-phim/ben-eagles-center/tiem-thu-y-ba-dao-phim-ngan-hanh-dong-hai-eag/1e55cb71-d77c-4665-b81a-ea195314edc3"
//        });
    }
    @Test
    public void AllinOne(){
        // Gọi phương thức Login để đăng nhập
        Login();
        // Tìm và click vào phần tử có id là "exp" để vào trang trại nghiệm
        WebElement exp = chromeDriver.findElement(By.id("exp"));
        exp.click();
        sleep(3000);
        Media(new String[]{"/vi/giai-tri", "/vi/xem-video/ngoi-ghe-nghe-ke-chuyen/truc-vong/ea720d41-b0e0-4324-956b-575deb4a3261"});
        sleep(3000);
        Movie(new String[]{
                "/vi/giai-tri",
                "/en/giai-tri",
                "/vi/chon-phim-xem",
                "/en/chon-phim-xem",
                "/vi/xem-phim/ben-eagles-center/tiem-thu-y-ba-dao-phim-ngan-hanh-dong-hai-eag/1e55cb71-d77c-4665-b81a-ea195314edc3",
                "/en/xem-phim/ben-eagles-center/tiem-thu-y-ba-dao-phim-ngan-hanh-dong-hai-eag/1e55cb71-d77c-4665-b81a-ea195314edc3"
        });
    }
//    public void quicklyButtonexperience(String button){
//        Login();
//        // Tìm và click vào phần tử có id là "exp"
//        WebElement exp = chromeDriver.findElement(By.id("exp"));
//        exp.click();
//        WebElement buttonexperience = chromeDriver.findElement(By.id("icon-media"));
//        buttonexperience.click();
//        WebElement all = chromeDriver.findElement(By.id(button));
//
//    }
//    @Test
//    public void videofromHome(){
//        quicklyButtonexperience("button2");
//    }
//
//    @Test
//    public void moviefromHome(){
//        quicklyButtonexperience("button3");
//    }
//    @Test
//    public void newsfromHome(){
//        quicklyButtonexperience("button4");
//    }

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
}
