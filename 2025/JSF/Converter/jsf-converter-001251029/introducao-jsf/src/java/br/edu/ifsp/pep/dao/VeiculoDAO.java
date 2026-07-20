/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Veiculo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author aluno
 */
@Stateless
public class VeiculoDAO extends AbstractDAO<Veiculo>{
    
    public List<Veiculo> buscarPeloNome(String nome){
        EntityManager em = getEntityManager();
        
        TypedQuery<Veiculo> query = em.createNamedQuery("Veiculo.buscarPeloNome", Veiculo.class);
        query.setParameter("nome", "%" + nome + "%");
        
        return query.getResultList();
    }
    
     public Veiculo buscarPeloId(Integer id){
        EntityManager em = getEntityManager();
        return em.find(Veiculo.class,id);
    }
    
}
