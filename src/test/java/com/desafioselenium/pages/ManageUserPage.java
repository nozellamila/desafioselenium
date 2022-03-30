package com.desafioselenium.pages;

import com.desafioselenium.bases.PageBase;
import org.openqa.selenium.By;

public class ManageUserPage extends PageBase {

    //Mapping
    By createNewAccountButton = By.xpath("//a[text()='Create New Account']");
    By usernameInput = By.id("user-username");
    By realNameInput = By.id("user-realname");
    By emailInput = By.id("email-field");
    By accessLevelCreateSelect = By.id("user-access-level");
    By accessLevelUpdateSelect = By.id("edit-access-level");
    By createUserButton = By.xpath("//input[@value='Create User']");
    By deleteUserButton = By.xpath("//input[@value='Delete User']");
    By confirmDeleteUserButton = By.xpath("//input[@value='Delete Account']");
    By pesquisarUsuarioInput = By.id("search");
    By aplicarFiltroButton = By.xpath("//input[@value='Apply Filter']");
    By colunaUsername = By.xpath("//table/tbody/tr[1]/td[1]/a");
    By colunaRealName = By.xpath("//table/tbody/tr/td[2]");
    By colunaAccessLevel = By.xpath("//table/tbody/tr[1]/td[4]");
    By checkColunaEnabled = By.xpath("//table/tbody/tr[1]/td[5]/i");
    By updateUserButton = By.xpath("//input[@value='Update User']");
    By enabledCheckbox = By.xpath("//div[2]/div[1]/div/div/table/tbody/tr[5]/td[2]/label/span");
    By showDisabledCheckbox = By.xpath("//form/fieldset/label[2]/span");


    //Actions
    public void clicarCriarNovaConta(){click(createNewAccountButton);}
    public void clicarCreateUserButton(){click(createUserButton);}
    public void deletarUsuario(){click(deleteUserButton); click(confirmDeleteUserButton);}
    public void preencherUsernameInput(String username){sendKeys(usernameInput, username);}
    public void preencherRealnameInput(String realname){sendKeys(realNameInput, realname);}
    public void preencherEmailInput(String email){sendKeys(emailInput, email);}

    public void selecionarAccessLevelUpdateUser(String accessLevel){comboBoxSelectByVisibleText(accessLevelUpdateSelect, accessLevel);}
    public void preencherPesquisarUsuario(String username){sendKeys(pesquisarUsuarioInput, username);}

    public void clicarAplicarFiltro(){click(aplicarFiltroButton);}
    public String retornaTextoColunaRealName(){return getText(colunaRealName);}

    public void clicarColunaUsername(){click(colunaUsername);}
    public void clicarUpdateUser(){click(updateUserButton);}
    public String retornaTextoColunaAccessLevel(){return getText(colunaAccessLevel);}

    public boolean checkHabilitadoExiste(){return returnIfElementExists(checkColunaEnabled);}
    public void clicarEnabledCheckbox(){ClickJavaScript(enabledCheckbox);}
    public void clicarShowDisabledCheckbox(){ClickJavaScript(showDisabledCheckbox);}
    public boolean mensagemEstaPresente(String mensagem){ return retornaIfMensagemPresente(mensagem); }

}
