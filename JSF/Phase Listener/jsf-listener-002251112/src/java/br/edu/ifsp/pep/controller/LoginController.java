package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.LoginDAO;
import br.edu.ifsp.pep.dao.PessoaDAO;
import br.edu.ifsp.pep.entidade.Login;
import br.edu.ifsp.pep.entidade.Pessoa;
import br.edu.ifsp.pep.util.Mensagem;
import com.mysql.cj.protocol.Message;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginController implements Serializable {
    
    @Inject
    private PessoaDAO pessoaDAO;
    
     @Inject
    private LoginDAO loginDAO;

    private Pessoa pessoaLogada = null; //nao esta logado
//  private Pessoa pessoaLogada = new Pessoa(); //pessoa logada
    
    private Login login = new Login();

    public LoginController() {
        System.out.println("Construtor Login Controller");
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    public Pessoa getPessoaLogada() {
        return pessoaLogada;
    }

    public String acessar(){
        Login loginEncontrado = loginDAO.buscarLogin(login.getLogin(), login.getSenha());

        if (loginEncontrado != null) {
            this.pessoaLogada = loginEncontrado.getPessoa();
            Mensagem.sucesso("Seja Bem Vindo, " + this.pessoaLogada.getNome() + "!");
            pessoaLogada = null;
            return "/pessoa/cadastro";
        } else {
            Mensagem.erro("Credenciais incorretas!");
            return null;
        }
    }
    
    
}
