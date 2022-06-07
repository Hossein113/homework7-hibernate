package maktab74.repositori;

import maktab74.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.SQLException;

public class UserRepository {

    private EntityManager entityManager;

    public UserRepository(EntityManager em) {
        this.entityManager = em;
    }

    public User insertUser(User user) throws SQLException {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();

        return user;
    }

    public int getMaxId() throws SQLException {

        TypedQuery query = entityManager.createQuery("select max(u) from User u ", Integer.class);

        return query.getFirstResult();

    }
    public User getByUsernameAndPassword(String username, String codenational) throws SQLException {

        TypedQuery query = entityManager.createQuery("select User from User where userName =" + username +
                " and password =" + codenational, User.class);

        User user = (User) query.getSingleResult();
        return user;

    }

}


