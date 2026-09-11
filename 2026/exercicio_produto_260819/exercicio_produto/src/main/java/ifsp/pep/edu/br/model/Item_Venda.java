package ifsp.pep.edu.br.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author sakai
 */
@Entity
@Table(name = "item_venda")
public class Item_Venda implements Serializable{
    
    @Id //chave-primaria
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "venda_id", nullable = false)//chave estrangeira
    private Venda venda;

    public Item_Venda() {
    }

    public Item_Venda(Long id, Venda venda) {
        this.id = id;
        this.venda = venda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        return Objects.equals(this.id, other.id);
    }
    
    
}
