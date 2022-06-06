package maktab74.repositori;

import maktab74.domain.OfficalShoe;

import java.sql.*;

public class OfficalshoeRepository {

    Connection connection;

    public OfficalshoeRepository(Connection connection) {

        this.connection = connection;
    }

    public OfficalShoe insertOfficalShoe(OfficalShoe oficalShoe) throws SQLException {

        String insertQuery = "insert into officalshoe_table( name, price,material ,size,color,made_in" +
                ",following_layer_type,number) values (?,?,?,?,?,?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, oficalShoe.getName());
        preparedStatement.setInt(2, oficalShoe.getPrice());
        preparedStatement.setString(3, oficalShoe.getMaterial());
        preparedStatement.setInt(4, oficalShoe.getSize());
        preparedStatement.setString(5, oficalShoe.getColor());
        preparedStatement.setString(6, oficalShoe.getMadeIn());
        preparedStatement.setString(7, oficalShoe.getFollowingLayerType());
        preparedStatement.setInt(8, oficalShoe.getNumber());
        preparedStatement.executeUpdate();
        oficalShoe.setId(getMaxId());
        return oficalShoe;
    }

    private int getMaxId() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select max(id) from officalshoe_table");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }


    public OfficalShoe[] getAllOfficalShoe() throws SQLException {
        int allPrint = countAllOfficalshoe();


        OfficalShoe[] officalShoes = new OfficalShoe[allPrint];
        int count = 0;
        String query = "select * from officalshoe_table";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {

            officalShoes[count] = new OfficalShoe(

                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(7),
                    resultSet.getInt(3),
                    resultSet.getInt(9),
                    resultSet.getInt(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(8)


            );


            count++;
        }
        return officalShoes;
    }


    public int countAllOfficalshoe() throws SQLException {
        String query = "select count(*) from officalshoe_table";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public OfficalShoe getById(int officalshoeId) throws SQLException {
        String quri = "select * from officalshoe_table where id =" + officalshoeId;
        PreparedStatement preparedStatement = connection.prepareStatement(quri);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new OfficalShoe(


                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(7),
                    resultSet.getInt(3),
                    resultSet.getInt(9),
                    resultSet.getInt(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(8)

            );

        }
        return null;
    }

    public void douwnProduct(int officalShoe) throws SQLException {
        String quri = " update officalshoe_table set number=number-1 where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(quri);
        preparedStatement.setInt(1, officalShoe);
        preparedStatement.executeUpdate();
    }

}



