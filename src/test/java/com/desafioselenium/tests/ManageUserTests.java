package com.desafioselenium.tests;

import com.desafioselenium.bases.TestBase;
import com.desafioselenium.flows.ManageUserFlows;
import com.desafioselenium.pages.LoginPage;
import com.desafioselenium.pages.MainPage;
import com.desafioselenium.pages.ManageUserPage;
import com.desafioselenium.pages.ViewIssuesPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Random;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ManageUserTests extends TestBase {
    LoginPage loginPage;
    MainPage mainPage;
    ManageUserPage manageUserPage;
    ManageUserFlows manageUserFlows;

    @Test
    public void criarUsuario(){
        loginPage = new LoginPage();
        mainPage = new MainPage();
        manageUserPage = new ManageUserPage();
        int rdm = new Random().nextInt(1000);

        String usuario = "administrator";
        String senha = "administrator";
        String novoUsuario = "teste" + rdm;
        String email = "teste-" + rdm + "@email.com";

        loginPage.preenhcerUsuario(usuario);
        loginPage.clicarEmEntrar();
        loginPage.preencherSenha(senha);
        loginPage.clicarEmEntrar();

        mainPage.clicarMenuManage();
        mainPage.clicarManageUsers();

        manageUserPage.clicarCriarNovaConta();
        manageUserPage.preencherUsernameInput(novoUsuario);
        manageUserPage.preencherRealnameInput(novoUsuario);
        manageUserPage.preencherEmailInput(email);
        manageUserPage.clicarCreateUserButton();

        mainPage.clicarMenuManage();
        mainPage.clicarManageUsers();

        manageUserPage.preencherPesquisarUsuario(novoUsuario);
        manageUserPage.clicarAplicarFiltro();

        Assert.assertTrue(manageUserPage.retornaTextoColunaRealName().contains(novoUsuario));

        manageUserPage.clicarColunaUsername();
        manageUserPage.deletarUsuario();

    }

    @Test//csv
    public void criarUsuarioInformacoesInvalidas(){
        loginPage = new LoginPage();
        mainPage = new MainPage();
        manageUserPage = new ManageUserPage();
        int rdm = new Random().nextInt(1000);

        String usuario = "administrator";
        String senha = "administrator";
        String novoUsuario = "teste" + rdm;
        String email = "teste-" + rdm + "@email.com";



    }

    @Test
    public void filtrarUsuario(){
        loginPage = new LoginPage();
        mainPage = new MainPage();
        manageUserPage = new ManageUserPage();
        manageUserFlows = new ManageUserFlows();

        String novoUsuario = manageUserFlows.criarUsuario();

        Assert.assertTrue(manageUserPage.retornaTextoColunaRealName().contains(novoUsuario));

        manageUserPage.clicarColunaUsername();
        manageUserPage.deletarUsuario();

    }

    @Test
    public void editarUsuario(){
        loginPage = new LoginPage();
        mainPage = new MainPage();
        manageUserPage = new ManageUserPage();
        manageUserFlows = new ManageUserFlows();
        String novoAccessLevel = "updater";

        String usuario = manageUserFlows.criarUsuario();

        manageUserPage.clicarColunaUsername();
        manageUserPage.selecionarAccessLevelUpdateUser(novoAccessLevel);
        manageUserPage.clicarUpdateUser();

        mainPage.clicarManageUsers();

        manageUserPage.preencherPesquisarUsuario(usuario);
        manageUserPage.clicarAplicarFiltro();

        Assert.assertTrue(manageUserPage.retornaTextoColunaAccessLevel().contains(novoAccessLevel));

        manageUserPage.clicarColunaUsername();
        manageUserPage.deletarUsuario();

    }

    @Test
    public void desabilitarUsuario(){
        loginPage = new LoginPage();
        mainPage = new MainPage();
        manageUserPage = new ManageUserPage();
        manageUserFlows = new ManageUserFlows();

        String usuario = manageUserFlows.criarUsuario();

        manageUserPage.clicarColunaUsername();
        manageUserPage.clicarEnabledCheckbox();
        manageUserPage.clicarUpdateUser();

        mainPage.clicarManageUsers();

        manageUserPage.clicarShowDisabledCheckbox();
        manageUserPage.preencherPesquisarUsuario(usuario);
        manageUserPage.clicarAplicarFiltro();

        Assert.assertTrue(!manageUserPage.checkHabilitadoExiste());

        manageUserPage.clicarColunaUsername();
        manageUserPage.deletarUsuario();
    }

    @Test
    public void resetSenhaUsuario(){
        loginPage = new LoginPage();
        mainPage = new MainPage();
        manageUserPage = new ManageUserPage();
        manageUserFlows = new ManageUserFlows();

        String usuario = manageUserFlows.criarUsuario();

        manageUserPage.clicarColunaUsername();

        manageUserPage.clicarEnabledCheckbox();
        manageUserPage.clicarUpdateUser();

        mainPage.clicarManageUsers();

        manageUserPage.clicarShowDisabledCheckbox();
        manageUserPage.preencherPesquisarUsuario(usuario);
        manageUserPage.clicarAplicarFiltro();

        Assert.assertTrue(!manageUserPage.checkHabilitadoExiste());

        manageUserPage.clicarColunaUsername();
        manageUserPage.deletarUsuario();
    }
}
