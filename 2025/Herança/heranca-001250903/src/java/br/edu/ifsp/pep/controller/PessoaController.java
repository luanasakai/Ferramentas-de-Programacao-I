package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.PessoaDAO;
import br.edu.ifsp.pep.dao.PessoaFisicaDAO;
import br.edu.ifsp.pep.dao.PessoaJuridicaDAO;
import br.edu.ifsp.pep.entity.Pessoa;
import br.edu.ifsp.pep.entity.PessoaFisica;
import br.edu.ifsp.pep.entity.PessoaJuridica;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author aluno
 */
@Named(value = "pessoaController")
@SessionScoped
public class PessoaController implements Serializable {
    
    @Inject
    private PessoaDAO pessoaDAO;
    
    @Inject
    private PessoaFisicaDAO pessoaFisicaDAO;
    
    @Inject
    private PessoaJuridicaDAO pessoaJuridicaDAO;
    
    public void inserirPessoa(){
        
        System.out.println("INSERINDO PESSOA");
        Pessoa p =new Pessoa();
        p.setNome("Luana");
        
        pessoaDAO.inserir(p);
        
        PessoaFisica pf = new PessoaFisica();
        pf.setNome("Luana Com CPF");
        pf.setCpf("44444444444444");
        
        pessoaFisicaDAO.inserir(pf);
        
        PessoaJuridica pj = new PessoaJuridica();
        pj.setNome("Luana Com CNJP");
        pj.setCnpj("000011111292938");
        
        pessoaJuridicaDAO.inserir(pj);      
    }
    
}
