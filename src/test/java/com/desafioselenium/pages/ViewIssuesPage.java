package com.desafioselenium.pages;

import com.desafioselenium.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ViewIssuesPage extends PageBase {

    //Mapping
    By viewIssuesMenu = By.xpath("//span[text()=' View Issues ']");
    By bugIdInput = By.name("bug_id");
    By bugIdField = By.xpath("//td[@class='bug-id']");

    //Actions
    public void clicarMenuViewIssues(){
        click(viewIssuesMenu);
    }
    public void preencherIdIssue(String id){
        sendKeys(bugIdInput, id + Keys.ENTER);
    }
    public String retornaIdPesquisado(){return getText(bugIdField);}
}
