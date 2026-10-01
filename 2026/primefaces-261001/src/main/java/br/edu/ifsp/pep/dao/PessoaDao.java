package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PessoaDao extends AbstractDao<Pessoa> {

    public List<Pessoa> obterTodas() {
        EntityManager em = getEntityManager();
        
        TypedQuery<Pessoa> query = em.createNamedQuery(
                "Pessoa.buscarTodas", Pessoa.class);
        return query.getResultList();

    }

    public List<Pessoa> obterPorNome(String nome) {
        EntityManager em = getEntityManager();
            TypedQuery<Pessoa> query = em.createNamedQuery(
                    "Pessoa.buscarPorNome", Pessoa.class);
            query.setParameter("nome", "%" + nome + "%");
            return query.getResultList();
    }

}
