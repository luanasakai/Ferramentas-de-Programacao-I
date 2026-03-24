package br.edu.ifsp.pep.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "manutencao")
@NamedQueries(value = {
    @NamedQuery(name = "Manutencao.buscarTodos", query = "FROM Manutencao m"),
    @NamedQuery(name = "Manutencao.buscarPeloId", query = "FROM Manutencao m WHERE m.id = :id"),
    @NamedQuery(name = "Manutencao.buscarVeiculoManutencao", query = "SELECT m FROM Manutencao m WHERE m.veiculo.id = :id")
})
public class Manutencao implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "preco", nullable = false)
    private double preco;
    
    @Lob//observacao longa
    @Column(name = "observacao")
    private String observacao;
    
    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;
    
    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private Servico servico;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }   

    @Override
    public String toString() {
        return "[Manutencao]" + "\n" + 
                "ID: " + id + "\n" +
                "Data: " + data + "\n" +
                "Preco: " + preco + "\n" +
                "Observacao: " + observacao + "\n" +
                "Veiculo: " + veiculo;
    }
    
    

}
