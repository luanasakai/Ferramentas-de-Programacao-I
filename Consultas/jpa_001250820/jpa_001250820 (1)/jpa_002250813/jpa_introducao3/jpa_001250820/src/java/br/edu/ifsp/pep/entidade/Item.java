
package br.edu.ifsp.pep.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
/**
 *
 * @author aluno
 */

 @Entity
 @IdClass(ItemPK.class)
 @Table(name = "item")
public class Item {
    
    @EmbeddedId
    private ItemPK itemPK;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "produto_codigo")
    //o nome deste atributo precisa estar igual ao de ItemPK
    private Produto produto;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "venda_codigo")
    //o nome deste atributo precisa estar igual ao de ItemPK
    private Venda venda;
    
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
    
    @Column(name = "preco", nullable = false, precision = 8, scale = 2)
    private BigDecimal preco;

    public Item() {
    }

    public Item(Produto produto, Venda venda, Integer quantidade, BigDecimal preco) {
        this.produto = produto;
        this.venda = venda;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    
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

    public ItemPK getItemPK() {
        return itemPK;
    }

    public void setItemPK(ItemPK itemPK) {
        this.itemPK = itemPK;
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
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.itemPK);
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
        final Item other = (Item) obj;
        return Objects.equals(this.itemPK, other.itemPK);
    }

    
}
