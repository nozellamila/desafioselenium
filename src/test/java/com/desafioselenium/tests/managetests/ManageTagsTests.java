package com.desafioselenium.tests.managetests;

import com.desafioselenium.bases.TestBase;
import com.desafioselenium.flows.LoginFlows;
import com.desafioselenium.pages.MainPage;
import com.desafioselenium.pages.managepages.ManageTagsPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Random;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ManageTagsTests extends TestBase {
    LoginFlows loginFlows;
    MainPage mainPage;
    ManageTagsPage manageTagsPage;

    @Test
    public void criarTag(){
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        manageTagsPage = new ManageTagsPage();
        int rdm = new Random().nextInt(1000);

        String usuario = "administrator";
        String senha = "administrator";
        String tag = "tag" + rdm;

        loginFlows.efetuarLogin(usuario, senha);

        mainPage.clicarMenuManage();
        mainPage.clicarManageTags();

        manageTagsPage.preencherTagName(tag);
        manageTagsPage.clicarCreateTag();

        Assert.assertTrue(manageTagsPage.retornaTagDescription().contains(tag));
    }

    @Test
    public void atualizarTag(){
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        manageTagsPage = new ManageTagsPage();
        int rdm = new Random().nextInt(1000);

        String usuario = "administrator";
        String senha = "administrator";
        String tag = "tag" + rdm;
        String descricao = "Descrição: " + tag;

        loginFlows.efetuarLogin(usuario, senha);

        mainPage.clicarMenuManage();
        mainPage.clicarManageTags();

        manageTagsPage.preencherTagName(tag);
        manageTagsPage.clicarCreateTag();

        manageTagsPage.findTagCadastrada(tag);
        manageTagsPage.clicarUpdateTag();
        manageTagsPage.preencherTagDescription(descricao);
        manageTagsPage.clicarUpdateTag();

        Assert.assertTrue(manageTagsPage.retornaTagDescription().contains(descricao));
    }

    @Test
    public void deletarTag(){
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        manageTagsPage = new ManageTagsPage();
        int rdm = new Random().nextInt(1000);

        String usuario = "administrator";
        String senha = "administrator";
        String tag = "tag" + rdm;

        loginFlows.efetuarLogin(usuario, senha);

        mainPage.clicarMenuManage();
        mainPage.clicarManageTags();

        manageTagsPage.preencherTagName(tag);
        manageTagsPage.clicarCreateTag();

        manageTagsPage.findTagCadastrada(tag);
        manageTagsPage.clicarDeleteTag();

        mainPage.clicarMenuManage();
        mainPage.clicarManageTags();

        Assert.assertTrue(!manageTagsPage.isTagCadastrada());
    }
}
