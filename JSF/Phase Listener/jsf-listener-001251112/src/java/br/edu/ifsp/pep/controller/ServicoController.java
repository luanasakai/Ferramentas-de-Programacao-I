/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.ServicoDAO;
import br.edu.ifsp.pep.dao.VeiculoDAO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 *
 * @author aluno
 */


@Named
@RequestScoped
public class ServicoController {
    
    @Inject
    private ServicoDAO servicoDAO;
    
}
