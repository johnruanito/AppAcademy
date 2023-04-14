/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.academia.domain.acesso;

import br.com.academia.domain.aluno.Aluno;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ruan
 */

@Stateless
public class AcessoRepository {
    
    @PersistenceContext
    private EntityManager em;
    
    public Acesso findUltimoAcesso (Aluno aluno){
        
        try{
        return em.createQuery("SELECT a FROM Acesso a WHERE a.aluno.matricula = :matricula ORDER BY a.id DESC", Acesso.class).setParameter("matricula", aluno.getMatricula()).setMaxResults(1).getSingleResult();
  
        }catch(NoResultException e){
            return null;
        }
    }
    
    public void store(Acesso acesso){
        em.persist(acesso);
        
    }
}
