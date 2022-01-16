package com.desafioselenium.tests;

import com.desafioselenium.bases.TestBase;
import com.desafioselenium.dbsteps.UsuariosDBSteps;
import com.desafioselenium.pages.LoginPage;
import com.desafioselenium.pages.MainPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class LoginTests extends TestBase {
    //Objects
    LoginPage loginPage;
    MainPage mainPage;

    //Tests
    @Test
    public void efetuarLoginComSucesso(){
        //Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();

        //Parameteres
        String usuario = "templateautomacao";
        String senha = "123456";

        //Test
        loginPage.preenhcerUsuario(usuario);
        loginPage.preencherSenha(senha);
        loginPage.clicarEmLogin();

        Assert.assertEquals(usuario, mainPage.retornaUsernameDasInformacoesDeLogin());
    }

    //@Test
    public void efetuarLoginComSucesso_SenhaRetornadaDoDB(){
        //Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();

        //Parameteres
        String usuario = "templateautomacao";
        String senha = UsuariosDBSteps.retornaSenhaDoUsuarioDB(usuario);

        //Test
        loginPage.preenhcerUsuario(usuario);
        loginPage.preencherSenha(senha);
        loginPage.clicarEmLogin();

        Assert.assertEquals(usuario, mainPage.retornaUsernameDasInformacoesDeLogin());
    }
}
