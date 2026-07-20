package br.edu.ifsp.pep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Objects;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "pessoa_juridica")
//@DiscriminatorValue("PJ")
public class PessoaJuridica extends Pessoa{
    
    @Column(name= "cnpj", nullable = false, length = 18)
    private String cnpj;

    public PessoaJuridica() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    

}
