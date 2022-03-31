package com.desafioselenium.flows;

import com.desafioselenium.pages.LoginPage;
import com.desafioselenium.pages.MainPage;
import com.desafioselenium.pages.managepages.ManageUserPage;

import java.util.Random;

public class ManageUserFlows {

    LoginPage loginPage;
    MainPage mainPage;
    ManageUserPage manageUserPage;

    public String criarUsuario() {
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

        return manageUserPage.retornaTextoColunaRealName();
    }

    public void deletarUsuario(String username) {
        mainPage = new MainPage();
        manageUserPage = new ManageUserPage();

        mainPage.clicarMenuManage();
        mainPage.clicarManageUsers();

        manageUserPage.preencherPesquisarUsuario(username);
        manageUserPage.clicarAplicarFiltro();

        manageUserPage.clicarColunaUsername();
        manageUserPage.deletarUsuario();
    }
}
