/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifsp.pep.edu.br.model;

import java.io.Serializable;

/**
 *
 * @author aluno
 */
public class ItemVendaPK implements Serializable{
    
    private Long venda;
    
    private Long produto;

    public ItemVendaPK(Long venda, Long produto) {
        this.venda = venda;
        this.produto = produto;
    }

    public Long getVenda() {
        return venda;
    }

    public Long getProduto() {
        return produto;
    }
}
