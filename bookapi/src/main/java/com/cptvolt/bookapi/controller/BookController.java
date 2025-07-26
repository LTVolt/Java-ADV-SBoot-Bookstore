package com.cptvolt.bookapi.controller;


import com.cptvolt.bookapi.dto.BookRequestDTO;
import com.cptvolt.bookapi.dto.BookResponseDTO;
import com.cptvolt.bookapi.model.Book;
import com.cptvolt.bookapi.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public BookResponseDTO addBook(@Valid @RequestBody BookRequestDTO bookRequestDTO) {
        Book book = Book.builder()
                .bookTitle(bookRequestDTO.getBookTitle())
                .author(bookRequestDTO.getAuthor())
                .isbn(bookRequestDTO.getIsbn())
                .build();
        Book saved = bookService.addBook(book);

        return BookResponseDTO.builder()
                .id(saved.getId())
                .bookTitle(saved.getBookTitle())
                .author(saved.getAuthor())
                .isbn(saved.getIsbn())
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        try {
            return ResponseEntity.ok(bookService.updateBook(id, book));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/title")
    public List<Book> searchByTitle(@RequestParam String title) {
        return bookService.searchByTitle(title);
    }

    @GetMapping("/search/author")
    public List<Book> searchByAuthor(@RequestParam String author) {
        return bookService.searchByAuthor(author);
    }
}
