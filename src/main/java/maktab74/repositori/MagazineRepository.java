package maktab74.repositori;



import maktab74.domain.Magazine;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.List;

public class MagazineRepository {

    private EntityManager entityManager;

    public MagazineRepository(EntityManager em) {
        this.entityManager = em;
    }


    public Magazine insertMagazine(Magazine magazine) throws SQLException {

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(magazine);
        transaction.commit();
        return magazine;
    }

    public int getMaxId() throws SQLException {
        TypedQuery query = entityManager.createQuery("select max(m) from Magazine m ", Integer.class);

        return query.getFirstResult();
    }

    public List<Magazine> getAllMagazine() throws SQLException {
        TypedQuery<Magazine> query = entityManager.createQuery("select m from Magazine m", Magazine.class);
        return query.getResultList();
    }


    public int countAllMagazine() throws SQLException {
        TypedQuery query = entityManager.createQuery("select count(m)from Magazine m", Integer.class);
        int firstResult = query.getFirstResult();
        return firstResult;
    }

    public Magazine getById(int magazineId) throws SQLException {

        return entityManager.find(Magazine.class, magazineId);
    }


    public void douwnProduct(int magazineId) throws SQLException {

        entityManager.getTransaction().begin();

        Magazine magazine = entityManager.find(Magazine.class, magazineId);

       magazine.setNumber(magazine.getNumber() - 1);

        entityManager.persist(magazine);

        entityManager.getTransaction().commit();
    }
}
