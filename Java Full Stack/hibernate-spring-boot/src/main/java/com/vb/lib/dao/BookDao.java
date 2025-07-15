package com.vb.lib.dao;


import java.util.List;

import com.vb.lib.model.Book;

public interface BookDao {

	List<Book> findAll();
	Book findById(int bid);
	Book add(Book book);
	boolean remove(Book book);
	Book update(Book book);
	List<Book> findByAuthor(String author);

}