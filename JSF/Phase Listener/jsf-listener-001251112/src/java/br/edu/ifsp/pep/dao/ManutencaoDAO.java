package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Manutencao;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author aluno
 */
@Stateless
public class ManutencaoDAO extends AbstractDAO<Manutencao>{
    
    public List<Manutencao> buscarTodos() {
        
        EntityManager em = getEntityManager();
        TypedQuery<Manutencao> query = em.createNamedQuery("Manutencao.buscarTodos", Manutencao.class);
        
        return query.getResultList();
        
    }
    
    public List<Manutencao> buscarVeiculoManutencao(Integer id){
        EntityManager em = getEntityManager();
        
        TypedQuery<Manutencao> query = em.createNamedQuery("Manutencao.buscarVeiculoManutencao", Manutencao.class);
        query.setParameter("id", id);
        
        return query.getResultList();
    }
}