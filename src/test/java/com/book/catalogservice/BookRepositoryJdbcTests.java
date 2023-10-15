package com.book.catalogservice;

import com.book.catalogservice.config.DataConfig;
import com.book.catalogservice.domain.Book;
import com.book.catalogservice.domain.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
@Import(DataConfig.class)
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE
)
@ActiveProfiles("integration")
public class BookRepositoryJdbcTests {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private JdbcAggregateTemplate jdbcAggregateTemplate;

    @Test
    void findBookByIsbnWhenExisting() {
        var isbn = "123";
        var book = Book.of(isbn,"Title","Author",12.9);
        jdbcAggregateTemplate.insert(book);
        Optional<Book> autalBook = bookRepository.findByIsbn(isbn);

        assertThat(autalBook).isPresent();

        assertThat(autalBook.get().isbn()).isEqualTo(book.isbn());
    }
}
