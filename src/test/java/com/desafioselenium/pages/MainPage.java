package com.desafioselenium.pages;

import com.desafioselenium.bases.PageBase;
import org.openqa.selenium.By;

public class MainPage extends PageBase {
    //Mapping
    By usernameLoginInfoTextArea = By.xpath("//td[@class='login-info-left']/span[@class='italic']");
    By reportIssueLink = By.xpath("//a[@href='/bug_report_page.php']");

    //Actions
    public String retornaUsernameDasInformacoesDeLogin(){
        return getText(usernameLoginInfoTextArea);
    }

    public void clicarEmReportIssue(){
        click(reportIssueLink);
    }
}
