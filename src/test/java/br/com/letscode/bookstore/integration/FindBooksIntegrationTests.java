package br.com.letscode.bookstore.integration;

import br.com.letscode.bookstore.controller.BookRestController;
import br.com.letscode.bookstore.model.CreateBookRequest;
import br.com.letscode.bookstore.service.BookService;
import org.hamcrest.collection.IsArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FindBooksIntegrationTests {

    private static final String TITLE = "Clean Architecture";
    private static final int PAGES = 350;

    @Autowired
    private MockMvc mockHttpClient;

    @Autowired
    private BookService service;

    @Autowired
    private BookRestController controller;

    @Test
    void shoudl_create_controller() {
        assertNotNull(controller);
    }

    @Test
    void should_get_all_books() throws Exception {
       mockHttpClient.perform(get("/books"))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(jsonPath("$").isArray());
    }

    @Test
    void should_get_1_book() throws Exception {
        createMockBook();

        mockHttpClient.perform(get("/books"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].title", is(TITLE)))
                .andExpect(jsonPath("$[0].pages", is(PAGES)));
    }

    private void createMockBook() {
        service.create(CreateBookRequest.builder()
                        .title(TITLE)
                        .pages(PAGES)
                .build());
    }
}
