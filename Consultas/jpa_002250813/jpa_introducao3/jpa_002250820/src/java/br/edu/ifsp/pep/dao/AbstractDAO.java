package br.edu.ifsp.pep.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author aluno
 */
public abstract class AbstractDAO<T> {
    
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;
    
    protected EntityManager getEntityManager(){
        return em;
    }
    
    public void inserir(T entity){
        em.persist(entity);
    }
    
    public void alterar(T entity){
        //se a chave primaria da entity existir, altera o objeto
        //se nao, cria.
        em.merge(entity);
    }
    
    public void remover(T entity){
        em.remove(em.merge(entity));
    }
 
}
