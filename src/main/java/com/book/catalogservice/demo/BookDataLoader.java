package com.book.catalogservice.demo;

import com.book.catalogservice.domain.Book;
import com.book.catalogservice.domain.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("testdata")
public class BookDataLoader {
    private final BookRepository bookRepository;

    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData(){
        Book book = new Book("12", "Native cloud application", "zjx", 99.99);
        Book book1 = new Book("344", "Spring Jpa", "zgy", 19.9);
        bookRepository.save(book);
        bookRepository.save(book1);

    }
}
