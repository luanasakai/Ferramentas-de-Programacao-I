package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.CargoDAO;
import br.edu.ifsp.pep.dao.ManutencaoDAO;
import br.edu.ifsp.pep.dao.PessoaDAO;
import br.edu.ifsp.pep.dao.VeiculoDAO;
import br.edu.ifsp.pep.entidade.Cargo;
import br.edu.ifsp.pep.entidade.Manutencao;
import br.edu.ifsp.pep.entidade.Pessoa;
import br.edu.ifsp.pep.entidade.Veiculo;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PessoaController  {

    @Inject
    private PessoaDAO pessoaDAO;
    
    @Inject
    private CargoDAO cargoDAO;
    
    @Inject
    private ManutencaoDAO manutencaoDAO;
    
    @Inject
    private VeiculoDAO veiculoDAO;

    private List<Pessoa> pessoas;
    private Pessoa pessoa = new Pessoa();
    
    private int numero = 10;

    public PessoaController() {
        System.out.println("Construtor");
    }
    
     // CRUD
    public String inserir() {

        if (pessoa.getNome().length() < 5) {
            Mensagem.atencao("O Nome deve ter pelo menos 5 caracteres.");
            return null;
        }

        pessoaDAO.inserir(pessoa);
        pessoa = new Pessoa();
        Mensagem.sucesso("Pessoa Cadastrada.");
        
        return "/pessoa/lista";//retorna para a pagina de lista automaticamente
    }
    
    public void excluir(Pessoa pessoa) {

        // ANTES DE EXCLUIR IREI VERIFICAR SE ESTA PESSOA TEM CARROS E CARROS EM MANUTENCAO
        List<Veiculo> veiculos = buscarPessoaVeiculo(pessoa.getId());
        List<Manutencao> manutencoes = buscarVeiculoManutencao(veiculos);
        
        /* Utiliza isEmpity pois: lista (do DAO) nao retorna null e sim vazio.
            1. [obj1, obj2...] se encontrou;
            2. [] (lista vazia) se NAO encontrou.
            *OBS: NUNCA RETORNA NULL.
        */

        if (!veiculos.isEmpty() && !manutencoes.isEmpty()) {
            Mensagem.erro("Erro: Pessoa possui manutenções pendentes.");
        } else if (!veiculos.isEmpty()) {
            Mensagem.erro("Erro: Pessoa possui veículo(s) cadastrado(s).");
        } else {

            pessoa.toString();
            pessoaDAO.remover(pessoa);
            Mensagem.sucesso("Pessoa removida.");

            this.pessoas = null; // vai no banco e refaz a lista (para atualizar a tabela)
        }
    }

    // METODOS DE CONSULTA
    public List<Pessoa> getPessoas() {
        System.out.println("metodo getPessoas");
        if (this.pessoas == null) {
            System.out.println("Acessando banco de dados...");
            this.pessoas = pessoaDAO.buscarTodas();
        }

        return this.pessoas;
    }
    
    // Metodo utilizado para AutoComplete ou SelectItems
    public List<Cargo> buscarCargoPeloNome(String nome){
        
        return cargoDAO.buscarPeloNome(nome);
    }
    
    public List<Veiculo> buscarPessoaVeiculo(Integer id){
        return veiculoDAO.buscarPessoaVeiculo(id);
    }
    
    public List<Manutencao> buscarVeiculoManutencao(List<Veiculo> veiculos){
        /*FOR EACH
            for (type variableName : arrayName) {
                // code block to be executed
            }
        */
        List<Manutencao> manutencoes = null;
        for(Veiculo v : veiculos)
            manutencoes = manutencaoDAO.buscarVeiculoManutencao(v.getId());
        
        return manutencoes;
    }
    
    // metodos estaticos
    public void exibir() {
        System.out.println("Metodo exibir.");
        System.out.println(pessoa);
        System.out.println("Numero: " + numero);
//      System.out.println("Nome: " + nome);
    }
    
     public void incrementar() {
        this.numero++;
        System.out.println("Numero: " + numero);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
