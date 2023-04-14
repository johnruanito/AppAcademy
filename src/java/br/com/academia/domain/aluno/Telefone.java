/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academia.domain.aluno;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 *
 * @author Ruan
 */

@Embeddable
public class Telefone implements Serializable {
    
    @Column(name = "CELULA_DDD", nullable = false, length = 2)
    private Integer dddCelular;
    
    @Column(name = "CELULAR_NUMERO", nullable = false, length = 9)
    private Integer numeroCelular;

        
    public Integer getDddCelular() {
        return dddCelular;
    }

    public void setDddCelular(Integer dddCelular) {
        this.dddCelular = dddCelular;
    }

    public Integer getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(Integer numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    @Override
    public String toString() {
        return "Telefone{" + "dddCelular=" + dddCelular + ", numeroCelular=" + numeroCelular + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.dddCelular);
        hash = 13 * hash + Objects.hashCode(this.numeroCelular);
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
        final Telefone other = (Telefone) obj;
        if (!Objects.equals(this.dddCelular, other.dddCelular)) {
            return false;
        }
        if (!Objects.equals(this.numeroCelular, other.numeroCelular)) {
            return false;
        }
        return true;
    }
    
    
}
