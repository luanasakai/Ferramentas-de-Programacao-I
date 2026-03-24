package br.edu.ifsp.dao;

import br.edu.ifsp.entity.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author aluno
 */
@Stateless
public class pessoaDAO {
    
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;

    public pessoaDAO() {
        System.out.println("Pessoa DAO");
    }
    
    public void inserir(Pessoa p){
        em.persist(p);
    }
    
}
