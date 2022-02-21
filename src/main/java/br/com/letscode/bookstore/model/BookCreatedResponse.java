package br.com.letscode.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCreatedResponse {

    private String id;
    private String title;
    private Integer pages;
}
