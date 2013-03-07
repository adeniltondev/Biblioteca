/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "Emprestimo")
public class Emprestimo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEmprestimo", nullable = false)
    private Integer idEmprestimo;
    
    @Column(name = "dataemprestimo", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataEmprestimo;
    
    @ManyToOne(optional = false)
    @ForeignKey(name = "FK_idUsuario")
    @JoinColumn(name = "idEmprestimo", referencedColumnName = "idEmprestimo")
    private Usuario usuario;
    
    @ManyToOne(optional = false)
    @ForeignKey(name = "FK_idResponsavel")
    @JoinColumn(name = "idEmprestimo", referencedColumnName = "idEmprestimo")
    private Responsavel responsavel;
    
    @ManyToOne(optional = false)
    @ForeignKey(name = "FK_idLivro")
    @JoinColumn(name = "idEmprestimo", referencedColumnName = "idEmprestimo")
    private Livro livro;
    
    public Emprestimo() {
        usuario = new Usuario();
        responsavel = new Responsavel();
        livro = new Livro();
    }

    public Integer getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Integer idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (this.dataEmprestimo != null ? this.dataEmprestimo.hashCode() : 0);
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
        final Emprestimo other = (Emprestimo) obj;
        if (this.dataEmprestimo != other.dataEmprestimo && (this.dataEmprestimo == null || !this.dataEmprestimo.equals(other.dataEmprestimo))) {
            return false;
        }
        return true;
    }
 
}
