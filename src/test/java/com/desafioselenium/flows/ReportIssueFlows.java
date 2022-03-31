package com.desafioselenium.flows;

import com.desafioselenium.pages.LoginPage;
import com.desafioselenium.pages.issuespages.ReportIssuesPage;
import com.desafioselenium.pages.issuespages.ViewIssuesPage;

import java.util.Random;

public class ReportIssueFlows {
    LoginPage loginPage;
    ReportIssuesPage reportIssuesPage;
    ViewIssuesPage viewIssuesPage;

    public ReportIssueFlows(){
        loginPage = new LoginPage();
        reportIssuesPage = new ReportIssuesPage();
        viewIssuesPage = new ViewIssuesPage();
    }

    public String criarIssue(){
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

        return viewIssuesPage.retornaIdPesquisado();
    }
}
