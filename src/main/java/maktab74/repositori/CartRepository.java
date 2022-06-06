package maktab74.repositori;


import maktab74.domain.*;

import java.sql.*;
import java.util.ArrayList;

public class CartRepository {

    private Connection connection;
    private BookRepository bookRepository;
    private MagazineRepository magazineRepository;
    private SportShoeRepository sportShoeRepository;
    private OfficalshoeRepository officalshoeRepository;
    private RadioRepository radioRepository;
    private TelevisionRepository televisionRepository;


    public CartRepository(
            Connection dataBase,
            BookRepository bookRepository, MagazineRepository magazineRepository,
            SportShoeRepository sportShoeRepository, OfficalshoeRepository officalshoeRepository,
            RadioRepository radioRepository, TelevisionRepository televisionRepository) {
        this.connection = dataBase;
        this.bookRepository = bookRepository;
        this.magazineRepository = magazineRepository;
        this.sportShoeRepository = sportShoeRepository;
        this.officalshoeRepository = officalshoeRepository;
        this.radioRepository = radioRepository;
        this.televisionRepository = televisionRepository;
    }


    public Cart insertoCart(int userId) throws SQLException {
        String insertQuery = "insert into cart_table( user_id) values (?) ";

        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setInt(1, userId);

        preparedStatement.executeUpdate();
        Cart cart = new Cart();
        cart.setId(getMaxId());
        return cart;
    }

    private int getMaxId() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select max(id) from cart_table");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }


    // added to Relation 1
    public void insertToReleationCart(int cartId, int productId, String productName) throws SQLException {

        String quri = "insert into relation_table(cart_id,product_id,reference) values(?,?,?)";
        PreparedStatement preparedStatementst = connection.prepareStatement(quri);
        preparedStatementst.setInt(1, cartId);
        preparedStatementst.setInt(2, productId);
        preparedStatementst.setString(3, productName);
        preparedStatementst.executeUpdate();
    }


    // added to relation_table 3
    public int getCartId(int userId) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select id from cart_table where user_id =" + userId);
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }

        return 0;
    }

    public int cartCapacity(int userId) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select count(cart_id) from relation_table where cart_id =" + userId);
        while (resultSet.next()) {
            return resultSet.getInt(1);

        }
        return 0;

    }

    public Cart getByUserId(int userId) throws SQLException {
        Cart cart = new Cart();
        String cartQuery = "select * from cart_table where user_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(cartQuery);
        preparedStatement.setInt(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int cartId = resultSet.getInt(1);
            cart.setId(cartId);
            cart.setUserId(userId);
            cart.setProductList(new ArrayList<>());

            relationAachTable(cart);

        }
        return cart;
    }

    private void relationAachTable(Cart cart) throws SQLException {
        String relationQuery = "select * from relation_table where cart_id = ?";

        PreparedStatement relationPreparedStatement = connection.prepareStatement(relationQuery);
        relationPreparedStatement.setInt(1, cart.getId());
        ResultSet relationResultSet = relationPreparedStatement.executeQuery();
        while (relationResultSet.next()) {
            switch (relationResultSet.getString(3)) {
                case "Sportshoe": {
                    SportShoe sportShoe = sportShoeRepository.getById(
                            relationResultSet.getInt(2));
                    cart.getProductList().add(sportShoe);

                    break;
                }
                case "Officalshoe": {
                    OfficalShoe officalShoe = officalshoeRepository.getById(
                            relationResultSet.getInt(2)
                    );

                    cart.getProductList().add(officalShoe);
                    break;
                }
                case "Book": {
                    Book book = bookRepository.getById(
                            relationResultSet.getInt(2)
                    );
                    cart.getProductList().add(book);
                    break;
                }
                case "Magazine": {
                    Magazine magazine = magazineRepository.getById(
                            relationResultSet.getInt(2)
                    );
                    cart.getProductList().add(magazine);
                    break;

                }
                case "Television": {
                    Television television = televisionRepository.getById(
                            relationResultSet.getInt(2)
                    );
                    cart.getProductList().add(television);
                    break;
                }
                case "Radio": {
                    Radio radio = radioRepository.getById(relationResultSet.getInt(2)

                    );
                    cart.getProductList().add(radio);
                    break;
                }
            }
        }
    }


    public void exeptCart(Cart cart) throws SQLException {
        String cartQuery = "delete from relation_table where cart_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(cartQuery);
        preparedStatement.setInt(1, cart.getId());
        preparedStatement.executeUpdate();

    }

    public void relationAachTableExeptCart(Cart cart) throws SQLException {
        String relationQuery = "select * from relation_table where cart_id = ?";

        PreparedStatement relationPreparedStatement = connection.prepareStatement(relationQuery);
        relationPreparedStatement.setInt(1, cart.getId());
        ResultSet relationResultSet = relationPreparedStatement.executeQuery();
        while (relationResultSet.next()) {
            switch (relationResultSet.getString(3)) {
                case "Sportshoe": {
                    sportShoeRepository.douwnProduct(relationResultSet.getInt(2));
                    break;
                }
                case "Officalshoe": {
                    officalshoeRepository.douwnProduct(relationResultSet.getInt(2));
                    break;
                }
                case "Book": {
                    bookRepository.douwnProduct(relationResultSet.getInt(2));

                    break;
                }
                case "Magazine": {

                    magazineRepository.douwnProduct(relationResultSet.getInt(2));
                    break;

                }
                case "Television": {
                    televisionRepository.douwnProduct(relationResultSet.getInt(2));


                    break;
                }
                case "Radio": {
                    radioRepository.douwnProduct(relationResultSet.getInt(2));
                    break;
                }
            }
        }
    }


}

    /*public Cart getProductAndRefrence(int maxRelation) throws SQLException {

        Cart cart = new Cart();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from relation_table where ");
        while (resultSet.next()) {
            cart = getUserCart(resultSet.getInt(2), resultSet.getString(3));

        }
        return cart;

    }


    public Cart getUserCart(int userId, String refrance) throws SQLException {

        switch (refrance) {

            case "Television":
                break;
            case "Radio":
                break;
            case "Book":
                applicationContext.getBookRepository().getById(userId);
                break;
            case "Magazine":
                break;
            case "Shoesport":
                break;
            case "Officalshoe":
                break;
        }
        return
    }*/