package com.desafioselenium.tests.managetests;

import com.desafioselenium.bases.TestBase;
import com.desafioselenium.flows.LoginFlows;
import com.desafioselenium.pages.MainPage;
import com.desafioselenium.pages.managepages.ManageGlobalProfilesPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Random;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ManageGlobalProfilesTests extends TestBase {
    LoginFlows loginFlows;
    MainPage mainPage;
    ManageGlobalProfilesPage manageGlobalProfilesPage;

    @Test
    public void criarPerfil(){
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        manageGlobalProfilesPage = new ManageGlobalProfilesPage();

        int rdm = new Random().nextInt(1000);
        String username = "administrator";
        String senha = "administrator";
        String plataforma = "plataforma" + rdm;
        String os = "10";
        String osVersao = "V10";

        loginFlows.efetuarLogin(username, senha);

        mainPage.clicarMenuManage();
        mainPage.clicarManageGlobalProfiles();

        manageGlobalProfilesPage.preencherPlataforma(plataforma);
        manageGlobalProfilesPage.preencherOs(os);
        manageGlobalProfilesPage.preencherOsVersao(osVersao);
        manageGlobalProfilesPage.clicarAdicionarPerfil();

        Assert.assertTrue(manageGlobalProfilesPage.isPlataformaCadastrada(plataforma));
    }

    @Test
    public void deletarPerfil(){
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        manageGlobalProfilesPage = new ManageGlobalProfilesPage();

        String username = "administrator";
        String senha = "administrator";
        String plataforma = "Windows";
        String os = "10";
        String osVersao = "V10";

        loginFlows.efetuarLogin(username, senha);

        mainPage.clicarMenuManage();
        mainPage.clicarManageGlobalProfiles();

        manageGlobalProfilesPage.preencherPlataforma(plataforma);
        manageGlobalProfilesPage.preencherOs(os);
        manageGlobalProfilesPage.preencherOsVersao(osVersao);
        manageGlobalProfilesPage.clicarAdicionarPerfil();

        manageGlobalProfilesPage.deletaProfile();

        Assert.assertTrue(!manageGlobalProfilesPage.isPlataformaCadastrada(plataforma));
    }
}
