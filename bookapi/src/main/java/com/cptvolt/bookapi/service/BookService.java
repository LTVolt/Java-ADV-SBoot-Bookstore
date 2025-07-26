package com.cptvolt.bookapi.service;

import com.cptvolt.bookapi.bookstore.BookStore;
import com.cptvolt.bookapi.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookStore bookStore;

    public BookService(BookStore bookStore) {
        this.bookStore = bookStore;
    }

    public List<Book> getAllBooks()
    {
        return bookStore.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return  bookStore.findById(id);
    }

    public Book addBook(Book book) {
        return bookStore.save(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        return bookStore.findById(id).map(book -> {
            book.setBookTitle(updatedBook.getBookTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setIsbn(updatedBook.getIsbn());
            return bookStore.save(book);
        }).orElseThrow(() -> new RuntimeException("Book not found!"));
    }

    public void deleteBook(Long id){
        bookStore.deleteById(id);
    }

    public List<Book> searchByTitle(String title){
        return bookStore.findByBookTitleContainingIgnoreCase(title);
    }

    public List<Book> searchByAuthor(String author) {
        return bookStore.findByAuthorContainingIgnoreCase(author);
    }
}
