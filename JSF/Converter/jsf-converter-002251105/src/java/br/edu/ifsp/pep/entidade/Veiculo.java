package br.edu.ifsp.pep.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "veiculo")
@NamedQueries(value = {
    @NamedQuery(name = "Veiculo.buscarTodos", query = "FROM Veiculo v"),
    @NamedQuery(name = "Veiculo.buscarPeloId", query = "FROM Veiculo v WHERE v.id = :id"),
    @NamedQuery(name = "Veiculo.buscarPeloNome", query = "SELECT v FROM Veiculo v WHERE v.nome LIKE :nome"),
    @NamedQuery(name = "Veiculo.buscarPessoaVeiculo", query = "SELECT v FROM Veiculo v WHERE v.pessoa.id = :id")
})
public class Veiculo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "ano", nullable = false)
    private Integer ano;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;

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

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "[Veiculo]" + "\n" +
               "ID: " + id + "\n" + 
               "Nome: " + nome + "\n" + 
               "Ano: " + ano + "\n" + 
               "Pessoa: " + pessoa;
    }

}
