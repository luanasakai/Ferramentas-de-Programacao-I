package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Categoria;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author aluno
 */
@Stateless
public class CategoriaDAO extends AbstractDAO<Categoria>{
    
    public Categoria buscarPorCodigo(Integer codigo){
        EntityManager em = getEntityManager();
        return em.find(Categoria.class, codigo);
    }
}
