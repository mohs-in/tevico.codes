package org.tevico;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class QuestionOne {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/mohsin/Downloads/chromedriver-mac-arm64/chromedriver");
        SafariDriver driver = new SafariDriver();

        driver.get("https://console.tevi.co/login");
        driver.manage().window().maximize();

        try {
            System.out.println("Landed on Login Page");

            WebElement email = driver.findElement(By.id("signinSrEmail"));
            email.clear();
            email.sendKeys("tevicouser@gmail.com");
            System.out.println("Entered Email Address");

            WebElement password = driver.findElement(By.id("signupSrPassword"));
            password.clear();
            password.sendKeys("@10724e2eF");
            System.out.println("Entered Password");

            WebElement SignInButton = driver.findElement(By.className("btn-primary"));
            SignInButton.click();
            System.out.println("Clicked on Sign In Button");

            System.out.println("User Signed In Successful.");

        } catch (Exception e) {
            System.out.println("Error!!! Work on it...");
        }
    }
}
