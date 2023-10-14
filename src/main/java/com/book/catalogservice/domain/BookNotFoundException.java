package com.book.catalogservice.domain;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String isbn) {
        super("The book with isbn " + isbn + " was not found.");
    }
}
