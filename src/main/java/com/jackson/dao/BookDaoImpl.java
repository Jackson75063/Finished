package com.jackson.dao;

import com.jackson.model.Book;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class BookDaoImpl implements BookDao {


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(book);
    }

    @Override
    public void updateBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
    }

    @Override
    public void removeBook(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, id);

        if(book!=null){
            session.delete(book);
        }
    }

    @Override
    public Book getBookById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, id);

        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> listBooks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Book> bookList = session.createQuery("from Book").list();

        return bookList;
    }

    public List<Integer> task2()  {
        Session session = this.sessionFactory.getCurrentSession();

        String genre  = "select book_author.author_id  from book_author  group by book_author.author_id   having COUNT(book_author.author_id) > 1";
        SQLQuery query= session.createSQLQuery(genre);

        List<Integer>  genreList = query.list();

        return genreList;
    }

    public Map<String, Integer> task4() {

        Session session = this.sessionFactory.getCurrentSession();

        String genre1  = "SELECT book.genre FROM Book book  GROUP BY genre";
        SQLQuery query= session.createSQLQuery(genre1);
        List<String>  genreList = query.list();

        String count = "SELECT  COUNT(genre) AS counter FROM book book  GROUP BY genre";
        query= session.createSQLQuery(count);
        List<Integer>  countList = query.list();
   /*
        Map<List<String>, List<Integer>> task4List = new Hashtable<List<String>, List<Integer>>();
        task4List.put(genreList,countList);
*/

        Map<String, Integer> task4List = new HashMap<String, Integer>();
        for (String genre : genreList) {
            task4List.put(genre ,countList.get(genreList.indexOf(genre)));
        }

        return task4List;

    }

}
