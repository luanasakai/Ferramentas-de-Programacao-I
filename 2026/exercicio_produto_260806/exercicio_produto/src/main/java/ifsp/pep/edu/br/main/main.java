/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ifsp.pep.edu.br.main;

import ifsp.pep.edu.br.model.Categoria;
import ifsp.pep.edu.br.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;

/**
 *
 * @author sakai
 */
public class main {

    public static void main(String[] args) {
    
        Produto p1 = new Produto("Mouse", 2, new BigDecimal(150));
        Produto p2 = new Produto("Teclado", 3, new BigDecimal(400));
        
        Categoria c1 = new Categoria("Perifericos");
        Categoria c2 = new Categoria("Bebidas");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexaoPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(c1);
        em.persist(c2);
        em.getTransaction().commit();
        em.close(); 
        
        
    }
}
