package com.desafioselenium.tests;

import com.desafioselenium.bases.TestBase;
import com.desafioselenium.pages.LoginPage;
import com.desafioselenium.pages.ViewIssuesPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ViewIssuesTests extends TestBase {
    LoginPage loginPage;
    ViewIssuesPage viewIssuesPage;

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
}
