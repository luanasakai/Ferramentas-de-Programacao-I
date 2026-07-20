
package br.edu.ifsp.pep.cntroller;

import br.edu.ifsp.pep.dao.CategoriaDAO;
import br.edu.ifsp.pep.dao.PessoaDAO;
import br.edu.ifsp.pep.dao.ProdutoDAO;
import br.edu.ifsp.pep.dao.VeiculoDAO;
import br.edu.ifsp.pep.entidade.Categoria;
import br.edu.ifsp.pep.entidade.Endereco;
import br.edu.ifsp.pep.entidade.Pessoa;
import br.edu.ifsp.pep.entidade.Produto;
import br.edu.ifsp.pep.entidade.TipoPessoa;
import br.edu.ifsp.pep.entidade.TipoVeiculo;
import br.edu.ifsp.pep.entidade.Veiculo;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
@Named(value = "pessoaController")
@SessionScoped
public class PessoaController implements Serializable {
    
    @Inject()
    private PessoaDAO pessoaDAO;
    
    
    @Inject()
    private VeiculoDAO veiculoDAO;
    
    @Inject()
    private ProdutoDAO produtoDAO;
    
    @Inject()
    private CategoriaDAO categoriaDAO;
    
    public void inserir(){
    
        System.out.println("INSERINDO PESSOA");
        
        Pessoa p =new Pessoa();
        p.setNome("xuxa");
        p.setEmail("soparabaixinhos@xuxa.com");
        p.setSalario(new BigDecimal(1000));
        p.setDataNascimento(LocalDate.now());
        p.setTipo(TipoPessoa.Gerente);
        
        //ENDERECO
        Endereco e = new Endereco();
        e.setLogradouro("Rua dos bobos, 00-00");
        e.setBairro("Centro");
        e.setCidade_estado("Xique-Xique, Bahia");
        
        p.setEndereco(e);
        
        //VEICULOS
        Veiculo v1 = new Veiculo();
        v1.setNome("Uno");
        v1.setTipo(TipoVeiculo.Carro);
        
        Veiculo v2 = new Veiculo();
        v2.setNome("Fusca");
        v2.setTipo(TipoVeiculo.Carro);
        
        List<Veiculo> veiculos = new ArrayList<>();
        veiculos.add(v1);
        veiculos.add(v2);
        
        p.setVeiculos(veiculos);
        
        pessoaDAO.inserir(p);
 
    }
    
    public void inserirVeiculos(){
        
        Veiculo v = new Veiculo();
        v.setNome("Gol");
        v.setTipo(TipoVeiculo.Carro);
        
        veiculoDAO.inserir(v);
    }
    
    public void inserirCategoria(){
        Categoria c = new Categoria();
        c.setNome("Categoria 1");
        
        categoriaDAO.inserir(c);
    }
    
    public void alterarCategoria(){
        
        Categoria c = categoriaDAO.buscarPorCodigo(1);
        if(c != null){
            System.out.println(c.getNome());
            c.setNome("Categoria 1 - Alterada");
            
            categoriaDAO.alterar(c);
        }else{
            System.out.println("Nao existe categoria.");
        }
        
        /*
        Categoria c = new Categoria();
        c.setCodigo(1);
        c.setNome("Nova Categoria");*/
    }
    
    public void removerCategoria(){
        Categoria c = new Categoria();
        c.setCodigo(1);
        
        categoriaDAO.remover(c);
    }
    
    public void inserirProduto2(){
        Produto p1 = new Produto();
        p1.setNome("Produto 3");
        p1.setPreco(BigDecimal.ZERO);
        p1.setQuantidade(100);
       
        //BUSCAR CATEGORIA NO BD
        //o atributo categoria, na classe produto, NAO pode ter CASCADE
        Categoria c = categoriaDAO.buscarPorCodigo(1);
        p1.setCategoria(c);
        
        /*DESTE JEITO TBM FUNCIONA
        Categoria c = new Categoria();
        c.setCodigo(1);*/
        produtoDAO.inserir(p1);
    }
    
    public void inserirProduto(){
        //PRODUTO
        Produto p1 = new Produto();
        p1.setNome("Produto 1");
        p1.setPreco(BigDecimal.ZERO);
        p1.setQuantidade(100);
        
        Categoria c = new Categoria();
        c.setCodigo(1);
        p1.setCategoria(c);
        
        produtoDAO.inserir(p1);
        
        Produto p2 = new Produto();
        p2.setNome("Produto 2");
        p2.setPreco(BigDecimal.ZERO);
        p2.setQuantidade(200);
        
        p2.setCategoria(c);
        
        produtoDAO.inserir(p2);
    }
    
}
