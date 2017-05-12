package com.testbidqa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Creates web elements for Registration Page
public class RegisterPage {

    WebDriver driver;

    @FindBy(id="user_login")
    WebElement usrName;

    @FindBy(name="user_email")
    WebElement usrEmail;

    @FindBy(name="pass1")
    WebElement usrPwd;

    @FindBy(name="pass2")
    WebElement usrRPwd;

    @FindBy(xpath = ".//*[@id='registerform']/div[5]/label[1]")
    WebElement usrTypeQA;

    @FindBy(xpath = ".//*[@id='registerform']/div[5]/label[2]")
    WebElement usrTypePO;

    @FindBy(xpath = ".//*[@id='recaptcha-anchor']/div[5]")
    WebElement usrNotRobot;

    @FindBy(name = "submits")
    WebElement submitButton;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getURL(String url){
        driver.get(url);
    }

    public void setUsrName(String strUsrName){
        usrName.sendKeys(strUsrName);
    }

    public void setUsrEmail(String strUsrEmail){
        usrEmail.sendKeys(strUsrEmail);
    }

    public void setUsrPwd(String strUsrPwd){
        usrPwd.sendKeys(strUsrPwd);
    }

    public void setUsrRPwd(String strUsrRPwd){
        usrRPwd.sendKeys(strUsrRPwd);
    }

    public void setUsrTypePO(){
        usrTypePO.click();
    }

    public void setUsrTypeQA(){
        usrTypeQA.click();
    }

    public void clickNotRobot(){
        driver.switchTo().frame("undefined");
        usrNotRobot.click();
    }

    public void submit(){
        submitButton.click();
    }
}
