/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Régis
 */
@Entity
@Table(name = "Professor")
public class Professor implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idProfessor", nullable = false)
    private Integer idProfessor;
    
    @Column(name = "nome", unique = true, nullable = false, length = 45)
    private String nome;
    
    @Column(name = "rua", nullable = false, length = 45)
    private String rua;
    
    @Column(name = "bairro", nullable = false, length = 45)
    private String bairro;
    
    @Column(name = "cidade", nullable = false, length = 45)
    private String cidade;
    
    @Column(name = "cep", nullable = true, length = 45)
    private String cep;
    
    @Column(name = "telefone", nullable = true, length = 45)
    private String telefone;
    
    @ManyToOne(optional = false)
    @ForeignKey(name = "FK_idUsuario")
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private Usuario usuario;

    public Professor() {
    }

    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.idProfessor != null ? this.idProfessor.hashCode() : 0);
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
        final Professor other = (Professor) obj;
        if (this.idProfessor != other.idProfessor && (this.idProfessor == null || !this.idProfessor.equals(other.idProfessor))) {
            return false;
        }
        return true;
    }
    
}
