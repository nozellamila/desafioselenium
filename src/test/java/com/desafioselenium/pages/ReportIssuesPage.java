package com.desafioselenium.pages;

import com.desafioselenium.bases.PageBase;
import org.openqa.selenium.By;

public class ReportIssuesPage extends PageBase {
    //Mapping
    By reportIssueMenu = By.xpath("//span[text()=' Report Issue ']");
    By selecionarProjetoButton = By.xpath("//input[@value='Select Project']");
    By categoryComboBox = By.name("category_id");
    By summaryInput = By.name("summary");
    By descriptionInput = By.name("description");
    By uploadFileInput = By.xpath("//table/tbody/tr[12]/td/input");
    By submitButton = By.xpath("//input[@type='submit']");
    By bugDescriptionField = By.xpath("//td[@class='bug-description']");

    //Actions
    public void clicarMenuReportIssue(){
        click(reportIssueMenu);
    }
    public void clicarSelecionarProjeto(){click(selecionarProjetoButton);}
    public void selecionarCategoria(String categoria){
        comboBoxSelectByVisibleText(categoryComboBox, categoria);
    }
    public void preencherResumo(String resumo){
        sendKeys(summaryInput, resumo);
    }
    public void preencherDescricao(String descricao){
        sendKeys(descriptionInput, descricao);
    }
    public void inserirAnexo(String caminhoArquivo){
        sendKeysWithoutWaitVisible(uploadFileInput, caminhoArquivo);
    }
    public void clicarEmSubmitReport(){
        click(submitButton);
    }
    public String retornaDescricaoCriada(){return getText(bugDescriptionField);}
}
