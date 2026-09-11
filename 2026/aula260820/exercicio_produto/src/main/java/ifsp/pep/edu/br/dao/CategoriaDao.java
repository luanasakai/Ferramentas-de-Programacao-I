/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifsp.pep.edu.br.dao;

import ifsp.pep.edu.br.model.Categoria;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author aluno
 */
public class CategoriaDao extends AbstractDao<Categoria> {

    public Categoria buscarpeloID(Long id) {
        Categoria categoria = null;

        try (EntityManager em = getEntityManager()) {
            categoria = em.find(Categoria.class, id);
        }

        return categoria;
    }

    public List<Categoria> buscarPeloNome(String nome) {
        try (EntityManager em = getEntityManager()) {

            return em.createQuery(
                    "SELECT c FROM Categoria c WHERE LOWER(c.nome) LIKE LOWER(:nome)",
                    Categoria.class
            )
                    .setParameter("nome", "%" + nome + "%")
                    .getResultList();
        }
    }
}
