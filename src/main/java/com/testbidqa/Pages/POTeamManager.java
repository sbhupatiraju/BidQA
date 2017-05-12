package com.testbidqa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by soumya on 5/1/17.
 */
public class POTeamManager {

    WebDriver driver;
    public POTeamManager(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="projects-filter")
    WebElement prjFilters;
    public void setPrjFilters(int index){
        Select country = new Select(prjFilters);
        country.selectByIndex(index);
    }

    @FindBy(id="create-new-team")
    WebElement btnCreateNewTeam;
    public void clkBtnCreateNewTeam(){
        btnCreateNewTeam.click();
    }

    @FindBy(id="select-project")
    WebElement selectProject;
    public void selectProject(int index){
        Select project = new Select(selectProject);
        project.selectByIndex(index);
    }

    @FindBy(id="team-title")
    WebElement teamTitle;
    public void setTeamTitle(String title){
        teamTitle.sendKeys(title);
    }

    @FindBy(id="team-desc")
    WebElement teamDesc;
    public void setTeamDesc(String titleDesc){
        teamDesc.sendKeys(titleDesc);
    }

    @FindBy(id="submit-create-team")
    WebElement btnCreate;
    public void clkCreate(){
        btnCreate.click();
    }

    @FindBy(xpath = "//*[starts-with(@id,'team-')]") //".//*[@id='team-109']/div[1]/div[3]/a[contains(text(), 'team-')]")
    WebElement addUsers;
    public void clkAddUsers(){
        System.out.println("Inside clkAddUsers method");
        addUsers.click();
    }

    @FindBy(id="to-team")
    WebElement toTeam;
    public void selectToTeam(int index){
        Select team = new Select(toTeam);
        team.selectByIndex(index);
    }

    @FindBy(id="select-add-users")
    WebElement selectAddUsers;
    public void setSelectAddUsers(int index){
        Select users = new Select(selectAddUsers);
        users.selectByIndex(index);
    }

    @FindBy(id="submit-add-user")
    WebElement submitAddUser;
    public void clkAdd(){
        submitAddUser.click();
    }


}
