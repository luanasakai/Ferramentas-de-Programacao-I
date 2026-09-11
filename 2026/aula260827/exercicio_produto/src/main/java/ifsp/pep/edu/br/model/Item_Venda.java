package ifsp.pep.edu.br.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author sakai
 */
@Entity
@Table(name = "item_venda")
@IdClass(ItemVendaPK.class)
public class Item_Venda implements Serializable{
    
    @Id
    @JoinColumn(name = "venda_id", nullable = false)//chave estrangeira
    private Venda venda;
    
    @Id
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;
    
    private Integer quantidade;
    
    private BigDecimal preco;

    public Item_Venda() {
    }

    public Item_Venda(Venda venda, Produto produto, Integer quantidade, BigDecimal preco) {
        this.venda = venda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.venda);
        hash = 97 * hash + Objects.hashCode(this.produto);
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
        final Item_Venda other = (Item_Venda) obj;
        if (!Objects.equals(this.venda, other.venda)) {
            return false;
        }
        return Objects.equals(this.produto, other.produto);
    }
}
