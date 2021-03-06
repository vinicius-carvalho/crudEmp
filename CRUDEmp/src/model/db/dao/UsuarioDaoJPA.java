/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.db.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.user.User;

/**
 *
 * @author Joao Carloss
 */
public class UsuarioDaoJPA extends factory.DaoFactory implements UsuarioDAO{
    
   

    @Override
    public boolean add(User user) {
        if(factory.isOpen()){
            EntityManager em = factory.createEntityManager();
             em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            em.close();
            return true;
        }
        
        return false;
    }

    @Override
    public List<User> list() {
        EntityManager em =  factory.createEntityManager();
        final String jpql = "SELECT user FROM User user";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        List<User> list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public User find(long id) {
        return null;
    }

    @Override
    public int remove(long id) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.remove(user);
        em.getTransaction().commit();
        em.close();
        
        return 1;
        
    }

    @Override
    public int update(User user) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
        return 1;
    }
    
    
    
}
