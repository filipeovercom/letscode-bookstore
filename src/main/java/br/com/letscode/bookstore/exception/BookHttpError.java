package br.com.letscode.bookstore.exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BookHttpError {

    private final LocalDateTime localDateTime = LocalDateTime.now();
    private String message;
    private String httpName;
    private int httpCode;

    public BookHttpError(String message, String httpName, int httpCode) {
        this.message = message;
        this.httpName = httpName;
        this.httpCode = httpCode;
    }
}
