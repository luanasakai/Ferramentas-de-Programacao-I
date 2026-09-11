/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ifsp.pep.edu.br.main;

import ifsp.pep.edu.br.dao.CategoriaDao;
import ifsp.pep.edu.br.dao.PessoaDao;
import ifsp.pep.edu.br.dao.ProdutoDao;
import ifsp.pep.edu.br.model.Categoria;
import ifsp.pep.edu.br.model.Pessoa;
import ifsp.pep.edu.br.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sakai
 */
public class main {

    public static void main(String[] args) {
        
//        Categoria c1 = new Categoria();
//        c1.setNome("Perifericos");
//        criarCategoria(c1);
//        
//        Pessoa p1  = new Pessoa("Luana", "luana@gmail.com", new BigDecimal("1000"));
//        Pessoa p2  = new Pessoa("Karina", "karina@gmail.com", new BigDecimal("2000"));
//        criarPessoa(p1);
//        criarPessoa(p2);
//        
//        System.out.println("\n" +"TODAS AS PESSOAS: ");
//        listarTodasPessoas();
//        
//        System.out.println("\n" + "PESSOA COM SALARIO MAIOR QUE 1.000: ");
//        listarPeloSalario();
//        
//        Produto pr = new Produto();
//        pr.setNome("Mouse");
//        pr.setPreco(new BigDecimal("400"));
//        pr.setQuantidade(2);
//        pr.setCategoria(c1);
//        criarProduto(pr);

      //  criarCategoriaEproduto();  
        //pesquisarCategoriaPorId();
//        pesquisarCategoriaPorNome();
//        pesquisarProdutoPorCategoria();
    
    }
    
    private static void criarCategoria(Categoria c){
        CategoriaDao categoriaDao = new CategoriaDao();
        categoriaDao.inserir(c);
    }
    
    
    private static void criarPessoa(Pessoa p){
        PessoaDao pessoaDao = new PessoaDao();
        pessoaDao.inserir(p);
    }
    
    private static void listarTodasPessoas(){
        PessoaDao pessoaDao = new PessoaDao();
        
        System.out.println(pessoaDao.buscarTodos());
    }
    
    private static void listarPeloSalario(){
        PessoaDao pessoaDao = new PessoaDao();
        
        System.out.println(pessoaDao.buscarPeloSalario(new BigDecimal("1000")));
    }
    
    
    private static void criarProduto(Produto p){
        ProdutoDao produtoDao = new ProdutoDao();
        produtoDao.inserir(p);
    }

    private static void criarCategoriaEproduto() {
       Categoria c = new Categoria("Categoria 2");
       CategoriaDao categoriaDao = new CategoriaDao();
       
       Produto p1 = new Produto("Produto 2",  100, new BigDecimal("100"), c);
       Produto p2 = new Produto("Produto 3",  300, new BigDecimal("200"), c);
       
       List<Produto> produtos = new ArrayList<>();
       produtos.add(p1);
       produtos.add(p2);
       
       c.setProdutos(produtos);
       categoriaDao.inserir(c);
    }
    
    private static void pesquisarCategoriaPorId(){
        System.out.println("\n" +"Pesquisar Categoria por ID:");
        CategoriaDao categoriaDao = new CategoriaDao();
        
        Categoria categoria = categoriaDao.buscarpeloID(1l);
        System.out.println(categoria);
        
        for(Produto produto : categoria.getProdutos()){
            System.out.println(produto);
        }
 
    }

    private static void pesquisarCategoriaPorNome() {
        System.out.println("\n" + "Pesquisar Categoria por Nome:");
        CategoriaDao categoriaDao = new CategoriaDao();
        
        List<Categoria> categorias = categoriaDao.buscarPeloNome("Cate");
        
        for(Categoria categoria : categorias){
            System.out.println(categoria);
        }
    }

    private static void pesquisarProdutoPorCategoria() {
        System.out.println("\n" + "Pesquisar Produto por Categoria:");
        ProdutoDao produtoDao = new ProdutoDao();
        
        List<Produto> produtos = produtoDao.buscarPelaCategoria(1l);
        
        for(Produto produto : produtos){
            System.out.println(produto);
        }
    }
}
