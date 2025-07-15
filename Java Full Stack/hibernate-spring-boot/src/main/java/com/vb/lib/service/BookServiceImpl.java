package com.vb.lib.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vb.lib.dao.BookDao;
import com.vb.lib.model.Book;

@Component
public class BookServiceImpl implements BookService{
	@Autowired
	BookDao bookDao;

	
	@Override
	public Book findById(int bid) {
		// TODO Auto-generated method stub
		return bookDao.findById(bid);
	}

	@Override
	public List<Book> findByAuthor(String author) {
		// TODO Auto-generated method stub
		return bookDao.findByAuthor(author);
	}
	
}
