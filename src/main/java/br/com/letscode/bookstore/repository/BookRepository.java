package br.com.letscode.bookstore.repository;

import br.com.letscode.bookstore.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
