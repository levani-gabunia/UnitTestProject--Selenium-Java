package Pages;

import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class CommonPage {
    WebDriver driver;

    By createAccBTn = By.className("ty-account-info__title-txt");
    By userDataPassInput = By.xpath("/html/body/div[1]/div[4]/div[4]/div/div/div[2]/div/div/div/form/div[2]/input");
    By userDataPass2Input = By.xpath("//*[@id=\"password2\"]");
    By userDataCityInput = By.name("user_data[s_city]");
    By userDataAdressInput = By.name("user_data[s_address]");
    By UImessage = By.xpath("//*[@id=\"tygh_container\"]/div[3]/div");
    By loginForm = By.xpath("/html/body/div[4]");

}
