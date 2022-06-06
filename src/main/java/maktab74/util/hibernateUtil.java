package maktab74.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;




import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;

    public class hibernateUtil {

        private static final EntityManagerFactory emf;

        static {
            emf = Persistence.createEntityManagerFactory("defult");
        }

        public static EntityManagerFactory getEntityManagerFactory(){
            return emf;
        }
    }
