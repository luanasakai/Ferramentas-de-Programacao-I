package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.ManutencaoDAO;
import br.edu.ifsp.pep.dao.ServicoDAO;
import br.edu.ifsp.pep.dao.VeiculoDAO;
import br.edu.ifsp.pep.entidade.Manutencao;
import br.edu.ifsp.pep.entidade.Servico;
import br.edu.ifsp.pep.entidade.Veiculo;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;


/**
 *
 * @author aluno
 */

@Named
@RequestScoped
public class ManutencaoController {
    
    @Inject
    private ManutencaoDAO manutencaoDAO;
    
    @Inject
    private ServicoDAO servicoDAO;
    
    @Inject
    private VeiculoDAO veiculoDAO;
    
    private Manutencao manutencao = new Manutencao();
    private List<Manutencao> manutencoes;

    public Manutencao getManutencao() {
        return manutencao;
    }

    public void setManutencao(Manutencao manutencao) {
        this.manutencao = manutencao;
    }
    
    public List<Veiculo> buscarVeiculoPeloNome(String nome){
        
        return veiculoDAO.buscarPeloNome(nome);
    }
    
    public List<Servico> buscarServicoPeloNome(String nome){
        
        return servicoDAO.buscarPeloNome(nome);
    }
    
    public List<Manutencao> getManutencoes(){
        System.out.println("metodo getPessoas");
        if (this.manutencoes == null) {
            System.out.println("Acessando banco de dados...");
            this.manutencoes = manutencaoDAO.buscarTodos();
        }

        return this.manutencoes;
    }
    
    public String inserir() {

        if (manutencao == null) {
            Mensagem.atencao("Todos os campos devem ser preenchidos!");
            return null;
        
        }else if (manutencao.getVeiculo() == null){
            Mensagem.atencao("O campo de Veiculo deve ser preenchido!");
        
        }else if (manutencao.getServico()== null){
            Mensagem.atencao("O campo de Servico deve ser preenchido!");
        
        }else if (manutencao.getData() == null) {
            
            Mensagem.erro("A data não pode ser vazia.");
        
        }else if (manutencao.getPreco() <= 0) {
            
            Mensagem.erro("O preço deve ser maior que zero.");
        
        }
        
        manutencaoDAO.inserir(manutencao);
        manutencao = new Manutencao(); //limpa os campus
        Mensagem.sucesso("Manutencao Cadastrada!");
        
        return "/manutencao/lista_manutencao";//retorna para a pagina de lista automaticamente
    }
    
     public void excluir(Manutencao m) {
        m.toString();
        
        manutencaoDAO.remover(m);
        
        Mensagem.sucesso("Manutencao removida.");
        
        this.manutencoes = null;  // vai no banco e refaz a lista (para atualizar a tabela)
    }
    
}
