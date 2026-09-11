/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifsp.pep.edu.br.dao;

import ifsp.pep.edu.br.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author aluno
 */
public class ProdutoDao extends AbstractDao<Produto>{
    
    //buscar pelo id
    
    //buscar pelo nome
    
    //buscar todos produtos com preco > que um determinado valor
    
    //buscar produto pelo id da categoria
    public List<Produto> buscarPelaCategoria(Long idCategoria){
        List<Produto> produtos;
        produtos = null;
        
        try (EntityManager em = getEntityManager()) {
             TypedQuery<Produto> query = em.createNamedQuery("Produto.buscarPelaCategoria", Produto.class);
             query.setParameter("id", idCategoria);
             produtos = query.getResultList();
             
             return produtos;
         }
    }
}
