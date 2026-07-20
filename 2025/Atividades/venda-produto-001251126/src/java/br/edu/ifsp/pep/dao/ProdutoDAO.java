
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Produto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author aluno
 */
@Stateless
public class ProdutoDAO extends AbstractDAO<Produto> {
    
    public List<Produto> buscarTodos() {
        System.out.println("buscar todos");
        
        EntityManager em = getEntityManager();
        TypedQuery<Produto> query = em.createNamedQuery("Produto.buscarTodos", Produto.class);
        
        return query.getResultList();
    }
    
    public List<Produto> buscarPorNome() {
        System.out.println("buscar por nome");
        return null;
    }
    
    public Produto buscarPorCodigo(Integer codigo) {
        
        EntityManager em = getEntityManager();
        return em.find(Produto.class, codigo);
    }

    
}
