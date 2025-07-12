package com.lb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lb.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
