/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.converter;

import br.edu.ifsp.pep.dao.VeiculoDAO;
import br.edu.ifsp.pep.entidade.Veiculo;
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
//toda vez que precisar converter string para veiculo ele utiliza a classe veiculo
@FacesConverter(forClass = Veiculo.class)
public class VeiculoConverter implements Converter<Veiculo>{
    
    @Inject
    private VeiculoDAO veiculoDAO;

    @Override
    public Veiculo getAsObject(FacesContext fc, UIComponent uic, String string) {
        
        if(string == null){
            return null;
        }
        
        //obtem o DAO
        VeiculoDAO veiculoDAO = CDI.current().select(VeiculoDAO .class).get();
        
        //buscar no BD
        return veiculoDAO.buscarPeloId(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Veiculo v) {
        
        if(v == null){
            return null;
        }
        
        return String.valueOf(v.getId());
    }
    
}
