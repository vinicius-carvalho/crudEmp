package model.livros;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

<<<<<<< HEAD
@Entity @Table(name="livro")
public class Livro implements Serializable {

    
=======
@Entity
@Table(name = "Livros")
public class Livro implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "livro")
    private User owner; //Irá ter referência para o User ?
    private String autor;
    private String titulo;
    private String editora;
    
>>>>>>> c7c4174a175b74fa56f53edb2d31dfe2abdc4685

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

   
    
    
    
    

}
