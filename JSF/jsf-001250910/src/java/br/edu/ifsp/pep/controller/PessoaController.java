package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.PessoaDAO;
import br.edu.ifsp.pep.entity.Pessoa;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author aluno
 */
@Named
/*CRIA NOVA REQUISICAO = NEW OBJETO
  OBJETO SESSIONSCOPED SO EXISTE ENQUANTO A SESSAO ESTIVER ATIVA
//@SessionScoped*/
/*As classes (controller) sao instanciadas pelo servidor (neste caso o glassfish)*/
@RequestScoped
public class PessoaController implements Serializable{
    //ATRIBUTOS PARA OBTER VALORES DO HTML
    /*No html n precisa utilizar set nem get, apenas o nome do atributo, 
    pois o componente vai performar get/set em momentos diferentes*/
    /*TUDO que vem do HTML eh STRING mas ao passar para o servidor 
    ele transforma para os valores vinculados*/
    
    @Inject()
    private PessoaDAO pessoaDAO;
 
    private Pessoa pessoa = new Pessoa();

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public PessoaController() {
        System.out.println("CONSTRUTOR PESSOA CONTROLLER");
    }
    
    public void inserir(){
        
        if(pessoa.getNome().isEmpty()){
            
             Mensagem.atencao("O nome deve estar preenchido.");
             
        }else if(pessoa.getNome().length() < 3){
            
             Mensagem.atencao("O nome deve possuir pelo menos 3 letras.");
             
        }else if(!pessoa.getNome().chars().allMatch(c -> Character.isLetter(c) || Character.isSpaceChar(c))){
             
            Mensagem.erro("O nome não pode conter números ou caracteres especiais.");
            
        }else if (pessoa.getDataNascimento() == null) {
            
            Mensagem.erro("A data de nascimento não pode ser vazia.");
        
        } else if (pessoa.getSalario() <= 0) {
            
            Mensagem.erro("O salário deve ser maior que zero.");
        
        }else{
            pessoaDAO.inserir(pessoa);
            Mensagem.sucesso("Pessoa Cadastrada com Sucesso!");
            
            //limpa os componentes do html
            this.pessoa = new Pessoa();
        }
    }
    
    public void exibir(){
        System.out.println("\nMETODO EXIBIR");
        System.out.println(pessoa);
        /*
        System.out.println("\nMETODO EXIBIR");
        System.out.println("Numero Inicial: " + numero);
        System.out.println("Nome: " + nome);
        */
    }
    
    public void incrementar(){
        /*
        System.out.println("\nMETODO INCREMENTAR");
        this.numero++;
        System.out.println("Numero Incrementado: " + numero);
        System.out.println("Nome: " + nome);
        */
    }
}
