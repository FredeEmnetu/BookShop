package com.example.BookShop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.CrossOrigin;

@RestController

@CrossOrigin(origins = "http://127.0.0.1:3000") // Enable CORS for this controller
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/books")
    public List<Book> addBook(@RequestParam(name="title") String title) {
        return bookService.findByTitle(title);


    }

    @GetMapping("/All")
    public List<Book> getAllBooks(){
        return bookService.getAll();
    }    
}
