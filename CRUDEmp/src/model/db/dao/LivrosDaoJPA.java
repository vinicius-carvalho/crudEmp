package model.db.dao;

import factory.DaoFactory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.livro.Livro;

public class LivrosDaoJPA  extends DaoFactory implements LivrosDao {

    

    public boolean add(Livro livro) {
        if (factory.isOpen()) {
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            em.persist(livro);
            em.getTransaction().commit();
            em.close();
            return true;
        } else {
            return false;
        }
    }

    public List<Livro> list() {

        EntityManager em = factory.createEntityManager();
        String jpql = "SELECT livro FROM Livro livro";
        TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
        List<Livro> livros = query.getResultList();
        em.close();
        System.out.println(livros.toString());

        return livros;

    }

    public Livro find(long id) {

        return null;
    }

    public int remove(long id) {

        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Livro removerLivro = em.find(Livro.class, id);
        em.remove(removerLivro);
        em.getTransaction().commit();
        em.close();

        return 1;

    }

    public int update(Livro livro) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.merge(livro);
        em.getTransaction().commit();
        em.close();

        return 1;
    }

    public Livro findByLogin(String nome) {
        return null;
    }

    public List<Livro> search(String term) {
        return null;
    }
}
