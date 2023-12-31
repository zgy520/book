package com.book.catalogservice;

import com.book.catalogservice.config.BookProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By zhanggy12
 * Date: 2023/10/12 19:10
 * Email: zhanggy12@lenovo.com
 * Desc:
 */
@RestController
public class HomeController {
    private final BookProperties bookProperties;
    @Autowired
    private Environment environment;

    public HomeController(BookProperties bookProperties) {
        this.bookProperties = bookProperties;
    }

    @GetMapping(value = "/")
    public String getGreeting() {
        return bookProperties.getGreeting() + ":" + bookProperties.getEnvtest();
    }

    @GetMapping(value = "/test")
    public String getTest() {
        return "rest";
    }
}
