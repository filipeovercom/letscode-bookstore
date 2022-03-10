package br.com.letscode.bookstore.service;

import br.com.letscode.bookstore.exception.BusinessException;
import br.com.letscode.bookstore.model.entity.Book;
import br.com.letscode.bookstore.model.dto.BookCreatedResponse;
import br.com.letscode.bookstore.model.dto.BookEditResponse;
import br.com.letscode.bookstore.model.dto.CreateBookRequest;
import br.com.letscode.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        return new ArrayList<>(repository.findAll());
    }

    public Book findById(Long id) {

        Optional<Book> optionalBook = repository.findById(id);

        if (optionalBook.isEmpty()) {
            throw new BusinessException(1, "Não existe livro com o id: " + id);
        }

        return optionalBook.get();

    }

    public BookEditResponse edit(Long id, CreateBookRequest request) {

        Book receiveBook = Book.of(request);

        Book editBook = findById(id);

        BeanUtils.copyProperties(receiveBook, editBook, "id");

        editBook = repository.save(editBook);

        return BookEditResponse.of(editBook);
    }

    public BookEditResponse editTitle(Long id, String title) {

        Book editBook = findById(id);

        editBook.setTitle(title);

        editBook = repository.save(editBook);

        return BookEditResponse.of(editBook);

    }

    public void deleteById(Long id) {

        Book editDeleted = findById(id);

        repository.deleteById(editDeleted.getId());

    }

    public Page<Book> getAllBooksPageable(Pageable pageable) {

        return repository.findAll(pageable);
    }
}
