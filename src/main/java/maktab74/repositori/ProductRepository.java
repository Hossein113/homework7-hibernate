package maktab74.repositori;


import maktab74.domain.Product;

import java.sql.*;


public class ProductRepository {

    Connection connection;


    public ProductRepository(Connection connection) {

        this.connection = connection;
    }


    public Product insert(Product product) throws SQLException {

        String insertQuery = "insert into product_table (name , price , madeIn) values (?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setLong(2, product.getPrice());
        preparedStatement.setString(3, product.getMadeIn());
        preparedStatement.executeUpdate();

        product.setId(getMaxId());
        return product;
    }

    private int getMaxId() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select max(id) from product_table");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }
}