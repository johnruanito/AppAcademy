/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.academia.interfaces.relatorio.web;

import br.com.academia.application.service.AlunoService;
import br.com.academia.application.ultil.StringUltil;
import br.com.academia.application.ultil.ValidationException;
import br.com.academia.domain.acesso.Acesso;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Ruan
 */

@Named
@RequestScoped
public class RelatorioEntradaSaidaBean implements Serializable{
    
    @Inject
    private FacesContext facesContext;
    
    
    @EJB
    private AlunoService alunoService;
    
    private String matricula;  
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    
    private List<Acesso> acessos;
    
    
    public void carregarAluno(){
        if (!StringUltil.isEmpty(matricula)) {
            gerarRelatorio();
        }
    }
    
    public String gerarRelatorio(){
        try {
            acessos = alunoService.listAcessoAlunos(matricula, dataInicial, dataFinal);
            
        } catch (ValidationException e) {
            facesContext.addMessage(null, new FacesMessage(e.getMessage()));
        }
        
        
        
        return null;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public List<Acesso> getAcessos() {
        return acessos;
    }

    public void setAcessos(List<Acesso> acessos) {
        this.acessos = acessos;
    }


    
    
    
}
