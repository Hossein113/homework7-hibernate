package maktab74.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreateTable {

    private Connection connection;

    private String schemaName = "jdbc_prodoct";


    public DatabaseCreateTable(Connection aa) {
        this.connection = aa;
    }


    public void init() throws SQLException {
        createSchema();

        initTables();
    }

    private void initTables() throws SQLException {

        createTableRadio();
        createTableTelevision();

        createTableSportShoe();
        createTableOfficalShoe();

        createTableBook();
        createTableMagazine();

        initUserTable();
        createCartTable();
        createCarteRelationProductTable();


    }

    private void createCarteRelationProductTable() throws SQLException {

        String quri = " create table if not exists relation_table" +
                "(" +
                "cart_id int ," +
                " product_id int, " +
                "reference varchar (255)," +
                "primary key(cart_id, product_id, reference)" +
                ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(quri);
    }

    private void createCartTable() throws SQLException {
        String quri = "create table if not exists cart_table" +
                "(" +
                "id int not null auto_increment," +
                "user_id int," +
                "primary key (id)" +
                ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(quri);
    }

    private void createSchema() throws SQLException {
        String quri = " create schema if not exists " + schemaName;

        Statement statement = connection.createStatement();
        statement.executeUpdate(quri);

        statement = connection.createStatement();
        statement.executeUpdate("use " + schemaName);
    }


    private void createTableRadio() throws SQLException {

        String quri = "create table if not exists radio_table " +
                "(" +
                "id int not null auto_increment," +
                "name varchar(255)," +
                "price int," +
                "made_in varchar(255)," +
                "color varchar(255)," +
                "size varchar(255)," +
                "voltage_in varchar(255)," +
                "channel_number int ," +
                "speaker_number int ," +
                "weight varchar (255)," +
                "brand varchar(255)," +
                "number int ," +
                "primary key (id)" +
                ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(quri);

    }

    private void createTableTelevision() throws SQLException {

        String quri = "create table if not exists television_table " +
                "(" +
                "id int not null auto_increment," +
                "name varchar(255)," +
                "price int," +
                "made_in varchar(255)," +
                "color varchar(255)," +
                "inch_size varchar(255)," +
                "voltage_in varchar(255)," +
                "channel_number int ," +
                "speaker_number int ," +
                "weight varchar (255)," +
                "image_type varchar (255)," +
                "brand varchar(255)," +
                "number int ," +
                "primary key (id)" +
                ")";


        Statement statement = connection.createStatement();
        statement.executeUpdate(quri);

    }


    private void createTableSportShoe() throws SQLException {

        String quri = "create table if not exists sportShoe_table " +
                "(" +
                "id int not null auto_increment," +
                "name varchar(255)," +
                "price int," +
                "material varchar(255)," +
                "size int," +
                "color varchar(255)," +
                "made_in varchar (255)," +
                "stra_type varchar(255)," +
                "sport_type varchar(255)," +
                "number int ," +
                "primary key (id)" +
                ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(quri);

    }

    private void createTableOfficalShoe() throws SQLException {

        String quri = "create table if not exists OfficalShoe_table " +
                "(" +
                "id int not null auto_increment," +
                "name varchar(255)," +
                "price int," +
                "size int," +
                "material varchar(255)," +
                "color varchar(255)," +
                "made_in varchar (255)," +
                "following_layer_type varchar(255)," +
                "number int ," +
                "primary key (id)" +
                ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(quri);

    }


    private void createTableBook() throws SQLException {

        String quri = "create table if not exists book_table " +
                "(" +
                "id int not null auto_increment," +
                "name varchar(255)," +
                "price int," +
                "made_in varchar(255)," +
                "title varchar(255)," +
                "pages_number int," +
                "writer varchar(255)," +
                "publisher varchar(255)," +
                "print_year int," +
                "number int ," +
                "primary key (id)" +
                ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(quri);

    }

    private void createTableMagazine() throws SQLException {

        String quri = "create table if not exists magazine_table " +
                "(" +
                "id int not null auto_increment," +
                "name varchar(255)," +
                "price int," +
                "made_in varchar(255)," +
                "title varchar(255)," +
                "page_type varchar(255)," +
                "page_size varchar(255)," +
                "number int ," +
                "primary key (id)" +
                ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(quri);

    }

    private void initUserTable() throws SQLException {
        String createUserTable =
                "create table if not exists user_table" +
                        "(" +
                        "id int not null auto_increment," +
                        "first_name varchar(255)," +
                        "last_name varchar(255)," +
                        "username varchar(255)," +
                        "password varchar(255)," +
                        "phone_number varchar(255)," +
                        "email_address varchar(255)," +
                        "primary key (id)" +
                        ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createUserTable);
    }
}

