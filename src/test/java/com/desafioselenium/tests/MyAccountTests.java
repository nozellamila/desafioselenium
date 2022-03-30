package com.desafioselenium.tests;

import com.desafioselenium.bases.TestBase;
import com.desafioselenium.flows.LoginFlows;
import com.desafioselenium.flows.ManageUserFlows;
import com.desafioselenium.pages.LoginPage;
import com.desafioselenium.pages.MainPage;
import com.desafioselenium.pages.ManageUserPage;
import com.desafioselenium.pages.MyAccountPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class MyAccountTests extends TestBase {
    LoginFlows loginFlows;
    MainPage mainPage;
    ManageUserPage manageUserPage;
    MyAccountPage myAccountPage;

    @Test
    public void mudarSenhaUsuario(){
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        manageUserPage = new ManageUserPage();
        myAccountPage = new MyAccountPage();
        String username = "administrator";
        String senhaAtual = "administrator";
        String senhaNova = "123456";

        loginFlows.efetuarLogin(username, senhaAtual);

        myAccountPage.clicarUserInfo();
        myAccountPage.clicarMyAccount();

        myAccountPage.preencherSenhaAtual(senhaAtual);
        myAccountPage.preencherNovaSenha(senhaNova);
        myAccountPage.preencherConfirmacaoSenha(senhaNova);
        myAccountPage.clicarUpdateUser();

        loginFlows.efetuarLogin(username, senhaNova);

        Assert.assertEquals(username, mainPage.retornaUsernameDasInformacoesDeLogin());

        //Voltando à senha antiga
        myAccountPage.clicarUserInfo();
        myAccountPage.clicarMyAccount();
        myAccountPage.preencherSenhaAtual(senhaNova);
        myAccountPage.preencherNovaSenha(senhaAtual);
        myAccountPage.preencherConfirmacaoSenha(senhaAtual);
        myAccountPage.clicarUpdateUser();
    }

    @ParameterizedTest(name = "{index} => senhaAtual={0}, senhaNova={1}, confirmacaoSenha={2}, mensagem={3}")
    @CsvFileSource(resources = "/data/senhaValidations.csv")
    public void mudarSenhaUsuarioDadosInvalidos(String senhaAtual,
                                                String senhaNova,
                                                String confirmacaoSenha,
                                                String mensagem){
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        manageUserPage = new ManageUserPage();
        myAccountPage = new MyAccountPage();
        String username = "administrator";
        String senhaAdm = "administrator";

        loginFlows.efetuarLogin(username, senhaAdm);

        myAccountPage.clicarUserInfo();
        myAccountPage.clicarMyAccount();

        myAccountPage.preencherSenhaAtual(senhaAtual);
        myAccountPage.preencherNovaSenha(senhaNova);
        myAccountPage.preencherConfirmacaoSenha(confirmacaoSenha);
        myAccountPage.clicarUpdateUser();

        Assert.assertTrue(myAccountPage.mensagemEstaPresente(mensagem));
    }

    @Test
    public void editarUsuario(){
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        manageUserPage = new ManageUserPage();
        myAccountPage = new MyAccountPage();
        String username = "administrator";
        String senha = "administrator";
        String nomeReal = "Mila Nozella";
        String novoNomeReal = "teste editar";

        loginFlows.efetuarLogin(username, senha);

        myAccountPage.clicarUserInfo();
        myAccountPage.clicarMyAccount();

        myAccountPage.preencherRealnameInput(novoNomeReal);
        myAccountPage.clicarUpdateUser();

        myAccountPage.clicarUserInfo();
        myAccountPage.clicarMyAccount();

        Assert.assertEquals(novoNomeReal, myAccountPage.retornaRealName());

        myAccountPage.preencherRealnameInput(nomeReal);
        myAccountPage.clicarUpdateUser();
    }

    @Test
    public void editarPreferenciasUsuario(){
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        manageUserPage = new ManageUserPage();
        myAccountPage = new MyAccountPage();
        String username = "administrator";
        String senha = "administrator";
        String refreshDelayPadrao = "30";
        String novoRefreshDelay = "40";

        loginFlows.efetuarLogin(username, senha);

        myAccountPage.clicarUserInfo();
        myAccountPage.clicarMyAccount();
        myAccountPage.clicarPreferences();

        String refreshDelayAtual = myAccountPage.retornaRefreshDelay();

        if(refreshDelayAtual.equals("40")){
            myAccountPage.preencherRefreshDelayInput(refreshDelayPadrao);
            myAccountPage.scrollToUpdatePrefs();
            myAccountPage.clicarUpdatePrefs();
            myAccountPage.scrollToInicio();
        }

        myAccountPage.preencherRefreshDelayInput(novoRefreshDelay);
        myAccountPage.clicarUpdatePrefs();

        refreshDelayAtual = myAccountPage.retornaRefreshDelay();

        Assert.assertEquals(novoRefreshDelay, refreshDelayAtual);

    }


}
