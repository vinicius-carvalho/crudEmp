

package model.emprestimo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import model.livro.Livro;
import model.user.User;
import org.hibernate.annotations.CollectionId;

/**
 *
 * @author Vinicius
 */
@Entity @Table(name="emprestimo")
public class Emprestimo implements Serializable {
    
    @Id @GeneratedValue
    private long id;
    
    @ManyToOne
    private User owner;
    
    @OneToMany
    private List<Livro> livrosEmprestimo;
    
    @Basic
    private String nome;
    private String livro;
    private String dataEntrega;  
    private String dataEmprestimo;
    private String telefone;
    private String endereco;
    private String email;
    
    //@JoinColumn(name="livro", referencedColumnName = "id")
    //@ManyToOne
    
    @CollectionTable(name="livro", joinColumns = @JoinColumn(name = "id"))
    private long codLivro;
    
    //@JoinColumn(name="user", referencedColumnName = "id")
    //@ManyToOne
    
    @CollectionTable(name="user", joinColumns = @JoinColumn(name = "id"))
    private long codUser;

    public Emprestimo() {
    }

    public long getCodLivro() {
        return codLivro;
    }

    public void setCodLivro(long CodLivro) {
        this.codLivro = CodLivro;
    }

    public long getCodUser() {
        return codUser;
    }

    public void setCodUser(long CodUser) {
        this.codUser = CodUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String DataEmprestimo) {
        this.dataEmprestimo = DataEmprestimo;
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

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
     
}