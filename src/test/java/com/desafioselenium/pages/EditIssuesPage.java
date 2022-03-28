package com.desafioselenium.pages;

import com.desafioselenium.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class EditIssuesPage extends PageBase {

    //Mapping
    By editarIssueButton = By.xpath("//input[@value='Edit']");
    By statusCombo = By.name("status");
    By resolutionCombo = By.name("resolution");
    By osInput = By.id("os");
    By osVersaoInput = By.id("os_build");
    By updateIssueButton = By.xpath("//input[@value='Update Information']");
    By assignedToCombo = By.name("handler_id");

    //Actions
    public void clicarEditarIssue(){
        click(editarIssueButton);
    }
    public void selecionarStatus(String status){comboBoxSelectByVisibleText(statusCombo, status);}
    public void selecionarResolution(String resolution){comboBoxSelectByVisibleText(resolutionCombo, resolution);}
    public void preencherOs(String os){ sendKeys(osInput, os);}
    public void preencherOsVersao(String osVersao){ sendKeys(osVersaoInput, osVersao);}
    public void clicarUpdateIssue(){click(updateIssueButton);}
    public void scrollToUpdateButton(){ ScrollToElementJavaScript(updateIssueButton); }

    public void selecionarAssignedTo(String usuario){comboBoxSelectByVisibleText(assignedToCombo, usuario);}
}
