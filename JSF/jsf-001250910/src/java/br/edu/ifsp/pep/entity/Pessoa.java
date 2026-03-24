package br.edu.ifsp.pep.entity;

import jakarta.inject.Named;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author aluno
 */
@Table(name = "pessoa")
@Entity
public class Pessoa implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int numero;
    
    @Column(name= "nome", nullable = false, length = 80)
    private String nome;
    
    @Column(name= "data_nascimento", nullable = false)
    private LocalDate dataNascimento;
    
    @Column(name= "salario", nullable = false, scale = 2, precision = 8)
    private double salario;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "===================== [PESSOA] ========================= " + "\n" 
                + "Numero: " + numero + "\n"
                + "Nome: " + nome + "\n"
                + "Data de Nascimento: " + dataNascimento + "\n"
                + "Salario: " + salario + "\n" +
                "======================================================= " ;
    }
    
    
 
}
