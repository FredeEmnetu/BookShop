package com.example.BookShop;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "User")
public class User {
    @Id
    private String id;

    private String name;
    private String address;
    private int age;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null && !name.isEmpty()){
            this.name = name;
        }
        
    }
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        if(address != null && !address.isEmpty()){
            this.address = address;
        }
    }
    public int getAge() {
        return age;
    }

    public void setage(Integer age) {
        if(age != null && age > 16){
            this.age = age;
        }
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email != null && !email.isEmpty()){
            this.email = email;
        }
    }

    public String toString(){
        return this.getName() + " is " + this.getAge() + " with email " + this.getEmail() 
        + " and is currently at " + this.getAddress();
    }
    public boolean Compare(User Otherbook){
        if(Otherbook != null){
            return this.age > Otherbook.age;
        }
        return false;
    }
}
