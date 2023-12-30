package org.tevico;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QuestionThree {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "/Users/mohsin/Downloads/chromedriver-mac-arm64/chromedriver");
        SafariDriver driver = new SafariDriver();

        driver.get("https://console.tevi.co/login");
        driver.manage().window().maximize();

        try {
            System.out.println("Landed on Login Page");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement forgotPass = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/forgotpass']")));

            forgotPass.click();
            System.out.println("Clicked on Forgot Password?");

            driver.navigate().to("https://console.tevi.co/forgotpass");
            driver.get("https://console.tevi.co/forgotpass");
            System.out.println("Opened Forgot Password Page");

            WebElement email = driver.findElement(By.id("signinSrEmail"));
            email.clear();
            email.sendKeys("tevicouser@gmail.com");

            WebElement submitButton = driver.findElement(By.className("btn-primary"));
            submitButton.click();

            System.out.println("Forgot Link Sent Successfully");

        } catch (Exception e) {
                System.out.println(e);
        }
    }
}