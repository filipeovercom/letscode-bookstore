package br.com.letscode.bookstore.controller;

import br.com.letscode.bookstore.model.Book;
import br.com.letscode.bookstore.model.BookCreatedResponse;
import br.com.letscode.bookstore.model.BookDTO;
import br.com.letscode.bookstore.model.BookEditResponse;
import br.com.letscode.bookstore.model.CreateBookRequest;
import br.com.letscode.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping(value = "/{id}")
    public BookDTO findById(@PathVariable("id") Long id) {
        return BookDTO.of(bookService.findById(id));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookEditResponse editBook(@PathVariable("id") Long id, @RequestBody CreateBookRequest request) {
        log.info("Editing book: {}", request);
        BookEditResponse book = bookService.edit(id, request);
        log.info("Book Edited: {}", book);
        return book;
    }

    @PatchMapping(value = "/{id}/{title}")
    @ResponseStatus(HttpStatus.OK)
    public BookEditResponse editParcialBook(@PathVariable("id") Long id, @PathVariable("title") String title) {
        log.info("Editing book: {}", title);
        BookEditResponse book = bookService.editTitle(id, title);
        log.info("Book Edited: {}", book);
        return book;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable("id") Long id) {
        bookService.deleteById(id);
    }

    @GetMapping(value = "/pageable")
    public Page<Book> getPageBook(Pageable pageable) {

        Sort sort = Sort.by("id").descending();
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);

        return bookService.getAllBooksPageable(pageRequest);
    }

}
