package com.desafioselenium.tests;

import com.desafioselenium.bases.TestBase;
import com.desafioselenium.dbsteps.UsuariosDBSteps;
import com.desafioselenium.pages.LoginPage;
import com.desafioselenium.pages.MainPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class LoginTests extends TestBase {

    LoginPage loginPage;
    MainPage mainPage;

    @Test
    public void efetuarLoginComSucesso(){
        loginPage = new LoginPage();
        mainPage = new MainPage();

        String usuario = "administrator";
        String senha = "administrator";

        loginPage.preenhcerUsuario(usuario);
        loginPage.clicarEmEntrar();
        loginPage.preencherSenha(senha);
        loginPage.clicarEmEntrar();

        Assert.assertEquals(usuario, mainPage.retornaUsernameDasInformacoesDeLogin());
    }

    @Test
    public void efetuarLoginComSenhaInvalida(){

        loginPage = new LoginPage();
        mainPage = new MainPage();

        String usuario = "administrator";
        String senha = "123";
        String msgSenhaInvalida = "Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.";

        loginPage.preenhcerUsuario(usuario);
        loginPage.clicarEmEntrar();
        loginPage.preencherSenha(senha);
        loginPage.clicarEmEntrar();

        Assert.assertEquals(msgSenhaInvalida, loginPage.retornaMensagemDeErro());
    }
}
