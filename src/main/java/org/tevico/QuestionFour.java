package org.tevico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QuestionFour {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "/Users/mohsin/Downloads/chromedriver-mac-arm64/chromedriver");
        SafariDriver driver = new SafariDriver();

        driver.get("https://console.tevi.co/home");
        driver.manage().window().maximize();

        try {
            System.out.println("Landed on Login Page");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signinSrEmail")));
            email.clear();
            email.sendKeys("tevicouser@gmail.com");

            WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signupSrPassword")));
            password.clear();
            password.sendKeys("@10724e2eF");

            WebElement SignInButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn-primary")));
            SignInButton.click();

            System.out.println("User Signed In Successful.");

//            driver.get("https://console.tevi.co/home");

            WebElement tevicoText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main\"]/ng-component/div/div[2]/div/div/div[2]/app-profile-switch-account/div/div[2]/ul/li[2]/div/a/div[2]/span[2]")));
            tevicoText.click();
            System.out.println("Clicked on Tevico Engineering");

            Thread.sleep(5000);

            String text = "60011 (Read-only Admin)";
            boolean userCheck = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"main\"]/ng-component/div/div[1]/div/div[1]/div[1]/div/div/span[2]"), text));

            if(userCheck) {
                System.out.println("Welcome Title Verified");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
//solved