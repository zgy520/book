package com.book.catalogservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "book")
public class BookProperties {
    /**
     * A message to welcome users.
     */
    private String greeting;

    /**
     * test
     */
    private String envtest;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getEnvtest() {
        return envtest;
    }

    public void setEnvtest(String envtest) {
        this.envtest = envtest;
    }
}
