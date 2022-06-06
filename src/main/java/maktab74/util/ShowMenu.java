package maktab74.util;

import maktab74.domain.User;

public class ShowMenu {

    public void showWelcomeMenu() {
        System.out.println("welcome to application");
        System.out.println("plz choose a number:");
        System.out.println("1: login");
        System.out.println("2: signup");
        System.out.println("3: exit");
    }

    public void showRightNumber() {

        System.out.println("plz enter right number");
    }


    public void showFirstName() {
        System.out.println("plz enter your first name:");
    }

    public void showLastName() {
        System.out.println("plz enter your last name:");
    }

    public void showUsername() {

        System.out.println("plz enter your username:");
    }

    public void showPassword() {

        System.out.println("plz enter your password:");
    }

    public void showEmail() {

        System.out.println("plz enter your Email:");
    }

    public void showPhoneNumber() {

        System.out.println("plz enter your Phone number:");
    }

    public void showWelcome(User currentUser) {

        System.out.println("login successfully done");
        System.out.println(
                "welcome " + currentUser.getFirstName() + " " + currentUser.getLastName()
        );

    }

    public void showLoginFail() {

        System.out.println("username or password is wroung");
    }

    public void showLogout() {
        System.out.println(" Bye ... !!! ");
    }

    public void showUserMenu() {
        System.out.println("plz choose a number:");
        System.out.println("1:show my cart ");
        System.out.println("2: show all Product");
        System.out.println("3: show my profile");
        System.out.println("4: logout");
    }

    public void showLogoutProfile() {

        System.out.println("logout successful");
    }

    public void showProfile(User currentUser) {
        System.out.println("************************************");

        System.out.println("ID: " + currentUser.getId());
        System.out.println("FirstName: " + currentUser.getFirstName());
        System.out.println("LastName: " + currentUser.getLastName());
        System.out.println("Username: " + currentUser.getUserName());
        System.out.println("Email Address: " + currentUser.getEmailAddress());
        System.out.println("phone Number: " + currentUser.getPhoneNumber());
        System.out.println("************************************");
    }

    public void showAddeProduct() {

        System.out.println("select choose number");
        System.out.println("1 . Shoe");
        System.out.println("2. Electerical ");
        System.out.println("3. Readable ");
        System.out.println("4. back ");
    }

    public void showAddedShoe() {

        System.out.println("select choose number");
        System.out.println("1 . Sport shoe");
        System.out.println("2. Offical shoe ");
        System.out.println("3. back ");
    }


    public void showAllProduct() {
        System.out.println("show All Product :");
    }

    public void showItemMyCart() {

        System.out.println("1 : added my cart");
        System.out.println("2 : acxept my cart");
        System.out.println("3 : show all Product");
        System.out.println("4 : back");

    }

    public void showAddedElectrical() {
        {

            System.out.println("select choose number");
            System.out.println("1 . Televesion");
            System.out.println("2. Radio ");
            System.out.println("3. back ");
        }
    }

    public void showAddedRedable() {

        System.out.println("select choose number");
        System.out.println("1 . Book");
        System.out.println("2. Magazine ");
        System.out.println("3. back ");

    }

    public void printChooseModel() {

        System.out.println("selec chosse number 1,2,3 for buing?");
    }

    public void printSuccessfullBuy() {
        System.out.println("successfull added to Cart");
    }

    public void printSuccessfullBuyCart() {

        System.out.println("successfull Buy !!!");
    }

    public void printErorrCapaciti() {

        System.out.println("your Cart is full !!!");
    }

    public void wrong() {
        System.out.println("please Enter right values !!!  ");
    }
}
