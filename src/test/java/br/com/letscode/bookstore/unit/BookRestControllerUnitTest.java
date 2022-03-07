package br.com.letscode.bookstore.unit;

import br.com.letscode.bookstore.controller.BookRestController;
import br.com.letscode.bookstore.model.Book;
import br.com.letscode.bookstore.service.BookService;
import org.hamcrest.collection.HasItemInArray;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookRestControllerUnitTest {

    private static final long ID = 10L;
    private static final int PAGES = 250;
    private static final String TITLE = "Clean Code";
    public static final int EXPECTED_RESULT_SIZE = 1;

    @Mock private BookService service;

    @InjectMocks private BookRestController controller;

    @Test
    void should_get_all_books() {
        var expectedResult = List.of(buildMockBook());
        when(service.getAllBooks()).thenReturn(expectedResult);

        var result = controller.getAll();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(EXPECTED_RESULT_SIZE, result.size());
        assertEquals(expectedResult, result);
    }

    private Book buildMockBook() {
        return Book.builder()
                .id(ID)
                .pages(PAGES)
                .title(TITLE)
                .build();
    }
}
