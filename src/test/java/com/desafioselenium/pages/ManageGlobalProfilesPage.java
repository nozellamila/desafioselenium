package com.desafioselenium.pages;

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
    By confirmaDeleteProfileButton = By.xpath("//input[@value='Delete Profile']");
    By listaProfiles = By.xpath("//div[2]/div/div[2]/div/div/table/tbody/tr/td[1]");

    //Actions
    public void clicarAdicionarPerfil(){click(addProfileButton);}
    public void preencherPlataforma(String plataforma){sendKeys(plataformaInput, plataforma);}
    public void preencherOs(String os){sendKeys(osInput, os);}
    public void preencherOsVersao(String osVersao){sendKeys(osVersaoInput, osVersao);}
    public void findEDeletaPerfilCadastrado(String plataforna){
        List<WebElement> webElementList = waitForElements(listaProfiles);

        for(Integer i = 1; i <= webElementList.size(); i++){
            WebElement webElement = waitForElement(By.xpath("//div[2]/div/div[2]/div/div/table/tbody/tr[$i]/td[1]".replace("$i", i.toString())));
            String nomePlataforma = webElement.getText();

            if(nomePlataforma.equals(plataforna)){
                deletarPerfil(i.toString());
                return;
            }
        }
    }

    public void deletarPerfil(String linha){
        String pathDelete = "/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[$count]/td[6]/div/div[2]/form/button";

        click(By.xpath(pathDelete.replace("$count", linha)));
        click(confirmaDeleteProfileButton);}

    public boolean isPlataformaCadastrada(String plataforma){return returnIfElementExists(By.xpath("//td[text()='$plataforma']".replace("$plataforma", plataforma)));}

}
