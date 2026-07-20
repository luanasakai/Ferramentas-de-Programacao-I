package br.edu.ifsp.pep.listener;

import jakarta.faces.context.FacesContext;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;

public class ControleAcessoListener implements PhaseListener{

    @Override
    public void afterPhase(PhaseEvent event) {
        System.out.println("After Phase: " + event.getPhaseId());
        
        FacesContext ctx = event.getFacesContext();
        String pagina = ctx.getViewRoot().getViewId();
        System.out.println("Pagina: " + pagina);
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        System.out.println("Before Phase; " + event.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
