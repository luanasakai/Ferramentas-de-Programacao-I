/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.entidade.Pessoa;
import java.io.Serializable;

/**
 *
 * @author aluno
 */
public class LoginController implements Serializable{
    
    private Pessoa pessoaLogada = new Pessoa();

    public LoginController() {
        System.out.println("After Phase: ");
    }

    public Pessoa getPessoaLogada() {
        return pessoaLogada;
    }

    public void setPessoaLogada(Pessoa pessoaLogada) {
        this.pessoaLogada = pessoaLogada;
    }
    
    
}
