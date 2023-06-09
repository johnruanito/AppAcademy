/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academia.domain.aluno;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ruan
 */

@Entity
@Table(name = "ESTADO")
public class Estado implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "SIGLA", nullable = false, length = 2)
    private String sigla;
    
    @Column(name = "NOME",nullable = false, length = 30)
    private String nome;

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Estado{" + "sigla=" + sigla + ", nome=" + nome + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.sigla);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.sigla, other.sigla)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
}
