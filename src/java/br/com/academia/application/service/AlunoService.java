/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.academia.application.service;

import br.com.academia.application.ultil.StringUltil;
import br.com.academia.application.ultil.Validation;
import br.com.academia.application.ultil.ValidationException;
import br.com.academia.domain.acesso.Acesso;
import br.com.academia.domain.aluno.Aluno;
import br.com.academia.domain.aluno.Aluno.Situacao;
import br.com.academia.domain.aluno.AlunoRepository;
import java.time.LocalDate;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ruan
 */

@Stateless
public class AlunoService {
    
    @EJB
    private AlunoRepository alunoRepository;
    
    public void createOrUpdate(Aluno aluno){
     
        if (StringUltil.isEmpty(aluno.getMatricula())) {
            create(aluno);
        }
        else{
            update(aluno);
        }
    }

   
    private void create(Aluno aluno) {

        Validation.assertNotEmpty(aluno);
        String maxMatricula = alunoRepository.getMaxMatriculaAno();
        aluno.gerarMatricula(maxMatricula);
        alunoRepository.store(aluno);
        
        
    }
    
    public void delete(String matricula){
        alunoRepository.delete(matricula);
        
               
    }
    
     private void update(Aluno aluno) {
        
        Validation.assertNotEmpty(aluno);
        Validation.assertNotEmpty(aluno.getMatricula());
        alunoRepository.update(aluno);
    }
     
     public Aluno findByMatricula(String matricula){
         return alunoRepository.findByMatricula(matricula);
     }
     
     
     
     public List<Aluno> listAluno(String matricula, String nome, Integer rg, Integer telefone){
         if (StringUltil.isEmpty(matricula) && StringUltil.isEmpty(nome) && rg == null && telefone == null) {
             throw new ValidationException("Pelo menos um criterio de pesquisa deve ser fornecido"); 
         }
         
         return alunoRepository.listAlunos(matricula, nome, rg, telefone);
     }
     
     public List<Aluno> listSituacoesAlunos(Situacao situacao){
         Validation.assertNotEmpty(situacao);
         return alunoRepository.listSituacoesAlunos(situacao);
     }
     
     
     
     public List<Acesso> listAcessoAlunos(String matricula, LocalDate dataInicial, LocalDate dataFinal){
         
         if (StringUltil.isEmpty(matricula) && dataInicial==null && dataFinal==null) {
             throw new ValidationException("Pelo menos um criterio de pesquisa deve ser fornecido");
         }
         return alunoRepository.listAcessoAlunos(matricula, dataInicial, dataFinal);
         
     }
     
}
