package br.com.letscode.bookstore.service;

import br.com.letscode.bookstore.model.BookCreatedResponse;
import br.com.letscode.bookstore.model.CreateBookRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookService {

    public BookCreatedResponse create(CreateBookRequest request) {
        BookCreatedResponse response = new BookCreatedResponse();
        BeanUtils.copyProperties(request, response);
        response.setId(UUID.randomUUID().toString());
        return response;
    }
}
