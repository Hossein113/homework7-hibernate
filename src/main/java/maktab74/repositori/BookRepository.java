package maktab74.repositori;

import maktab74.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

public class BookRepository {

    private EntityManager entityManager;

    public BookRepository(EntityManager em) {

        this.entityManager = em;

    }

    public Book insertBook(Book book) throws SQLException {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(book);
        transaction.commit();
        return book;
    }

    public int getMaxId() throws SQLException {
        TypedQuery query = entityManager.createQuery("select max(b) from Book b ", Integer.class);
        //int queryMaxResults=query.getfirstResults();
        //return queryMaxResults
        return query.getFirstResult();
    }


    public List<Book> getAllBook() throws SQLException {
        TypedQuery<Book> query = entityManager.createQuery("select b from Book b", Book.class);
        return query.getResultList();
    }


    public int countAllBook() throws SQLException {

        TypedQuery query = entityManager.createQuery("select count(b)from Book b", Integer.class);
        int firstResult = query.getFirstResult();
        return firstResult;
    }

    public Book getById(int bookId) throws SQLException {
         return entityManager.find(Book.class, bookId);
       // TypedQuery query = entityManager.createQuery("select b from Book b where b.id =" + bookId, Book.class);
        //Book book = (Book) query.getSingleResult();
        //return book;
    }

    public void douwnProduct(int bookId) throws SQLException {

        /*EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();*/

        entityManager.getTransaction().begin();

        Book book = entityManager.find(Book.class, bookId);

        book.setNumber(book.getNumber() - 1);

        entityManager.persist(book);

        entityManager.getTransaction().commit();

       // Query query = entityManager.createQuery("update Book set number=number-1 where id=" + bookId);

    }
}