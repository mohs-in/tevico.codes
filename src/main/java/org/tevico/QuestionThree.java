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
            // Set up WebDriverWait to wait for a max of given seconds before throwing an exception
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            System.out.println("Landed on Login Page");

            WebElement forgotPass = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/forgotpass']")));
            // Click on Forgot Password? link
            forgotPass.click();
            System.out.println("Clicked on Forgot Password?");

            driver.navigate().to("https://console.tevi.co/forgotpass");
            driver.get("https://console.tevi.co/forgotpass");
            System.out.println("Opened Forgot Password Page");

            WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signinSrEmail")));
            // Clear any existing text in the email field and enter the specified email address
            email.clear();
            email.sendKeys("tevicouser@gmail.com");

            WebElement submitButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn-primary")));
            // Click on the Submit button
            submitButton.click();

            // Display the Forget link is sent successfully
            System.out.println("Forgot Link Sent Successfully");

        } catch (Exception e) {
                System.out.println(e);
        }
    }
}
//solved