package model.db.dao;

import java.util.List;

import model.pet.Animal;

public interface LivrosDao {
	
       boolean add(Animal pet);

	List<Animal> list();

	Animal find(long id);

	int remove(long id);

	int update(Animal pet);

	Animal findByLogin(String nome);

	List<Animal> search(String term);

}
