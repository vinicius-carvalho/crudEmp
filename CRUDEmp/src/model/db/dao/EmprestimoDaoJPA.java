/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.db.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.emprestimo.Emprestimo;
import model.user.User;

/**
 *
 * @author Vinicius
 */
public class EmprestimoDaoJPA implements EmprestimoDAO{
    
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudemp");
    
    @Override
    public boolean add(Emprestimo emp) {
        if(factory.isOpen()){
            EntityManager em = factory.createEntityManager();
             em.getTransaction().begin();
            em.persist(emp);
            em.getTransaction().commit();
            em.close();
            return true;
        }
        
        return false;
    }

    @Override
    public List<Emprestimo> list() {
        EntityManager em =  factory.createEntityManager();
        final String jpql = "SELECT * FROM emp Emprestimo";
        TypedQuery<Emprestimo> query = em.createQuery(jpql, Emprestimo.class);
        em.close();
        return query.getResultList();
    }

    @Override
    public Emprestimo find(long id) {
        return null;
    }

    @Override
    public int remove(long id) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Emprestimo emp = em.find(Emprestimo.class, id);
        em.remove(emp);
        em.getTransaction().commit();
        em.close();
        
        return 1;
        
    }

    @Override
    public int update(Emprestimo emp) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.merge(emp);
        em.getTransaction().commit();
        em.close();
        return 1;
    }

   

   
    
}
