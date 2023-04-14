/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.academia.interfaces.acesso.web;

import br.com.academia.application.service.AcessoService;
import br.com.academia.application.ultil.ValidationException;
import br.com.academia.domain.acesso.TipoAcesso;
import java.io.Serializable;
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
public class ControleAcessoBean implements Serializable{
    
    
    @EJB
    private AcessoService acessoService;
    
    @Inject
    private FacesContext facesContext;
    
    private String matricula;
    private Integer rg;
    
    public String registrarAcesso(){
        
        TipoAcesso tipoAcesso;
        
        try {
           tipoAcesso = acessoService.registraAcesso(matricula, rg);
        } catch (ValidationException e) {
            facesContext.addMessage(null, new FacesMessage(e.getMessage()));
            
            return null;
        }
        String msg;
        
        if (tipoAcesso == TipoAcesso.Entrada) {
            msg = "Entrada Registrada!";
            
        }else if(tipoAcesso == TipoAcesso.Saida){
            msg = "Saida Registrada!";
            
        }else{
            msg = "Dados incosistentes";
        }
        
        facesContext.addMessage(null, new FacesMessage(msg));
        return null;
    }

    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }
    
}
