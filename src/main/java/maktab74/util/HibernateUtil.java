package maktab74.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("defult");
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }
}
