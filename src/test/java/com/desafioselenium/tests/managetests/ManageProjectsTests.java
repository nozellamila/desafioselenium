package com.desafioselenium.tests.managetests;

import com.desafioselenium.bases.TestBase;
import com.desafioselenium.flows.LoginFlows;
import com.desafioselenium.pages.MainPage;
import com.desafioselenium.pages.managepages.ManageProjectsPage;
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

    }

    @Test
    public void criarProjetoPrivado(){
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        manageProjectsPage = new ManageProjectsPage();

        String username = "administrator";
        String senha = "administrator";
        int rdm = new Random().nextInt(1000);
        String nomeProjeto = "Projeto" + rdm;
        String viewStatus = "private";

        loginFlows.efetuarLogin(username, senha);

        mainPage.clicarMenuManage();
        mainPage.clicarManageProjects();
        manageProjectsPage.clicarCriarProjeto();
        manageProjectsPage.preencherNomeProjeto(nomeProjeto);
        manageProjectsPage.selecionarViewStatus(viewStatus);
        manageProjectsPage.clicarAddProjeto();

        manageProjectsPage.findProjetoCadastrado();

        Assert.assertTrue(manageProjectsPage.mensagemEstaPresente(" This project is private. Only administrators and manually added users have access.\t"));

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

        //cria projeto
        manageProjectsPage.clicarCriarProjeto();
        manageProjectsPage.preencherNomeProjeto(nomeProjeto);
        manageProjectsPage.clicarAddProjeto();

        //altera projeto
        manageProjectsPage.findProjetoCadastrado();
        manageProjectsPage.selecionarStatus(status);
        manageProjectsPage.clicarUpdateProjeto();

        Assert.assertTrue(manageProjectsPage.retornaTextoColunaStatus().contains(status));

    }

    @Test
    public void criarSubProjeto(){
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        manageProjectsPage = new ManageProjectsPage();

        String username = "administrator";
        String senha = "administrator";
        int rdm = new Random().nextInt(1000);
        String nomeProjeto = "Projeto" + rdm;
        String nomeSubProjeto = "Subprojeto";
        String status = "release";

        loginFlows.efetuarLogin(username, senha);

        mainPage.clicarMenuManage();
        mainPage.clicarManageProjects();
        manageProjectsPage.clicarCriarProjeto();
        manageProjectsPage.preencherNomeProjeto(nomeProjeto);
        manageProjectsPage.clicarAddProjeto();

        manageProjectsPage.findProjetoCadastrado();
        manageProjectsPage.clicarCriarSubProjeto();
        manageProjectsPage.preencherNomeProjeto(nomeSubProjeto);
        manageProjectsPage.clicarAddProjeto();

        manageProjectsPage.findProjetoCadastrado();

        Assert.assertTrue(manageProjectsPage.retornaTextoColunaNameSubProjeto().contains(nomeSubProjeto));

    }

    @Test
    public void criarCategoria(){
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        manageProjectsPage = new ManageProjectsPage();

        String username = "administrator";
        String senha = "administrator";
        int rdm = new Random().nextInt(1000);
        String categoria = "Categoria" + rdm;


        loginFlows.efetuarLogin(username, senha);

        mainPage.clicarMenuManage();
        mainPage.clicarManageProjects();

        manageProjectsPage.preencherCategoria(categoria);
        manageProjectsPage.clicarAddCategoria();

        Assert.assertTrue(manageProjectsPage.retornaTextoColunaCategoria().contains(categoria));
    }

    @Test
    public void criarVersao(){
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        manageProjectsPage = new ManageProjectsPage();

        String username = "administrator";
        String senha = "administrator";
        int rdm = new Random().nextInt(1000);
        String nomeProjeto = "Projeto" + rdm;
        String versao = "v." + rdm;

        loginFlows.efetuarLogin(username, senha);

        mainPage.clicarMenuManage();
        mainPage.clicarManageProjects();
        manageProjectsPage.clicarCriarProjeto();
        manageProjectsPage.preencherNomeProjeto(nomeProjeto);
        manageProjectsPage.clicarAddProjeto();

        manageProjectsPage.findProjetoCadastrado();
        manageProjectsPage.scrollToVersao();
        manageProjectsPage.preencherVersao(versao);
        manageProjectsPage.clicarAddVersao();

        Assert.assertTrue(manageProjectsPage.retornaTextoColunaVersao().contains(versao));
    }

    @Test
    public void adicionarUsuarioProjeto(){
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        manageProjectsPage = new ManageProjectsPage();

        String username = "administrator";
        String senha = "administrator";
        int rdm = new Random().nextInt(1000);
        String nomeProjeto = "Projeto" + rdm;
        String usuario = "test.reporter";

        loginFlows.efetuarLogin(username, senha);

        mainPage.clicarMenuManage();
        mainPage.clicarManageProjects();
        manageProjectsPage.clicarCriarProjeto();
        manageProjectsPage.preencherNomeProjeto(nomeProjeto);
        manageProjectsPage.clicarAddProjeto();

        manageProjectsPage.findProjetoCadastrado();

        manageProjectsPage.scrollToVersao();
        manageProjectsPage.selecionarUsuario(usuario);
        manageProjectsPage.clicarAddUsuario();

        Assert.assertTrue(manageProjectsPage.retornaTextoColunaUsername().contains(usuario));
    }


}
