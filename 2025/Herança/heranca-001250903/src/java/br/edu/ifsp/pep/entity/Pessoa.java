package br.edu.ifsp.pep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "pessoa")
/*
Heranca - JOINED
 - Cria tabelas de 1:N
 - No Banco de Dados:
    - Cria uma tabela para cada classe, porem:
        - Se fizer consulta na Classe Mae: 
            - As Classes Filhas aparecerao.
                - e terao um Tipo (DTYPE):
                    - Nome da Clase Filha.
                        - Ex: PessoaFisica
        - Se fizer consulta nas Classes filhas:
            - Somente os atributos das Classes Filhas aparecerao

    Pessoa -> PessoaFisica
    Pessoa -> PessoaJuridica*/
@Inheritance(strategy = InheritanceType.JOINED)
/* 
Heranca - TABLE_PER_CLASS
Cria uma tabela por classe 
ex: ira criar uma tabela para Pessoa, PessoaFisica e PessoaJuridica.
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)*/

/*
Heranca - SINGLE_TABLE
Junta todos os atributos das Classes Filhas na tabela de Classe Mae, 
padronizando as Classes Filhas como uma coluna "Tipo", definindo um valor 
para conseguir diferenciar.
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

Atribui um tipo para diferenciar um objeto
@DiscriminatorColumn(name="TYPE", discriminatorType=DiscriminatorType.STRING, length=2)

// Valor do tipo 
@DiscriminatorValue("P")*/
public class Pessoa implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;
    
    @Column(name= "nome", nullable = false, length = 80)
    private String nome;

    public Pessoa() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.codigo);
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
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.codigo, other.codigo);
    }
    
    
}
