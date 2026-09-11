package ifsp.pep.edu.br.dao;

import ifsp.pep.edu.br.model.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author sakai
 */
public class VendaDao extends AbstractDao<Venda>{
    
    public Venda obterPeloId(Long id){
        Venda venda;
        try(EntityManager em = getEntityManager()){
            venda = em.find(Venda.class, id);
        }
        
        return venda;
    }
    
    public List<Venda> obterTodas(){
        List<Venda> vendas;
        
        try(EntityManager em = getEntityManager()){
            TypedQuery<Venda> query = em.createNamedQuery("Venda.obterTodas", Venda.class);
            vendas = query.getResultList();
        }
        return vendas;
    }
    
    
}
