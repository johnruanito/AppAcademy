/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.academia.application.service;


import br.com.academia.domain.aluno.Aluno.Sexo;
import br.com.academia.domain.aluno.Aluno.Situacao;
import br.com.academia.domain.aluno.Estado;
import br.com.academia.domain.aluno.EstadoRepository;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ruan
 */

@Stateless
public class DataService {
    
    @EJB
    private EstadoRepository estadoRepository;
    
    public List<Estado> listEstados(){
        
        return estadoRepository.listEstados();
    }
    
    
    public Sexo[] getSexos(){
        return Sexo.values();
        
    }
    
    public Situacao[] getSituacoes(){
        return Situacao.values();
    }
}
    
    

