package br.com.letscode.bookstore.controller;

import br.com.letscode.bookstore.model.BookCreatedResponse;
import br.com.letscode.bookstore.model.CreateBookRequest;
import br.com.letscode.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/books")
@RequiredArgsConstructor
public class BookRestController {

    private final BookService bookService;

    @PostMapping
    public BookCreatedResponse createBook(@RequestBody CreateBookRequest request) {
        return bookService.create(request);
    }
}
