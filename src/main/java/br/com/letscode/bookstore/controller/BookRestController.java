package br.com.letscode.bookstore.controller;

import br.com.letscode.bookstore.model.Book;
import br.com.letscode.bookstore.model.BookCreatedResponse;
import br.com.letscode.bookstore.model.CreateBookRequest;
import br.com.letscode.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
@RequiredArgsConstructor
@Slf4j
public class BookRestController {

    private final BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookCreatedResponse createBook(@RequestBody CreateBookRequest request) {
        log.info("Creating book: {}", request);
        BookCreatedResponse book = bookService.create(request);
        log.info("Book created: {}", book);
        return book;
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAllBooks();
    }
}
