/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.db.dao;

import java.util.List;
import model.livros.Livro;

/**
 *
 * @author Joao Carloss
 */
public interface UsuarioDAO {
    
      boolean add(User User);

	User<User> list();

	User find(long id);

	int remove(long id);

	int update(Livro livro);

	User findByLogin(String nome);

	User<User> search(String term)
    
}
