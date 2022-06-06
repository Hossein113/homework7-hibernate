package maktab74.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Book.TABLE_NAME)
public class Book extends Readable {

    public static final String TABLE_NAME = "book_table";
    public static final String PAGES_NUMBER = "pages_number";
    public static final String WRITER = "writer";
    public static final String PUBLISHER = "publisher";
    public static final String PRINT_YEAR = "print_year";


    @Column(name = PAGES_NUMBER)
    private int pagesNumber;

    @Column(name = WRITER)
    private String writer;

    @Column(name = PUBLISHER)
    private String publisher;

    @Column(name = PRINT_YEAR)
    private int printYear;

    public Book() {
    }

    public Book(int id, String name, String madeIn, int price, int number, String title, int pagesNumber, String writer, String publisher, int printYear) {
        super(id, name, madeIn, price, number, title);
        this.pagesNumber = pagesNumber;
        this.writer = writer;
        this.publisher = publisher;
        this.printYear = printYear;
    }

    public Book(String name, String madeIn, int price, int number, String title, int pagesNumber, String writer, String publisher, int printYear) {
        super(name, madeIn, price, number, title);
        this.pagesNumber = pagesNumber;
        this.writer = writer;
        this.publisher = publisher;
        this.printYear = printYear;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrintYear() {
        return printYear;
    }

    public void setPrintYear(int printYear) {
        this.printYear = printYear;
    }


    @Override
    public String toString() {
        return "Book{" +
                "pagesNumber=" + pagesNumber +
                ", writer='" + writer + '\'' +
                ", publisher='" + publisher + '\'' +
                ", printYear=" + printYear +
                "} " + super.toString();
    }

}
