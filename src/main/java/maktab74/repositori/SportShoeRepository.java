package maktab74.repositori;

import maktab74.domain.SportShoe;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

public class SportShoeRepository {

    private EntityManager entityManager;

    public SportShoeRepository(EntityManager em) {

        this.entityManager = em;
    }

    public SportShoe insertSportShoe(SportShoe sportShoe) throws SQLException {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(sportShoe);
        transaction.commit();

        return sportShoe;
    }

    private int getMaxId() throws SQLException {
        TypedQuery query = entityManager.createQuery("select max(s) from SportShoe s", Integer.class);

        return query.getFirstResult();
    }

    public List<SportShoe> getAllSportShoe() throws SQLException {
        TypedQuery<SportShoe> query = entityManager.createQuery("select s from SportShoe s ", SportShoe.class);
        return query.getResultList();
    }


    public int countAllSportShoe() throws SQLException {
        TypedQuery query = entityManager.createQuery("select count(s)from SportShoe s", Integer.class);
        int firstResult = query.getFirstResult();
        return firstResult;
    }

    public SportShoe getById(int sportshoeId) throws SQLException {
        return entityManager.find(SportShoe.class, sportshoeId);
    }

    public void douwnProduct(int sportShoeId) throws SQLException {
        entityManager.getTransaction().begin();

        SportShoe sportShoe = entityManager.find(SportShoe.class, sportShoeId);

        sportShoe.setNumber(sportShoe.getNumber() - 1);

        entityManager.persist(sportShoe);

        entityManager.getTransaction().commit();
    }

}


