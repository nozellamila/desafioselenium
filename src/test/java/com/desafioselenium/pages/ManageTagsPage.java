package com.desafioselenium.pages;

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
    By tagDescriptionField = By.xpath("//table/tbody/tr[6]/td[2]");
    By createTagButton = By.xpath("//input[@value='Create Tag']");
    By updateTagButton = By.xpath("//input[@value='Update Tag']");
    By countLinhasManageTags = By.xpath("//div[4]/div[2]/div[2]/div/table/tbody/tr/td/a");
    By deleteTagButton = By.xpath("//input[@value='Delete Tag']");

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
    public void findTagCadastrada(String tag){
        List<WebElement> webElementList = waitForElements(countLinhasManageTags);
        AtomicReference<Integer> count = new AtomicReference<>(1);
        String pathTag = "//div[4]/div[2]/div[2]/div/table/tbody/tr[$count]/td/a";
        webElementList.forEach(webElement -> {
            String nomeTag = webElement.getText();

            if(nomeTag.equals(tag)){
                WebElement tagWebelement = waitForElement(By.xpath(pathTag.replace("$count", count.toString())));
                tagWebelement.click();
            }
            count.set(count.get() + 1);
        });
    }
    public boolean isTagCadastrada(String tag){
        List<WebElement> webElementList = waitForElements(countLinhasManageTags);
        AtomicBoolean tagExiste = new AtomicBoolean(false);
        webElementList.forEach(webElement -> {
            String nomeTag = webElement.getText();

            if(nomeTag.equals(tag)){
                tagExiste.set(true);
            }
        });
        return tagExiste.get();
    }
}
