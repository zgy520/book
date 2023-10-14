package com.book.catalogservice;

import com.book.catalogservice.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class BookJsonTests {
    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private JacksonTester<Book> json;

    @Test
    void testSerialize() throws IOException {
        Book book = new Book("12", "Title", "Author", 9.9);
        var jsonContent = json.write(book);

        assertThat(jsonContent).extractingJsonPathStringValue("@.isbn")
                .isEqualTo(book.isbn());

        assertThat(jsonContent).extractingJsonPathStringValue("@.author")
                .isEqualTo(book.author());

    }

    @Test
    void testDeserialize() throws IOException {
        var content = """
                {
                    "isbn": "123",
                    "title": "title",
                    "author": "author",
                    "price": 9.9
                }
                """;
        assertThat(json.parse(content))
                .usingRecursiveAssertion()
                .isEqualTo(new Book("123","title","author",9.9));
    }
}
