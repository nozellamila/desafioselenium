package com.desafioselenium.pages.managepages;

import com.desafioselenium.bases.PageBase;
import org.openqa.selenium.By;

public class ManageCustomFieldsPage extends PageBase {
    //Mapping
    By addCustomFieldInput = By.name("name");
    By addCustomFieldButton = By.xpath("//input[@value='New Custom Field']");
    By customNameInput = By.id("custom-field-name");
    By deleteCustomFieldButton = By.xpath("//input[@value='Delete Custom Field']");
    By updateCustomFieldButton = By.xpath("//input[@value='Update Custom Field']");
    By confirmaDeleteButton = By.xpath("//input[@value='Delete Field']");
    By linkProjectButton = By.xpath("//input[@value='Link Custom Field']");
    By defaultValueInput = By.id("custom-field-default-value");
    By selecionarProjetoSelect = By.id("custom-field-project-id");

    //Actions
    public void clicarAdicionarCustomField(){click(addCustomFieldButton);}
    public void clicarUpdateCustomField(){click(updateCustomFieldButton);}
    public void clicarLinkProjeto(){click(linkProjectButton);}
    public void preencherNomeCustom(String nome){sendKeys(addCustomFieldInput, nome);}
    public void preencherDefaultValue(String defaultValue){sendKeys(defaultValueInput, defaultValue);}
    public String retornaTextoCustomName(){return getValue(customNameInput);}
    public void deletaCustomField(){click(deleteCustomFieldButton); click(confirmaDeleteButton);}
    public void scrollToUpdate(){ScrollToElementJavaScript(updateCustomFieldButton);}
    public boolean retornaTextoDefaultValue(String defaultValue){return returnIfElementExists(retornaElementoDefaultValue(defaultValue));}
    public boolean retornaProjetoLinkado(String projeto){return returnIfElementExists(retornaElementoProjeto(projeto));}
    public boolean mensagemEstaPresente(String mensagem){ return retornaIfMensagemPresente(mensagem); }
    public void selecionarProjeto(String projeto){comboBoxSelectByVisibleText(selecionarProjetoSelect, projeto);}

    public By retornaElementoDefaultValue(String defaultValue){
        return By.xpath("//td[text()='$defaultValue']".replace("$defaultValue", defaultValue));
    }
    public By retornaElementoProjeto(String projeto){
        return By.xpath("//td/strong[text()='$projeto']".replace("$projeto", projeto));
    }
}
