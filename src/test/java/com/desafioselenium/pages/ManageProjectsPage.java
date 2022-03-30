package com.desafioselenium.pages;

import com.desafioselenium.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ManageProjectsPage extends PageBase {
    //Mapping
    By criarProjetoButton = By.xpath("//button[text()='Create New Project']");
    By projectNameInput = By.id("project-name");
    By addProjectButton = By.xpath("//input[@value='Add Project']");
    By deleteProjectButton = By.xpath("//input[@value='Delete Project']");
    By updateProjectButton = By.xpath("//input[@value='Update Project']");
    By countLinhasName = By.xpath("//div[2]/table/tbody/tr/td[1]/a");
    By colunaStatus = By.xpath("//div[2]/table/tbody/tr[1]/td[2]");
    By statusSelect = By.id("project-status");

    //Actions
    public void clicarCriarProjeto(){click(criarProjetoButton);}
    public void clicarAddProjeto(){click(addProjectButton);}
    public void clicarUpdateProjeto(){click(updateProjectButton);}
    public void preencherNomeProjeto(String nome){sendKeys(projectNameInput, nome);}
    public void findProjetoCadastrado(){
        String pathNome = "//div[2]/table/tbody/tr[1]/td[1]/a";

        WebElement tagWebelement = waitForElement(By.xpath(pathNome));
        tagWebelement.click();

    }
    public String retornaNomeProjeto(){return getValue(projectNameInput);}
    public void deleteProjeto(){click(deleteProjectButton); click(deleteProjectButton);}
    public boolean mensagemEstaPresente(String mensagem){ return retornaIfMensagemPresente(mensagem); }
    public void selecionarStatus(String status){comboBoxSelectByVisibleText(statusSelect, status);}
    public String retornaTextoColunaStatus(){return getText(colunaStatus);}
}
