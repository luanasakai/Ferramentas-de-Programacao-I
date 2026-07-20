package br.edu.ifsp.pep.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "servico")
@NamedQueries(value = {
    @NamedQuery(name = "Servico.buscarTodos", query = "FROM Servico s"),
    @NamedQuery(name = "Servico.buscarPeloId", query = "FROM Servico s WHERE s.id = :id"),
    @NamedQuery(name = "Servico.buscarPeloNome", query = "SELECT s FROM Servico s WHERE s.nome LIKE :nome")
})
public class Servico implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "[Servico]" + "\n" +
               "ID: " + id + "\n" + 
               "Nome: " + nome + "\n";
    }
}
