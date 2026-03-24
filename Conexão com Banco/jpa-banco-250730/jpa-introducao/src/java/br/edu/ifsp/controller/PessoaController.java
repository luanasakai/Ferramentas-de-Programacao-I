package br.edu.ifsp.controller;

import br.edu.ifsp.dao.pessoaDAO;
import br.edu.ifsp.entity.Pessoa;
import br.edu.ifsp.entity.TipoPessoa;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author aluno
 */
@Named(value = "pessoaController")// permite o acesso pelo arquivo xhtml
@SessionScoped
public class PessoaController implements Serializable{
    
    @Inject
    private pessoaDAO pessoaDAO;
    
    public void inserir(){
        System.out.println("metodo inserir");
        
        Pessoa p = new Pessoa();
        p.setNome("Luana Satiro Sakai");
        p.setDataNascimento(LocalDate.now());
        p.setSalario(new BigDecimal(10000));
        p.setEmail("luana@gmail.com");
        p.getTipo(TipoPessoa.Administrador);
        pessoaDAO.inserir(p);
        
    }
}
