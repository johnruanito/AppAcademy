/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academia.domain.aluno;

import br.com.academia.application.ultil.StringUltil;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ruan
 */

@Entity
@Table(name = "ALUNO")
public class Aluno implements Serializable {
    
    public enum Sexo{
        Masculino, Feminino;      
    }
    
    public enum Situacao{
        Ativo, Inativo, Pendente;
    }
    
    @Id
    @Column(name = "ID",nullable = false, length = 8)
    private String matricula;
    
    @Column(name = "NOME",nullable = false, length = 64)
    private String nome;
    
    @Enumerated
    @Column( name = "SEXO",nullable = false)
    private Sexo sexo;
    
    @Column(name ="RG", nullable = false, length = 7)
    private Integer rg;
    
    @Column(name ="CPF", nullable = false, length = 11)
    private Integer cpf;
    
    @Column(name = "NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;
    
    @Enumerated
    @Column(name = "SITUACAO", nullable = false, length = 1)
    private Situacao situacao;
    
    @Column(name = "EMAIL", nullable = true, length = 64)
    private String email;
    
    @Embedded
    private Endereco endereco = new Endereco();
    
    @Embedded
    private Telefone telefone = new Telefone();
    
    public void gerarMatricula(String maxMatricula){
        
        Year ano = Year.now();
        
        if (maxMatricula==null) {
            maxMatricula = ano + StringUltil.leftZeroes(0, 4);
        }
        int sequencial = Integer.parseInt(maxMatricula.substring(4));
        sequencial++;
        
        this.matricula = ano + StringUltil.leftZeroes(sequencial, 4);
              
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }
    
    

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Aluno[" + "matricula=" + matricula + ", nome=" + nome + ", sexo=" + sexo + ", rg=" + rg + ", cpf=" + cpf + 
                ", dataNascimento=" + dataNascimento + ", situacao=" + situacao + ", email=" + email + ", endereco=" + endereco +
                ", telefone=" + telefone + "]";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.matricula);
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
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }

    
    
    
}
