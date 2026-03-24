package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Veiculo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author aluno
 */
@Stateless
public class VeiculoDAO {
    
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;

    public VeiculoDAO() {
        System.out.println("VEICULO DAO");
    }
    
    public void inserir(Veiculo veiculo){
        em.persist(veiculo);
    }
    
    
}
