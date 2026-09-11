package ifsp.pep.edu.br.model;

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
import java.time.LocalDateTime;
import java.util.Objects;


/**
 *
 * @author sakai
 */
@Entity
@Table(name = "venda")
@NamedQueries({
    @NamedQuery(name = "Venda.obterTodas", query = "SELECT v FROM Venda v")
})
public class Venda implements Serializable{
    
    @Id //chave-primaria
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    private Long id;
    
    @Column(name = "data", nullable = false)
    private LocalDateTime data;
    
    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)//chave estrangeira
    private Pessoa pessoa;

    public Venda() {
    }

    public Venda(LocalDateTime data, Pessoa pessoa) {
        this.data = data;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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
        final Venda other = (Venda) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Venda" + "\n"
        + "Id: " + id + "\n"+
          "Data: " + data + "\n"+
          "Pessoa:" + pessoa + "\n";
    } 
}
