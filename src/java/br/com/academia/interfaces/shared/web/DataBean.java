/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.academia.interfaces.shared.web;

import br.com.academia.application.service.DataService;
import br.com.academia.domain.aluno.Aluno.Sexo;
import br.com.academia.domain.aluno.Aluno.Situacao;
import br.com.academia.domain.aluno.Estado;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Ruan
 */

@Named
@ApplicationScoped
public class DataBean implements Serializable{
    
    @EJB
    private DataService dataService;
    
    public Sexo[] getSexos(){
        return dataService.getSexos();
        
    }
    
    public Situacao[] getSituacoes(){
        return dataService.getSituacoes();
    }
    
    
    public List<Estado> getEstado(){
        return dataService.listEstados();
    }
    
}
