package com.testbidqa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by soumya on 5/1/17.
 */
public class QAProjectsInProgress {
    WebDriver driver;

    public QAProjectsInProgress(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = ".//*[@id='post-4724']/div/div[5]/div[1]/button")
    WebElement btnStartWorkTimer;
    public void clkBtnStartWorkTimer(){
        btnStartWorkTimer.click();
    }

    @FindBy(xpath=".//*[@id='post-4724']/div/div[5]/div[2]/div/div[2]/div/label/input")
    WebElement checkBoxAccept;
    public void clkCheckBoxAccept(){
        checkBoxAccept.click();
    }

    @FindBy(xpath = ".//*[@id='post-4724']/div/div[5]/div[2]/div/div[2]/input[2]")
    WebElement btnOk;
    public void clkBtnOk(){
        btnOk.click();
    }

    @FindBy(id="stopwatch4724")
    WebElement stopWatch;

    @FindBy(xpath = ".//*[@id='post-4724']/div/div[5]/div[1]/button")
    WebElement btnStopWorkTimer;
    public void clkBtnStopWorkTimer(){
        btnStopWorkTimer.click();
    }

    @FindBy(linkText = "Mark Delivered")
    WebElement btnMarkDelivered;
    public void clkBtnMarkDelivered(){
        btnMarkDelivered.click();
    }

    @FindBy(name = "yes")
    WebElement btnYesMarkDelivered;
    public void clkBtnYesMarkDelivered(){
        btnMarkDelivered.click();
    }


}
