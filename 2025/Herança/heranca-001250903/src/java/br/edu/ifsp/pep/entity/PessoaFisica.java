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
@Table(name = "pessoa_fisica")
//@DiscriminatorValue("PF")
public class PessoaFisica extends Pessoa{
    
    @Column(name= "cpf", nullable = false, length = 14)
    private String cpf;

    public PessoaFisica() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
