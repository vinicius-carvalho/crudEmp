

package model.emprestimo;

import java.io.Serializable;
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
import model.livro.Livro;

/**
 *
 * @author Vinicius
 */
@Entity @Table(name="Emprestimo")
public class Emprestimo implements Serializable {
    
     @Id @GeneratedValue
    private long id;
     @ManyToOne
    private model.user.User owner;
     @OneToMany
     private List<Livro> livrosEmprestimo;
     @Temporal(TemporalType.DATE)
    private Date dataEntrega;
     @Temporal(TemporalType.DATE)
     private Date DataEmprestimo;
     int CodLivro;
     int CodUser;

    public Emprestimo() {
    }

    public int getCodLivro() {
        return CodLivro;
    }

    public void setCodLivro(int CodLivro) {
        this.CodLivro = CodLivro;
    }

    public int getCodUser() {
        return CodUser;
    }

    public void setCodUser(int CodUser) {
        this.CodUser = CodUser;
    }


    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataEmprestimo() {
        return DataEmprestimo;
    }

    public void setDataEmprestimo(Date DataEmprestimo) {
        this.DataEmprestimo = DataEmprestimo;
    }
    

    public model.user.User getOwner() {
        return owner;
    }

    public void setOwner(model.user.User owner) {
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