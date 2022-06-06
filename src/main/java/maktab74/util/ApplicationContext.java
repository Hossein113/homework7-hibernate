package maktab74.util;

import maktab74.repositori.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class ApplicationContext {
    private DatabaseConnected databaseConnected;
    private DatabaseCreateTable databaseCreateTable;
    private RadioRepository radioRepository;
    private DataInit dataInit;

    private TelevisionRepository televisionRepository;
    private SportShoeRepository sportShoeRepository;
    private OfficalshoeRepository officalshoeRepository;
    private BookRepository bookRepository;
    private MagazineRepository magazineRepository;
    private UserRepository userRepository;
    private ShowMenu showMenu;
    private Scanner intScanner;
    private Scanner stringScanner;
    private SecurityUser securityUser;
    private CartRepository cartRepository;

    public CartRepository getCartRepository() {
        cartRepository = new CartRepository(databaseConnected.getConnection(), getBookRepository(), getMagazineRepository(),
                getSportShoeRepository(), getOfficalshoeRepository(),
                getRadioRepository(), getTelevisionRepository());

        return cartRepository;
    }

    public UserRepository getUserRepository() {
        this.userRepository = new UserRepository(databaseConnected.getConnection());
        return userRepository;
    }

    public SecurityUser getSecurityUser() {
        if (securityUser == null) {
            this.securityUser = new SecurityUser();
        }
        return securityUser;
    }

    public Scanner getIntScanner() {
        {
            this.intScanner = new Scanner(System.in);
        }
        return intScanner;
    }

    public Scanner getStringScanner() {
        if (stringScanner == null) {
            this.stringScanner = new Scanner(System.in);
        }
        return stringScanner;

    }


    public BookRepository getBookRepository() {
        if (bookRepository == null) {
            bookRepository = new BookRepository(databaseConnected.getConnection());
        }
        return bookRepository;
    }

    public MagazineRepository getMagazineRepository() {
        if (magazineRepository == null) {
            magazineRepository = new MagazineRepository(databaseConnected.getConnection());
        }
        return magazineRepository;
    }

    public OfficalshoeRepository getOfficalshoeRepository() {
        if (officalshoeRepository == null) {
            officalshoeRepository = new OfficalshoeRepository(databaseConnected.getConnection());
        }
        return officalshoeRepository;
    }

    public DatabaseCreateTable getDatabaseCreateTable() {

        return databaseCreateTable;
    }

    public DataInit getDataInit() {
        dataInit = new DataInit(getRadioRepository(), getTelevisionRepository(),
                getSportShoeRepository(), getOfficalshoeRepository(),
                getBookRepository(), getMagazineRepository());
        return dataInit;
    }

    public RadioRepository getRadioRepository() {
        if (radioRepository == null)
            this.radioRepository = new RadioRepository(databaseConnected.getConnection());
        return radioRepository;
    }

    public SportShoeRepository getSportShoeRepository() {
        if (sportShoeRepository == null) {
            this.sportShoeRepository = new SportShoeRepository(databaseConnected.getConnection());
        }
        return sportShoeRepository;
    }

    public TelevisionRepository getTelevisionRepository() {
        if (televisionRepository == null)
            this.televisionRepository = new TelevisionRepository(databaseConnected.getConnection());
        return televisionRepository;
    }

    public ApplicationContext() throws SQLException, ClassNotFoundException {

        this.databaseConnected = new DatabaseConnected();
        Connection zarfe = databaseConnected.getConnection();

        this.databaseCreateTable = new DatabaseCreateTable(zarfe);
        //        this.databaseCreateTable = new DatabaseCreateTable(databaseConnected.getConnection());


    }


    public DatabaseConnected getDatabaseConnected() {


        return databaseConnected;
    }

    public ShowMenu getShowMenu() {
        this.showMenu = new ShowMenu();
        return showMenu;
    }

}
