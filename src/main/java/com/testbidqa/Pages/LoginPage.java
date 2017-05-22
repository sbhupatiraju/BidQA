package com.testbidqa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Creates web elements for PageResources page
public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='log']")
    WebElement usrName;

    @FindBy(id = "login_password")
    WebElement usrPwd;

    @FindBy(id = "submits")
    WebElement signIn;

    @FindBy(xpath="//a[contains(@href,'http://test.bidqa.com/wp-login.php?action=logout')]")
    WebElement logout;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //This method is used to type in the Username for login
    public void setUsrName(String strUsrName){
        //new WebDriverWait(driver,40).until(ExpectedConditions.elementToBeClickable(usrName));
        usrName.sendKeys(strUsrName);
    }

    ////This method is used to type in the Password for login
    public void setUsrPwd(String strUsrPwd){
        usrPwd.sendKeys(strUsrPwd);
    }

    //This method clicks on the Sign In button
    public void clickSignIn() {
        signIn.click();
    }

    //This method is used to log out
    public void clickLogout(){
        logout.click();
    }

}
