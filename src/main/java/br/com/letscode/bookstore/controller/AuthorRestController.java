package br.com.letscode.bookstore.controller;

import br.com.letscode.bookstore.model.dto.DefaultResponse;
import br.com.letscode.bookstore.model.dto.SuccessResponse;
import br.com.letscode.bookstore.model.entity.Author;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/authors")
@Slf4j
public class AuthorRestController {

    @GetMapping
    public List<Author> findAll() {
        return Collections.emptyList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SuccessResponse<Author>> createAuthor(@RequestBody @Valid Author author) {
        log.info("Criando autor: {}", author);

        return new ResponseEntity<>(
                new SuccessResponse<>(author),
                HttpStatus.CREATED);
    }
}
