package model.db.dao;

import java.util.List;
import model.livros.Livro;



public interface LivrosDao {
	
       boolean add(Livro livro);

	List<Livro> list();

	Livro find(long id);

	int remove(long id);

	int update(Livro livro);

	Livro findByLogin(String nome);

	List<Livro> search(String term);

}
