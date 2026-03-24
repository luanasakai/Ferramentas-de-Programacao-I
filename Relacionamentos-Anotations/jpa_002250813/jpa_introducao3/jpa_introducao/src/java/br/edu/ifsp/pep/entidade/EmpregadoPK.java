
package br.edu.ifsp.pep.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author aluno
 */

@Embeddable
class EmpregadoPK implements Serializable {
    
    //@Column(name = "nome_empregado", insertable = false, updatable = false)
    private String nome;
    
    //@Column(name = "dataNascimento_empregado", insertable = false, updatable = false)
    private LocalDate dataNascimento;

    public EmpregadoPK() {
    }
    
    
    
}
