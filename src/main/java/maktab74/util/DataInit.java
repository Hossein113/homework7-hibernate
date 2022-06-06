package maktab74.util;

import maktab74.domain.*;
import maktab74.repositori.*;

import java.sql.SQLException;

public class DataInit {

    private RadioRepository radioRepository;
    private TelevisionRepository televisionRepository;
    private SportShoeRepository sportShoeRepository;
    private OfficalshoeRepository officalshoeRepository;
    private BookRepository bookRepository;
    private MagazineRepository magazineRepository;


    DataInit(RadioRepository radioRepository, TelevisionRepository televisionRepository,
             SportShoeRepository sportShoeRepository, OfficalshoeRepository officalshoeRepository,
             BookRepository bookRepository, MagazineRepository magazineRepository

    ) {
        this.radioRepository = radioRepository;
        this.televisionRepository = televisionRepository;
        this.sportShoeRepository = sportShoeRepository;
        this.officalshoeRepository = officalshoeRepository;
        this.bookRepository = bookRepository;
        this.magazineRepository = magazineRepository;
    }


    public void init() throws SQLException {
        if (radioRepository.getMaxId() == 0) {
            initRadio();
            initTelevision();
            initShoeSport();
            initOfficalShoe();
            initBook();
            initMaganize();


        }
    }


    private void initRadio() throws SQLException {
        radioRepository.insertRadio(
                new Radio(
                        "radio 1", "japan", 2000,
                        3, "sony", "black", "large",
                        "220 V", 15, 4, "6 Kg"

                )
        );
        radioRepository.insertRadio(
                new Radio(
                        "radio 2", "korea", 600,
                        3, "LG", "black", "large",
                        "220 V", 12, 4, "5 Kg"

                )
        );
        radioRepository.insertRadio(
                new Radio(
                        "radio 3", "japan", 5000,
                        3, "panasonic", "black", "medium",
                        "220 V", 10, 2, "3 Kg"

                )
        );


    }


    private void initTelevision() throws SQLException {
        televisionRepository.insertTelevision(new Television(

                        "Tv1", "japan", 50000, 3,
                        "sony", "black", 65, "220",
                        30, 4, "8kg", "4k"
                )
        );


        televisionRepository.insertTelevision(new Television(
                        "Tv2", "japan", 40000, 3,
                        "panasonic", "black", 50, "220",
                        20, 4, "6kg", "Qled"
                )
        );

        televisionRepository.insertTelevision(new Television(
                        "Tv3", "korea", 30000, 3,
                        "LG", "black", 50, "220",
                        20, 2, "4kg", "led"
                )
        );
    }

    private void initShoeSport() throws SQLException {
        sportShoeRepository.insertSportShoe(new SportShoe(

                "sport1", "naiki", 900, 3, 42,
                "coton", "black", "band", "fottball"));

        sportShoeRepository.insertSportShoe(new SportShoe(
                "sport1", "naiki", 800, 3, 43,
                "coton", "black", "band", "fottball"));

        sportShoeRepository.insertSportShoe(new SportShoe(
                "sport1", "adidas", 700, 3, 44,
                "coton", "red", "band", "basketbal"));
    }

    private void initOfficalShoe() throws SQLException {
        officalshoeRepository.insertOfficalShoe(new OfficalShoe(
                "offical1", "turkish", 800,
                3, 42, "coton",
                "black", "plastic"
        ));

        officalshoeRepository.insertOfficalShoe(new OfficalShoe(
                "offical2", "turkish", 700,
                3, 43, "coton",
                "black", "plastic"
        ));
        officalshoeRepository.insertOfficalShoe(
                new OfficalShoe(
                        "offical3", "turkish", 600,
                        3, 44, "coton",
                        "red", "plastic"
                ));
    }

    private void initBook() throws SQLException {
        bookRepository.insertBook(new Book(

                        "book1", "torkie", 80000, 3,
                        "tittle 1", 200, "writer 1",
                        "publiser1", 2012
                )
        );
        bookRepository.insertBook(new Book(

                        "book2", "torkie", 40000, 3,
                        "tittle 2", 120, "writer 2",
                        "publiser2", 2012

                )
        );
        bookRepository.insertBook(new Book(

                        "book3", "torkie", 30000, 3,
                        "tittle 3", 130, "writer 3",
                        "publiser3", 2013
                )
        );

    }

    private void initMaganize() throws SQLException {

        magazineRepository.insertMagazine(new Magazine(
                        "maganize1", "torkie", 30000,
                        3, "tittle 1", "papar",
                        "A4"

                )
        );
        magazineRepository.insertMagazine(new Magazine(
                        "maganize2", "torkie", 20000,
                        3, "tittle 2", "papar",
                        "A5"
                )
        );
        magazineRepository.insertMagazine(new Magazine(
                        "maganize3", "torkie", 15000,
                        3, "tittle 3", "papar",
                        "A4"
                )
        );
    }
}
