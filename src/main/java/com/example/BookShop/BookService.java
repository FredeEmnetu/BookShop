package com.example.BookShop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepo bookRepository;

    @Autowired
    public BookService(BookRepo bookRepository){
        this.bookRepository = bookRepository;
    }


    public void saveBook(Book book) {
        bookRepository.save(book);
    }
    public List<Book> findByTitle(String title){
        return bookRepository.findByTitle(title);
    }
    public List<Book> getAll(){
        return bookRepository.findAll();
    }

}
