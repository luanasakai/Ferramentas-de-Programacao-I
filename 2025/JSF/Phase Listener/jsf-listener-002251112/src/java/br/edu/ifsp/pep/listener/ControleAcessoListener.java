package br.edu.ifsp.pep.listener;

import br.edu.ifsp.pep.controller.LoginController;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import java.io.IOException;

public class ControleAcessoListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext ctx = event.getFacesContext();

        // Se ainda não há view (ex: primeira requisição), sai.
        if (ctx.getViewRoot() == null) {
            return;
        }

        String pagina = ctx.getViewRoot().getViewId();
        System.out.println("Verificando acesso à página: " + pagina);

        // Recupera o bean da sessão manualmente
        LoginController loginController = (LoginController) ctx.getExternalContext()
                .getSessionMap().get("loginController");

        // ✅ Páginas públicas — o listener NÃO interfere nelas
        boolean paginaPublica =
                pagina.contains("/login/login") ||
                pagina.contains("/index");

        // Define se a página é restrita
        boolean paginaRestrita = 
                pagina.contains("/manutencao/lista") ||
                pagina.contains("/pessoa/lista");

        // Verifica login
        boolean logado = loginController != null && loginController.getPessoaLogada() != null;

        // Só bloqueia se for página restrita e usuário não estiver logado
        if (paginaRestrita && !paginaPublica && !logado) {
            System.out.println("Acesso negado — redirecionando para login.xhtml");
            redirecionar(ctx, "/login/login");
        }
    }

    private void redirecionar(FacesContext ctx, String pagina) {
        try {
            String projeto = ctx.getExternalContext().getRequestContextPath();
            ctx.getExternalContext().redirect(projeto + pagina);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        // opcional para logs
    }

    @Override
    public PhaseId getPhaseId() {
        // RESTORE_VIEW evita redirecionar tarde demais
        return PhaseId.RESTORE_VIEW;
    }
}
