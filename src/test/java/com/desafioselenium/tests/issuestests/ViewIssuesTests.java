package com.desafioselenium.tests.issuestests;

import com.desafioselenium.bases.TestBase;
import com.desafioselenium.flows.ReportIssueFlows;
import com.desafioselenium.flows.ViewIssuesFlows;
import com.desafioselenium.pages.LoginPage;
import com.desafioselenium.pages.issuespages.ReportIssuesPage;
import com.desafioselenium.pages.issuespages.ViewIssuesPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ViewIssuesTests extends TestBase {
    LoginPage loginPage;
    ViewIssuesPage viewIssuesPage;
    ReportIssuesPage reportIssuesPage;
    ReportIssueFlows reportIssueFlows;
    ViewIssuesFlows viewIssuesFlows;

    @Test
    public void pesquisarIssue(){
        loginPage = new LoginPage();
        viewIssuesPage = new ViewIssuesPage();

        String usuario = "administrator";
        String senha = "administrator";
        String idIssue = "0000001";

        loginPage.preenhcerUsuario(usuario);
        loginPage.clicarEmEntrar();
        loginPage.preencherSenha(senha);
        loginPage.clicarEmEntrar();

        viewIssuesPage.clicarMenuViewIssues();
        viewIssuesPage.preencherIdIssue(idIssue);

        Assert.assertEquals(idIssue, viewIssuesPage.retornaIdPesquisado());
    }

    @Test
    public void adicionarMarcador(){
        loginPage = new LoginPage();
        viewIssuesPage = new ViewIssuesPage();

        String usuario = "administrator";
        String senha = "administrator";
        String idIssue = "0000001";

        loginPage.preenhcerUsuario(usuario);
        loginPage.clicarEmEntrar();
        loginPage.preencherSenha(senha);
        loginPage.clicarEmEntrar();

        viewIssuesPage.clicarMenuViewIssues();
        viewIssuesPage.preencherIdIssue(idIssue);

        viewIssuesPage.preencherTag("tag1");
        viewIssuesPage.clicarAttach();

        Assert.assertTrue(viewIssuesPage.retornaTagCadastrada().contains("tag1"));

    }

    @Test
    public void clonarIssue(){
        loginPage = new LoginPage();
        viewIssuesPage = new ViewIssuesPage();
        reportIssuesPage = new ReportIssuesPage();

        String usuario = "administrator";
        String senha = "administrator";
        String idIssue = "0000001";
        String mensagemIssueClonada = "Issue generated from: 0000001";

        loginPage.preenhcerUsuario(usuario);
        loginPage.clicarEmEntrar();
        loginPage.preencherSenha(senha);
        loginPage.clicarEmEntrar();

        viewIssuesPage.clicarMenuViewIssues();
        viewIssuesPage.preencherIdIssue(idIssue);

        viewIssuesPage.clicarClone();
        reportIssuesPage.clicarEmSubmitReport();

        viewIssuesPage.scrollToIssueHistory();

        Assert.assertTrue(viewIssuesPage.mensagemEstaPresente(mensagemIssueClonada));

    }

    @Test
    public void mudarStatusIssue(){
        loginPage = new LoginPage();
        viewIssuesPage = new ViewIssuesPage();
        reportIssuesPage = new ReportIssuesPage();

        String usuario = "administrator";
        String senha = "administrator";
        String idIssue = "0000001";
        String statusNew = "new";
        String confirmacaoStatusNew = "New Issue";
        String statusFeedback = "feedback";
        String confirmacaoStatusFeedback = "Request Feedback";

        loginPage.preenhcerUsuario(usuario);
        loginPage.clicarEmEntrar();
        loginPage.preencherSenha(senha);
        loginPage.clicarEmEntrar();

        viewIssuesPage.clicarMenuViewIssues();
        viewIssuesPage.preencherIdIssue(idIssue);

        viewIssuesPage.selecionarStatus(statusFeedback);
        viewIssuesPage.clicarMudarStatus();
        viewIssuesPage.clicarConfirmarMudancaStatus(confirmacaoStatusFeedback);

        Assert.assertTrue(viewIssuesPage.retornaStatus().contains(statusFeedback));
    }

    @Test
    public void criarRelacionamentoIssue(){
        loginPage = new LoginPage();
        viewIssuesPage = new ViewIssuesPage();
        reportIssuesPage = new ReportIssuesPage();
        reportIssueFlows = new ReportIssueFlows();

        String idIssueARelacionar = "0000001";
        String idIssue = reportIssueFlows.criarIssue();

        viewIssuesPage.scrollToRelacionar();

        viewIssuesPage.preencherIssueRelacionada(idIssueARelacionar);
        viewIssuesPage.clicarAdicionaRelacao();

        Assert.assertTrue(viewIssuesPage.retornaIssueRelacionada().contains(idIssueARelacionar));

    }

    @Test
    public void verificarHistoricoIssue(){
        loginPage = new LoginPage();
        viewIssuesPage = new ViewIssuesPage();
        reportIssuesPage = new ReportIssuesPage();
        reportIssueFlows = new ReportIssueFlows();
        viewIssuesFlows = new ViewIssuesFlows();

        reportIssueFlows.criarIssue();
        viewIssuesPage.scrollToIssueHistory();

        int qtdLinhasBefore = viewIssuesPage.countLinhasTabelaHistorico();

        viewIssuesPage.scrollToInicio();

        viewIssuesFlows.mudaStatusIssue();
        viewIssuesPage.scrollToIssueHistory();

        int qtdLinhasAfter = viewIssuesPage.countLinhasTabelaHistorico();

        Assert.assertTrue(qtdLinhasAfter > qtdLinhasBefore);

    }

    @Test
    public void adicionarAnotacaoIssue(){
        loginPage = new LoginPage();
        viewIssuesPage = new ViewIssuesPage();
        reportIssuesPage = new ReportIssuesPage();
        reportIssueFlows = new ReportIssueFlows();
        viewIssuesFlows = new ViewIssuesFlows();
        String anotacao = "Anotacao teste";

        reportIssueFlows.criarIssue();
        viewIssuesPage.scrollToTabelaActivity();

        int qtdLinhasBefore = viewIssuesPage.countLinhasTabelaActivity();

        viewIssuesPage.preencherAnotacao(anotacao);
        viewIssuesPage.clicarAdicionarAnotacao();

        int qtdLinhasAfter = viewIssuesPage.countLinhasTabelaActivity();

        Assert.assertTrue(qtdLinhasAfter > qtdLinhasBefore);

        viewIssuesPage.scrollToInicio();
    }

    @Test
    public void enviarLembreteIssue(){
        loginPage = new LoginPage();
        viewIssuesPage = new ViewIssuesPage();
        reportIssuesPage = new ReportIssuesPage();
        reportIssueFlows = new ReportIssueFlows();
        viewIssuesFlows = new ViewIssuesFlows();
        String lembrete = "lembrete teste";
        String destinatario = "administrator";

        reportIssueFlows.criarIssue();
        viewIssuesPage.scrollToTabelaActivity();

        int qtdLinhasBefore = viewIssuesPage.countLinhasTabelaActivity();

        viewIssuesPage.scrollToInicio();
        viewIssuesPage.clicarSendReminder();
        viewIssuesPage.selecionarDestinatario(destinatario);
        viewIssuesPage.preencherLembrete(lembrete);
        viewIssuesPage.clicarSendLembrete();

        viewIssuesPage.scrollToTabelaActivity();

        int qtdLinhasAfter = viewIssuesPage.countLinhasTabelaActivity();

        Assert.assertTrue(qtdLinhasAfter > qtdLinhasBefore);

        viewIssuesPage.scrollToInicio();

    }

    @Test
    public void fecharIssue(){
        loginPage = new LoginPage();
        viewIssuesPage = new ViewIssuesPage();
        reportIssuesPage = new ReportIssuesPage();
        reportIssueFlows = new ReportIssueFlows();

        reportIssueFlows.criarIssue();

        viewIssuesPage.fecharIssue();

        Assert.assertTrue(viewIssuesPage.retornaStatus().contains("closed"));
    }

    @Test
    public void reabrirIssue(){
        loginPage = new LoginPage();
        viewIssuesPage = new ViewIssuesPage();
        reportIssuesPage = new ReportIssuesPage();
        reportIssueFlows = new ReportIssueFlows();

        reportIssueFlows.criarIssue();

        viewIssuesPage.fecharIssue();

        Assert.assertTrue(viewIssuesPage.retornaStatus().contains("closed"));

        viewIssuesPage.clicarReabrirIssue();
        viewIssuesPage.clicarRequestFeedback();

        Assert.assertTrue(viewIssuesPage.retornaStatus().contains("feedback"));

    }
}
