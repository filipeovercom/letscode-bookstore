package br.com.letscode.bookstore.service;

import br.com.letscode.bookstore.model.Book;
import br.com.letscode.bookstore.model.BookCreatedResponse;
import br.com.letscode.bookstore.model.CreateBookRequest;
import br.com.letscode.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public BookCreatedResponse create(CreateBookRequest request) {
        log.debug("Received book to create {}", request);
        Book newBook = Book.of(request);
        Book savedBook = repository.save(newBook);
        log.debug("Book create in service {}", savedBook);
        return BookCreatedResponse.of(savedBook);
    }

    public List<Book> getAllBooks() {
        List<Book> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }
}
