
package br.edu.ifsp.pep.entidade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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
    private Integer codigo;
    
    @Column(name= "nome", nullable = false, length = 80)
    private String nome;
    
    @Column(name= "data_nascimento", nullable = false)
    private LocalDate dataNascimento;
    
    @Column(name= "salario", nullable = false, scale = 2, precision = 8)
    private BigDecimal salario;
    
    @Column(name = "email", nullable = false, length = 80, unique = true)
    private String email;
    
    @Column(name = "tipo", nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipo;
    
    @OneToMany(mappedBy = "pessoa")
    private List<Venda> vendas;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "pessoa_veiculo",
            joinColumns = @JoinColumn(name = "pessoa_codigo"),
            inverseJoinColumns = @JoinColumn(name = "veiculo_codigo"))
    private List<Veiculo> veiculos;
    
    //persiste todas mudancas de pessoa-endereco
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_codigo", nullable = false)
    private Endereco endereco;
    
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
    

    public Pessoa() {
    }


    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

}
