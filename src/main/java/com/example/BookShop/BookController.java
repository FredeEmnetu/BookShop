package com.example.BookShop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book) {
        System.out.println(book.getPrice());
        bookService.saveBook(book);
        // return "YOu made it here!";

    }

    @GetMapping("/get")
    public List<Book> getStart(){
        return bookService.getAllBooks();
    }
}
