package org.tevico;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QuestionOne {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "/Users/mohsin/Downloads/chromedriver-mac-arm64/chromedriver");
        SafariDriver driver = new SafariDriver();

        driver.get("https://console.tevi.co/login");
        driver.manage().window().maximize();

        try {
            // Set up WebDriverWait to wait for a max of 10 sec before throwing an exception
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signinSrEmail")));
            WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signupSrPassword")));
            WebElement SignInButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn-primary")));

            System.out.println("Landed on Login Page");

            // Clear any existing text in the email field and enter the specified email address
            email.clear();
            email.sendKeys("tevicouser@gmail.com");
            System.out.println("Entered Email Address");

            // Clear any existing password in the password field and enter the specified password
            password.clear();
            password.sendKeys("@10724e2eF");
            System.out.println("Entered Password");

            // Click on the Sign-In button
            SignInButton.click();
            System.out.println("Clicked on Sign In Button");

            // Successful user Sign-In
            System.out.println("User Signed In Successful.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
// solved