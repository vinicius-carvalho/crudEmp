/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.db.dao;

import factory.DaoFactory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.emprestimo.Emprestimo;
import model.livro.Livro;
import model.user.User;

 

/**
 *
 * @author Vinicius
 */
public class EmprestimoDaoJPA extends DaoFactory implements EmprestimoDAO {

    
    @Override
    public boolean add(Emprestimo emp) {

        if (factory.isOpen()) {

            EntityManager em = factory.createEntityManager();
            
                
            //Criado um usuário
            Query query = em.createQuery("SELECT u from User u WHERE u.id = :id");
            query.setParameter("id", emp.getCodUser());
            User user = (User) query.getSingleResult();
                  
       
            
            //Criando Empréstimo
            Query query2 = em.createQuery("SELECT l from Livro l WHERE l.id = :id");
            query2.setParameter("id", emp.getCodLivro());
            Livro livro = (Livro) query2.getSingleResult();

            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setNome(user.getNome());
            emprestimo.setLivro(livro.getTitulo());
            emprestimo.setDataEmprestimo(emp.getDataEmprestimo());
            emprestimo.setDataEntrega(emp.getDataEntrega());
            emprestimo.setTelefone(user.getTelefone());
            emprestimo.setEndereco(user.getEndereco());
            emprestimo.setEmail(user.getEmail());
            emprestimo.setCodLivro(emp.getCodLivro());
            emprestimo.setCodUser(emp.getCodUser());

            em.getTransaction().begin();
            em.persist(emprestimo);
            em.getTransaction().commit();
            em.close();

            return true;
        }

        return false;
    }

    @Override
    public List<Emprestimo> list() {
        EntityManager em = factory.createEntityManager();
        String jpql = "SELECT emprestimo FROM Emprestimo emprestimo";
        TypedQuery<Emprestimo> query = em.createQuery(jpql, Emprestimo.class);
        List<Emprestimo> listEmprestimo = query.getResultList();
        em.close();
        return listEmprestimo;
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
