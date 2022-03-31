package com.desafioselenium.flows;

import com.desafioselenium.pages.LoginPage;
import com.desafioselenium.pages.issuespages.ReportIssuesPage;
import com.desafioselenium.pages.issuespages.ViewIssuesPage;

public class ViewIssuesFlows {
    LoginPage loginPage;
    ReportIssuesPage reportIssuesPage;
    ViewIssuesPage viewIssuesPage;

    public ViewIssuesFlows(){
        loginPage = new LoginPage();
        reportIssuesPage = new ReportIssuesPage();
        viewIssuesPage = new ViewIssuesPage();
    }

    public void mudaStatusIssue(){
        if(viewIssuesPage.retornaStatus().contains("feedback")){
            viewIssuesPage.selecionarStatus("new");
            viewIssuesPage.clicarMudarStatus();
            viewIssuesPage.clicarConfirmarMudancaStatus("New Issue");
        }

        viewIssuesPage.selecionarStatus("feedback");
        viewIssuesPage.clicarMudarStatus();
        viewIssuesPage.clicarConfirmarMudancaStatus("Request Feedback");
    }
}
