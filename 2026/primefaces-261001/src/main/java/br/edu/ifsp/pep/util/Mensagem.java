package br.edu.ifsp.pep.util;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
@Named
@RequestScoped
public class Mensagem{
    
    public static void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
    public static void showInfo(String conteudo) {
        addMessage(FacesMessage.SEVERITY_INFO, "Infomacao", conteudo);
    }
    public static void showWarn(String conteudo) {
        addMessage(FacesMessage.SEVERITY_WARN, "Atencao", conteudo);
    }
    public static void showError(String conteudo) {
        addMessage(FacesMessage.SEVERITY_ERROR, "Erro", conteudo);
    }
    public void showSticky() {
        FacesContext.getCurrentInstance().addMessage("sticky-key", new FacesMessage(FacesMessage.SEVERITY_INFO, "Sticky Message", "Message Content"));
    }
    public void showMultiple() {
        addMessage(FacesMessage.SEVERITY_INFO, "Message 1", "Message Content");
        addMessage(FacesMessage.SEVERITY_INFO, "Message 2", "Message Content");
        addMessage(FacesMessage.SEVERITY_INFO, "Message 3", "Message Content");
    }
}