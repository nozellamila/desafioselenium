package com.desafioselenium.pages.issuespages;

import com.desafioselenium.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ViewIssuesPage extends PageBase {

    //Mapping
    By viewIssuesMenu = By.xpath("//span[text()=' View Issues ']");
    By bugIdInput = By.name("bug_id");
    By bugIdField = By.xpath("//td[@class='bug-id']");
    By bugTagsField = By.xpath("//td[@class='bug-tags']");
    By attachTagsInput = By.name("tag_string");
    By attachButton = By.xpath("//input[@value='Attach']");
    By detachButton = By.xpath("//table/tbody/tr[12]/td/a[2]");

    By cloneButton = By.xpath("//input[@value='Clone']");
    By issueHistoryTitle = By.xpath("/html/body/div[2]/div[2]/div[2]/div/div[6]/div[2]/div[1]/h4");

    By statusField = By.xpath("//td[@class='bug-status']");
    By changeStatusButton = By.xpath("//input[@value='Change Status To:']");
    By statusCombo = By.name("new_status");

    By relacionaIssueInput = By.name("dest_bug_id");
    By adicionaRelacaoButton = By.name("add_relationship");
    By issueRelacionadaField = By.xpath("//div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[2]");
    By excluirRelacaoButton = By.xpath("//table/tbody/tr/td[6]/a/i");
    By deletarRelacaoButton = By.xpath("//input[@value='Delete']");

    By linhasTabelaHistorico = By.xpath("//div[6]/div[2]/div[2]/div/div/table/tbody/tr");

    By anotacaoTextArea = By.id("bugnote_text");
    By adicionarAnotacaoButton = By.xpath("//input[@value='Add Note']");
    By linhasTabelaActivity = By.xpath("//div[4]/div[2]/div[2]/div/div/table/tbody/tr");

    By assignedToField = By.xpath("//td[@class='bug-assigned-to']/a");

    By sendReminderButton = By.xpath("//a[text()='Send a Reminder']");
    By selectRecipientSelect = By.id("recipient");
    By reminderTextArea = By.name("bugnote_text");
    By sendButton = By.xpath("//input[@value='Send']");

    By closeButton = By.xpath("//input[@value='Close']");
    By confirmarCloseButton = By.xpath("//input[@value='Close Issue']");

    By reopenButton = By.xpath("//input[@value='Reopen']");
    By requestFeedbackButton = By.xpath("//input[@value='Request Feedback']");
    By deletarIssueButton = By.xpath("//input[@value='Delete']");
    By confirmarDeletarIssueButton = By.xpath("//input[@value='Delete Issues']");

    //Actions
    public void clicarMenuViewIssues(){
        click(viewIssuesMenu);
    }
    public void preencherIdIssue(String id){
        sendKeys(bugIdInput, id + Keys.ENTER);
    }
    public String retornaIdPesquisado(){return getText(bugIdField);}

    public boolean mensagemEstaPresente(String mensagem){ return retornaIfMensagemPresente(mensagem); }

    public void preencherTag(String tag){
        sendKeys(attachTagsInput, tag);
    }
    public void clicarAttach(){ click(attachButton);}
    public String retornaTagCadastrada(){ return getText(bugTagsField);}
    public void clicarDetach(){click(detachButton);}

    public void clicarClone(){click(cloneButton);}

    public void scrollToIssueHistory(){ ScrollToElementJavaScript(issueHistoryTitle); }
    public void scrollToInicio(){ ScrollToTop(); }

    public void selecionarStatus(String status){comboBoxSelectByVisibleText(statusCombo, status);}
    public void clicarMudarStatus(){click(changeStatusButton);}
    public void clicarConfirmarMudancaStatus(String status){
        By confirmChangeStatusButton = By.xpath("//input[@value='$status']".replace("$status", status));
        click(confirmChangeStatusButton);
    }
    public String retornaStatus(){ return getText(statusField);}

    public void preencherIssueRelacionada(String id){ sendKeys(relacionaIssueInput, id);}
    public void clicarAdicionaRelacao(){ClickJavaScript(adicionaRelacaoButton);}
    public String retornaIssueRelacionada(){return getText(issueRelacionadaField);}
    public void clicarExcluirRelacao(){
        click(excluirRelacaoButton);
        click(deletarRelacaoButton);}
    public void scrollToRelacionar(){ ScrollToElementJavaScript(relacionaIssueInput); }

    public int countLinhasTabelaHistorico(){
        return waitForElements(linhasTabelaHistorico).size();
    }

    public void preencherAnotacao(String anotacao){sendKeys(anotacaoTextArea,anotacao);}
    public void clicarAdicionarAnotacao(){click(adicionarAnotacaoButton);}
    public void scrollToTabelaActivity(){ ScrollToElementJavaScript(linhasTabelaActivity); }
    public int countLinhasTabelaActivity(){ return waitForElements(linhasTabelaActivity).size(); }

    public String retornaAssignedTarefa(){return getText(assignedToField);}

    public void clicarSendReminder(){click(sendReminderButton);}
    public void selecionarDestinatario(String destinatario){comboBoxSelectByVisibleText(selectRecipientSelect, destinatario);}
    public void preencherLembrete(String lembrete){sendKeys(reminderTextArea, lembrete);}
    public void clicarSendLembrete(){click(sendButton);}

    public void fecharIssue(){
        click(closeButton);
        click(confirmarCloseButton);
    }
    public void clicarReabrirIssue(){click(reopenButton);}
    public void clicarRequestFeedback(){click(requestFeedbackButton);}
    public void deletarIssue(){
        click(deletarIssueButton);
        click(confirmarDeletarIssueButton);
    }
}
