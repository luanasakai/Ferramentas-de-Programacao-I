package br.edu.ifsp.pep.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author aluno
 */
@Embeddable
public class TelefoneId implements Serializable {
    
    @Column(name = "ddd")
    private int ddd;
    
    @Column(name = "numero", length = 10, nullable = false)
    private String numero;

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.ddd;
        hash = 97 * hash + Objects.hashCode(this.numero);
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
        final TelefoneId other = (TelefoneId) obj;
        if (this.ddd != other.ddd) {
            return false;
        }
        return Objects.equals(this.numero, other.numero);
    }
    
    
    
}