
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Pessoa;
import br.edu.ifsp.pep.entidade.TipoPessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author aluno
 */

@Stateless
public class PessoaDAO extends AbstractDAO<Pessoa>{
    
    //QUERY DINAMICAS - criadas em tempo de execucao.
    //NAMEDQUERY - criadas apenas uma vez.
    public List<Pessoa> findAll(){
        
        //JPQL (Java Persistence Query Language)
        EntityManager em = getEntityManager();
        
        /*
        //toda vez que o metodo for chamado a query eh criada
        TypedQuery<Pessoa> query = em.createQuery("Select p from Pessoa p", Pessoa.class);*/
        TypedQuery<Pessoa>  query = em.createNamedQuery("Pessoa.findAll", Pessoa.class);
        
        return query.getResultList();
    }
    
    public Pessoa findPorCodigo(Integer codigo){
        
        EntityManager em = getEntityManager();
        //TypedQuery<Pessoa> query = em.createQuery("Select p from Pessoa p WHERE p.codigo = :codigo", Pessoa.class);
        
        TypedQuery<Pessoa> query = em.createNamedQuery("Pessoa.findPorCodigo", Pessoa.class);
        
        //passando o parametro codigo do metodo, como parametro da query
        query.setParameter("codigo", codigo);
        
        try{
            
            return query.getSingleResult();
            
        }catch(NoResultException e){
            e.printStackTrace();//retorna pilha de erros 
            return null;
        }/*catch(NonUniqueResultException e){
            e.printStackTrace();
        }// retorna erro de programador*/
    }
    
    //Obter quantidade de pessoas.
    public Long obterQuantidadePessoa(){
        EntityManager em = getEntityManager();
        //COUNT - conta as pessoas
        //TypedQuery<Long> query = em.createQuery("Select COUNT(p) from Pessoa p", Long.class);
        
        TypedQuery<Long> query = em.createNamedQuery("Pessoa.obterQuantidadePessoa", Long.class);
        
        try{
            
            return query.getSingleResult();
            
        }catch(NoResultException e){
            
            e.printStackTrace();//retorna pilha de erros 
            return null;
        } 
    }
    
    //Obter maior salario.
    public BigDecimal obterMaiorSalario(){
        
        EntityManager em = getEntityManager();
        //TypedQuery<BigDecimal> query = em.createQuery("Select MAX(p.salario) from Pessoa p", BigDecimal.class);
        
        TypedQuery<BigDecimal> query = em.createNamedQuery("Pessoa.obterMaiorSalario", BigDecimal.class);
        
        try{
            
            return query.getSingleResult();
            
        }catch(NoResultException e){
            
            e.printStackTrace();//retorna pilha de erros 
            return null;
        } 
    }
    
    
    //Obter menor salario.
    public BigDecimal obterMenorSalario(){
        
        EntityManager em = getEntityManager();
        //TypedQuery<BigDecimal> query = em.createQuery("Select MIN(p.salario) from Pessoa p", BigDecimal.class);
        
        TypedQuery<BigDecimal> query = em.createNamedQuery("Pessoa.obterMenorSalario", BigDecimal.class);
        
        try{
            
            return query.getSingleResult();
            
        }catch(NoResultException e){
            
            e.printStackTrace();//retorna pilha de erros 
            return null;
        } 
    }
    
    //Obter salario medio.
    public Double obterSalarioMedio(){
        
        EntityManager em = getEntityManager();
        //TypedQuery<Double> query = em.createQuery("Select AVG(p.salario) from Pessoa p", Double.class);
        
        TypedQuery<Double> query = em.createNamedQuery("Pessoa.obterSalarioMedio", Double.class);
        
        try{
            
            return query.getSingleResult();
            
        }catch(NoResultException e){
            
            e.printStackTrace();//retorna pilha de erros 
            return null;
        } 
    }
    
    //Obter todas as pessoas que ganham mais que 5000.00
    public List<Pessoa> findBySalario(){
        
        EntityManager em = getEntityManager();
        //TypedQuery<Pessoa> query = em.createQuery("Select p.salario from Pessoa p WHERE p.salario > 5000.00", Pessoa.class);
        
        TypedQuery<Pessoa> query = em.createNamedQuery("Pessoa.findBySalario", Pessoa.class);
     
        return query.getResultList();
    }
    
    //Obter as pessoas que são Gerente.
    public List<Pessoa> findByGerente(TipoPessoa gerente){
        EntityManager em = getEntityManager();
    
        // Aqui, convertemos o tipo da enum para string antes de usar o LIKE
        TypedQuery<Pessoa> query = em.createNamedQuery("Pessoa.findByGerente", Pessoa.class);
    
        // Passamos o nome da enum como string no parâmetro
        query.setParameter("gerente", "%" + gerente.name() + "%"); 
    
        return query.getResultList();
    }
    
    //Obter as pessoas que são Gerente e ganham menos do que R$ 5.000,00.
    
}
