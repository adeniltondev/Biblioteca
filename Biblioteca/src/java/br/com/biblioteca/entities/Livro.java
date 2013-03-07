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
@Table(name = "Livro")
public class Livro implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idLivro", nullable = false)
    private Integer idLivro;
    
    @Column(name = "idLivro", nullable = false, length = 45)
    private String titulo;
    
    @Column(name = "autor", nullable = false, length = 45)
    private String autor;
    
    @Column(name = "editora", nullable = false, length = 45)
    private String editora;
    
    @Column(name = "tombamento", unique = true, nullable = false, length = 45)
    private String tombamento;
    
    @Column(name = "assunto", nullable = true, length = 45)
    private String assunto;
    
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
    
    @Column(name = "disponivel", nullable = false)
    private Integer disponivel;
    
    @OneToMany(mappedBy = "Livro", fetch = FetchType.LAZY)
    @ForeignKey(name = "FK_idLivro")
    private List<Emprestimo> emprestimoss;

    public Livro() {
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getTombamento() {
        return tombamento;
    }

    public void setTombamento(String tombamento) {
        this.tombamento = tombamento;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Integer disponivel) {
        this.disponivel = disponivel;
    }

    public List<Emprestimo> getEmprestimoss() {
        return emprestimoss;
    }

    public void setEmprestimoss(List<Emprestimo> emprestimoss) {
        this.emprestimoss = emprestimoss;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.idLivro != null ? this.idLivro.hashCode() : 0);
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
        final Livro other = (Livro) obj;
        if (this.idLivro != other.idLivro && (this.idLivro == null || !this.idLivro.equals(other.idLivro))) {
            return false;
        }
        return true;
    }
    
}
