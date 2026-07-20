
package br.edu.ifsp.pep.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author aluno
 */
//itemPk eh a classe que define os atributos da chave primaria
@Embeddable
public class ItemPK implements Serializable {
    
    //@Column(name = "produto_codigo", insertable = false, updatable = false)
    private Integer produto;
    
    //@Column(name = "venda_codigo", insertable = false, updatable = false)
    private Integer venda;

    public ItemPK() {
    }

}
