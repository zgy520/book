package com.book.catalogservice.demo;

import com.book.catalogservice.domain.Book;
import com.book.catalogservice.domain.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("testdata")
public class BookDataLoader {
    private final BookRepository bookRepository;

    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData(){
        bookRepository.deleteAll();
        Book book = Book.of("12", "Native cloud application", "zjx", 99.99,"dzgydx");
        Book book1 = Book.of("344", "Spring Jpa", "zgy", 19.9,"dzgydx");
        bookRepository.saveAll(List.of(book,book1));

    }
}
