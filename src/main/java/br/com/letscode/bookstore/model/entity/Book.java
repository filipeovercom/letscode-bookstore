package br.com.letscode.bookstore.model.entity;

import br.com.letscode.bookstore.model.dto.CreateBookRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer pages;

    public static Book of(CreateBookRequest request) {
        Book book = new Book();
        BeanUtils.copyProperties(request, book);
        return book;
    }
}
