/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.db.dao;

import java.util.List;

import model.user.User;

/**
 *
 * @author Joao Carloss
 */
public interface UsuarioDAO {
    
      boolean add(User User);

	List<User> list();

	User find(long id);

	int remove(long id);

	int update(User user);
    
}
