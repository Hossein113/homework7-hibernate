package maktab74.repositori;

import maktab74.domain.OfficalShoe;
import maktab74.domain.Radio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.List;

public class RadioRepository {

    private EntityManager entityManager;

    private Radio[] radioList;


    public RadioRepository(EntityManager em) {

        this.entityManager = em;
    }

    public Radio[] getRadioList() {
        return radioList;
    }

    public void setRadioList(Radio[] radioList) {
        this.radioList = radioList;
    }

    public Radio insertRadio(Radio radio) throws SQLException {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(radio);
        transaction.commit();
        return radio;
    }

    public int getMaxId() throws SQLException {
        TypedQuery query = entityManager.createQuery("select max(r) from Radio r", Integer.class);

        return query.getFirstResult();

    }

    public List<Radio> getAllRadio() throws SQLException {
        TypedQuery<Radio> query = entityManager.createQuery("select r from Radio r", Radio.class);
        return query.getResultList();
    }

    public Radio getById(int radioId) throws SQLException {
        return entityManager.find(Radio.class, radioId);
    }


    public int countAllRadio() throws SQLException {
        TypedQuery query = entityManager.createQuery("select count(r)from Radio r", Integer.class);
        int firstResult = query.getFirstResult();
        return firstResult;
    }

    public void douwnProduct(int radioId) throws SQLException {

        entityManager.getTransaction().begin();

        Radio radio = entityManager.find(Radio.class, radioId);

        radio.setNumber(radio.getNumber() - 1);

        entityManager.persist(radio);

        entityManager.getTransaction().commit();

    }


}

