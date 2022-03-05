package br.com.letscode.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEditResponse {

    private Long id;
    private String title;
    private Integer pages;

    public static BookEditResponse of(Book book) {
        BookEditResponse response = new BookEditResponse();
        BeanUtils.copyProperties(book, response);
        return response;
    }
}
