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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ruan
 */
@Embeddable
public class Endereco implements Serializable {
    
    @Column(name = "LOGRADOURO", nullable = false, length = 128)
    private String logradouro;
    
    @Column(name = "BAIRRO", nullable = false, length = 128)
    private String bairro;
    
    
    @Column(name = "NUMERO", nullable = true, length = 4)
    private Integer numero;
    
    @Column(name = "COMPLEMENTO", nullable = true, length = 32)
    private String complemento;
    
    @Column(name = "CIDADE", nullable = false, length = 64)
    private String cidade;
    
    @ManyToOne
    @JoinColumn(name  = "ESTADO_ID", nullable = false)
    private Estado estado = new Estado();
    
    @Column(name = "CEP", nullable = false, length = 8)
    private Integer cep;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Endereco{" + "logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + ", complemento=" + complemento + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.logradouro);
        hash = 23 * hash + Objects.hashCode(this.bairro);
        hash = 23 * hash + Objects.hashCode(this.numero);
        hash = 23 * hash + Objects.hashCode(this.complemento);
        hash = 23 * hash + Objects.hashCode(this.cidade);
        hash = 23 * hash + Objects.hashCode(this.estado);
        hash = 23 * hash + Objects.hashCode(this.cep);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.logradouro, other.logradouro)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.complemento, other.complemento)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        return true;
    }
    
    
}
