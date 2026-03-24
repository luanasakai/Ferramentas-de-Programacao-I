
package br.edu.ifsp.pep.entidade;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author aluno
 */

@Entity
@Table(name = "telefone")
public class Telefone implements Serializable {
    
    @EmbeddedId
    private TelefoneId telefoneId;
    
    private String numero;
    
    
    
    

    public Telefone() {
    }

    public TelefoneId getTelefoneId() {
        return telefoneId;
    }

    public void setTelefoneId(TelefoneId telefoneId) {
        this.telefoneId = telefoneId;
    }
    
 

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.telefoneId);
        hash = 83 * hash + Objects.hashCode(this.numero);
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
        final Telefone other = (Telefone) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return Objects.equals(this.telefoneId, other.telefoneId);
    }

    
    
    
    
    
    
    
    
    
}
