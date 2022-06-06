package com.desafioselenium.tests.managetests;

import com.desafioselenium.bases.TestBase;
import com.desafioselenium.flows.ManageUserFlows;
import com.desafioselenium.pages.LoginPage;
import com.desafioselenium.pages.MainPage;
import com.desafioselenium.pages.managepages.ManageUserPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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
    }

    @ParameterizedTest(name = "{index} => username={0}, email={1}, mensagem={2}")
    @CsvFileSource(resources = "/data/usuarioValidations.csv")
    public void criarUsuarioInformacoesInvalidas(String username,
                                                 String email,
                                                 String mensagem){
        loginPage = new LoginPage();
        mainPage = new MainPage();
        manageUserPage = new ManageUserPage();
        int rdm = new Random().nextInt(1000);

        String usuario = "administrator";
        String senha = "administrator";

        loginPage.preenhcerUsuario(usuario);
        loginPage.clicarEmEntrar();
        loginPage.preencherSenha(senha);
        loginPage.clicarEmEntrar();

        mainPage.clicarMenuManage();
        mainPage.clicarManageUsers();

        manageUserPage.clicarCriarNovaConta();
        manageUserPage.preencherUsernameInput(username);
        manageUserPage.preencherRealnameInput(username);
        manageUserPage.preencherEmailInput(email);
        manageUserPage.clicarCreateUserButton();

        Assert.assertTrue(manageUserPage.mensagemEstaPresente(mensagem));

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
    }
}
