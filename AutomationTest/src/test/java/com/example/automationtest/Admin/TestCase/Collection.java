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
import java.io.File;

public class Collection extends BestFunction {
    ChromeDriver chromeDriver;
    private String url = "https://localhost:44399/";
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
    }

    @Test
    public void addCollection(){
        MaxiumWin(chromeDriver);
//        LogAdmin(chromeDriver);
        AdminLogin(url , "SystemAdmin","wWeallnet@#2023!",chromeDriver);
        sleep(3000);
        chromeDriver.get(url+ "vi/bo-suu-tap/danh-sach");
        sleep(3000);
        //Click add Collection
        WebElement btaddCollection = chromeDriver.findElement(By.className("button-save"));
        btaddCollection.click();
        WebElement name = chromeDriver.findElement(By.id("ctrlName"));
        name.sendKeys("Khoa Review Phim");
        sleep(3000);
        WebElement nameEnglish = chromeDriver.findElement(By.id("ctrlNameEn"));
        nameEnglish.sendKeys("KhoaPu");
        sleep(3000);
        WebElement description = chromeDriver.findElement(By.id("ctrlDescription"));
        description.sendKeys("Review phim rất hay");
        sleep(3000);
        WebElement searchIcon = chromeDriver.findElement(By.className("fa-search"));
        searchIcon.click();
        sleep(3000);
        WebElement search = chromeDriver.findElement(By.cssSelector("input.form-control.reset-btn"));
        search.sendKeys("Khoa Review Phim");
        sleep(10000);
        WebElement clickbutton = chromeDriver.findElement(By.className("search-icon-new"));
        clickbutton.click();
        sleep(3000);
        WebElement addButton = chromeDriver.findElement(By.xpath("//a[contains(@class, 'btn') and i[@class='far fa-plus']]"));
        addButton.click();
        sleep(3000);
        WebElement enable = chromeDriver.findElement(By.id("ctrlEnable"));
        enable.click();
        WebElement elementToClick = chromeDriver.findElement(By.cssSelector("a.button-save"));
        // Click the element
        elementToClick.click();
        sleep(5000);
        WebElement addButton2 = chromeDriver.findElement(By.className("btn-primary"));
        addButton2.click();
        sleep(3000);

//        WebElement closeButton = chromeDriver.findElement(By.id("btnameclose"));
//        closeButton.click();
//        sleep(3000);

        WebElement luuButton = chromeDriver.findElement(By.xpath("//a[contains(text(),'Lưu')]"));
        JavascriptExecutor executor = (JavascriptExecutor) chromeDriver;
        executor.executeScript("arguments[0].click();", luuButton);

        sleep(5000);
        WebElement resetButton = chromeDriver.findElement(By.xpath("//button[@class='reset-btn']/img[contains(@src, 'icon-delete.png')]"));
        resetButton.click();
        sleep(5000);
        WebElement confirmButton = chromeDriver.findElement(By.className("confirm"));
        confirmButton.click();

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
