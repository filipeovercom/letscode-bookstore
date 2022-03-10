package br.com.letscode.bookstore.model.dto;

import br.com.letscode.bookstore.model.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long id;

    private String title;

    private Integer pages;

    public static BookDTO of(Book book) {
        return BookDTO.builder()
                .title(book.getTitle())
                .id(book.getId())
                .pages(book.getPages())
                .build();
    }
}
