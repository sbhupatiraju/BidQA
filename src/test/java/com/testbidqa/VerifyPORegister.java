/*package com.testbidqa;

import com.testbidqa.Resources.RegisterPage;
import com.testbidqa.TestData.RegistrationData;
import com.testbidqa.Resources.HomePage;
import com.testbidqa.Resources.LoginPage;
import com.testbidqa.TestResources.PageResources;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


/**
 * Unit test for simple App.
 */
/*public class VerifyPORegister {

    WebDriver driver;
    RegistrationData rd = new RegistrationData();
    String pw = rd.createRandomName();
    String userName = rd.createRandomName();
    String email = rd.createEmail();

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "/Applications/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://test.bidqa.com/wp-login.php?action=register");
    }

    @Test
    public void poRegister() throws InterruptedException {
        PageResources pageResources = new PageResources(driver);

        pageResources.getRegisterPage().setUsrName(userName);
        pageResources.getRegisterPage().setUsrEmail(email);
        pageResources.getRegisterPage().setUsrPwd(pw);
        pageResources.getRegisterPage().setUsrRPwd(pw);
        pageResources.getRegisterPage().setUsrTypePO();
        pageResources.getRegisterPage().clickNotRobot();
        Thread.sleep(5000);
        pageResources.getRegisterPage().submit();

        //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.linkText("Post New Project")))
    }

}

   /* @Test
    public void logIn() {
        HomePage objHome = new HomePage();
        LoginPage objLogin = new LoginPage();
        objHome.clickLogin();
        objLogin.setUsrName("sam9");
        objLogin.setUsrPwd("letmein");
        objLogin.clickSignIn();

    }*/

