import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginTest {
       WebDriver browser;
@BeforeMethod
public void setup() {
       ChromeOptions options = new ChromeOptions();
       options.addArguments("start-maximized");
       //options.addArguments("headless");
       browser = new ChromeDriver(options);
       browser.get("https://www.saucedemo.com/");
}



@Test
public void firstLogin() {
       // открыть браузер
       // зайдем на сайт https://www.saucedemo.com/


       /*browser.findElement(By.xpath("//*[@id='user-name']"));
       browser.findElement(By.cssSelector("[id='user-name']"));*/
       browser.findElement(By.id("user-name")).sendKeys("standard_user");
       //Thread.sleep(1000);
       browser.findElement(By.id("user-name")).sendKeys(Keys.COMMAND + "A");
       //Thread.sleep(1000);
       browser.findElement(By.id("user-name")).sendKeys(Keys.BACK_SPACE);
       //Thread.sleep(1000);
       browser.findElement(By.id("user-name")).sendKeys("standard_user");
       browser.findElement(By.xpath("//*[@data-test='password']")).sendKeys("secret_sauce");
       browser.findElement(By.cssSelector("[name='login-button']")).click();
       //[data-test='title']
       boolean titleIsDisplayed = browser.findElement(By.cssSelector("[data-test='title']")).isDisplayed();
       assertTrue(titleIsDisplayed);

       String titleName = browser.findElement(By.cssSelector("[data-test='title']")).getText();
       assertEquals(titleName, "Productsss", "Неверный заголовок");

       browser.quit();
   }

       @Test
       public void incorrectLogin() {
              // открыть браузер
              // зайдем на сайт https://www.saucedemo.com/

       /*browser.findElement(By.xpath("//*[@id='user-name']"));
       browser.findElement(By.cssSelector("[id='user-name']"));*/
              browser.findElement(By.id("user-name")).sendKeys("locked_out_user");
              browser.findElement(By.xpath("//*[@data-test='password']")).sendKeys("secret_sauce");
              browser.findElement(By.cssSelector("[name='login-button']")).click();

              boolean errorIsDisplayed = browser.findElement(By.cssSelector("[data-test='error']")).isDisplayed();
              assertTrue(errorIsDisplayed, "Нет сообщения об ошибке");

              String errorMsg = browser.findElement(By.cssSelector("[data-test='error']")).getText();
              assertEquals(errorMsg, "Epic sadface: Sorry, this user has been locked out.",
                      "Неверный текст сообщения об ошибке");
       }

       @AfterMethod
       public void closeBrowser( ){
       browser.quit();
       }

}