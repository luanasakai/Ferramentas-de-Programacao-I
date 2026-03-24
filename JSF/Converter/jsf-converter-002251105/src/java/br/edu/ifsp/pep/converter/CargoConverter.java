/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.converter;

import br.edu.ifsp.pep.dao.CargoDAO;
import br.edu.ifsp.pep.entidade.Cargo;
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
//toda vez que precisar converter string para cargo ele utiliza a classe cargo
@FacesConverter(forClass = Cargo.class)
public class CargoConverter implements Converter<Cargo>{
    @Inject
    private CargoDAO CargoDAO;
    
    @Override
    public Cargo getAsObject(FacesContext fc, UIComponent uic, String string) {
        if(string == null){
            return null;
        }
        
        //obtem o DAO
        CargoDAO cargoDAO = CDI.current().select(CargoDAO.class).get();
        
        //buscar no BD
        return cargoDAO.buscarPeloId(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Cargo cargo) {
        
        if(cargo == null){
            return null;
        }
        
        return String.valueOf(cargo.getId());
        
    }
    
}
