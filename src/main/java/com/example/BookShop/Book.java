package com.example.BookShop;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Book {
    @Id
    private String id;
    
    private String title;
    private String publisher;
    private double price;
    private String author;
    private String image; 

    public Book(){}

    public Book(String title, String publisher, double price, String author){
        this.title = title;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title != null && !title.isEmpty()){
            this.title = title;
        }
        
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        if(publisher != null && !publisher.isEmpty()){
            this.publisher = publisher;
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author != null && !author.isEmpty()){
            this.author = author;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price > -1.0){
            this.price = price;
        }
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String toString(){
        return "The book '" + this.getTitle() + "' was written by " + this.getAuthor() 
        + " and is priced at " + this.getPrice();
    }

    public boolean Compare(Book Otherbook){
        if(Otherbook != null){
            return this.price > Otherbook.price;
        }
        return false;
    }
}
