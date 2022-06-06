import maktab74.domain.*;
import maktab74.util.ApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

public class Application {

    public static void main(String args[]) throws SQLException, ClassNotFoundException {

        ApplicationContext applicationContext = new ApplicationContext();

        applicationContext.getDatabaseCreateTable().init();
        System.out.println("ok");
        applicationContext.getDataInit().init();
        System.out.println("0k");
        process(applicationContext);


    }


    private static void firstMenu(ApplicationContext applicationContext) throws SQLException, ClassNotFoundException {


//
//        Product[] products = new Product[4];
//
//        Shoes shoes = new SportShoe();
//        Shoes shoes1 = new OfficalShoe();
//
//        ElectricalAppliances electricalAppliances = new Radio();
//        ElectricalAppliances electricalAppliances1 = new Television();
//
//        products[0] = shoes;
//        products[1] = shoes1;
//        products[2] = electricalAppliances;
//        products[3] = electricalAppliances1;
//
//        for (Product pr : products) {
//            System.out.println(pr.getClass().getName());


    }

    private static void process(ApplicationContext applicationContext) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {

                applicationContext.getShowMenu().showWelcomeMenu();
//                applicationContext.getIntScanner().nextLine();
                int selectedNumber = scanner.nextInt();
                if (selectedNumber == 1) {
                    login(applicationContext);
                } else if (selectedNumber == 2) {
                    signup(applicationContext);
                } else if (selectedNumber == 3) {
                    applicationContext.getShowMenu().showLogout();
                    break;
                } else {
                    applicationContext.getShowMenu().showRightNumber();
                    process(applicationContext);
                }
            }
        } catch (Exception e) {

            applicationContext.getShowMenu().wrong();
            process(applicationContext);
        }

    }


    private static void login(ApplicationContext applicationContext) throws SQLException {

        applicationContext.getShowMenu().showUsername();
        String username = applicationContext.getStringScanner().nextLine();

        applicationContext.getShowMenu().showPassword();
        String password = applicationContext.getStringScanner().nextLine();

        User user = applicationContext.getUserRepository().getByUsernameAndPassword(username, password);
        if (user != null) {
            applicationContext.getShowMenu().showWelcome(user);
            applicationContext.getSecurityUser().setCurrentUser(user);
            redirectUserToPanel(applicationContext);
        } else {

            applicationContext.getShowMenu().showLoginFail();

        }


    }


    private static void redirectUserToPanel(ApplicationContext applicationContext) throws SQLException {

        try {
            while (true) {
                applicationContext.getShowMenu().showUserMenu();
                int selectedNumber = applicationContext.getIntScanner().nextInt();
                if (selectedNumber == 1) {
                    int userId = applicationContext.getSecurityUser().getCurrentUser().getId();
                    Cart cart = applicationContext.getCartRepository().getByUserId(userId);
                    printMyCart(cart);
                    cartUserToPanel(applicationContext);
                } else if (selectedNumber == 2) {
                    applicationContext.getShowMenu().showAllProduct();
                    allPrintAllProduct(applicationContext);
                    redirectUserToPanel(applicationContext);
                } else if (selectedNumber == 3) {

                    applicationContext.getShowMenu().showProfile(applicationContext.getSecurityUser().getCurrentUser());
                    redirectUserToPanel(applicationContext);
                } else if (selectedNumber == 4) {

                    applicationContext.getShowMenu().showLogoutProfile();
                    applicationContext.getSecurityUser().logout();
                    break;
                } else {
                    applicationContext.getShowMenu().showRightNumber();
                    redirectUserToPanel(applicationContext);
                }
            }

        } catch (Exception ex) {
            applicationContext.getShowMenu().wrong();
            redirectUserToPanel(applicationContext);
        }

    }

    private static void cartUserToPanel(ApplicationContext applicationContext) throws SQLException {
        try {

            while (true) {

                applicationContext.getShowMenu().showItemMyCart();

                int selectNumber = applicationContext.getIntScanner().nextInt();
                if (selectNumber == 1) {
                    addedProductTocart(applicationContext);
                    redirectUserToPanel(applicationContext);
                } else if (selectNumber == 2) {
                    int userId = applicationContext.getSecurityUser().getCurrentUser().getId();
                    Cart cart = applicationContext.getCartRepository().getByUserId(userId);
                    applicationContext.getCartRepository().relationAachTableExeptCart(cart);
                    applicationContext.getCartRepository().exeptCart(cart);
                    applicationContext.getShowMenu().printSuccessfullBuyCart();
                    redirectUserToPanel(applicationContext);

                } else if (selectNumber == 3) {
                    applicationContext.getShowMenu().showAllProduct();
                    printAllProduct(applicationContext);

                } else if (selectNumber == 4) {

                    redirectUserToPanel(applicationContext);

                } else {
                    applicationContext.getShowMenu().showRightNumber();
                    cartUserToPanel(applicationContext);
                }


            }
        } catch (Exception ex) {
            applicationContext.getShowMenu().wrong();
            cartUserToPanel(applicationContext);
        }

    }


    private static void printMyCart(Cart cart) {
        if (cart.getProductList().size() == 0) {
            System.out.println("cart is empty ... !");
        } else {
            for (int i = 0; i < cart.getProductList().size(); i++) {

                System.out.println(cart.getProductList().get(i));
            }
        }
    }

    private static void addedProductTocart(ApplicationContext applicationContext) throws SQLException {
        try {

            applicationContext.getShowMenu().showAddeProduct();
            int capacity = applicationContext.getCartRepository().cartCapacity(applicationContext.getSecurityUser().getCurrentUser().getId());
            if (capacity < 5) {

                int selectNumber = applicationContext.getIntScanner().nextInt();
                if (selectNumber == 1) {


                    addedSheoToMycart(applicationContext);
                } else if (selectNumber == 2) {


                    addedElectricalToMycart(applicationContext);
                } else if (selectNumber == 3) {

                    addedRedableToMyCart(applicationContext);
                } else if (selectNumber == 4) {
                    cartUserToPanel(applicationContext);

                } else {
                    applicationContext.getShowMenu().showRightNumber();
                    addedProductTocart(applicationContext);

                }
            } else {
                applicationContext.getShowMenu().printErorrCapaciti();

            }
        } catch (Exception ex) {

            applicationContext.getShowMenu().wrong();
            addedProductTocart(applicationContext);

        }

    }


    private static void addedRedableToMyCart(ApplicationContext applicationContext) throws SQLException {
        try {
            applicationContext.getShowMenu().showAddedRedable();
            int selectNumber = applicationContext.getIntScanner().nextInt();
            if (selectNumber == 1) {
                applicationContext.getShowMenu().printChooseModel();
                addToRelationBook(applicationContext);

            } else if (selectNumber == 2) {
                applicationContext.getShowMenu().printChooseModel();

                addToRelationMagazine(applicationContext);
            } else if (selectNumber == 3) {
                addedProductTocart(applicationContext);

            } else {
                applicationContext.getShowMenu().showRightNumber();
                addedRedableToMyCart(applicationContext);

            }
        } catch (Exception ex) {

            applicationContext.getShowMenu().wrong();
            addedRedableToMyCart(applicationContext);
        }


    }

    private static void addToRelationBook(ApplicationContext applicationContext) throws SQLException {
        Book[] books = applicationContext.getBookRepository().getAllBook();
        for (int i = 0; i < books.length; i++) {
            System.out.println(i + 1 + ":" + books[i]);

        }
        try {
            int productId = applicationContext.getIntScanner().nextInt();

            if (productId < books.length + 1) {
                int userId = applicationContext.getSecurityUser().getCurrentUser().getId();
                int cartId = applicationContext.getCartRepository().getCartId(userId);
                int pruduct = books[productId - 1].getId();
                applicationContext.getCartRepository().insertToReleationCart(
                        cartId, pruduct, "Book"

                );
                applicationContext.getShowMenu().printSuccessfullBuy();


            } else {
                applicationContext.getShowMenu().showRightNumber();
                addToRelationBook(applicationContext);
            }
        } catch (Exception ex) {
            applicationContext.getShowMenu().wrong();
            addToRelationBook(applicationContext);
        }
    }

    private static void addToRelationMagazine(ApplicationContext applicationContext) throws SQLException {
        Magazine[] magazines = applicationContext.getMagazineRepository().getAllMagazine();
        for (int i = 0; i < magazines.length; i++) {
            System.out.println(i + 1 + ":" + magazines[i]);

        }
        try {
            int productId = applicationContext.getIntScanner().nextInt();

            if (productId < magazines.length + 1) {
                int userId = applicationContext.getSecurityUser().getCurrentUser().getId();
                int cartId = applicationContext.getCartRepository().getCartId(userId);
                int pruduct = magazines[productId - 1].getId();
                applicationContext.getCartRepository().insertToReleationCart(
                        cartId, pruduct, "Magazine"
                );
                applicationContext.getShowMenu().printSuccessfullBuy();


            } else {
                applicationContext.getShowMenu().showRightNumber();
                addToRelationMagazine(applicationContext);
            }
        } catch (Exception ex) {
            applicationContext.getShowMenu().wrong();
            addToRelationMagazine(applicationContext);
        }
    }

    private static void addedElectricalToMycart(ApplicationContext applicationContext) throws SQLException {
        try {
            applicationContext.getShowMenu().showAddedElectrical();
            int selectNumber = applicationContext.getIntScanner().nextInt();
            if (selectNumber == 1) {
                applicationContext.getShowMenu().printChooseModel();
                addToRelationTelevision(applicationContext);

            } else if (selectNumber == 2) {
                applicationContext.getShowMenu().printChooseModel();

                addToRelationRadio(applicationContext);
            } else if (selectNumber == 3) {
                addedProductTocart(applicationContext);

            } else {
                applicationContext.getShowMenu().showRightNumber();
                addedElectricalToMycart(applicationContext);
            }
        } catch (Exception exception) {

            applicationContext.getShowMenu().wrong();
            addedElectricalToMycart(applicationContext);
        }


    }

    private static void addToRelationTelevision(ApplicationContext applicationContext) throws SQLException {
        Television[] televisions = applicationContext.getTelevisionRepository().getAllTelevision();
        for (int i = 0; i < televisions.length; i++) {
            System.out.println(i + 1 + ":" + televisions[i]);

        }
        try {
            int productId = applicationContext.getIntScanner().nextInt();

            if (productId < televisions.length + 1) {
                int userId = applicationContext.getSecurityUser().getCurrentUser().getId();
                int cartId = applicationContext.getCartRepository().getCartId(userId);
                int pruduct = televisions[productId - 1].getId();
                applicationContext.getCartRepository().insertToReleationCart(
                        cartId, pruduct, "Television"

                );
                applicationContext.getShowMenu().printSuccessfullBuy();


            } else {
                applicationContext.getShowMenu().showRightNumber();
                addToRelationTelevision(applicationContext);
            }
        } catch (Exception ex) {
            applicationContext.getShowMenu().wrong();
            addToRelationTelevision(applicationContext);
        }
    }

    private static void addToRelationRadio(ApplicationContext applicationContext) throws SQLException {
        Radio[] radios = applicationContext.getRadioRepository().getAllRadio();
        for (int i = 0; i < radios.length; i++) {
            System.out.println(i + 1 + ":" + radios[i]);

        }
        try {
            int productId = applicationContext.getIntScanner().nextInt();

            if (productId < radios.length + 1) {
                int userId = applicationContext.getSecurityUser().getCurrentUser().getId();
                int cartId = applicationContext.getCartRepository().getCartId(userId);
                int pruduct = radios[productId - 1].getId();
                applicationContext.getCartRepository().insertToReleationCart(
                        cartId, pruduct, "Radio"
                );
                applicationContext.getShowMenu().printSuccessfullBuy();


            } else {
                applicationContext.getShowMenu().showRightNumber();
                addToRelationRadio(applicationContext);
            }
        } catch (Exception ex) {
            applicationContext.getShowMenu().wrong();
            addToRelationRadio(applicationContext);
        }

    }


    private static void addedSheoToMycart(ApplicationContext applicationContext) throws SQLException {

        try {
            applicationContext.getShowMenu().showAddedShoe();
            int selectNumber = applicationContext.getIntScanner().nextInt();
            if (selectNumber == 1) {


                addToRelationSportShoe(applicationContext);

            } else if (selectNumber == 2) {

                addToRelationOfficalShoe(applicationContext);
            } else if (selectNumber == 3) {
                addedProductTocart(applicationContext);

            } else {

                applicationContext.getShowMenu().showRightNumber();
                addedSheoToMycart(applicationContext);
            }
        } catch (Exception ex) {

            applicationContext.getShowMenu().wrong();
            addedSheoToMycart(applicationContext);

        }

    }

    private static void addToRelationSportShoe(ApplicationContext applicationContext) throws SQLException {
        Scanner scanneri = new Scanner(System.in);
        SportShoe[] sportShoes = applicationContext.getSportShoeRepository().getAllSportShoe();
        applicationContext.getShowMenu().printChooseModel();
        for (int i = 0; i < sportShoes.length; i++) {
            System.out.println(i + 1 + ":" + sportShoes[i]);

        }
        try {

            int productId = scanneri.nextInt();
            if (productId < sportShoes.length) {

                int userId = applicationContext.getSecurityUser().getCurrentUser().getId();
                int cartId = applicationContext.getCartRepository().getCartId(userId);
                int pruduct = sportShoes[productId - 1].getId();
                applicationContext.getCartRepository().insertToReleationCart(
                        cartId, pruduct, "Sportshoe"
                );
                applicationContext.getShowMenu().printSuccessfullBuy();


            } else {
                applicationContext.getShowMenu().showRightNumber();
                addToRelationSportShoe(applicationContext);
            }
        } catch (Exception ex) {

            applicationContext.getShowMenu().wrong();
            addToRelationSportShoe(applicationContext);
        }

    }

    private static void addToRelationOfficalShoe(ApplicationContext applicationContext) throws SQLException {
        OfficalShoe[] officalShoes = applicationContext.getOfficalshoeRepository().getAllOfficalShoe();
        applicationContext.getShowMenu().printChooseModel();
        for (int i = 0; i < officalShoes.length; i++) {
            System.out.println(i + 1 + ":" + officalShoes[i]);

        }
        try {

            int productId = applicationContext.getIntScanner().nextInt();

            if (productId < officalShoes.length + 1) {
                int userId = applicationContext.getSecurityUser().getCurrentUser().getId();
                int cartId = applicationContext.getCartRepository().getCartId(userId);
                int pruduct = officalShoes[productId - 1].getId();
                applicationContext.getCartRepository().insertToReleationCart(
                        cartId, pruduct, "Officalshoe"
                );
                applicationContext.getShowMenu().printSuccessfullBuy();


            } else {
                applicationContext.getShowMenu().showRightNumber();
                addToRelationOfficalShoe(applicationContext);
            }
        } catch (Exception ex) {

            applicationContext.getShowMenu().wrong();
            addToRelationOfficalShoe(applicationContext);
        }

    }

    private static void allPrintAllProduct(ApplicationContext applicationContext) throws SQLException {
        printAllProduct(applicationContext);
    }

    private static void printAllProduct(ApplicationContext applicationContext) throws SQLException {
        printAllBook(applicationContext);
        printAllMagazine(applicationContext);
        printAllRadio(applicationContext);
        printAllTelevision(applicationContext);
        printAllSportShoe(applicationContext);
        printAllOfficalShoe(applicationContext);
        redirectUserToPanel(applicationContext);
    }


    private static void printAllBook(ApplicationContext applicationContext) throws SQLException {
        Book[] books = applicationContext.getBookRepository().getAllBook();
        for (int i = 0; i < books.length; i++) {
            System.out.println((i + 1 + ": " + books[i]));
        }
    }


    private static void printAllMagazine(ApplicationContext applicationContext) throws SQLException {
        Magazine[] magazines = applicationContext.getMagazineRepository().getAllMagazine();
        for (int i = 0; i < magazines.length; i++) {
            System.out.println((i + 4 + ": " + magazines[i]));
        }
    }

    private static void printAllRadio(ApplicationContext applicationContext) throws SQLException {
        Radio[] radio = applicationContext.getRadioRepository().getAllRadio();
        for (
                int i = 0; i < radio.length; i++) {
            System.out.println((i + 7 + ": " + radio[i]));
        }
    }

    private static void printAllTelevision(ApplicationContext applicationContext) throws SQLException {
        Television[] televisions = applicationContext.getTelevisionRepository().getAllTelevision();
        for (int i = 0; i < televisions.length; i++) {
            System.out.println((i + 10 + ": " + televisions[i]));
        }
    }

    private static void printAllSportShoe(ApplicationContext applicationContext) throws SQLException {
        SportShoe[] sportShoes = applicationContext.getSportShoeRepository().getAllSportShoe();
        for (int i = 0; i < sportShoes.length; i++) {
            System.out.println((i + 13 + ": " + sportShoes[i]));
        }
    }

    private static void printAllOfficalShoe(ApplicationContext applicationContext) throws SQLException {
        OfficalShoe[] officalShoes = applicationContext.getOfficalshoeRepository().getAllOfficalShoe();
        for (int i = 0; i < officalShoes.length; i++) {
            System.out.println((i + 16 + ": " + officalShoes[i]));

        }
    }


    private static void signup(ApplicationContext applicationContext) throws SQLException {

        User user = new User();

        applicationContext.getShowMenu().showFirstName();
        String firstName = applicationContext.getStringScanner().nextLine();


        applicationContext.getShowMenu().showLastName();
        String lastName = applicationContext.getStringScanner().nextLine();


        applicationContext.getShowMenu().showUsername();
        String username = applicationContext.getStringScanner().nextLine();


        applicationContext.getShowMenu().showPassword();
        String password = applicationContext.getStringScanner().nextLine();

        applicationContext.getShowMenu().showPhoneNumber();
        String phoneNumber = applicationContext.getStringScanner().nextLine();


        applicationContext.getShowMenu().showEmail();
        String email = applicationContext.getStringScanner().nextLine();


        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserName(username);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setEmailAddress(email);


        User adedUser = applicationContext.getUserRepository().insertUser(user);
        applicationContext.getCartRepository().insertoCart(user.getId());
        System.out.println(adedUser);
    }


}




