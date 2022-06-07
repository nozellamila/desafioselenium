package com.desafioselenium.pages.managepages;

import com.desafioselenium.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class ManageTagsPage extends PageBase {
    //Mapping
    By tagNameInput = By.id("tag-name");
    By tagDescriptionTextArea = By.id("tag-description");
    By tagDescriptionField = By.xpath("//table/tbody/tr[1]/td[1]");
    By tagDescriptionColumn = By.xpath("//table/tbody/tr[6]/td[2]");
    By createTagButton = By.xpath("//input[@value='Create Tag']");
    By updateTagButton = By.xpath("//input[@value='Update Tag']");
    By countLinhasManageTags = By.xpath("//div[4]/div[2]/div[2]/div/table/tbody/tr/td/a");
    By deleteTagButton = By.xpath("//input[@value='Delete Tag']");
    By tagPath = By.xpath("//div[4]/div[2]/div[2]/div/table/tbody/tr/td/a");

    //Actions
    public void preencherTagName(String tagName){sendKeys(tagNameInput, tagName);}
    public void preencherTagDescription(String tag){sendKeys(tagDescriptionTextArea, tag);}
    public void clicarCreateTag(){click(createTagButton);}
    public void clicarUpdateTag(){click(updateTagButton);}
    public void clicarDeleteTag(){ click(deleteTagButton); click(deleteTagButton);}
    public int countLinhasTabelaManageTags(){
        return waitForElements(countLinhasManageTags).size();
    }
    public String retornaTagDescription(){return getText(tagDescriptionField);}
    public String retornaTagDescriptionColumn(){return getText(tagDescriptionColumn);}

    public void findTagCadastrada(String tag){
        click(tagPath);
    }
    public boolean isTagCadastrada(){

        return returnIfElementExists(tagPath);
    }
}
