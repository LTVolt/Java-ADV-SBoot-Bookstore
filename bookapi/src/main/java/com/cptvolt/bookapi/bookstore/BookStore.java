package com.cptvolt.bookapi.bookstore;


import com.cptvolt.bookapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookStore extends JpaRepository<Book, Long> {

    List<Book> findByBookTitleContainingIgnoreCase(String title);
    List<Book> findByAuthorContainingIgnoreCase(String author);

}
