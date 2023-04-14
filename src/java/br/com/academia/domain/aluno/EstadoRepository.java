/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.academia.domain.aluno;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ruan
 */

@Stateless
public class EstadoRepository {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Estado> listEstados(){
        TypedQuery<Estado> q = em.createQuery("SELECT e FROM Estado e ORDER BY e.nome", Estado.class);
        
        return q.getResultList();
        
          
    }
    
}
