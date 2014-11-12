package model.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.db.connection.ConnectionFactory;
import model.livros.Livro;



public class LivrosDaoJPA implements LivrosDao{
	private ConnectionFactory factory;

	public LivrosDaoJPA() {
		factory = new ConnectionFactory();
	}

  
    public boolean add(Livro livro) {
        return false;   
    }

    
    public List<Livro> list() {
        return null;
        
    }

    public Livro find(long id) {
       return null;
    }

  
    public int remove(long id) {
    return 1;
    }


    public int update(Livro livro) {
    return 0;
    }

  
    public Livro findByLogin(String nome) {
        return null;
    }

   
    public List<Livro> search(String term) {
        return null;
    }
}
