package com.desafioselenium.tests;

import com.desafioselenium.bases.TestBase;
import com.desafioselenium.dbsteps.UsuariosDBSteps;
import com.desafioselenium.flows.LoginFlows;
import com.desafioselenium.flows.ManageUserFlows;
import com.desafioselenium.pages.LoginPage;
import com.desafioselenium.pages.MainPage;
import com.desafioselenium.utils.DriverFactory;
import com.desafioselenium.utils.Utils;
import io.qameta.allure.Allure;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.util.Random;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class LoginTests extends TestBase {

    ManageUserFlows manageUserFlows;
    LoginFlows loginFlows;
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

    @Test
    public void criarConta(){
        loginPage = new LoginPage();
        loginFlows = new LoginFlows();
        manageUserFlows = new ManageUserFlows();

        int rdm = new Random().nextInt(1000);
        String username = "user" + rdm;
        String email = "user-" + rdm + "@email.com";
        String usuario = "administrator";
        String senha = "administrator";

        loginPage.clicarEmCriarNovaConta();
        loginPage.preenhcerUsuario(username);
        loginPage.preencherEmail(email);
        loginPage.clicarCriarConta();

        Assert.assertTrue(loginPage.mensagemEstaPresente("Registro de conta processado"));
    }

    @Test
    public void criarContaUsuarioInvalido(){
        loginPage = new LoginPage();
        loginFlows = new LoginFlows();
        manageUserFlows = new ManageUserFlows();

        int rdm = new Random().nextInt(1000);
        String email = "user-" + rdm + "@email.com";
        String usuario = "administrator";

        loginPage.clicarEmCriarNovaConta();
        loginPage.preenhcerUsuario(usuario);
        loginPage.preencherEmail(email);
        loginPage.clicarCriarConta();

        Assert.assertTrue(loginPage.mensagemEstaPresente("Este nome de usuário já está sendo usado.  Por favor, volte e selecione um outro."));

    }

    @Test
    public void criarContaEmailInvalido(){
        loginPage = new LoginPage();
        loginFlows = new LoginFlows();
        manageUserFlows = new ManageUserFlows();

        int rdm = new Random().nextInt(1000);
        String email = "root@localhost";
        String usuario = "user-" + rdm;

        loginPage.clicarEmCriarNovaConta();
        loginPage.preenhcerUsuario(usuario);
        loginPage.preencherEmail(email);
        loginPage.clicarCriarConta();

        Assert.assertTrue(loginPage.mensagemEstaPresente("Este e-mail já está sendo usado.  Por favor, volte e selecione outro."));

    }

    @Test
    public void esqueciASenhaUsuario(){
        loginPage = new LoginPage();
        loginFlows = new LoginFlows();
        manageUserFlows = new ManageUserFlows();

        String email = "root@localhost";
        String usuario = "administrator";

        loginPage.preenhcerUsuario(usuario);
        loginPage.clicarEmEntrar();
        loginPage.clicarPerdeuASenha();
        loginPage.preencherEmail(email);
        loginPage.clicarEnviar();

        Assert.assertTrue(loginPage.mensagemEstaPresente("Entrar"));

    }

    @Test
    public void esqueciASenhaUsuarioUsuarioInvalido(){
        loginPage = new LoginPage();
        loginFlows = new LoginFlows();
        manageUserFlows = new ManageUserFlows();

        String email = "root@localhost";
        String usuario = "administrator";

        loginPage.preenhcerUsuario(usuario);
        loginPage.clicarEmEntrar();
        loginPage.clicarPerdeuASenha();
        loginPage.preenhcerUsuario(usuario);
        loginPage.preencherEmail(email);
        loginPage.clicarEnviar();

        Assert.assertTrue(loginPage.mensagemEstaPresente("A informação fornecida não combina com nenhuma conta registrada!"));
    }
    @Test
    public void esqueciASenhaUsuarioEmailInvalido(){
        loginPage = new LoginPage();
        loginFlows = new LoginFlows();
        manageUserFlows = new ManageUserFlows();

        String email = "abcd@localhost";
        String usuario = "administrator";

        loginPage.preenhcerUsuario(usuario);
        loginPage.clicarEmEntrar();
        loginPage.clicarPerdeuASenha();
        loginPage.preencherEmail(email);
        loginPage.clicarEnviar();

        Assert.assertTrue(loginPage.mensagemEstaPresente("A informação fornecida não combina com nenhuma conta registrada!"));
    }
}
