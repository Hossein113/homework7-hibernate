package maktab74.repositori;

import maktab74.domain.Book;

import java.sql.*;

public class BookRepository {

    private Connection connection;

    public BookRepository(Connection db) {

        this.connection = db;

    }

    public Book insertBook(Book book) throws SQLException {

        String insertQuery = "insert into book_table (name,price,made_in,title,pages_number,writer," +
                "publisher,print_year,number) values (?,?,?,?,?,?,?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, book.getName());
        preparedStatement.setInt(2, book.getPrice());
        preparedStatement.setString(3, book.getMadeIn());
        preparedStatement.setString(4, book.getTitle());
        preparedStatement.setInt(5, book.getPagesNumber());
        preparedStatement.setString(6, book.getWriter());
        preparedStatement.setString(7, book.getPublisher());
        preparedStatement.setInt(8, book.getPrintYear());
        preparedStatement.setInt(9, book.getNumber());

        preparedStatement.executeUpdate();

        book.setId(getMaxId());
        return book;
    }

    public int getMaxId() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select max(id) from book_table");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public Book[] getAllBook() throws SQLException {
        int allPrint = countAllBook();


        Book[] books = new Book[allPrint];
        int count = 0;
        String query = "select * from book_table";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {

            books[count] = new Book(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(4),
                    resultSet.getInt(3),
                    resultSet.getInt(10),
                    resultSet.getString(5),
                    resultSet.getInt(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getInt(9)

            );


            count++;
        }
        return books;
    }


    public int countAllBook() throws SQLException {
        String query = "select count(*) from book_table";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public Book getById(int bookId) throws SQLException {
        String quri = "select * from book_table where id =" + bookId;
        PreparedStatement preparedStatement = connection.prepareStatement(quri);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Book(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(4),
                    resultSet.getInt(3),
                    resultSet.getInt(10),
                    resultSet.getString(5),
                    resultSet.getInt(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getInt(9)
            );

        }
        return null;
    }

    public void douwnProduct(int bookId) throws SQLException {
        String quri = " update book_table set number=number-1 where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(quri);
        preparedStatement.setInt(1, bookId);
        preparedStatement.executeUpdate();

    }
}