package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Produto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author aluno
 */
@Stateless
public class ProdutoDAO {
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;

    public ProdutoDAO() {
        System.out.println("PRODUTO DAO");
    }

    public void inserir(Produto produto){
        em.persist(produto);
    }
   
}
