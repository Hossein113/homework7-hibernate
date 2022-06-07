package maktab74.repositori;


import maktab74.domain.Magazine;
import maktab74.domain.OfficalShoe;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.List;

public class OfficalshoeRepository {

   private EntityManager entityManager;

    public OfficalshoeRepository(EntityManager em) {

        this.entityManager = em;
    }

    public OfficalShoe insertOfficalShoe(OfficalShoe oficalShoe) throws SQLException {

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(oficalShoe);
        transaction.commit();
        return oficalShoe;
    }

    private int getMaxId() throws SQLException {
        TypedQuery query = entityManager.createQuery("select max(o) from OfficalShoe o", Integer.class);

        return query.getFirstResult();
    }


    public List<OfficalShoe> getAllOfficalShoe() throws SQLException {
        TypedQuery<OfficalShoe> query = entityManager.createQuery("select o from OfficalShoe o", OfficalShoe.class);
        return query.getResultList();
    }


    public int countAllOfficalshoe() throws SQLException {
        TypedQuery query = entityManager.createQuery("select count(o)from OfficalShoe o", Integer.class);
        int firstResult = query.getFirstResult();
        return firstResult;
    }

    public OfficalShoe getById(int officalshoeId) throws SQLException {
        return entityManager.find(OfficalShoe.class, officalshoeId);
    }

    public void douwnProduct(int officalShoeId) throws SQLException {
       entityManager.getTransaction().begin();

        OfficalShoe officalShoe = entityManager.find(OfficalShoe.class, officalShoeId);

       officalShoe.setNumber(officalShoe.getNumber() - 1);

       entityManager.persist(officalShoe);

        entityManager.getTransaction().commit();
    }

}



