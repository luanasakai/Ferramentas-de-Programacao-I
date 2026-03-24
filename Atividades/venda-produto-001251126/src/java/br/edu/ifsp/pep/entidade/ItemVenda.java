/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "item_vendaa")
public class ItemVenda implements Serializable{
    
    @Id //chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    @Column(name = "codigo")
    private Integer codigo;

    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;
    
    @JoinColumn(name = "venda_id", nullable = false)
    private Venda venda;
    
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
    
    @Column(name = "preco", nullable = false, precision = 6, scale = 2)
    private BigDecimal preco;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.codigo);
        hash = 13 * hash + Objects.hashCode(this.produto);
        hash = 13 * hash + Objects.hashCode(this.venda);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemVenda other = (ItemVenda) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    
    
    @Override
    public String toString() {
        return "ItemVenda{" + "produto=" + produto + ", venda=" + venda + ", quantidade=" + quantidade + ", preco=" + preco + '}';
    } 
}
