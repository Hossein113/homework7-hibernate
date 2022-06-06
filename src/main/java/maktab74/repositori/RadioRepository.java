package maktab74.repositori;

import maktab74.domain.Radio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.*;

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
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select max(id) from radio_table");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public Radio[] getAllRadio() throws SQLException {
        int allPrint = countAllRadio();


        Radio[] radios = new Radio[allPrint];
        int count = 0;
        String query = "select * from radio_table";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {

            radios[count] = new Radio(


                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(4),
                    resultSet.getInt(3),
                    resultSet.getInt(12),
                    resultSet.getString(11),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getInt(8),
                    resultSet.getInt(9),
                    resultSet.getString(10)

            );


            count++;
        }
        return radios;
    }

    public Radio getById(int RadioId) throws SQLException {
        String quri = "select * from Radio_table where id =" + RadioId;
        PreparedStatement preparedStatement = connection.prepareStatement(quri);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Radio(


                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(4),
                    resultSet.getInt(3),
                    resultSet.getInt(12),
                    resultSet.getString(11),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getInt(8),
                    resultSet.getInt(9),
                    resultSet.getString(10)

            );
        }
        return null;
    }


    public int countAllRadio() throws SQLException {
        String query = "select count(*) from radio_table";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public void douwnProduct(int radioId) throws SQLException {
        String quri = " update radio_table set number=number-1 where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(quri);
        preparedStatement.setInt(1, radioId);
        preparedStatement.executeUpdate();
    }


}

