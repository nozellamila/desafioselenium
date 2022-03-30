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
    By criarNovaContaLink = By.xpath("//div[2]/a");
    By criarContaButton = By.xpath("//input[@value='Criar Conta']");
    By cliqueParaProsseguirButton = By.xpath("//div[4]/a");
    By perdeuASenhaLink = By.xpath("//form/fieldset/a");
    By enviarButton = By.xpath("//input[@value='Enviar']");

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
    public void clicarCriarConta(){
        click(criarContaButton);
    }
    public void clicarPerdeuASenha(){
        click(perdeuASenhaLink);
    }
    public void clicarEnviar(){
        click(enviarButton);
    }

    public String retornaMensagemDeErro(){
        return getText(mensagemErroTextArea);
    }

    public void clicarEmCriarNovaConta(){
        click(criarNovaContaLink);
    }
    public void preencherEmail(String email){sendKeys(emailField, email); }
    public boolean mensagemEstaPresente(String mensagem){ return retornaIfMensagemPresente(mensagem); }
    public void clicarParaProsseguir(){click(cliqueParaProsseguirButton);}
}
