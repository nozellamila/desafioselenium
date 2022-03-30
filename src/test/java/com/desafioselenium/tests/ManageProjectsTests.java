package com.desafioselenium.tests;

import com.desafioselenium.bases.TestBase;
import com.desafioselenium.flows.LoginFlows;
import com.desafioselenium.pages.MainPage;
import com.desafioselenium.pages.ManageProjectsPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Random;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)

public class ManageProjectsTests extends TestBase {
    LoginFlows loginFlows;
    MainPage mainPage;
    ManageProjectsPage manageProjectsPage;

    @Test
    public void criarProjeto(){
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        manageProjectsPage = new ManageProjectsPage();

        String username = "administrator";
        String senha = "administrator";
        int rdm = new Random().nextInt(1000);
        String nomeProjeto = "Projeto" + rdm;

        loginFlows.efetuarLogin(username, senha);

        mainPage.clicarMenuManage();
        mainPage.clicarManageProjects();
        manageProjectsPage.clicarCriarProjeto();
        manageProjectsPage.preencherNomeProjeto(nomeProjeto);
        manageProjectsPage.clicarAddProjeto();

        manageProjectsPage.findProjetoCadastrado();

        Assert.assertTrue(manageProjectsPage.retornaNomeProjeto().contains(nomeProjeto));

        manageProjectsPage.deleteProjeto();
    }

    @Test
    public void criarProjetoDadosInvalidos(){
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        manageProjectsPage = new ManageProjectsPage();

        String username = "administrator";
        String senha = "administrator";
        String nomeProjeto = "Projeto Automação Mantis API REST";

        loginFlows.efetuarLogin(username, senha);

        mainPage.clicarMenuManage();
        mainPage.clicarManageProjects();
        manageProjectsPage.clicarCriarProjeto();
        manageProjectsPage.preencherNomeProjeto(nomeProjeto);
        manageProjectsPage.clicarAddProjeto();

        Assert.assertTrue(manageProjectsPage.mensagemEstaPresente("A project with that name already exists. Please go back and enter a different name."));
    }

    @Test
    public void alterarProjeto(){
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        manageProjectsPage = new ManageProjectsPage();

        String username = "administrator";
        String senha = "administrator";
        int rdm = new Random().nextInt(1000);
        String nomeProjeto = "Projeto" + rdm;
        String status = "release";

        loginFlows.efetuarLogin(username, senha);

        mainPage.clicarMenuManage();
        mainPage.clicarManageProjects();
        manageProjectsPage.clicarCriarProjeto();
        manageProjectsPage.preencherNomeProjeto(nomeProjeto);
        manageProjectsPage.clicarAddProjeto();

        manageProjectsPage.findProjetoCadastrado();
        manageProjectsPage.selecionarStatus(status);
        manageProjectsPage.clicarUpdateProjeto();

        Assert.assertTrue(manageProjectsPage.retornaTextoColunaStatus().contains(status));

        manageProjectsPage.findProjetoCadastrado();
        manageProjectsPage.deleteProjeto();
    }
}
