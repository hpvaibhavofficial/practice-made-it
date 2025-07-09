package com.vb.lib.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vb.lib.model.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

@Component
public class BookDaoImpl implements BookDao {

    @Autowired
    EntityManagerFactory factory;

    @Override
    public List<Book> findAll() {
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("SELECT b FROM Book b");
        List<Book> list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public Book findById(int bid) {
        EntityManager em = factory.createEntityManager();
        Book book = em.find(Book.class, bid);
        em.close();
        return book;
    }

    @Override
    public Book add(Book book) {
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();
        em.close();
        return book;
    }

    @Override
    public boolean remove(Book book) {
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Book managed = em.find(Book.class, book.getBid());
        if (managed != null) {
            tx.begin();
            em.remove(managed);
            tx.commit();
        }
        em.close();
        return true;
    }

    @Override
    public Book update(Book book) {
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Book merged = em.merge(book);
        tx.commit();
        em.close();
        return merged;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("SELECT b FROM Book b WHERE b.author = :author");
        query.setParameter("author", author);
        List<Book> list = query.getResultList();
        em.close();
        return list;
    }
}
