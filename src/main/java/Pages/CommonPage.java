package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPage {
    WebDriver driver;
    WebDriverWait wait;

    By createAccBTn = By.className("ty-account-info__title-txt");
    By userDataPassInput = By.xpath("/html/body/div[1]/div[4]/div[4]/div/div/div[2]/div/div/div/form/div[2]/input");
    By userDataPass2Input = By.xpath("//*[@id=\"password2\"]");
    By userDataCityInput = By.name("user_data[s_city]");
    By userDataAdressInput = By.name("user_data[s_address]");
    By UImessage = By.xpath("//*[@id=\"tygh_container\"]/div[3]/div");
    By loginForm = By.xpath("/html/body/div[4]");

}
