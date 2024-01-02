package com.example.automationtest.Admin.TestCase;

import com.example.automationtest.Library.BestFunction;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

public class Media extends BestFunction {
    ChromeDriver chromeDriver;
    private String url = "https://admin.weallnet.com/";
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
    }

    @Test
    public void Movie() throws AWTException {
        createChannelAndAddAction("MOVIE",chromeDriver, url);
        Setup();
        MaxiumWin(chromeDriver);
        AdminLogin(url , "SystemAdmin","wWeallnet@#2023!",chromeDriver);
        sleep(3000);
        String[] access = {"vi/Movie/List"};
        for(String Access : access) {
            chromeDriver.get(url + Access);
            if(Access.equals("vi/Movie/List") || Access.equals("vi/MovieInteractive/List")){
                WebElement link = chromeDriver.findElement(By.cssSelector("a.button-save"));
                link.click();
            }else {
                WebElement link = chromeDriver.findElement(By.cssSelector("a.button-add"));
                link.click();
            }
            sleep(3000);
            WebElement Title = chromeDriver.findElement(By.id("ctrlTitle"));
            Title.sendKeys("Phim moi.net");
            WebElement searchChannel = chromeDriver.findElement(By.cssSelector("div[data-bind='click:$root.startSearchPopupChannelConfig']"));
            searchChannel.click();
            sleep(3000);
            WebElement search = chromeDriver.findElement(By.xpath("//input[@class='form-control reset-btn' and @placeholder='Tìm kiếm...']"));
            ;
            search.sendKeys("Khoa Review Phim");
            sleep(10000);
            WebElement clickbutton = chromeDriver.findElement(By.className("search-icon-new"));
            clickbutton.click();
            sleep(3000);
            WebElement buttonAddChanel = chromeDriver.findElement(By.cssSelector("a.btn.new-btn.btn-smallest[data-bind*='visible:$root.movieVM().movie()!=null'][data-bind*='click:$root.selectChannelConfig']"));
            buttonAddChanel.click();
            WebElement addDescription = chromeDriver.findElement(By.id("ctrlDescription"));
            addDescription.sendKeys("Phim hay lam");
            sleep(3000);
            WebElement ReleateDate = chromeDriver.findElement(By.id("ctrlReleaseDate"));
            ReleateDate.sendKeys("23/01/2024");
            sleep(3000);
            Robot rb = new Robot();
            String[] update = {"updateleftimage","updaterightimage"};
            for(String Update : update) {
                WebElement divElement = chromeDriver.findElement(By.id(Update));
                divElement.click();
                copycatch("D:\\Pic Bug\\Testpic.jpg");
                sleep(1000);
                rb.keyPress(KeyEvent.VK_CONTROL);
                rb.keyPress(KeyEvent.VK_V);
                sleep(1000);
                rb.keyRelease(KeyEvent.VK_CONTROL);
                rb.keyRelease(KeyEvent.VK_V);
                sleep(1000);
                simulateEnter();
                sleep(3000);
            }
            WebElement clickUploadVideo = chromeDriver.findElement(By.id("addvideo"));
            clickUploadVideo.click();
            copycatch("D:\\Pic Bug\\WEALLNET.mp4");
            sleep(1000);
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            sleep(1000);
            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyRelease(KeyEvent.VK_V);
            sleep(1000);
            simulateEnter();
        }
        sleep(15000);
        WebElement luuButton = chromeDriver.findElement(By.xpath("//a[contains(text(),'Lưu')]"));
        JavascriptExecutor executor = (JavascriptExecutor) chromeDriver;
        executor.executeScript("arguments[0].click();", luuButton);
    }
    @Test
    public void Video() throws AWTException {
        createChannelAndAddAction("VIDEO",chromeDriver, url);
        Setup();
        MaxiumWin(chromeDriver);
        AdminLogin(url , "SystemAdmin","wWeallnet@#2023!",chromeDriver);
        sleep(3000);
        String[] access = {"vi/video"};
        for(String Access : access) {
            chromeDriver.get(url + Access);
            WebElement link = chromeDriver.findElement(By.cssSelector("a.button-save"));
            link.click();
            sleep(3000);
            WebElement Title = chromeDriver.findElement(By.id("ctrlTitle"));
            Title.sendKeys("Phim moi.net");
            WebElement searchChannel = chromeDriver.findElement(By.cssSelector("div[data-bind='click:$root.startSearchPopupChannelConfig']"));
            searchChannel.click();
            sleep(3000);
            WebElement search = chromeDriver.findElement(By.xpath("//input[@class='form-control reset-btn' and @placeholder='Tìm kiếm...']"));
            ;
            search.sendKeys("Khoa Review Phim");
            sleep(10000);
            WebElement clickbutton = chromeDriver.findElement(By.className("search-icon-new"));
            clickbutton.click();
            sleep(3000);
            WebElement buttonAddChanel = chromeDriver.findElement(By.cssSelector("a.btn.new-btn.btn-smallest[data-bind*='visible:$root.videoVM().video()!=null'][data-bind*='click:$root.selectChannelConfig']"));
            buttonAddChanel.click();
            WebElement addDescription = chromeDriver.findElement(By.id("ctrlDescription"));
            addDescription.sendKeys("Phim hay lam");
            sleep(3000);
            WebElement ReleateDate = chromeDriver.findElement(By.id("ctrlReleaseDate"));
            ReleateDate.sendKeys("23/01/2024");
            sleep(3000);
            Robot rb = new Robot();
            String[] update = {"updateleftimage","updaterightimage"};
            for(String Update : update) {
                WebElement divElement = chromeDriver.findElement(By.id(Update));
                divElement.click();
                copycatch("D:\\Pic Bug\\Testpic.jpg");
                sleep(1000);
                rb.keyPress(KeyEvent.VK_CONTROL);
                rb.keyPress(KeyEvent.VK_V);
                sleep(1000);
                rb.keyRelease(KeyEvent.VK_CONTROL);
                rb.keyRelease(KeyEvent.VK_V);
                sleep(1000);
                simulateEnter();
                sleep(3000);
            }
            WebElement clickUploadVideo = chromeDriver.findElement(By.id("addvideo"));
            clickUploadVideo.click();
            copycatch("D:\\Pic Bug\\WEALLNET.mp4");
            sleep(1000);
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            sleep(1000);
            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyRelease(KeyEvent.VK_V);
            sleep(1000);
            simulateEnter();
        }
        sleep(15000);
        WebElement luuButton = chromeDriver.findElement(By.xpath("//a[contains(text(),'Lưu')]"));
        JavascriptExecutor executor = (JavascriptExecutor) chromeDriver;
        executor.executeScript("arguments[0].click();", luuButton);
    }
    @Test
    public void PostPicture() throws AWTException {
        createChannelAndAddAction("PHOTO",chromeDriver, url);
        Setup();
        MaxiumWin(chromeDriver);
        AdminLogin(url , "SystemAdmin","wWeallnet@#2023!",chromeDriver);
        sleep(3000);
        String[] access = {"vi/Photo/Admin"};
        for(String Access : access) {
            chromeDriver.get(url + Access);
            WebElement link = chromeDriver.findElement(By.cssSelector("a.button-save"));
            link.click();
            sleep(3000);
            WebElement Title = chromeDriver.findElement(By.id("ctrlTitle"));
            Title.sendKeys("Phim moi.net");
            WebElement searchChannel = chromeDriver.findElement(By.cssSelector("div[data-bind='click:$root.startSearchPopupChannelConfig']"));
            searchChannel.click();
            sleep(3000);
            WebElement search = chromeDriver.findElement(By.xpath("//input[@class='form-control reset-btn' and @placeholder='Tìm kiếm...']"));
            ;
            search.sendKeys("Khoa Review Phim");
            sleep(10000);
            WebElement clickbutton = chromeDriver.findElement(By.className("search-icon-new"));
            clickbutton.click();
            sleep(3000);
            WebElement buttonAddChanel = chromeDriver.findElement(By.cssSelector("a.btn.new-btn.btn-smallest[data-bind*='visible:$root.photoVM().photo()!=null'][data-bind*='click:$root.selectChannelConfig']"));
            buttonAddChanel.click();
            WebElement addDescription = chromeDriver.findElement(By.id("ctrlDescription"));
            addDescription.sendKeys("Phim hay lam");
            sleep(3000);
            WebElement buttonKeyWord = chromeDriver.findElement(By.id("addkeyword"));
            buttonKeyWord.click();
            sleep(3000);
            WebElement searchKeyword = chromeDriver.findElement(By.id("search-keyword-input"));
            searchKeyword.sendKeys("đòi lại tiền");
            sleep(3000);
            WebElement clickbutton2 = chromeDriver.findElement(By.id("searchChanelkey"));
            clickbutton2.click();
            sleep(3000);
            WebElement searchValue = chromeDriver.findElement(By.id("doilaitien"));
            searchValue.click();
            sleep(3000);
            WebElement closeButton = chromeDriver.findElement(By.id("deleteBtuttonkeyword"));
            closeButton.click();
            sleep(3000);
            Robot rb = new Robot();
            String[] accessPicture = {"D:\\Pic Bug\\Testpic.jpg","D:\\Pic Bug\\Testpic1.jpg","D:\\Pic Bug\\Testpic3.jpg"};
            for ( String acc: accessPicture) {
                WebElement picture = chromeDriver.findElement(By.id("screenshot-tab"));;
                picture.click();
                sleep(3000);
                WebElement uploadalotpicture = chromeDriver.findElement(By.id("cms-upload-drag-and-drop"));
                uploadalotpicture.click();
                sleep(3000);
                copycatch(acc);
                sleep(1000);
                rb.keyPress(KeyEvent.VK_CONTROL);
                rb.keyPress(KeyEvent.VK_V);
                sleep(1000);
                rb.keyRelease(KeyEvent.VK_CONTROL);
                rb.keyRelease(KeyEvent.VK_V);
                sleep(1000);
                simulateEnter();
            }
            sleep(5000);
            WebElement luuButton = chromeDriver.findElement(By.xpath("//a[contains(text(),'Lưu')]"));
            JavascriptExecutor executor = (JavascriptExecutor) chromeDriver;
            executor.executeScript("arguments[0].click();", luuButton);
        }
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

}
