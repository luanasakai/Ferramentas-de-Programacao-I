/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.converter;

import br.edu.ifsp.pep.dao.ServicoDAO;
import br.edu.ifsp.pep.entidade.Servico;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

/**
 *
 * @author aluno
 */
//toda vez que precisar converter string para manutencao ele utiliza a classe manutencao
@FacesConverter(forClass = Servico.class)
public class ServicoConverter implements Converter<Servico>{
    
    @Inject
    private ServicoDAO ManutencaoDAO;

    @Override
    public Servico getAsObject(FacesContext fc, UIComponent uic, String string) {
        
        if(string == null){
            return null;
        }
        
        //obtem o DAO
        ServicoDAO servicoDAO = CDI.current().select(ServicoDAO.class).get();
        
        //buscar no BD
        return servicoDAO.buscarPeloId(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Servico s) {
        
        if(s == null){
            return null;
        }
        
        return String.valueOf(s.getId());
    }
    
}
