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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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

    @ParameterizedTest(name = "{index} => categoria={0}, resumo={1}, descricao={2}, mensagem={3}")
    @CsvFileSource(resources = "/data/issueValidations.csv")
    public void criarIssueDadosInvalidos(String categoria,
                                         String resumo,
                                         String descricao,
                                         String mensagem){
        loginPage = new LoginPage();
        reportIssuesPage = new ReportIssuesPage();
        viewIssuesPage = new ViewIssuesPage();
        reportIssueFlows = new ReportIssueFlows();
        int rdm = new Random().nextInt(1000);
        resumo = resumo + rdm;
        descricao = descricao + rdm;

        String usuario = "administrator";
        String senha = "administrator";

        loginPage.preenhcerUsuario(usuario);
        loginPage.clicarEmEntrar();
        loginPage.preencherSenha(senha);
        loginPage.clicarEmEntrar();

        reportIssuesPage.clicarMenuReportIssue();
        reportIssuesPage.clicarSelecionarProjeto();
        reportIssuesPage.selecionarCategoria(categoria);
        reportIssuesPage.preencherResumo(resumo);
        reportIssuesPage.preencherDescricao(descricao);
        reportIssuesPage.clicarEmSubmitReport();

        Assert.assertTrue(reportIssuesPage.mensagemEstaPresente(mensagem));
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
