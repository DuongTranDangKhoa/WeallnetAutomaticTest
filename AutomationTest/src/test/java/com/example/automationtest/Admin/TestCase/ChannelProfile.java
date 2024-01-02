package com.example.automationtest.Admin.TestCase;

import com.example.automationtest.Library.BestFunction;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class ChannelProfile extends BestFunction {
    ChromeDriver chromeDriver;
    private String name = "";
    private String Channel = "";
    private String url = "https://admin.weallnet.com/";
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
    }
    @Test
    public void ChannelProfile() throws AWTException {
        MaxiumWin(chromeDriver);
//        LogAdmin(chromeDriver);
        AdminLogin(url,"SystemAdmin","wWeallnet@#2023!",chromeDriver);
        sleep(3000);
        chromeDriver.get(url + "vi/ChannelProfile/Admin");
        sleep(3000);
        WebElement link = chromeDriver.findElement(By.cssSelector("a.button-save"));
        link.click();
        sleep(3000);
        WebElement name = chromeDriver.findElement(By.id("ctrlName"));
        name.sendKeys("Khoa Review Phim");
//        WebElement ChannelConfig = chromeDriver.findElement(By.id("ctrlChannelConfig"));
//        ChannelConfig.sendKeys("");
        WebElement searchChannel = chromeDriver.findElement(By.cssSelector("div[data-bind='click:$root.startSearchPopupUserProfile']"));
        searchChannel.click();
        sleep(3000);
        WebElement search = chromeDriver.findElement(By.cssSelector("input.form-control.reset-btn"));
        search.sendKeys("Duong Tran Dang Khoa");
        sleep(10000);
        WebElement clickbutton = chromeDriver.findElement(By.className("search-icon-new"));
        clickbutton.click();
        sleep(3000);
        WebElement clickaddingchanel = chromeDriver.findElement(By.cssSelector("a.btn.new-btn.btn-smallest[data-bind='click:$root.selectUserProfile']"));
        clickaddingchanel.click();
        sleep(3000);
        WebElement dropdown = chromeDriver.findElement(By.cssSelector("select[data-bind='value: themes']"));
        Select select = new Select(dropdown);
        select.selectByValue("black");
        //loading img
//        WebElement uploadElement = chromeDriver.findElement(By.xpath("//input[@type='file']"));
//        uploadElement.sendKeys("D:\\Pic Bug\\Testpic.jpg");
        WebElement Description = chromeDriver.findElement(By.id("ctrlDescription"));
        Description.sendKeys("Khoa Review Phim");
        sleep(3000);
        WebElement div = chromeDriver.findElement(By.cssSelector(".cms-upload-select-picture"));
        div.click();
        sleep(1000);
        Robot rb = new Robot();
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

        WebElement checkbox = chromeDriver.findElement(By.id("ctrlEnable"));
        checkbox.click();
//        WebElement PopuChannelSetting = chromeDriver.findElement(By.cssSelector("a.button-save[data-bind='click: $root.openPopupChannelSettingType']"));
//        PopuChannelSetting.click();
//        sleep(3000);
//        WebElement type = chromeDAriver.findElement(By.cssSelector("a.btn.new-btn.btn-small.text-white[data-bind='click:$root.startAddChannelSettingType']"));
//        type.click();
//        WebElement closeButton = chromeDriver.findElement(By.className("button-cancel"));
//        closeButton.click();
        sleep(3000);

        String[] access = {"D:\\Pic Bug\\Testpic.jpg","D:\\Pic Bug\\Testpic1.jpg","D:\\Pic Bug\\Testpic3.jpg"};
        for ( String acc: access) {
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
        WebElement luuButton = chromeDriver.findElement(By.xpath("//a[contains(text(),'Lưu')]"));
        JavascriptExecutor executor = (JavascriptExecutor) chromeDriver;
        executor.executeScript("arguments[0].click();", luuButton);
//        // Click the button
//        button.click();

       sleep(5000);
        WebElement resetButton = chromeDriver.findElement(By.xpath("//button[@class='reset-btn']/img[contains(@src, 'icon-delete.png')]"));
        resetButton.click();
        sleep(5000);
       WebElement confirmButton = chromeDriver.findElement(By.className("confirm"));
       confirmButton.click();
        quitChrome(chromeDriver);
    }
    @Test
    public void AddActionMovie() throws AWTException {
        MaxiumWin(chromeDriver);
        AdminLogin("https://localhost:44399","SystemAdmin","wWeallnet@#2023!",chromeDriver);
        sleep(6000);
        chromeDriver.get("https://localhost:44399" + "/vi/ChannelProfile/Admin");
        sleep(6000);
        WebElement editButton = chromeDriver.findElement(By.className("edit-btn"));
        editButton.click();
        sleep(3000);
        WebElement action = chromeDriver.findElement(By.id("addaction"));
        action.click();
        sleep(3000);
            WebElement chosing = chromeDriver.findElement(By.id("MOVIE"));
            chosing.click();
        sleep(3000);
        WebElement actionClose = chromeDriver.findElement(By.id("closeTabAction"));
        actionClose.click();
        sleep(3000);
        WebElement save = chromeDriver.findElement(By.id("SaveChannelProfile"));
        save.click();
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
