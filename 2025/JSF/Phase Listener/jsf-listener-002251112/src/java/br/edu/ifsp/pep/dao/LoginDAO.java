/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Cargo;
import br.edu.ifsp.pep.entidade.Login;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author aluno
 */
@Stateless
public class LoginDAO extends AbstractDAO<Login>{
    public List<Login> buscarTodos() {
        
        EntityManager em = getEntityManager();
        TypedQuery<Login> query = em.createNamedQuery("Login.buscarTodos", Login.class);
        
        return query.getResultList();
        
    }
    
    public Login buscarLogin(String login, String senha){
        EntityManager em = getEntityManager();
        TypedQuery<Login> query = em.createNamedQuery("Login.buscarLogin", Login.class);

        query.setParameter("login", login);
        query.setParameter("senha", senha);     
        
        return query.getSingleResult();
    }
    
}
