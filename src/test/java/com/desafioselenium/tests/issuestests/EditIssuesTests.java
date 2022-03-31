package com.desafioselenium.tests.issuestests;

import com.desafioselenium.bases.TestBase;
import com.desafioselenium.flows.ReportIssueFlows;
import com.desafioselenium.flows.ViewIssuesFlows;
import com.desafioselenium.pages.issuespages.EditIssuesPage;
import com.desafioselenium.pages.LoginPage;
import com.desafioselenium.pages.issuespages.ReportIssuesPage;
import com.desafioselenium.pages.issuespages.ViewIssuesPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class EditIssuesTests extends TestBase {

    LoginPage loginPage;
    ViewIssuesPage viewIssuesPage;
    ReportIssuesPage reportIssuesPage;
    ReportIssueFlows reportIssueFlows;
    ViewIssuesFlows viewIssuesFlows;
    EditIssuesPage editIssuesPage;

    @Test
    public void adicionarAnotacaoIssue(){
        loginPage = new LoginPage();
        viewIssuesPage = new ViewIssuesPage();
        reportIssuesPage = new ReportIssuesPage();
        reportIssueFlows = new ReportIssueFlows();
        editIssuesPage = new EditIssuesPage();
        String os = "OS teste";
        String osVersao = "1";
        String status = "resolved";
        String resolution = "fixed";

        reportIssueFlows.criarIssue();

        editIssuesPage.clicarEditarIssue();
        editIssuesPage.selecionarStatus(status);
        editIssuesPage.selecionarResolution(resolution);
        editIssuesPage.preencherOs(os);
        editIssuesPage.preencherOsVersao(osVersao);

        editIssuesPage.scrollToUpdateButton();
        editIssuesPage.clicarUpdateIssue();

        Assert.assertTrue(viewIssuesPage.retornaStatus().contains(status));

        viewIssuesPage.deletarIssue();
    }

    @Test
    public void mudarResponsavelIssue(){
        loginPage = new LoginPage();
        viewIssuesPage = new ViewIssuesPage();
        reportIssuesPage = new ReportIssuesPage();
        reportIssueFlows = new ReportIssueFlows();
        editIssuesPage = new EditIssuesPage();
        String responsavel = "test.developer";

        reportIssueFlows.criarIssue();

        editIssuesPage.clicarEditarIssue();
        editIssuesPage.selecionarAssignedTo(responsavel);

        editIssuesPage.scrollToUpdateButton();
        editIssuesPage.clicarUpdateIssue();

        Assert.assertTrue(viewIssuesPage.retornaAssignedTarefa().contains(responsavel));

        viewIssuesPage.deletarIssue();
    }


}
