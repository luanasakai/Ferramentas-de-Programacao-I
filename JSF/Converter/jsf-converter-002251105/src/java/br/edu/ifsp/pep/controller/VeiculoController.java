package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.VeiculoDAO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;


@Named
@RequestScoped
public class VeiculoController {
    
    @Inject
    private VeiculoDAO veiculoDAO;
}
