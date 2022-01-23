package com.desafioselenium.pages;

import com.desafioselenium.bases.PageBase;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {
    //Mapping
    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By emailField = By.name("email");
    By loginButton = By.xpath("//input[@type='submit']");
    By mensagemErroTextArea = By.xpath("//div[@class='alert alert-danger']/p");
    By criarNovaContaLink = By.linkText("criar nova conta");

    //Actions
    public void preenhcerUsuario(String usuario){

        sendKeys(usernameField, usuario);
    }

    public void preencherSenha(String senha){

        sendKeys(passwordField, senha);
    }

    public void clicarEmEntrar(){
        click(loginButton);
    }

    public String retornaMensagemDeErro(){
        return getText(mensagemErroTextArea);
    }

    public void clicarEmCriarNovaConta(){
        click(criarNovaContaLink);
    }
    public void preencherEmail(String email){

        sendKeys(emailField, email);
    }
}
