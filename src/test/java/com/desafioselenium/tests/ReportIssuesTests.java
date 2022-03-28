package com.desafioselenium.tests;

import com.desafioselenium.bases.TestBase;
import com.desafioselenium.dbsteps.IssuesDBSteps;
import com.desafioselenium.flows.ReportIssueFlows;
import com.desafioselenium.pages.LoginPage;
import com.desafioselenium.pages.ReportIssuesPage;
import com.desafioselenium.pages.ViewIssuesPage;
import com.desafioselenium.utils.DBUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Random;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ReportIssuesTests extends TestBase {
    LoginPage loginPage;
    ReportIssuesPage reportIssuesPage;
    ViewIssuesPage viewIssuesPage;
    ReportIssueFlows reportIssueFlows;

    @Test
    public void criarIssue(){
        loginPage = new LoginPage();
        reportIssuesPage = new ReportIssuesPage();
        viewIssuesPage = new ViewIssuesPage();
        int rdm = new Random().nextInt(1000);

        String usuario = "administrator";
        String senha = "administrator";
        String resumo = "teste - " + rdm;
        String descricao = "teste descricao - " + rdm;

        loginPage.preenhcerUsuario(usuario);
        loginPage.clicarEmEntrar();
        loginPage.preencherSenha(senha);
        loginPage.clicarEmEntrar();

        reportIssuesPage.clicarMenuReportIssue();
        reportIssuesPage.clicarSelecionarProjeto();
        reportIssuesPage.selecionarCategoria("[All Projects] General");
        reportIssuesPage.preencherResumo(resumo);
        reportIssuesPage.preencherDescricao(descricao);
        reportIssuesPage.clicarEmSubmitReport();

        Assert.assertEquals(descricao, reportIssuesPage.retornaDescricaoCriada());

        viewIssuesPage.deletarIssue();
    }

    @Test//csv
    public void criarIssueDadosInvalidos(){

    }

    @Test
    public void deletarIssue(){
        loginPage = new LoginPage();
        reportIssuesPage = new ReportIssuesPage();
        viewIssuesPage = new ViewIssuesPage();
        reportIssueFlows = new ReportIssueFlows();
        String mensagemErro = "APPLICATION ERROR #1100";

        String idIssue = reportIssueFlows.criarIssue();

        viewIssuesPage.deletarIssue();

        viewIssuesPage.clicarMenuViewIssues();
        viewIssuesPage.preencherIdIssue(idIssue);

        Assert.assertTrue(viewIssuesPage.mensagemEstaPresente(mensagemErro));

    }
}
