
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author aluno
 */

@Stateless
public class PessoaDAO {
    
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;

    public PessoaDAO() {
        System.out.println("PESSOA DAO");
    }

    public void inserir(Pessoa pessoa){
        
        em.persist(pessoa);

    }
    
    
    
    
    
}
