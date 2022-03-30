package com.desafioselenium.tests;

import com.desafioselenium.bases.TestBase;
import com.desafioselenium.flows.LoginFlows;
import com.desafioselenium.pages.MainPage;
import com.desafioselenium.pages.ManageCustomFieldsPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Random;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ManageCustomFieldsTests extends TestBase {
    LoginFlows loginFlows;
    MainPage mainPage;
    ManageCustomFieldsPage manageCustomFieldsPage;

    @Test
    public void criarCustomField(){
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        manageCustomFieldsPage = new ManageCustomFieldsPage();

        String username = "administrator";
        String senha = "administrator";
        int rdm = new Random().nextInt(1000);
        String customName = "custom" + rdm;

        loginFlows.efetuarLogin(username, senha);

        mainPage.clicarMenuManage();
        mainPage.clicarManageCustomFields();

        manageCustomFieldsPage.preencherNomeCustom(customName);
        manageCustomFieldsPage.clicarAdicionarCustomField();

        Assert.assertTrue(manageCustomFieldsPage.retornaTextoCustomName().contains(customName));

        manageCustomFieldsPage.deletaCustomField();
    }

    @Test
    public void criarCustomFieldDadosInvalidos(){
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        manageCustomFieldsPage = new ManageCustomFieldsPage();

        String username = "administrator";
        String senha = "administrator";
        String mensagemErro = "A necessary field \"name\" was empty. Please recheck your inputs.";

        loginFlows.efetuarLogin(username, senha);

        mainPage.clicarMenuManage();
        mainPage.clicarManageCustomFields();

        manageCustomFieldsPage.clicarAdicionarCustomField();

        Assert.assertTrue(manageCustomFieldsPage.mensagemEstaPresente(mensagemErro));
    }

    @Test
    public void alterarCustomField(){
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        manageCustomFieldsPage = new ManageCustomFieldsPage();

        String username = "administrator";
        String senha = "administrator";
        int rdm = new Random().nextInt(1000);
        String customName = "custom" + rdm;
        String defaultValue = "default" + rdm;

        loginFlows.efetuarLogin(username, senha);

        mainPage.clicarMenuManage();
        mainPage.clicarManageCustomFields();

        manageCustomFieldsPage.preencherNomeCustom(customName);
        manageCustomFieldsPage.clicarAdicionarCustomField();

        manageCustomFieldsPage.preencherDefaultValue(defaultValue);
        manageCustomFieldsPage.scrollToUpdate();
        manageCustomFieldsPage.clicarUpdateCustomField();

        Assert.assertTrue(manageCustomFieldsPage.retornaTextoDefaultValue(defaultValue));

        manageCustomFieldsPage.clicarNomeCustomField(customName);
        manageCustomFieldsPage.deletaCustomField();
    }

    @Test
    public void linkarProjetoCustomField(){
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        manageCustomFieldsPage = new ManageCustomFieldsPage();

        String username = "administrator";
        String senha = "administrator";
        int rdm = new Random().nextInt(1000);
        String customName = "custom" + rdm;
        String projeto = "Projeto Automação Mantis API REST";

        loginFlows.efetuarLogin(username, senha);

        mainPage.clicarMenuManage();
        mainPage.clicarManageCustomFields();

        manageCustomFieldsPage.preencherNomeCustom(customName);
        manageCustomFieldsPage.clicarAdicionarCustomField();

        manageCustomFieldsPage.scrollToUpdate();
        manageCustomFieldsPage.selecionarProjeto(projeto);
        manageCustomFieldsPage.clicarLinkProjeto();

        Assert.assertTrue(manageCustomFieldsPage.retornaProjetoLinkado(projeto));

        manageCustomFieldsPage.deletaCustomField();
    }
}
