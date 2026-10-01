package br.edu.ifsp.pep.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class HomeController {

    private String nome = "Cesar";
    
    private int contador = 0;

    public HomeController() {
        System.out.println("Construtor Home Controller");
        System.out.println("Valor do contador: " + contador);
        System.out.println("Nome: " + nome);
    }

    public void incrementar() {
        System.out.println("Valor antes: " + contador); //0
        contador++;
        System.out.println("Valor depois: " + contador); //1
    }

    public void exibir() {
        System.out.println("Metodo exibir");
        System.out.println("Nome: " + nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

}
