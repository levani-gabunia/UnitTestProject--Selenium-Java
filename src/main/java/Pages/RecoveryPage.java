package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecoveryPage extends CommonPage {
    WebDriver driver;

    public RecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    By recoveryBtn = By.xpath("/html/body/div[4]/div[2]/div/div/div[3]/div[2]/a");
    By mailInput = By.xpath("//*[@id=\"login_id_popup\"]");
    By recoverySubmitBtn = By.name("dispatch[auth.recover_password]");
    By changePassBtn = By.xpath("//*[@id=\"save_profile_but\"]");
    By recoveryLink = By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/ul/li[1]/div/div/div[1]/div[2]/div/div/div/div/a");
    By yahooMailInput = By.xpath("//*[@id=\"login-username\"]");//*[@id="password1"]
    By yahooMailSubmitBtn = By.xpath("//*[@id=\"login-signin\"]");
    By yahooPassInput = By.xpath("//*[@id=\"login-passwd\"]");
    By yahooMailBoxBtb = By.id("ybarMailLink");
    By firstMail = By.xpath("//*[@id=\"mail-app-component\"]/div/div/div[2]/div/div/div[3]/div/div[1]/ul/li[3]/a");

    @Step("Click Create Account Button")
    public RecoveryPage GotoCreateAccount() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(createAccBTn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(loginForm)).isDisplayed();
        return this;
    }
    @Step("Click Recovery Button: {0}")
    public RecoveryPage GoToRecovery() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(recoveryBtn)).click();
        return this;
    }
    @Step("Fill Mail: {0}")
    public RecoveryPage FillMail(String mail) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(mailInput)).click();
        return this;
    }
    @Step("Click Submit: {0}")
    public RecoveryPage ClickSubmit() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(recoverySubmitBtn)).click();
/*        String color = driver.findElement(UImessage).getText();//getCssValue("border-color");
        Assert.assertEquals(color, "×\n" +
                "ინფორმაცია პაროლის აღდგენის ინსტრუქცია გაგზავნილია თქვენს ელ-პოსტაზე.");*/
        return this;
    }
    @Step("Yahoo Login - change Password: {0}")
    public RecoveryPage yahooLogin(String mail, String pass,String city, String adress) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://login.yahoo.com/?.lang=en-US&src=homepage&.done=https%3A%2F%2Fwww.yahoo.com%2F&pspid=2023538075&activity=ybar-signin");
        wait.until(ExpectedConditions.elementToBeClickable(yahooMailInput)).sendKeys(mail);
        wait.until(ExpectedConditions.elementToBeClickable(yahooMailSubmitBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(yahooPassInput)).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(yahooMailSubmitBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(yahooMailBoxBtb)).click();
        wait.until(ExpectedConditions.elementToBeClickable(firstMail)).click();
        wait.until(ExpectedConditions.elementToBeClickable(recoveryLink)).click();
/*        driver.findElement(userDataPassInput).sendKeys(pass);
        driver.findElement(userDataPass2Input).sendKeys(pass);
        driver.findElement(userDataCityInput).sendKeys(city);
        driver.findElement(userDataCityInput).sendKeys(adress);
        driver.findElement(changePassBtn).click();*/
        return this;
    }
}
