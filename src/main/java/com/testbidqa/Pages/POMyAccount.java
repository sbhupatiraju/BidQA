package com.testbidqa.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by soumya on 4/30/17.
 */
public class POMyAccount {

    WebDriver driver;

    @FindBy(xpath="//ul[@id='my-account-admin-menu_seller']/li/a[@href='http://test.bidqa.com/post-new/']")//(linkText = "Post New Project")
    WebElement postNewPrj;

    @FindBy(linkText = "Active Projects ")
    WebElement activePrj;

    @FindBy(xpath = ".//*[@id='my-account-admin-menu_seller']/li[3]/a")
    WebElement closedPrj;

    @FindBy(linkText = "Unpublished Projects ")
    WebElement unpublishedPrj;

    @FindBy(linkText = "Awaiting Completion ")
    WebElement awaitingCompletion;

    @FindBy(linkText = "Outstanding Payments ")
    WebElement outstandingPayments;

    @FindBy(xpath = ".//*[@id='my-account-admin-menu_seller']/li[7]/a")
    WebElement completedPayments;

    @FindBy(linkText = "Team Manager")
    WebElement teamManager;

    public POMyAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        //System.out.println("Inside POMyAccount constructor");
    }

    public void clickPostNewProject() throws InterruptedException {
        System.out.println("Inside clickPostNewProject ");
        //new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(postNewPrj));
        //Thread.sleep(3000);
        postNewPrj.click();
    }

    public void clickActiveProjects() {
        activePrj.click();
    }

    public void clickClosedProjects() {
        closedPrj.click();
    }

    public void clickUnpublishedProjects() {
        unpublishedPrj.click();
    }

    public void clickAwaitingCompletion() {
        awaitingCompletion.click();
    }

    public void clickOutstandingPayments() {
        outstandingPayments.click();
    }

    public void clickCompletedPayments() {
        completedPayments.click();
    }

    public void clickTeamManager() {
        teamManager.click();
    }

    @FindBy(id = "my-top-search-input")
    WebElement searchProject;
    public void setSearchProject(String prjTitle) {
        searchProject.sendKeys(prjTitle);
    }

    @FindBy(id = "my-top-submit-input")
    WebElement submitSearch;
    public void submitPrjSearch(){
        submitSearch.click();
    }

    @FindBy(linkText = "Read More")
    WebElement clickReadMore;
    public void clkReadMore(){
        clickReadMore.click();
    }

    @FindBy(xpath="//a[contains(@href,\'http://test.bidqa.com/?p_action=choose_winner\')]") //(linkText = "Select as Winner")
    WebElement selectAsWinner;
    public void clkSelectAsWinner(){
        //JavascriptExecutor jse = (JavascriptExecutor)driver;
        //jse.executeScript("window.scrollBy(0,350)", "");
        selectAsWinner.click();
    }

    @FindBy(name = "yes")
    WebElement chooseAWinner;
    public void clkChooseAWinner(){
        chooseAWinner.click();
    }


}
