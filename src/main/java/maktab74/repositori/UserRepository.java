package maktab74.repositori;

import maktab74.domain.User;

import java.sql.*;

public class UserRepository {

    private Connection connection;

    public UserRepository(Connection db) {
        this.connection = db;
    }

    public User insertUser(User user) throws SQLException {
        String insertQuery = "insert into user_table" +
                "(first_name,last_name,username,password,phone_number,email_address) values (? ,?, ?, ?,?,?)";

        PreparedStatement preparedStatement =
                connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getUserName());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setString(5, user.getPhoneNumber());
        preparedStatement.setString(6, user.getEmailAddress());

        preparedStatement.executeUpdate();

        user.setId(getMaxId());

        return user;
    }

    public int getMaxId() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select max(id) from user_table");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public User getByUsernameAndPassword(String username, String codenational) throws SQLException {
        String query = "select * from user_table where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, codenational);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new User(

                    resultSet.getInt(1),

                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)

            );
        }

        return null;
    }

}


