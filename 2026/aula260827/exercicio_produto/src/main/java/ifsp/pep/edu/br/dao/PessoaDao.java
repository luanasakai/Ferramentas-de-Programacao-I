/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifsp.pep.edu.br.dao;

import ifsp.pep.edu.br.model.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author aluno
 */
public class PessoaDao extends AbstractDao<Pessoa>{
    
    public List<Pessoa> buscarTodos(){
        
        EntityManager em = getEntityManager();
        
        // select p from Pessoa p = from Pessoa p
        TypedQuery<Pessoa> query = em.createNamedQuery("Pessoa.buscarTodos", Pessoa.class);
        
        List<Pessoa> lista= query.getResultList();
        em.close();
        
        return lista;
    }
    
    public List<Pessoa> buscarPeloSalario(BigDecimal salario){
        
        EntityManager em = getEntityManager();
        
        //:salario -> parametro/variavel
        TypedQuery<Pessoa> query = em.createNamedQuery("Pessoa.buscarPeloSalario", Pessoa.class);
                
        //pego o valor desejado e atribui ao parametro definido na consulta
        //valor nao eh mais estatico
        query.setParameter("salario", salario);
        
        List<Pessoa> lista= query.getResultList();
        em.close();
        
        return lista;
    }
    
    public Pessoa obterPeloId(Long id){
        Pessoa pessoa;
        try(EntityManager em = getEntityManager()){
            pessoa = em.find(Pessoa.class, id);
        }
        
        return pessoa;
    }
}
