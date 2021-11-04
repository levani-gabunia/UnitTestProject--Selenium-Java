package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;

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
        Thread.sleep(3000);
        driver.findElement(createAccBTn).click();
        Thread.sleep(3000);
        driver.findElement(loginForm).isDisplayed();
        return this;
    }
    @Step("Click Recovery Button: {0}")

    public RecoveryPage GoToRecovery() {
        driver.findElement(recoveryBtn).click();
        return this;
    }
    @Step("Fill Mail: {0}")
    public RecoveryPage FillMail(String mail) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(mailInput).sendKeys(mail);
        return this;
    }
    @Step("Click Submit: {0}")
    public RecoveryPage ClickSubmit() {
        driver.findElement(recoverySubmitBtn).click();
        String color = driver.findElement(UImessage).getText();//getCssValue("border-color");
        Assert.assertEquals(color, "×\n" +
                "ინფორმაცია პაროლის აღდგენის ინსტრუქცია გაგზავნილია თქვენს ელ-პოსტაზე.");
        return this;
    }
    @Step("Yahoo Login - change Password: {0}")
    public RecoveryPage yahooLogin(String mail, String pass,String city, String adress) throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://login.yahoo.com/?.lang=en-US&src=homepage&.done=https%3A%2F%2Fwww.yahoo.com%2F&pspid=2023538075&activity=ybar-signin");
        driver.findElement(yahooMailInput).sendKeys(mail);
        driver.findElement(yahooMailSubmitBtn).click();
        Thread.sleep(2000);
        driver.findElement(yahooPassInput).sendKeys(pass);
        driver.findElement(yahooMailSubmitBtn).click();
        driver.findElement(yahooMailBoxBtb).click();
        driver.findElement(firstMail).click();
        Thread.sleep(2000);
/*        driver.findElement(recoveryLink).click();
        driver.findElement(userDataPassInput).sendKeys(pass);
        driver.findElement(userDataPass2Input).sendKeys(pass);
        driver.findElement(userDataCityInput).sendKeys(city);
        driver.findElement(userDataCityInput).sendKeys(adress);
        driver.findElement(changePassBtn).click();*/
        return this;
    }
}
