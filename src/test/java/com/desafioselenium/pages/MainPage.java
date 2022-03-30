package com.desafioselenium.pages;

import com.desafioselenium.bases.PageBase;
import org.openqa.selenium.By;

public class MainPage extends PageBase {
    //Mapping
    By usernameLoginInfoTextArea = By.xpath("//span[@class='user-info']");
    By reportIssueLink = By.xpath("//a[@href='/bug_report_page.php']");
    By manageMenu = By.xpath("//span[text()=' Manage ']");
    By manageUsers = By.xpath("//a[text()='Manage Users']");
    By manageProjects = By.xpath("//a[text()='Manage Projects']");
    By manageTags = By.xpath("//a[text()='Manage Tags']");
    By manageCustomFields = By.xpath("//a[text()='Manage Custom Fields']");
    By manageGlobalProfiles = By.xpath("//a[text()='Manage Global Profiles']");
    By manageConfiguration = By.xpath("//a[text()='Manage Configuration']");

    //Actions
    public String retornaUsernameDasInformacoesDeLogin(){
        return getText(usernameLoginInfoTextArea);
    }

    public void clicarMenuManage(){
        click(manageMenu);
    }
    public void clicarManageUsers(){
        click(manageUsers);
    }
    public void clicarManageTags(){click(manageTags);}
    public void clicarManageProjects(){click(manageProjects);}
    public void clicarManageCustomFields(){click(manageCustomFields);}

}
