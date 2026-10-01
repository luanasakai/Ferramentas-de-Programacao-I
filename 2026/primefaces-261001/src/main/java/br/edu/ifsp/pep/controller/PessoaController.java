package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.PessoaDao;
import br.edu.ifsp.pep.entidade.Pessoa;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PessoaController {

    private Pessoa pessoa = new Pessoa();
    private List<Pessoa> pessoas;
    private Pessoa pessoaSelecionada; //precisa de get e set
    private Integer quantidadeLinhasPorPagina;
    
    @Inject
    private PessoaDao pessoaDao;

    public void exibirPessoaSelecionada(){
        System.out.println(pessoaSelecionada);
    }
    
    public void adicionar() {
        System.out.println(pessoa);
        this.pessoaDao.adicionar(pessoa);
        Mensagem.showInfo("Pessoa Cadastrada!");
    }
    
     public void editar(){
        if(pessoaSelecionada != null){
             this.pessoaDao.editar(pessoaSelecionada);
        }
    }
    
    public void excluir(){
        if(pessoaSelecionada != null){
             this.pessoaDao.excluir(pessoaSelecionada);
             this.pessoas = null;
             Mensagem.showInfo("Pessoa excluida!");
        }else{
            Mensagem.showError("Nao foi possivel excluir esta Pessoa");
        }
    }
    
    public List<Pessoa> obterPessoas(){
        
        if(this.pessoas == null){
            System.out.println("Acessando o banco de dados...");
            this.pessoas = pessoaDao.obterTodas();
        }
        return this.pessoas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
    }
    
    

}
