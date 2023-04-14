/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.academia.interfaces.relatorio.web;

import br.com.academia.application.service.AlunoService;
import br.com.academia.domain.aluno.Aluno;
import br.com.academia.domain.aluno.Aluno.Situacao;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.RequestParameterMap;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Ruan
 */

@Named
@SessionScoped
public class RelatorioSituacoesBean implements Serializable{
    
    @EJB
    private AlunoService alunoService;
    
    @Inject
    @RequestParameterMap
    private Map<String, String> requestParamsMap;
                
    private Situacao situacao;
    private List <Aluno> alunos;
    
    
    
    public void check(){
        String clear = requestParamsMap.get("clear");
        
        if (clear != null && Boolean.valueOf(clear)) {
           situacao = null;
           alunos = null;
                
        }
        
        
    }
    
    

    public String gerarRelatorio(){
       alunos = alunoService.listSituacoesAlunos(situacao);
        return null;
    }
    
    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    
    
}
