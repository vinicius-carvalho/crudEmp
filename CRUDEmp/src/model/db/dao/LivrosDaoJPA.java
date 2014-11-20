package model.db.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.db.connection.ConnectionFactory;
import model.livro.Livro;

public class LivrosDaoJPA implements LivrosDao {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudemp");

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
        String jpql = "SELECT livros FROM Livros livros";
        TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
        em.close();

        return query.getResultList();

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
