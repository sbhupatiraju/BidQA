package com.testbidqa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

// To locate web elements for 'Post New Project' and perform actions to create a project
public class POPostNewProject {

    WebDriver driver;

    @FindBy(name = "project_title")
    WebElement prjTitle;

    @FindBy(name = "project_description")
    WebElement prjDescription;

    @FindBy(xpath = "(//input[@name='project_cat_cat_multi[]'])[3]")
    WebElement prjCategoriesCheckBox;

    @FindBy(xpath = "(//input[@name='project_skill_cat_multi[]'])[4]")
    WebElement prjSkillsCheckBox;

    @FindBy(name = "budgets")
    WebElement prjBudget;

    @FindBy(id="ending")
    WebElement prjEndingOn;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[2]/a")
    WebElement prjEndingDate;

    @FindBy(xpath = "(//button[@type='button'])[5]")
    WebElement buttonDone;

    @FindBy(id = "do_input_new")
    WebElement prjCountry;

    @FindBy(name = "project_location_addr")
    WebElement prjAddress;

    @FindBy(name = "project_submit1")
    WebElement btnNextStep1;

    @FindBy(name = "project_submit2")
    WebElement btnNextStep2;

    @FindBy(xpath="//a[contains(text(),'Next Step')]")
    WebElement btnNextStep3;

    @FindBy(id="cb-payment")
    WebElement termsCheckBox ;

    @FindBy(xpath="//a[contains(@href,'paypal_listing')]")
    //(linkText = "Pay by PayPal")
    WebElement payByPayPalButton ;

    @FindBy(id = "email")
    WebElement payPalEmail;

    @FindBy(id = "password")
    WebElement payPalPwd;

    @FindBy(id = "btnLogin")
    WebElement payPalLoginBtn;

    @FindBy(xpath="//input[@id='confirmButtonTop']")
    WebElement btnPayNow;

    @FindBy(id = "merchantReturnBtn")
    WebElement merchantReturnBtn;

    @FindBy(xpath = ".//*[@id='cssmenu']/ul/li[8]/a")
    WebElement poLogout;

    //after clicking on 'Merchant Return button a security warning pop up window opens.

    public POPostNewProject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[@class='mm_inn']")
    WebElement pageTitle;
    //Method to get the page title
    public String getPageTitle(){
        return pageTitle.getText();
    }


    //This method is used to type in the Project Title
    public void setPrjTitle(String title){
        prjTitle.sendKeys(title);
    }

    //This method is used to type in the Project Description
    public void setPrjDescription(String description){
        prjDescription.sendKeys(description);
    }

    //This method clicks on a checkbox the Project Category
    public void selectCategories(){
        prjCategoriesCheckBox.click();
    }

    //This method clicks a checkbox for Skills
    public void selectSkills(){
        prjSkillsCheckBox.click();
    }

    //This method selects Project Budget from a drop down list
    public void selectPrjBudget(int index){
       Select budget = new Select(prjBudget);
       budget.selectByIndex(index);
    }

    //This method clicks on project Ending on
    public void setPrjEndingOn(){
        prjEndingOn.click();
    }

    //This method clicks on a date in the calendar pop-up
    public void setPrjEndingDate() {
        prjEndingDate.click();
    }


    //This method clicks on the Done button
    public void setButtonDone(){
        buttonDone.click();
    }

    //This method selects Country from a drop down list
    public void setPrjCountry(int index){
        Select country = new Select(prjCountry);
        country.selectByIndex(index);
    }

    //This method types in Address
    public void setPrjAddress(String address){
        prjAddress.sendKeys(address);
    }

    //This method clicks on Next Step 1 button
    public void clickNextStepBtn1(){
        btnNextStep1.click();
    }

    //This method clicks on Next Step 2 button
    public void clickNextStepBtn2(){
        btnNextStep2.click();
    }

    //This method clicks on Next Step 3 button
    public void clickNextStepBtn3(){
        btnNextStep3.click();
    }

    //This method clicks on the Check Terms checkbox
    public void chkTerms(){
        termsCheckBox.click();
    }

    //This method clicks on Pay By PayPal button
    public void clickPayByPayPal(){
        payByPayPalButton.click();
    }

    @FindBy(xpath="//h1[@class='alpha ng-binding']")
    WebElement payPalHeader;
    public String getPayPalHeader(){
        return payPalHeader.getText();
    }

    //This method types in the PayPal account email
    public void setPayPalEmail(String email){
        driver.switchTo().frame("injectedUl");
        payPalEmail.click();
        payPalEmail.sendKeys(email);
    }

    //This method types in the PayPal account password
    public void setPayPalPwd(String pwd){
        payPalPwd.sendKeys(pwd);
    }

    //This method clicks on Log In button for paypal login
    public void clickPayPalLogin(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        payPalLoginBtn.click();
    }

    //This method clicks on Pay Now button
    public void clkPayNow() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        Thread.sleep(3000);
        btnPayNow.click();
    }

    public void clickMerchantReturn(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        merchantReturnBtn.click();
    }

    public void clickLogout(){
        poLogout.click();
    }

    @FindBy(xpath="//div[@class='mm_inn mm_inn21']")
    WebElement createdProjectTitle;
    public String toGetProjectTitle(){
        return createdProjectTitle.getText();
    }

}
