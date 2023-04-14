/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.academia.interfaces.aluno.web;

import br.com.academia.application.service.AlunoService;
import br.com.academia.domain.aluno.Aluno;
import br.com.academia.application.ultil.StringUltil;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Ruan
 */

@FacesConfig
@Named
@RequestScoped

public class AlunoBean implements Serializable{
    
    @EJB
    private AlunoService alunoService;
    
    @Inject
    private FacesContext facesContext;
   
    private Aluno aluno = new Aluno();
    
    private String matricula;
    
    private String titulo = "Novo Aluno";
  
    
    public void carregar(){
        
        if (!StringUltil.isEmpty(matricula)) {
            
            aluno = alunoService.findByMatricula(matricula);
            titulo = "Alterar aluno";
            
        }
        
    }
    
    public String gravar(){
        alunoService.createOrUpdate(aluno);
        facesContext.addMessage(null, new FacesMessage("Dados gravados com sucesso"));
        return null;
    }

    
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTitulo() {
        return titulo;
    }
        
    
    
    
    
    
        
    
    
    
}
