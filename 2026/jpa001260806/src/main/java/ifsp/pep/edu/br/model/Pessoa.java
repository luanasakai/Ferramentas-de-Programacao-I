/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifsp.pep.edu.br.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author aluno
 */
//Entity
//serializable
//construtor and parameters 
//equals and hashcode
//identifier
@Entity
@Table(name = "pessoa", uniqueConstraints = {
    @UniqueConstraint(name = "unique_email", columnNames = {"email"}),
            
    @UniqueConstraint(name = "unique_nome_salario", columnNames = {"nome", "salario"})
})
public class Pessoa implements Serializable{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincrement
    private Long id;
    
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @Column(name = "email", length = 50, nullable = false)//unique = true - utilizar para uma coluna/atributo
    private String email;
    
    @Column(name = "salario", nullable = false, precision = 8, scale = 2)
    private BigDecimal salario;

    public Pessoa() {
    }
    
    public Pessoa(String nome, String email, BigDecimal salario) {
        this.nome = nome;
        this.email = email;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.nome);
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
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
    
    
}
