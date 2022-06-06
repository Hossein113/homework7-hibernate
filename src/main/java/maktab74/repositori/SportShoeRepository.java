package maktab74.repositori;

import maktab74.domain.SportShoe;

import java.sql.*;

public class SportShoeRepository {

    private Connection connection;

    public SportShoeRepository(Connection connection) {

        this.connection = connection;
    }

    public SportShoe insertSportShoe(SportShoe sportShoe) throws SQLException {

        String insertQuery = "insert into sportshoe_table ( name, price ,material, size,color,made_in ,stra_type ," +
                "sport_type ,number ) values (?,?,?,?,?,?,?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, sportShoe.getName());
        preparedStatement.setInt(2, sportShoe.getPrice());
        preparedStatement.setString(3, sportShoe.getMaterial());
        preparedStatement.setInt(4, sportShoe.getSize());
        preparedStatement.setString(5, sportShoe.getColor());
        preparedStatement.setString(6, sportShoe.getMadeIn());
        preparedStatement.setString(7, sportShoe.getStraType());
        preparedStatement.setString(8, sportShoe.getSportType());
        preparedStatement.setInt(9, sportShoe.getNumber());


        preparedStatement.executeUpdate();

        sportShoe.setId(getMaxId());
        return sportShoe;
    }

    private int getMaxId() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select max(id) from sportshoe_table");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public SportShoe[] getAllSportShoe() throws SQLException {
        int allPrint = countAllSportShoe();


        SportShoe[] sportShoes = new SportShoe[allPrint];
        int count = 0;
        String query = "select * from sportshoe_table";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {

            sportShoes[count] = new SportShoe(

                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(7),
                    resultSet.getInt(3),
                    resultSet.getInt(10),
                    resultSet.getInt(5),
                    resultSet.getString(4),
                    resultSet.getString(6),
                    resultSet.getString(8),
                    resultSet.getString(9)

            );


            count++;
        }
        return sportShoes;
    }


    public int countAllSportShoe() throws SQLException {
        String query = "select count(*) from sportshoe_table";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public SportShoe getById(int sportshoeId) throws SQLException {
        String quri = "select * from sportshoe_table where id =" + sportshoeId;
        PreparedStatement preparedStatement = connection.prepareStatement(quri);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new SportShoe(

                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(7),
                    resultSet.getInt(3),
                    resultSet.getInt(10),
                    resultSet.getInt(5),
                    resultSet.getString(4),
                    resultSet.getString(6),
                    resultSet.getString(8),
                    resultSet.getString(9)

            );
        }
        return null;
    }

    public void douwnProduct(int sportShoe) throws SQLException {
        String quri = " update sportshoe_table set number=number-1 where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(quri);
        preparedStatement.setInt(1, sportShoe);
        preparedStatement.executeUpdate();
    }

}


