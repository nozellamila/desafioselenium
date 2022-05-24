package com.desafioselenium.pages.managepages;

import com.desafioselenium.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ManageGlobalProfilesPage extends PageBase {
    //Mapping
    By plataformaInput = By.id("platform");
    By osInput = By.id("os");
    By osVersaoInput = By.id("os_build");
    By addProfileButton = By.xpath("//form/fieldset/div/div[3]/button");
    By deleteProfileButton = By.xpath("//button[text()='Delete']");
    By confirmaDeleteProfileButton = By.xpath("//input[@value='Delete Profile']");

    //Actions
    public void clicarAdicionarPerfil(){click(addProfileButton);}
    public void preencherPlataforma(String plataforma){sendKeys(plataformaInput, plataforma);}
    public void preencherOs(String os){sendKeys(osInput, os);}
    public void preencherOsVersao(String osVersao){sendKeys(osVersaoInput, osVersao);}
    public void deletaProfile(){
        click(deleteProfileButton);
        click(confirmaDeleteProfileButton);
    }
    public boolean isPlataformaCadastrada(String plataforma){return returnIfElementExists(By.xpath("//td[text()='$plataforma']".replace("$plataforma", plataforma)));}

}
