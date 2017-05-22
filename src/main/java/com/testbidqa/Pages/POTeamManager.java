package com.testbidqa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
    public void setPrjFilters(String prj){
        prjFilters.click();
        prjFilters.sendKeys(prj);
        prjFilters.click();
        //Select select = new Select(prjFilters);
        //select.selectByVisibleText(prj);

    }

    @FindBy(id="create-new-team")
    WebElement btnCreateNewTeam;
    public void clkBtnCreateNewTeam(){
        btnCreateNewTeam.click();
    }

    @FindBy(id="select-project")
    WebElement selectProject;
    public void selectProject(String prj){
        Select project = new Select(selectProject);
        project.selectByVisibleText(prj);
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

    @FindBy(xpath = "//a[@class='show-add-user glyphicon glyphicon-user btn btn-default btn-xs']")
    WebElement addUsers;
    public void clkAddUsers(){
        //System.out.println("Inside clkAddUsers method");
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

    public int getTotalUsers(){
        Select users = new Select(selectAddUsers);
        int listSize = users.getOptions().size();
        return listSize;
    }

    @FindBy(id="submit-add-user")
    WebElement submitAddUser;
    public void clkAdd(){
        submitAddUser.click();
    }

    @FindBy(xpath = "//a[contains(@href,'http://test.bidqa.com/wp-login.php?action=logout')]")
    WebElement logout;
    public void clkLogout(){
        logout.click();
    }

    @FindBy(xpath = "//input[@class='select-all']")
    WebElement allUsers;
    public void chkAllUsers(){
        allUsers.click();
    }

    @FindBy(xpath = "//button[@id='action']")
    WebElement actions;
    public void clkActions(String txt){
        actions.click();
        Select select = new Select(actions);
        select.selectByVisibleText(txt);
    }

}
