package ifsp.pep.edu.br.jpa001260806;

import ifsp.pep.edu.br.model.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;

public class Jpa001260806 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Pessoa p1  = new Pessoa("Luana", "luana@gmail.com", new BigDecimal(1000));
        Pessoa p2  = new Pessoa("Karina", "karina@gmail.com", new BigDecimal(2000));
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexaoPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();//inicia a transacao
        em.persist(p1);//persiste o objeto
        em.persist(p2);
        em.getTransaction().commit();//salva as alteracoes
        em.close();//finaliza a transacao
    }
}
