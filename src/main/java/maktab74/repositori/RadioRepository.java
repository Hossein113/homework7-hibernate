package maktab74.repositori;

import maktab74.domain.Radio;

import java.sql.*;

public class RadioRepository {

    private Connection connection;

    private Radio[] radioList;


    public RadioRepository(Connection db) {

        this.connection = db;
    }

    public Radio[] getRadioList() {
        return radioList;
    }

    public void setRadioList(Radio[] radioList) {
        this.radioList = radioList;
    }

    public Radio insertRadio(Radio radio) throws SQLException {

        String insertQuery = "insert into radio_table (name , price , made_in , color , size , voltage_in ,channel_number," +
                " speaker_number ,weight , brand,number) values (?,?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, radio.getName());
        preparedStatement.setInt(2, radio.getPrice());
        preparedStatement.setString(3, radio.getMadeIn());
        preparedStatement.setString(4, radio.getColor());
        preparedStatement.setString(5, radio.getSize());
        preparedStatement.setString(6, radio.getVoltageIn());
        preparedStatement.setInt(7, radio.getChannelNumber());
        preparedStatement.setInt(8, radio.getSpeakerNumber());
        preparedStatement.setString(9, radio.getWeight());
        preparedStatement.setString(10, radio.getBrand());
        preparedStatement.setInt(11, radio.getNumber());

        preparedStatement.executeUpdate();

        radio.setId(getMaxId());
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

