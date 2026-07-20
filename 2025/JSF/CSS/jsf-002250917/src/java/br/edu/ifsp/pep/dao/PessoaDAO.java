package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entity.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author aluno
 */
@Stateless
public class PessoaDAO extends AbstractDAO<Pessoa>{
    
    public List<Pessoa> buscarTodos(){
        EntityManager em = getEntityManager();
        TypedQuery<Pessoa> query =  em.createNamedQuery("Pessoa.buscarTodos", Pessoa.class);
        
        return query.getResultList();
    }
}
