
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.ItemVenda;
import br.edu.ifsp.pep.entidade.Produto;
import br.edu.ifsp.pep.entidade.Venda;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;

/**
 *
 * @author aluno
 */
@Stateless
public class VendaDAO extends AbstractDAO<Venda> {

    @Override
    public void inserir(Venda venda) throws Exception{
        EntityManager em = getEntityManager();
        
        try {
            for(ItemVenda item: venda.getItens()){
                Produto p = item.getProduto();
                p.removerQuantidade(item.getQuantidade());
                em.merge(p);
            }
            
            em.merge(venda);
                
        } catch (Exception ex) {
            try {
                em.getTransaction().rollback();
            } catch (IllegalStateException e) {
                throw new Exception(ex.getMessage());
            }
            
        }
    }
    
    

    
}
