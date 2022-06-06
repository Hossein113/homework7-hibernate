package maktab74.repositori;

import maktab74.domain.Television;

import java.sql.*;

public class TelevisionRepository {


    private Connection connection;

    public TelevisionRepository(Connection connection) {
        this.connection = connection;
    }


    public Television insertTelevision(Television television) throws SQLException {

        String insertQuery = "insert into television_table ( name, price, made_in,color,inch_size,voltage_in, channel_number,speaker_number , weight," +
                " image_type ,brand,number) values (?,?,?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, television.getName());
        preparedStatement.setInt(2, television.getPrice());
        preparedStatement.setString(3, television.getMadeIn());
        preparedStatement.setString(4, television.getColor());
        preparedStatement.setInt(5, television.getInchSize());
        preparedStatement.setString(6, television.getVoltageIn());
        preparedStatement.setInt(7, television.getChannalNumber());
        ;
        preparedStatement.setInt(8, television.getSpeakerNumber());
        preparedStatement.setString(9, television.getWeight());
        preparedStatement.setString(10, television.getImageType());
        preparedStatement.setString(11, television.getBrand());
        preparedStatement.setInt(12, television.getNumber());

        preparedStatement.executeUpdate();

        television.setId(getMaxId());
        return television;
    }

    private int getMaxId() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select max(id) from television_table");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public Television[] getAllTelevision() throws SQLException {
        int allPrint = countAllTelevision();


        Television[] televisions = new Television[allPrint];
        int count = 0;
        String query = "select * from television_table";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {

            televisions[count] = new Television(

                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(4),
                    resultSet.getInt(3),
                    resultSet.getInt(13),
                    resultSet.getString(12),
                    resultSet.getString(5),
                    resultSet.getInt(6),
                    resultSet.getString(7),
                    resultSet.getInt(8),
                    resultSet.getInt(9),
                    resultSet.getString(10),
                    resultSet.getString(11)

            );


            count++;
        }
        return televisions;
    }


    public int countAllTelevision() throws SQLException {
        String query = "select count(*) from television_table";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public Television getById(int televisionId) throws SQLException {
        String quri = "select * from television_table where id =" + televisionId;
        PreparedStatement preparedStatement = connection.prepareStatement(quri);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Television(


                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(4),
                    resultSet.getInt(3),
                    resultSet.getInt(13),
                    resultSet.getString(12),
                    resultSet.getString(5),
                    resultSet.getInt(6),
                    resultSet.getString(7),
                    resultSet.getInt(8),
                    resultSet.getInt(9),
                    resultSet.getString(10),
                    resultSet.getString(11)

            );
        }
        return null;
    }

    public void douwnProduct(int television) throws SQLException {
        String quri = " update television_table set number=number-1 where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(quri);
        preparedStatement.setInt(1, television);
        preparedStatement.executeUpdate();
    }


}
