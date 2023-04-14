/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.academia.application.service;

import br.com.academia.application.ultil.StringUltil;
import br.com.academia.application.ultil.ValidationException;
import br.com.academia.domain.acesso.Acesso;
import br.com.academia.domain.acesso.AcessoRepository;
import br.com.academia.domain.acesso.TipoAcesso;
import br.com.academia.domain.aluno.Aluno;
import br.com.academia.domain.aluno.AlunoRepository;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ruan
 */

@Stateless
public class AcessoService {
    
    @EJB
    private AcessoRepository acessoRepository;
    
    @EJB
    private AlunoRepository alunoRepository;
    
    public TipoAcesso registraAcesso(String matricula, Integer rg){
        if (StringUltil.isEmpty(matricula)&& rg ==null) {
            
            throw new ValidationException("E preciso fornecer a matricula ou o RG do aluno");
            
        }
        
        Aluno aluno;
        
        if (StringUltil.isEmpty(matricula)) {
            aluno = alunoRepository.findByRG(rg);
            
        } else {
            aluno = alunoRepository.findByMatricula(matricula);
        }
        
        if (aluno == null) {
            throw new ValidationException("O aluno nao foi encontrado");
        }
        
        Acesso ultimoAcesso = acessoRepository.findUltimoAcesso(aluno);
        TipoAcesso tipoAcesso;
        
        if (ultimoAcesso == null || ultimoAcesso.isEntradaSaidaPreenchidas()) {
            ultimoAcesso = new Acesso();
            ultimoAcesso.setAluno(aluno);
            tipoAcesso=ultimoAcesso.registraAcesso();
            acessoRepository.store(ultimoAcesso);
        }else{
            
            tipoAcesso=ultimoAcesso.registraAcesso();
        }
        
        return tipoAcesso;
        
        
    }
}
