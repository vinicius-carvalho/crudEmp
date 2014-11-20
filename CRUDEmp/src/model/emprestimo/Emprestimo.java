/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.emprestimo;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import model.livros.Livro;
import model.user.User;

/**
 *
 * @author Vinicius
 */
@Entity @Table(name="Emprestimo")
public class Emprestimo {
    
     @Id @GeneratedValue
    private long id;
     @ManyToOne
    private User owner;
     @OneToMany
     private List<Livro> livrosEmprestimo;
     @Temporal(TemporalType.DATE)
    private Date dataEntrega;

    public Emprestimo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Livro> getLivrosEmprestimo() {
        return livrosEmprestimo;
    }

    public void setLivrosEmprestimo(List<Livro> livrosEmprestimo) {
        this.livrosEmprestimo = livrosEmprestimo;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
     
}