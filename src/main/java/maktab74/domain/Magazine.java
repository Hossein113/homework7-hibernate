package maktab74.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = Magazine.TABLE_NAME)
public class Magazine extends Readable {

    public static final String TABLE_NAME = "magazine_table";
    public static final String PAGES_TYPE = "pages_type";
    public static final String PAGES_SIZE = "pages_size";


    @Column(name = PAGES_TYPE)
    private String pageType;

    @Column(name = PAGES_SIZE)
    private String pageSize;

    public Magazine(int id, String name, String madeIn, int price, int number, String title, String pageType, String pageSize) {
        super(id, name, madeIn, price, number, title);
        this.pageType = pageType;
        this.pageSize = pageSize;
    }

    public Magazine(String name, String madeIn, int price, int number, String title, String pageType, String pageSize) {
        super(name, madeIn, price, number, title);
        this.pageType = pageType;
        this.pageSize = pageSize;
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    public String getSize() {
        return pageSize;
    }

    public void setSize(String size) {
        this.pageSize = size;
    }


    @Override
    public String toString() {
        return "Magazine{" +
                "pageType='" + pageType + '\'' +
                ", pageSize='" + pageSize + '\'' +
                "} " + super.toString();
    }
}

