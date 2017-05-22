package com.testbidqa.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by soumya on 4/30/17.
 */
public class QAMyAccount {

    WebDriver driver;

    @FindBy(id = "my-top-search-input")
    WebElement prjSearch;
    public void setPrjSearch(String prjName){
        prjSearch.sendKeys(prjName);
    }

    @FindBy(id ="my-top-submit-input")
    WebElement submitSearch;
    public void clickSubmitSearch(){
        submitSearch.click();
    }

    @FindBy(linkText = "Read More")
    WebElement btnReadMore;
    public void clickReadMore(){
        btnReadMore.click();
    }

    @FindBy(id = "submit-proposal-id")
    WebElement btnSubmitProposal;
    public void clkSubmitProposal(){
        btnSubmitProposal.click();
    }


    @FindBy(xpath="//div[@class='bid_panel_box_title']")
    WebElement submitYourProposalTitle;
    public String getSubmitYourProposalTitle(){
       return submitYourProposalTitle.getText();
    }


    @FindBy(id = "bid")
    WebElement bid;
    public void setYourBid(int qaBid) throws InterruptedException {
        Thread.sleep(3000);
        bid.click();
        Thread.sleep(3000);
        bid.sendKeys(String.valueOf(qaBid));
    }

    @FindBy(id = "days_done")
    WebElement daysToComplete;
    public void setDaysToComplete(int days){
         daysToComplete.clear();
         daysToComplete.sendKeys(String.valueOf(days));
    }

    @FindBy(name = "description2") //xpath = "*[@id='fancybox-content']/div/div/div[2]/div/form/ul/li[6]/p/textarea")
    WebElement bidDescription;
    public void setBidDescription(String desc){
        bidDescription.sendKeys(desc);
    }

    @FindBy(xpath = ".//*[@id='submits_crt_check']")
    WebElement checkbox;
    public void clickCheckBox(){
        checkbox.click();
    }

    @FindBy(id = "submits_crt")
    WebElement btnPlaceBid;
    public void clickPlaceBid(){
        btnPlaceBid.click();
    }

    @FindBy(xpath = "//a[@href='http://test.bidqa.com/my-account/outstanding-projects/']")
    WebElement projectsInProgress;
    public void clkProjectsInProgress(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,300)", "");
        projectsInProgress.click();
    }

    @FindBy(xpath = ".//*[@id='my-account-admin-menu']/li[6]/a")
    WebElement feedbackReviews;
    public void clkFeedBackReviews(){
        feedbackReviews.click();
    }

    @FindBy(xpath = ".//*[@id='my-account-admin-menu_buyer']/li[1]/a")
    WebElement projectsIHaveWon;
    public void clkProjectsIHaveWon(){
        projectsIHaveWon.click();
    }

    @FindBy(xpath = ".//*[@id='my-account-admin-menu_buyer']/li[5]/a")
    WebElement myProposals;
    public void clkMyProposals(){
        myProposals.click();
    }

    @FindBy(xpath = ".//*[@id='cssmenu']/ul/li[7]/a")
    WebElement logout;
    public void clkLogout(){
        logout.click();
    }

    @FindBy(xpath = "//div[@class='bid_panel_ok']//div[@class='padd10']")
    WebElement bidPlaced;
    public String getBidPlaced(){
        return bidPlaced.getText();
    }

    public QAMyAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
