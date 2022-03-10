package br.com.letscode.bookstore.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author implements Serializable {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;
}
