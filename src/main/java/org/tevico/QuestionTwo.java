package org.tevico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class QuestionTwo {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "/Users/mohsin/Downloads/chromedriver-mac-arm64/chromedriver");
        SafariDriver driver = new SafariDriver();

        driver.get("https://console.tevi.co/home");
        driver.manage().window().maximize();

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signinSrEmail")));
            email.clear();
            email.sendKeys("tevicouser@gmail.com");

            WebElement password = driver.findElement(By.id("signupSrPassword"));
            password.clear();
            password.sendKeys("@10724e2eF");

            WebElement SignInButton = driver.findElement(By.className("btn-primary"));
            SignInButton.click();

            System.out.println("User Sign In Successful.");

            WebElement userSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"sidebar\"]/div/div/div[1]/div/div[7]/a/span")));
            userSection.click();

            driver.navigate().to("https://console.tevi.co/user");
            driver.get("https://console.tevi.co/user");
            System.out.println("Opened Users Page");

            WebElement inviteUser = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main\"]/ng-component/div[1]/div/button")));
            inviteUser.click();

            WebElement inviteEmail = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-content']//form//div[1]//input[@formcontrolname='email']")));
            inviteEmail.sendKeys("in.mohsin@outlook.com");
            System.out.println("Invite Email Added");

            WebElement dropdowm = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ng-select[@formcontrolname='role']//span[@class='ng-arrow-wrapper']")));
            dropdowm.click();

            WebElement dropdowninput = driver.findElement(By.xpath("//ng-select[@formcontrolname='role']//div[contains(@class, 'ng-option')]//span[text()='Read-only Admin']"));
            dropdowninput.click();
            System.out.println("Read Only Mode Selected");

            WebElement savebtn = driver.findElement(By.xpath("//button[contains(@class, 'btn-primary') and contains(text(), 'Save')]"));
            savebtn.click();
            System.out.println("Invite Successful");
            Thread.sleep(5000);
            WebElement threedots = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class, 'btn-ghost-dark') and .//em[@class='bi-three-dots-vertical']]")));
            threedots.click();
            System.out.println("Three dots clicked");

            Thread.sleep(3000);

            WebElement deleteUsr = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Delete User']")));
            deleteUsr.click();
            System.out.println("Waiting for user to confirm deletion");

            WebElement deleteUser = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Delete']")));
            deleteUser.click();
            System.out.println("Deleted User");

            Thread.sleep(5000);

            System.out.println("Test Successful");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
//sovled