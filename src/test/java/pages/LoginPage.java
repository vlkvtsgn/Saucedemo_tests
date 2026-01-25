package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By loginInput = By.id("user-name");
    private final By passwordInput = By.xpath("//*[@data-test='password']");
    private final By loginButton = By.cssSelector("[name='login-button']");
    private final By errorMsg = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String user, String password) {
        driver.findElement(loginInput).sendKeys(user);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }

    public String getErrorText() {
        return driver.findElement(errorMsg).getText();
    }
}
/*driver.findElement(By.id("user-name")).sendKeys(Keys.COMMAND + "A");
driver.findElement(By.id("user-name")).sendKeys(Keys.BACK_SPACE);
driver.findElement(By.id("user-name")).sendKeys("standard_user");*/

