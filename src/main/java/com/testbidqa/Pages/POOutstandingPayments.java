package com.testbidqa.Pages;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by soumya on 5/1/17.
 */
public class POOutstandingPayments {
    WebDriver driver;

    public POOutstandingPayments(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='escrowme']")
    WebElement btnMakeEscrow;
    public void clkMakeEscrow(){
        btnMakeEscrow.click();
    }

    @FindBy(id="amount")
    WebElement escrowAmount;
    public void setEscrowAmount(int amt){
        escrowAmount.sendKeys(String.valueOf(amt));
    }

    @FindBy(xpath="//select[@id='my_proj_sel']")
    WebElement escrowForProject;
    public void selectEscrowProject(String txt){
        Select escrowPrj = new Select(escrowForProject);
        escrowPrj.selectByVisibleText(txt);
    }

    @FindBy(xpath ="//select[@name='uids']")
    WebElement escrowForQA;
    public void selectEscrowQAEng(String qaEng){
        Select escrowQAEng = new Select(escrowForQA);
        escrowQAEng.selectByVisibleText(qaEng);
    }

    @FindBy(xpath="//input[@name='escrowme']")
    WebElement btnEscrowMe;
    public void clkEscrowMe(){
        btnEscrowMe.click();
    }
}
