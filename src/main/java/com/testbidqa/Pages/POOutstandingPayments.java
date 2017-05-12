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

    @FindBy(linkText = "Make Escrow")
    WebElement btnMakeEscrow;
    public void clkMakeEscrow(){
        btnMakeEscrow.click();
    }

    @FindBy(id="amount")
    WebElement escrowAmount;
    public void setEscrowAmount(int amt){
        escrowAmount.sendKeys(String.valueOf(amt));
    }

    @FindBy(id="my_proj_sel")
    WebElement escrowProject;
    public void selectEscrowProject(int index){
        Select escrowPrj = new Select(escrowProject);
        escrowPrj.selectByIndex(index);
    }

    @FindBy(xpath =".//*[@id='win_providers']/select")
    WebElement escrowQA;
    public void selectEscrowQAEng(int index){
        Select escrowQAEng = new Select(escrowQA);
        escrowQAEng.selectByIndex(index);
    }

    @FindBy(name = "escrowme")
    WebElement btnEscrowMe;
    public void clkEscrowMe(){
        btnEscrowMe.click();
    }
}
