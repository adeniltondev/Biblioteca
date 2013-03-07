/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "Responsavel")
public class Responsavel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idReponsavel", nullable = false)
    private Integer idResponsavel;
    
    @Column(name = "nome", unique = true, nullable = false, length = 45)
    private String nome;
    
    @Column(name = "email", unique = true, nullable = false, length = 60)
    private String email;
    
    @Column(name = "senha", nullable = false, length = 20)
    private String senha;
    
    @OneToMany(mappedBy = "Responsavel", fetch = FetchType.LAZY)
    @ForeignKey(name = "FK_idResponsavel")
    private List<Emprestimo> emprestimos;

    public Responsavel() {
    }

    public Integer getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Integer idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.idResponsavel != null ? this.idResponsavel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Responsavel other = (Responsavel) obj;
        if (this.idResponsavel != other.idResponsavel && (this.idResponsavel == null || !this.idResponsavel.equals(other.idResponsavel))) {
            return false;
        }
        return true;
    }
    
}
