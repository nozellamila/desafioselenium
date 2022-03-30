package com.desafioselenium.pages;

import com.desafioselenium.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class MyAccountPage extends PageBase {
    //Mapping
    By userInfoLink = By.xpath("//div[2]/ul/li[3]/a/span");
    By myAccountLink = By.xpath("//div[2]/ul/li[3]/ul/li[1]/a");
    By senhaAtualInput = By.id("password-current");
    By novaSenhaInput = By.id("password");
    By confirmacaoNovaSenhaInput = By.id("password-confirm");
    By updateUserButton = By.xpath("//input[@value='Update User']");
    By realNameInput = By.id("realname");
    By preferencesLink = By.xpath("//a[text()='Preferences']");
    By refreshDelayInput = By.id("refresh-delay");
    By updatePrefsButton = By.xpath("//div[2]/div[2]/button");


    //Actions
    public void clicarUserInfo(){click(userInfoLink);}
    public void clicarMyAccount(){click(myAccountLink);}
    public void clicarUpdateUser(){click(updateUserButton);}
    public void preencherSenhaAtual(String senha){sendKeys(senhaAtualInput, senha);}
    public void preencherNovaSenha(String novaSenha){sendKeys(novaSenhaInput, novaSenha);}
    public void preencherConfirmacaoSenha(String confirmaSenha){sendKeys(confirmacaoNovaSenhaInput, confirmaSenha);}
    public void preencherRealnameInput(String realname){clear(realNameInput); sendKeys(realNameInput, realname);}
    public String retornaRealName(){return getValue(realNameInput);}
    public void clicarPreferences(){click(preferencesLink);}
    public void preencherRefreshDelayInput(String refreshDelay){clear(refreshDelayInput); sendKeys(refreshDelayInput, refreshDelay);}
    public String retornaRefreshDelay(){return getValue(refreshDelayInput);}
    public void scrollToInicio(){ ScrollToTop(); }
    public void scrollToUpdatePrefs(){ScrollToElementJavaScript(updatePrefsButton);}
    public void clicarUpdatePrefs(){click(updatePrefsButton);}

}
