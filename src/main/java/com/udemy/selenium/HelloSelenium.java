package com.udemy.selenium;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HelloSelenium {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mh/workspaceSelenium/chromedriver");

        String baseUrl = "http://google.com";

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);

        driver.findElement(By.id("lst-ib")).sendKeys("letskodeit");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")).click();
        driver.findElement(By.linkText("Let's Kode It | Selenium Webdriver Tutorial | Rest API Tutorial")).click();

        String mainWindowHandle = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.ignoring(TimeoutException.class);


        wait.until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            public Boolean apply(@NullableDecl WebDriver webDriver) {
                System.out.println(webDriver.findElement(By.id("comp-jgmoxwr2inlineContent")));
                return webDriver.findElement(By.id("comp-jgmoxwr2inlineContent")).isDisplayed();
            }
        });

        driver.findElement(By.className("style-jgmoxws8")).click();

    }
}
