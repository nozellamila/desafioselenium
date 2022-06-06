package com.desafioselenium.pages.managepages;

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
    By editSubProjectButton = By.xpath("//a[text()='Edit']");
    By countLinhasName = By.xpath("//div[2]/table/tbody/tr/td[1]/a");
    By colunaStatus = By.xpath("//div[2]/table/tbody/tr[1]/td[2]");
    By statusSelect = By.id("project-status");
    By criarSubProjetoButton = By.xpath("//button[text()='Create New Subproject']");
    By colunaNameSubProjeto = By.xpath("//div[2]/div/fieldset/div/table/tbody/tr/td[1]/a");
    By addCategoriaInput = By.name("name");
    By addCategoriaButton = By.xpath("//input[@value='Add Category']");
    By colunaCategoria = By.xpath("//div[4]/div/div[2]/div/div/table/tbody/tr[1]/td[1]");
    By deletarCategoriaButton = By.xpath("//table/tbody/tr[1]/td[3]/div/div[2]/form/button");
    By confirmarDeletarCategoriaButton = By.xpath("//input[@value='Delete Category']");
    By versaoInput = By.name("version");
    By addVersaoButton = By.xpath("//input[@value='Add Version']");
    By colunaVersion = By.xpath("//div[5]/div[2]/div/div[3]/div/div/table/tbody/tr/td[1]");
    By deletarVersaoButton = By.xpath("//button[text()='Delete']");
    By confirmarDeletarVersaoButton = By.xpath("//input[@value='Delete Version']");
    By viewStatusSelect = By.id("project-view-state");
    By usuarioSelect = By.id("project-add-users-username");
    By addUsuarioButton = By.xpath("//input[@value='Add User']");
    By colunaUsername = By.xpath("//div[3]/form/div[1]/table/tbody/tr/td[1]/a/span");
    By enabledCheckbox = By.xpath("//table/tbody/tr[3]/td[2]/span");
    By checkColunaEnabled = By.xpath("//div[2]/table/tbody/tr[1]/td[3]/i");
    By nomeProjetoTag = By.xpath("//div[2]/table/tbody/tr[1]/td[1]/a");


    //Actions
    public void clicarCriarProjeto(){click(criarProjetoButton);}
    public void clicarCriarSubProjeto(){click(criarSubProjetoButton);}
    public void clicarEditarSubProjeto(){click(editSubProjectButton);}
    public void clicarAddProjeto(){click(addProjectButton);}
    public void clicarAddCategoria(){click(addCategoriaButton);}
    public void clicarUpdateProjeto(){click(updateProjectButton);}
    public void preencherNomeProjeto(String nome){sendKeys(projectNameInput, nome);}
    public void findProjetoCadastrado(){
        click(nomeProjetoTag);
    }
    public String retornaNomeProjeto(){return getValue(projectNameInput);}
    public void deleteProjeto(){click(deleteProjectButton); click(deleteProjectButton);}
    public void deleteCategoria(){click(deletarCategoriaButton); click(confirmarDeletarCategoriaButton);}
    public boolean mensagemEstaPresente(String mensagem){ return retornaIfMensagemPresente(mensagem); }
    public void selecionarStatus(String status){comboBoxSelectByVisibleText(statusSelect, status);}
    public String retornaTextoColunaStatus(){return getText(colunaStatus);}
    public String retornaTextoColunaNameSubProjeto(){return getText(colunaNameSubProjeto);}
    public String retornaTextoColunaCategoria(){return getText(colunaCategoria);}
    public void preencherCategoria(String categoria){sendKeys(addCategoriaInput, categoria);}
    public void preencherVersao(String versao){sendKeys(versaoInput, versao);}
    public void clicarAddVersao(){ClickJavaScript(addVersaoButton);}
    public void clicarDeletarVersao(){click(deletarVersaoButton); click(confirmarDeletarVersaoButton);}
    public String retornaTextoColunaVersao(){return getText(colunaVersion);}
    public void scrollToInicio(){ ScrollToTop(); }
    public void scrollToVersao(){ScrollToElementJavaScript(versaoInput);}
    public void selecionarViewStatus(String viewStatus){comboBoxSelectByVisibleText(viewStatusSelect, viewStatus);}
    public void selecionarUsuario(String usuario){comboBoxSelectByVisibleText(usuarioSelect, usuario);}
    public void clicarAddUsuario(){click(addUsuarioButton);}
    public String retornaTextoColunaUsername(){return getText(colunaUsername);}
    public boolean checkHabilitadoExiste(){return returnIfElementExists(checkColunaEnabled);}
    public void clicarEnabledCheckbox(){click(enabledCheckbox);}

}
