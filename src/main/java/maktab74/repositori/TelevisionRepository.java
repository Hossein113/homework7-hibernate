package maktab74.repositori;

import maktab74.domain.Television;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

public class TelevisionRepository {


    private EntityManager entityManager;

    public TelevisionRepository(EntityManager em) {
        this.entityManager = em;
    }


    public Television insertTelevision(Television television) throws SQLException {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(television);
        transaction.commit();
        return television;
    }

    private int getMaxId() throws SQLException {
        TypedQuery query = entityManager.createQuery("select max(t) from Television t ", Integer.class);

        return query.getFirstResult();
    }

    public List<Television> getAllTelevision() throws SQLException {
        TypedQuery<Television> query = entityManager.createQuery("select t from Television t", Television.class);
        return query.getResultList();
    }


    public int countAllTelevision() throws SQLException {
        TypedQuery query = entityManager.createQuery("select count(t)from Television t ", Integer.class);
        int firstResult = query.getFirstResult();
        return firstResult;
    }

    public Television getById(int televisionId) throws SQLException {
        return entityManager.find(Television.class, televisionId);
    }

    public void douwnProduct(int televisionId) throws SQLException {
        entityManager.getTransaction().begin();

        Television television = entityManager.find(Television.class, televisionId);

        television.setNumber(television.getNumber() - 1);

        entityManager.persist(television);

        entityManager.getTransaction().commit();
    }

}
