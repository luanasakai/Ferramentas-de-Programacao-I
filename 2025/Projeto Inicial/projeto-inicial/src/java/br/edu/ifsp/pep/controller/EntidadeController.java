package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.EntidadeDAO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author aluno
 */
@Named
/*CRIA NOVA REQUISICAO = NEW OBJETO
  OBJETO SESSIONSCOPED SO EXISTE ENQUANTO A SESSAO ESTIVER ATIVA
//@SessionScoped*/
/*As classes (controller) sao instanciadas pelo servidor (neste caso o glassfish)*/
@RequestScoped
public class EntidadeController implements Serializable{
    
    @Inject()
    private EntidadeDAO entidadeDAO;    
}
