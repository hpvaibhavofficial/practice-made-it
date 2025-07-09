package com.vb.lib.service;


import java.util.List;
import com.vb.lib.model.Book;

public interface BookService {

	Book findById(int bid);
	List<Book>findByAuthor(String author);
	
}
