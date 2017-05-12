package com.testbidqa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by soumya on 5/1/17.
 */
public class POAwaitingCompletion {

    WebDriver driver;
    public POAwaitingCompletion(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Mark Completed")
    WebElement btnMarkCompleted;
    public void acceptProject(){
        btnMarkCompleted.click();
    }

    @FindBy(xpath = ".//*[@id='main']/div/div[1]/div/div/form/input[2]")
    WebElement btnYesMarkCompleted;
    public void clkBtnYesMarkCompleted(){
        btnYesMarkCompleted.click();
    }


}
