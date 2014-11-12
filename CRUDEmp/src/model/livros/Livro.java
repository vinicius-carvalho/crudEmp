package model.livros;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="Livros")
public class Livro implements Serializable {

    
    @Id @GeneratedValue
    private Long id;
    private String nome;
    private float peso;
    private String data;
    private String tipo;

  

    public Livro() {
    }
    
    
      public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

  

}
