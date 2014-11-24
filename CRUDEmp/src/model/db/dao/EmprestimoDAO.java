/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.db.dao;

import java.util.List;
import model.emprestimo.Emprestimo;

import model.user.User;

/**
 *
 * @author Vinicius
 */
public interface EmprestimoDAO {

    boolean add(Emprestimo emp);

    List<Emprestimo> list();

    Emprestimo find(long id);

    int remove(long id);

    int update(Emprestimo emp);

}
